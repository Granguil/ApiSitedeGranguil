package granguil.data.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
import granguil.data.request.BookMarkRequest;
import granguil.data.response.BlockListResponse;
import granguil.data.response.BlockResponse;
import granguil.data.response.BookMarkResponse;
import granguil.data.response.BookResponse;
import granguil.data.response.ChapterResponse;
import granguil.data.response.ElementResponse;
import granguil.data.response.SceneResponse;
import granguil.data.response.UniverseResponse;

public class ElementMapper {
	
public static BlockListResponse getBlocksForConfig(List<Block> blocks) {
	BlockListResponse blr=new BlockListResponse();
	for(Block b:blocks) {
		BlockResponse br=new BlockResponse();
		br.setId(b.getId().toString());
		br.setOrder(b.getOrder());
		br.setParent(b.getSceneAssociated().getId());
		br.setText(b.getContentBlock());
		blr.getBlocks().add(br);
	}
	return blr;
}
	
public static List<SceneResponse> getScenes(List<Scene> scenes){
	List<SceneResponse> scenesList=new ArrayList<SceneResponse>();
	for(Scene sc:scenes) {
		SceneResponse sr=new SceneResponse(sc.getId(), sc.getChapter_associated().getId().toString(),sc.getInfo(), sc.getTitle(),sc.getCurrentState(),sc.getNumero());
		scenesList.add(sr);
	}
	
	return scenesList;
}
	
public static List<ChapterResponse> getChapters(List<Chapter> chapters){
	List<ChapterResponse> chaptersList=new ArrayList<ChapterResponse>();
	for(Chapter ch:chapters) {
		ChapterResponse cr=new ChapterResponse(ch.getId(),ch.getBook_associated().getId().toString(),ch.getInfo(), ch.getTitle(),ch.getCurrentState(),ch.getNumero());
		chaptersList.add(cr);
	}
	return chaptersList;
}

public static List<BookResponse> getBooks(List<Book> books){
	List<BookResponse> booksList=new ArrayList<BookResponse>();
	for(Book bk:books) {
		BookResponse br=new BookResponse(bk.getId(),bk.getUniverseAssociated().getId().toString(),bk.getInfo(),bk.getTitle(),bk.getCurrentState());
		booksList.add(br);
	}
	return booksList;
}

public static List<UniverseResponse> getUniverses(List<Universe> universes){
	List<UniverseResponse> universesList=new ArrayList<UniverseResponse>();
	for(Universe un:universes) {
		UniverseResponse ur=new UniverseResponse(un.getId(),un.getInfo(),un.getTitle(),un.getCurrentState());
		universesList.add(ur);
	}
	return universesList;
}


public static List<BlockResponse> getAllBlock(List<Block> list) {
	List<BlockResponse> listBlock=new ArrayList<BlockResponse>();
	for(Block block:list) {
		BlockResponse br=new BlockResponse(block.getId().toString(),block.getContentBlock(),block.getOrder(),block.getScene_associated().getId());
		listBlock.add(br);
	}
	return listBlock;
}

public static List<ElementResponse> getAllUniverse(List<Universe> list,List<ReadUser> rus,boolean all){
	List<ElementResponse> listUniverse=new ArrayList<ElementResponse>();
	for(Universe universe:list) {
		if(universe.getCurrentState()==CurrentState.PUBLISH || all) {
		ReadState rs=ReadState.NotRead;
		if(rus.stream().anyMatch(x->x.getUniverse()!=null && x.getUniverse().equals(universe))) {
			rs=rus.stream().filter(x->x.getUniverse()!=null && x.getUniverse().equals(universe)).collect(Collectors.toList()).get(0).getReadState();
		}
		ElementResponse er=new ElementResponse(universe.getId(),null,universe.getInfo(),rs.toString(),universe.getTitle(),universe.getNumero());
		listUniverse.add(er);
		}
	}
	return listUniverse;
}

public static List<ElementResponse> getAllText(List<Book> list,List<ReadUser> rus,boolean all){
	List<ElementResponse> listText=new ArrayList<ElementResponse>();
	for(Book book:list) {
		if(book.getCurrentState()==CurrentState.PUBLISH || all) {
		ReadState rs=ReadState.NotRead;
		if(rus.stream().anyMatch(x->x.getBook()!=null && x.getBook().equals(book))) {
			rs=rus.stream().filter(x->x.getBook()!=null && x.getBook().equals(book)).collect(Collectors.toList()).get(0).getReadState();
		}
		ElementResponse er=new ElementResponse(book.getId(),book.getUniverseAssociated().getId(),book.getInfo(),rs.toString(),book.getTitle(),book.getNumero());
		listText.add(er);
		}
	}
	return listText;
}

public static List<ElementResponse> getAllChapter(List<Chapter> list,List<ReadUser> rus,boolean all){
	List<ElementResponse> listChapter=new ArrayList<ElementResponse>();
	for(Chapter chapter:list) {
		if(chapter.getCurrentState()==CurrentState.PUBLISH || all) {
		ReadState rs=ReadState.NotRead;
		if(rus.stream().anyMatch(x->x.getChapter()!=null && x.getChapter().equals(chapter))) {
			rs=rus.stream().filter(x->x.getChapter()!=null && x.getChapter().equals(chapter)).collect(Collectors.toList()).get(0).getReadState();
		}
		ElementResponse er=new ElementResponse(chapter.getId(),chapter.getBook_associated().getId(),chapter.getInfo(),rs.toString(),chapter.getTitle(),chapter.getNumero());
		listChapter.add(er);
		}
	}
	return listChapter;
}

public static List<ElementResponse> getAllScene(List<Scene> list,List<ReadUser> rus,boolean all){
	List<ElementResponse> listScene=new ArrayList<ElementResponse>();
	for(Scene scene:list) {
		if(scene.getCurrentState()==CurrentState.PUBLISH || all) {
		ReadState rs=ReadState.NotRead;
		if(rus.stream().anyMatch(x->x.getScene()!=null && x.getScene().equals(scene))) {
			rs=rus.stream().filter(x->x.getScene()!=null && x.getScene().equals(scene)).collect(Collectors.toList()).get(0).getReadState();
		}
		ElementResponse er=new ElementResponse(scene.getId(),scene.getChapter_associated().getId(),scene.getInfo(),rs.toString(),scene.getTitle(),scene.getNumero());
		listScene.add(er);
		}
	}
	return listScene;
}


public static BookMark getBookMark(BookMarkRequest bmr,User user) {
	BookMark bm=new BookMark();
	if(bmr.getId()!=null) {
		bm.setId(bmr.getId());
	}
	Book book=new Book();
	book.setId(bmr.getBook());
	bm.setBook(book);
	Universe universe=new Universe();
	universe.setId(bmr.getUniverse());
	bm.setUniverse(universe);
	Chapter chapter=new Chapter();
	chapter.setId(bmr.getChapter());
	bm.setChapter(chapter);
	Scene scene=new Scene();
	scene.setId(bmr.getScene());
	bm.setScene(scene);
	bm.setUser(user);
	bm.setName(bmr.getTitle());
	return bm;
}

public static List<BookMarkResponse> convertBookMark(List<BookMark> lbm){
	List<BookMarkResponse> liste=new ArrayList<BookMarkResponse>();
	for(BookMark bm:lbm) {
		BookMarkResponse bmr=new BookMarkResponse();
		bmr.setBook(bm.getBook().getId());
		bmr.setChapter(bm.getChapter().getId());
		bmr.setId(bm.getId());
		bmr.setScene(bm.getScene().getId());
		bmr.setTitle(bm.getName());
		bmr.setUniverse(bm.getUniverse().getId());
		bmr.setUser(bm.getUser().getPseudo());
		liste.add(bmr);
	}
	return liste;
}
}