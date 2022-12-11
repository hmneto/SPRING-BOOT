package br.com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.model.CaseModel;
import br.com.app.repository.CaseRepository;

@Service
public class CaseService {
	
	@Autowired
	CaseRepository caseRepository;

	public Optional<CaseModel> getCase(String value) { 
		Optional<CaseModel>  optionalCaseModel = caseRepository.findByValue(value);
		return optionalCaseModel;
	}
	
	@Transactional
	public CaseModel Save (CaseModel caseModel) {
		return caseRepository.save(caseModel);
	}
	
}
