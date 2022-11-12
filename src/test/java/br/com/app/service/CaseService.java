package br.com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.repository.CaseRepository;

@Service
public class CaseService {
	
	@Autowired
	CaseRepository caseRepository;

	public Optional<CaseService> getCase(String value) { 
		return caseRepository.findByValue(value);
	}
	
}
