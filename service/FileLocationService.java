package granguil.data.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import granguil.data.entity.File;
import granguil.data.repository.FileRepository;
import granguil.data.repository.FileSystemRepository;


@Service
public class FileLocationService {

    @Autowired
    FileSystemRepository fileSystemRepository;
    
    @Autowired
    FileRepository fileRepository;

    public String save(byte[] bytes, String imageName,String nom) throws Exception {
        String location = fileSystemRepository.save(bytes, imageName);
        return fileRepository.save(new File(nom, location)).getLocation();
    }
    
    public FileSystemResource find(String name) {
        File file = fileRepository.findByName(name)
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return fileSystemRepository.findInFileSystem(file.getLocation());
    }
}
