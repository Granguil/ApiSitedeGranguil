package granguil.data.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import granguil.data.entity.Book;
import granguil.data.request.BlockListRequest;
import granguil.data.request.BookMarkRequest;
import granguil.data.request.DeleteBookMarkRequest;
import granguil.data.response.BlockListResponse;
import granguil.data.response.BookMarkListResponse;
import granguil.data.response.ReadDataResponse;
import granguil.data.response.ReadResponse;
import granguil.data.response.StringResponse;
import granguil.data.service.FileLocationService;
import granguil.data.service.ReadService;

@RestController
@RequestMapping("Read")
public class ReadController {
@Autowired
ReadService readService;

@Autowired
FileLocationService fileLocationService;

@GetMapping("/All/{pseudo}")
@CrossOrigin(origins="*")
public ReadResponse getAllContent(@PathVariable(name="pseudo")String pseudo) {
	ReadResponse readResponse=readService.getAllContent(pseudo);
	return readResponse;
}

@GetMapping("/{level}/{id}/{pseudo}")
@CrossOrigin(origins="*")
public ReadResponse getContentById(@PathVariable(name="level")int level,@PathVariable(name="id")String id,@PathVariable(name="pseudo")String pseudo) {
	ReadResponse readResponse=readService.getContentById(level,id,pseudo);
	return readResponse;
}

@PostMapping("/NewText")
@CrossOrigin(origins="*")
StringResponse uploadWord(@RequestParam MultipartFile newText,@RequestParam String nameFile,@RequestParam boolean NewUniverse) throws Exception {
	String location= fileLocationService.save(newText.getBytes(), newText.getOriginalFilename(),nameFile);
    String message=readService.Convert(location,NewUniverse,false,0,null,null);
    StringResponse sr=new StringResponse();
    sr.setMessage(message);
    return sr;
}

@PostMapping("/UpdateText")
@CrossOrigin(origins="*")
StringResponse updateText(@RequestParam MultipartFile newText,@RequestParam String nameFile,@RequestParam String universe,@RequestParam String textName) throws Exception {
	String message="";
	Book book=readService.searchText(universe,textName);
	if(book!=null) {
		String location= fileLocationService.save(newText.getBytes(), newText.getOriginalFilename(),nameFile);
	    message=readService.Convert(location,false,false,0,null,book);
	}else {
		message=textName+" doesn't exist for "+universe;
	}
	StringResponse sr=new StringResponse();
    sr.setMessage(message);
    return sr;
}

@PostMapping("/NewChapter")
@CrossOrigin(origins="*")
StringResponse newChapter(@RequestParam MultipartFile newText,@RequestParam String nameFile,@RequestParam String universe, @RequestParam String textName) throws Exception {
	String message="";
    if(readService.isTextInUniverse(textName, universe)) {
    	String location= fileLocationService.save(newText.getBytes(), newText.getOriginalFilename(),nameFile);
	    message=readService.Convert(location,false,true,0,textName,null);
    }else {
    	message="No Text with its name in the "+universe;
    }
	StringResponse sr=new StringResponse();
    sr.setMessage(message);
    return sr;
}

@PostMapping("/UpdateChapter")
@CrossOrigin(origins="*")
StringResponse updateChapter(@RequestParam MultipartFile newText,@RequestParam String nameFile,@RequestParam String universe, @RequestParam String textName,@RequestParam int numero) throws Exception {
	String message="";
	if(readService.isTextInUniverse(textName, universe)) {
    	String location= fileLocationService.save(newText.getBytes(), newText.getOriginalFilename(),nameFile);
	    message=readService.Convert(location,false,true,numero,textName,null);
    }else {
    	message="No Text with its name in the "+universe;
    }
    StringResponse sr=new StringResponse();
    sr.setMessage(message);
    return sr;
}
@PostMapping("/AddBookMark")
@CrossOrigin(origins="*")
boolean createBookMark(@Validated @RequestBody BookMarkRequest bmr) {
	System.out.println("Id bm : "+bmr.getId());
	try {
		if(bmr.getId()!=null) {
			System.out.println("Update");
			readService.updateBookMark(bmr);
		}else {
			System.out.println("Create");
			readService.saveBookMark(bmr);
		}
		return true;
	}catch(Exception e) {
		return false;
	}
}

@GetMapping("/GetBookMarks/{pseudo}")
@CrossOrigin(origins="*")
BookMarkListResponse getBookMarks(@PathVariable(name="pseudo")String pseudo) {
	System.out.println("Pseudo BM : "+pseudo);
	BookMarkListResponse bmlr=readService.getAllBookMarkByUser(pseudo);
	return bmlr;
}

@PostMapping("/DeleteBookMark")
@CrossOrigin(origins="*")
boolean deleteBookMark(@Validated @RequestBody DeleteBookMarkRequest bookmarkId) {
	try {
		readService.deleteBookMark(bookmarkId.getId());
		return true;
	}catch(Exception e) {
		return false;
	}
}

@PostMapping("/ReadByUser")
@CrossOrigin(origins="*")
boolean isReading(@Validated @RequestBody BookMarkRequest bmr) {
	try {
		readService.isReading(bmr);
		return true;
	}catch(Exception e) {
		System.out.println("Controller : "+e.getMessage());
		return false;
	}
}

@GetMapping("/ElementsConfig")
@CrossOrigin(origins="*")
ReadDataResponse getAllElementsForConfig() {
	ReadDataResponse rdr=readService.getAllForConfig();
	return rdr;
}

@GetMapping("/BlocksForConfig/{id}")
@CrossOrigin(origins="*")
BlockListResponse getAllBlockForConfig(@PathVariable(name="id") String id) {
	UUID uuid=UUID.fromString(id);
	BlockListResponse blr=readService.getAllBlocksById(uuid);
	return blr;
}

@PostMapping("/SaveBlocksForScene")
@CrossOrigin(origins="*")
StringResponse saveBlocksForScene(@RequestBody @Validated BlockListRequest blr) {
	System.out.println("Id : "+blr.blocks.get(0).getId());
	StringResponse sr=new StringResponse();
	sr.setMessage(readService.saveBlocks(blr));
	return sr;
}
}