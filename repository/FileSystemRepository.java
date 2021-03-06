package granguil.data.repository;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Repository;

@Repository
public class FileSystemRepository {

	    String RESOURCES_DIR_DEV = "c://React/";
	    String RESOURCES_DIR_PROD = "/home/pi/importfile";

	    public String save(byte[] content, String fileName) throws Exception {
	    	Path newFile=null;
	    	if(new File(RESOURCES_DIR_PROD).isDirectory()) {
	         newFile= Paths.get(RESOURCES_DIR_PROD + new Date().getTime() + "-" + fileName);
	    	}else {
	    		newFile= Paths.get(RESOURCES_DIR_DEV + new Date().getTime() + "-" + fileName);
	    	}
	        Files.createDirectories(newFile.getParent());

	        Files.write(newFile, content);

	        return newFile.toAbsolutePath()
	            .toString();
	    }
	    
	    public FileSystemResource findInFileSystem(String location) {
	        try {
	            return new FileSystemResource(Paths.get(location));
	        } catch (Exception e) {
	            // Handle access or file not found problems.
	            throw new RuntimeException();
	        }
	    }
}
