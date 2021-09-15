package granguil.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import granguil.data.entity.AssociatedCode;
import granguil.data.entity.Code;
import granguil.data.repository.AssociatedCodeRepository;

@Service
public class AssociatedCodeService {
@Autowired
AssociatedCodeRepository ACR;

public AssociatedCode getAssociatedElement(Code code) {
	AssociatedCode elements=ACR.findByCode(code).get();
	return elements;
}
}
