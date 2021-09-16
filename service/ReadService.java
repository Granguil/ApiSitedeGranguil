package granguil.data.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFNum;
import org.apache.poi.xwpf.usermodel.XWPFNumbering;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import granguil.data.Enum.BlockState;
import granguil.data.Enum.CurrentState;
import granguil.data.Enum.ReadState;
import granguil.data.entity.Block;
import granguil.data.entity.Book;
import granguil.data.entity.BookMark;
import granguil.data.entity.Chapter;
import granguil.data.entity.ReadUser;
import granguil.data.entity.Scene;
import granguil.data.entity.Universe;
import granguil.data.entity.User;
import granguil.data.mapper.ElementMapper;
import granguil.data.repository.BlockRepository;
import granguil.data.repository.BookMarkRepository;
import granguil.data.repository.BookRepository;
import granguil.data.repository.ChapterRepository;
import granguil.data.repository.ReadUserRepository;
import granguil.data.repository.SceneRepository;
import granguil.data.repository.UniverseRepository;
import granguil.data.repository.UserRepository;
import granguil.data.request.BlockListRequest;
import granguil.data.request.BlockRequest;
import granguil.data.request.BookMarkRequest;
import granguil.data.response.BlockListResponse;
import granguil.data.response.BlockResponse;
import granguil.data.response.BookMarkListResponse;
import granguil.data.response.BookMarkResponse;
import granguil.data.response.ElementResponse;
import granguil.data.response.ReadDataResponse;
import granguil.data.response.ReadResponse;

@Service
public class ReadService {

@Autowired
BlockRepository blockRepository;

@Autowired
UniverseRepository universeRepository;

@Autowired
BookRepository bookRepository;

@Autowired
ChapterRepository chapterRepository;

@Autowired
SceneRepository sceneRepository;

@Autowired
BookMarkRepository bmRepository;

@Autowired
UserRepository userRepository;

@Autowired
ReadUserRepository readUserRepository;

private enum LastCreated{
	Universe,Text,Chapter,None
}

public String saveBlocks(BlockListRequest blr) {
	String message="";
	try{
		Scene scene=sceneRepository.findById(blr.parent).get();
		if(blr.publish) {
			scene.setCurrentState(CurrentState.PUBLISH);
			scene.getChapterAssociated().setCurrentState(CurrentState.PUBLISH);
			scene.getChapterAssociated().getBookAssociated().setCurrentState(CurrentState.PUBLISH);
			scene.getChapterAssociated().getBookAssociated().getUniverseAssociated().setCurrentState(CurrentState.PUBLISH);
		}
		boolean removingBlock=false;
		for(BlockRequest br:blr.blocks) {
			if(br.getStatus().equals(BlockState.NEW)) {
				Block newBlock=new Block();
				newBlock.setContentBlock(br.getContent());
				newBlock.setOrder(br.getOrder());
				newBlock.setSceneAssociated(scene);
				scene.getBlocks().add(newBlock);
			}else {
				Block b=scene.getBlocks().stream().filter(x->x.getId().equals(UUID.fromString(br.getId()))).collect(Collectors.toList()).get(0);
				if(br.getStatus().equals(BlockState.DELETE)) {
					scene.getBlocks().remove(b);
					blockRepository.delete(b);
					removingBlock=true;
				}else {
					b.setContentBlock(br.getContent());
					b.setOrder(br.getOrder());
				}
			
			}
		}
		if(removingBlock) {
			Collections.sort(scene.getBlocks(), (x,y)->x.getOrder()-y.getOrder());
			int newOrder=1;
			for(Block blockToOrder:scene.getBlocks()) {
				blockToOrder.setOrder(newOrder);
				newOrder++;
			}
		}
		sceneRepository.save(scene);
		message="Update Success";
	}catch(Exception e) {
		System.out.println(e.getMessage());
		message=e.getLocalizedMessage();
	}
	return message;
}
public BlockListResponse getAllBlocksById(UUID id) {
	BlockListResponse blr=new BlockListResponse();
	Scene scene=sceneRepository.findById(id).get();
	List<Block> blocks=blockRepository.findBySceneAssociated(scene).get();
	blr=ElementMapper.getBlocksForConfig(blocks);
	return blr;
}

public ReadDataResponse getAllForConfig() {
	ReadDataResponse rdr=new ReadDataResponse();
	rdr.universe=ElementMapper.getUniverses(universeRepository.findAll());
	rdr.books=ElementMapper.getBooks(bookRepository.findAll());
	rdr.chapters=ElementMapper.getChapters(chapterRepository.findAll());
	rdr.scenes=ElementMapper.getScenes(sceneRepository.findAll());
	return rdr;
}

public ReadResponse getAllContent(String pseudo) {
	User user=userRepository.findByPseudo(pseudo).get();
	List<ReadUser> readUsers=readUserRepository.findByUser(user).get();
	ReadResponse readResponse=new ReadResponse();
	List<BlockResponse> blocks=ElementMapper.getAllBlock(blockRepository.findAll());
	List<ElementResponse> elements=new ArrayList<ElementResponse>();
	elements.addAll(ElementMapper.getAllUniverse(universeRepository.findAll(),readUsers,false));
	elements.addAll(ElementMapper.getAllText(bookRepository.findAll(),readUsers,false));
	elements.addAll(ElementMapper.getAllChapter(chapterRepository.findAll(),readUsers,false));
	elements.addAll(ElementMapper.getAllScene(sceneRepository.findAll(),readUsers,false));
	readResponse.Blocks=blocks;
	readResponse.Elements=elements;
	return readResponse;
}

public ReadResponse getContentById(int level,String id,String pseudo) {
	User user=userRepository.findByPseudo(pseudo).get();
	List<ReadUser> readUsers=readUserRepository.findByUser(user).get();
	ReadResponse readResponse=new ReadResponse();
	List<ElementResponse> elements=new ArrayList<ElementResponse>();
	List<BlockResponse> blocks=new ArrayList<BlockResponse>();
	if(id.equals("Root")) {
		elements.addAll(ElementMapper.getAllUniverse(universeRepository.findAll(),readUsers,false));
	}else {
		UUID uuid=UUID.fromString(id);
		switch(level) {
		case 0:
			Universe universe=universeRepository.findById(uuid).get();
			elements.addAll(ElementMapper.getAllText(universe.getBooks(), readUsers,false));
		break;
		case 1:
			Book book=bookRepository.findById(uuid).get();
			elements.addAll(ElementMapper.getAllChapter(book.getChapters(), readUsers,false));
		break;
		case 2:
			Chapter chapter=chapterRepository.findById(uuid).get();
			elements.addAll(ElementMapper.getAllScene(chapter.getScenes(),readUsers,false));
		break;
		case 3:
			Scene scene=sceneRepository.findById(uuid).get();
			blocks.addAll(ElementMapper.getAllBlock(scene.getBlocks()));
		}
	}
	readResponse.Elements=elements;
	readResponse.Blocks=blocks;
	return readResponse;
}

public void saveBookMark(BookMarkRequest bmr) {
	User user = userRepository.findByPseudo(bmr.getUser()).get();
	BookMark bm=ElementMapper.getBookMark(bmr,user);
	bmRepository.save(bm);
}

public void updateBookMark(BookMarkRequest bmr) {
	User user = userRepository.findByPseudo(bmr.getUser()).get();
	BookMark bm=ElementMapper.getBookMark(bmr,user);
	bmRepository.save(bm);
}

public BookMarkListResponse getAllBookMarkByUser(String pseudo) {
	User user=userRepository.findByPseudo(pseudo).get();
	List<BookMark> bookMarks=bmRepository.findByUser(user).get();
	List<BookMarkResponse> bmrList=ElementMapper.convertBookMark(bookMarks);
	BookMarkListResponse bmlr=new BookMarkListResponse(bmrList);
	return bmlr;
}

public void deleteBookMark(UUID id) {
	BookMark bm=bmRepository.findById(id).get();
	bmRepository.delete(bm);
}

public void isReading(BookMarkRequest bmr) {
	User user=userRepository.findByPseudo(bmr.getUser()).get();
	Universe universe=universeRepository.findById(bmr.getUniverse()).get();
	/*Book book=universe.getBooks().stream().filter(x->x.getId()==bmr.getBook()).collect(Collectors.toList()).get(0);
	Chapter chapter=book.getChapters().stream().filter(x->x.getId()==bmr.getChapter()).collect(Collectors.toList()).get(0);
	Scene scene=chapter.getScenes().stream().filter(x->x.getId()==bmr.getScene()).collect(Collectors.toList()).get(0);*/
	Book book=bookRepository.findById(bmr.getBook()).get();
	Chapter chapter=chapterRepository.findById(bmr.getChapter()).get();
	Scene scene=sceneRepository.findById(bmr.getScene()).get();
	Boolean chapterIsFinished=false;
	List<ReadUser> readUsers=readUserRepository.findByUserAndUniverseOrUserAndBookOrUserAndChapterOrUserAndScene(user,universe,user, book,user, chapter,user, scene).get();
	try {
		ReadUser ruScene=readUsers.stream().filter(x->x.getScene()!=null).collect(Collectors.toList()).get(0);
		ruScene.setReadState(ReadState.Finished);
		readUserRepository.save(ruScene);
	}catch(Exception e) {
		ReadUser ruScene=new ReadUser();
		ruScene.setScene(scene);
		ruScene.setReadState(ReadState.Finished);
		ruScene.setUser(user);
		readUserRepository.save(ruScene);
	}
	try {
		ReadUser ruChapter=readUsers.stream().filter(x->x.getChapter()!=null).collect(Collectors.toList()).get(0);
		if(scene.getNumero()==chapter.getScenes().size()) {
		ruChapter.setReadState(ReadState.Finished);
		chapterIsFinished=true;
		}else {
			ruChapter.setReadState(ReadState.Current);
		}
		readUserRepository.save(ruChapter);
	}catch(Exception e) {
		ReadUser ruChapter=new ReadUser();
		ruChapter.setChapter(chapter);
		if(scene.getNumero()==chapter.getScenes().size()) {
			ruChapter.setReadState(ReadState.Finished);
			chapterIsFinished=true;
		}else {
			ruChapter.setReadState(ReadState.Current);
		}
		ruChapter.setUser(user);
		readUserRepository.save(ruChapter);
	}
	try {
		ReadUser ruBook=readUsers.stream().filter(x->x.getBook()!=null).collect(Collectors.toList()).get(0);
		if(chapter.getNumero()==book.getChapters().size() && chapterIsFinished) {
		ruBook.setReadState(ReadState.Finished);
		}else {
			ruBook.setReadState(ReadState.Current);
		}
		readUserRepository.save(ruBook);
	}catch(Exception e) {
		ReadUser ruBook=new ReadUser();
		ruBook.setBook(book);
		if(chapter.getNumero()==book.getChapters().size() && chapterIsFinished) {
			ruBook.setReadState(ReadState.Finished);
		}else {
			ruBook.setReadState(ReadState.Current);
		}
		ruBook.setUser(user);
		readUserRepository.save(ruBook);
	}
	try {
		ReadUser ruUniverse=readUsers.stream().filter(x->x.getUniverse()!=null).collect(Collectors.toList()).get(0);
		ruUniverse.setReadState(ReadState.Current);
		readUserRepository.save(ruUniverse);
	}catch(Exception e) {
		ReadUser ruScene=new ReadUser();
		ruScene.setUniverse(universe);
		ruScene.setReadState(ReadState.Current);
		ruScene.setUser(user);
		readUserRepository.save(ruScene);
	}
	/*if(scene.getReadUser().stream().filter(x->x.getUser().getPseudo().equals(bmr.getUser())).collect(Collectors.toList()).size()==0) {
	ReadUser ruScene=new ReadUser();
	ruScene.setScene(scene);
	ruScene.setUser(user);
	ruScene.setReadState(ReadState.Finished);
	readUserRepository.save(ruScene);
	ReadUser ruChapter=new ReadUser();
	if(chapter.getScenes().stream().filter(x->x.getReadUser().stream().filter(y->y.getUser().getPseudo().equals(bmr.getUser())))) {
	ruChapter.setChapter(chapter);
	ruChapter.setUser(user);
	ruChapter.set
	}else {
		
	}
	}else {
		System.out.println("Skip");
	}*/
}

public Book searchText(String universe,String textName) {
	try {
		Book book=bookRepository.findByTitle(textName).get();
		if(book.getUniverseAssociated().getTitle().equals(universe)) {
			return book;
		}else {
			return null;
		}
	}catch(Exception e) {
		return null;
	}
}

public boolean isTextInUniverse(String bookName, String universe) {
	try {
		Book book=bookRepository.findByTitle(bookName).get();
		if(book.getUniverseAssociated().getTitle().equals(universe)) {
			return true;
		}else {
			return false;
		}
	}catch(Exception e) {
		return false;
	}
}

public String Convert(String location,boolean newUniverse,boolean isNewChapter,int numChapter,String bookName,Book bookToReplace) {
	XWPFDocument docx=null;
	LastCreated lc=LastCreated.None;
	String message = null;
	try {
		docx = new XWPFDocument(new FileInputStream(location));
	
    XWPFNumbering numbering=new XWPFNumbering();
    XWPFParagraph para = null;
    XWPFNum num = null;
    List<XWPFParagraph> paraList = null;
    Iterator<XWPFParagraph> paraIter = null;
    BigInteger numID = null;
    int numberingID = -1;
    numbering = docx.getNumbering();
    paraList = docx.getParagraphs();
    paraIter = paraList.iterator();
    Universe universe=null;
    Book book=null;
    Chapter chapter=null;
    int chapNumber=1;
    if(isNewChapter) {
    	try {
    		book=bookRepository.findByTitle(bookName).get();
    		universe=book.getUniverseAssociated();
    		if(numChapter==0) {
    			chapNumber=book.getChapters().size()+1;
    		}else {
    			try {
    			Chapter chapterToDelete=book.getChapters().stream().filter(x->x.getNumero()==numChapter).collect(Collectors.toList()).get(0);
    			boolean delete=book.getChapters().remove(chapterToDelete);
    			if(delete) {
    			chapterRepository.delete(chapterToDelete);
    			chapNumber=numChapter;
    			}else {
    				message="Fail To Delete Previous Chapter";
    			}
    			}catch(Exception e) {
    				message="Chapter doesn't exist";
    			}
    		}
    	}catch(Exception e) {
    		message="Text doesn't exist";
    	}
    }
    Scene scene=null;
    Block block=null;
    int sceneNumber=1;
    int orderBlock=1;
    if(message==null) {
    while(paraIter.hasNext()) {
  	  para = paraIter.next();
  	  numID = para.getNumID();
  	  if(para.getParagraphText().contains("<Universe>")) {
  		  try {
  			 if(!newUniverse) {
  				 universe=universeRepository.findByTitle(para.getParagraphText().substring(10)).get();
  			 }else {
  				 universe=new Universe(para.getParagraphText().substring(10),1,null,null);
  				 
  				 
  			 }
  			 lc=LastCreated.Universe;
  		  }catch(Exception e) {
  			  if(newUniverse) {
  				  message="Universe Already Existing";
  			  }else {
  				message="Universe Not Existing";
  			  }
  			  break;
  		  }
  	  }else if(para.getParagraphText().contains("<Text>")) {
  		  try {
  			  if(bookToReplace==null) {
  			  book=bookRepository.findByTitle(para.getParagraphText().substring(6)).get();
  			  message="Text Already Existing";
  			  break;
  			  }else {
  				book=new Book(para.getParagraphText().substring(6),1,null,universe,null);
  	  		  	universe.getBooks().add(book);
  			  }
  		  }catch(Exception e) {
  		  book=new Book(para.getParagraphText().substring(6),1,null,universe,null);
  		  universe.getBooks().add(book);
  		  }
  		  lc=LastCreated.Text;
  	  }else if(para.getParagraphText().contains("<Chapitre>")) {
  		  if(scene!=null && block.getScene_associated().getId()!=scene.getId()) {
  			  scene.setChapter_associated(null);
  			  chapter.getScenes().remove(scene);
  		  }
  		  
  		  chapter=new Chapter(para.getParagraphText().substring(10),chapNumber,null,book,null);
  		  book.getChapters().add(chapter);
  		  
  		  lc=LastCreated.Chapter;
  		  chapNumber++;
  		  scene=new Scene("Scene 1",1,null,chapter,null);
  		  chapter.getScenes().add(scene);
  		  sceneNumber=1;
  		  orderBlock=1;
  	  }else if(para.getParagraphText().contains("<Info>")) {
  		  if(lc==LastCreated.Universe) {
  			  universe.setInfo(universe.getTitle()+" : "+para.getParagraphText().substring(6));
  			  
  		  }else if(lc==LastCreated.Text) {
  			  book.setInfo(book.getTitle()+" : "+para.getParagraphText().substring(6));
  			  
  		  }else if(lc==LastCreated.Chapter) {
  			  chapter.setInfo(chapter.getTitle()+" : "+para.getParagraphText().substring(6));
  			  
  		  }else {
  			  message="Info Target Not Find";
  			 break;
  		  }
  	  }else {
  	  if(numID != null) {
  	  if(numID.intValue() != numberingID) {
  	  num = numbering.getNum(numID);
  	  numberingID = numID.intValue();
  	  
  	  if(!para.getParagraphText().isBlank() && para.getParagraphText()!=null) {
  	  block=new Block(" - "+para.getParagraphText(),orderBlock,scene);
	  scene.getBlocks().add(block);
	  orderBlock++;
  	  }
  	  }
  	  else {
  		if(!para.getParagraphText().isBlank() && para.getParagraphText()!=null) {
  		  block=new Block(" - "+para.getParagraphText(),orderBlock,scene);
		  scene.getBlocks().add(block);
		  orderBlock++;
  		}
  	  }
  	  }
  	  else {
  		   if((para.getParagraphText().equals("") || para.getParagraphText()==null) && block.getScene_associated().getId()==scene.getId() && orderBlock>2) {
  			  sceneNumber++;
  			  scene=new Scene("Scene "+sceneNumber,sceneNumber,null,chapter,null);
  			  chapter.getScenes().add(scene);
  			  orderBlock=1;
  		  }else {
  			if(!para.getParagraphText().isBlank() && para.getParagraphText()!=null) {
	  		  block=new Block(para.getParagraphText(),orderBlock,scene);
	  		  scene.getBlocks().add(block);
	  		  orderBlock++;
  		  }
  		  }
  	  }
  	 
  	  }
  	  }
    }
    if((scene!=null && block.getScene_associated().getId()!=scene.getId()) || scene.getBlocks().size()==0) {
    	scene.setChapter_associated(null);
		chapter.getScenes().remove(scene);
	  }
    
    
	if(message==null) {
		if(bookToReplace!=null) {
		universe.getBooks().remove(bookToReplace);
		bookRepository.delete(bookToReplace);
		}
		universeRepository.save(universe);
		message="Save Succeded";
	}
	} catch (IOException e) {
		// TODO Auto-generated catch block
	
		message= e.getLocalizedMessage();
	}catch(Exception e) {
	message=e.getLocalizedMessage();	
	}finally {
		try {
			docx.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			message=e.getLocalizedMessage();
		}catch(Exception e) {
			message=e.getLocalizedMessage();
		}
	}
	return message;
}

public String Convert2(String location,boolean newUniverse,boolean isNewChapter,int numChapter,String bookName) {
	XWPFDocument docx=null;
	LastCreated lc=LastCreated.None;
	String message = null;
	try {
		docx = new XWPFDocument(new FileInputStream(location));
	
    XWPFNumbering numbering=new XWPFNumbering();
    XWPFParagraph para = null;
    XWPFNum num = null;
    List<XWPFParagraph> paraList = null;
    Iterator<XWPFParagraph> paraIter = null;
    BigInteger numID = null;
    int numberingID = -1;
    numbering = docx.getNumbering();
    paraList = docx.getParagraphs();
    paraIter = paraList.iterator();
    Universe universe=null;
    Book book=null;
    Chapter chapter=null;
    int chapNumber=1;
    if(isNewChapter) {
    	try {
    		book=bookRepository.findByTitle(bookName).get();
    		if(numChapter==0) {
    			chapNumber=book.getChapters().size()+1;
    		}else {
    			try {
    			Chapter chapterToDelete=book.getChapters().stream().filter(x->x.getNumero()==numChapter).collect(Collectors.toList()).get(0);
    			boolean delete=book.getChapters().remove(chapterToDelete);
    			if(delete) {
    			chapterRepository.delete(chapterToDelete);
    			chapNumber=numChapter;
    			}else {
    				message="Fail To Delete Previous Chapter";
    			}
    			}catch(Exception e) {
    				message="Chapter doesn't exist";
    			}
    		}
    	}catch(Exception e) {
    		message="Text doesn't exist";
    	}
    }
    Scene scene=null;
    Block block=null;
    int sceneNumber=1;
    int orderBlock=1;
    if(message==null) {
    while(paraIter.hasNext()) {
  	  para = paraIter.next();
  	  numID = para.getNumID();
  	  if(para.getParagraphText().contains("<Universe>")) {
  		  try {
  			 if(!newUniverse) {
  				 universe=universeRepository.findByTitle(para.getParagraphText().substring(10)).get();
  			 }else {
  				 universe=new Universe(para.getParagraphText().substring(10),1,null,null);
  				 universeRepository.save(universe);
  				 
  			 }
  			 lc=LastCreated.Universe;
  		  }catch(Exception e) {
  			  if(newUniverse) {
  				  message="Universe Already Existing";
  			  }else {
  				message="Universe Not Existing";
  			  }
  			  break;
  		  }
  	  }else if(para.getParagraphText().contains("<Text>")) {
  		  try {
  			  book=bookRepository.findByTitle(para.getParagraphText().substring(6)).get();
  			  message="Text Already Existing";
  			  break;
  		  }catch(Exception e) {
  		  book=new Book(para.getParagraphText().substring(6),1,null,universe,null);
  		  bookRepository.save(book);
  		  }
  		  lc=LastCreated.Text;
  	  }else if(para.getParagraphText().contains("<Chapitre>")) {
  		  if(scene!=null && block.getScene_associated().getId()!=scene.getId()) {
  			  sceneRepository.delete(scene);
  		  }
  		  
  		  chapter=new Chapter(para.getParagraphText().substring(10),chapNumber,null,book,null);
  		  chapterRepository.save(chapter);
  		  
  		  lc=LastCreated.Chapter;
  		  chapNumber++;
  		  scene=new Scene("Scene 1",1,null,chapter,null);
  		  sceneRepository.save(scene);
  		  sceneNumber=1;
  		  orderBlock=1;
  	  }else if(para.getParagraphText().contains("<Info>")) {
  		  if(lc==LastCreated.Universe) {
  			  universe.setInfo(universe.getTitle()+" : "+para.getParagraphText().substring(6));
  			  universeRepository.save(universe);
  		  }else if(lc==LastCreated.Text) {
  			  book.setInfo(book.getTitle()+" : "+para.getParagraphText().substring(6));
  			  bookRepository.save(book);
  		  }else if(lc==LastCreated.Chapter) {
  			  chapter.setInfo(chapter.getTitle()+" : "+para.getParagraphText().substring(6));
  			  chapterRepository.save(chapter);
  		  }else {
  			  message="Info Target Not Find";
  			 break;
  		  }
  	  }else {
  	  if(numID != null) {
  	  if(numID.intValue() != numberingID) {
  	  num = numbering.getNum(numID);
  	  numberingID = numID.intValue();
  	  
  	  if(!para.getParagraphText().isBlank() && para.getParagraphText()!=null) {
  	  block=new Block(" - "+para.getParagraphText(),orderBlock,scene);
	  blockRepository.save(block);
	  orderBlock++;
  	  }
  	  }
  	  else {
  		if(!para.getParagraphText().isBlank() && para.getParagraphText()!=null) {
  		  block=new Block(" - "+para.getParagraphText(),orderBlock,scene);
		  blockRepository.save(block);
		  orderBlock++;
  		}
  	  }
  	  }
  	  else {
  		   if((para.getParagraphText().equals("") || para.getParagraphText()==null) && block.getScene_associated().getId()==scene.getId() && orderBlock>2) {
  			  sceneNumber++;
  			  scene=new Scene("Scene "+sceneNumber,sceneNumber,null,chapter,null);
  			  sceneRepository.save(scene);
  			  orderBlock=1;
  		  }else {
  			if(!para.getParagraphText().isBlank() && para.getParagraphText()!=null) {
	  		  block=new Block(para.getParagraphText(),orderBlock,scene);
	  		  blockRepository.save(block);
	  		  orderBlock++;
  		  }
  		  }
  	  }
  	 
  	  }
  	  }
    }
    if(scene!=null && block.getScene_associated().getId()!=scene.getId()) {
		  sceneRepository.delete(scene);
	  }
    
    
	if(message==null) {
		message="Save Succeded";
	}
	} catch (IOException e) {
		// TODO Auto-generated catch block
	
		message= e.getLocalizedMessage();
	}finally {
		try {
			docx.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			message=e.getLocalizedMessage();
		}
	}
	return message;
}
}
