package granguil.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import granguil.data.entity.Code;
import granguil.data.repository.CodeRepository;

@Service
public class CodeService {
@Autowired
CodeRepository codeRepository;

public List<Code> getMapObject(){
	List<Code> list=codeRepository.findAll();
	return list;
}
}
