package br.com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.model.CaseModel;
import br.com.app.service.CaseService;

@RestController
@RequestMapping("/case")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CaseController {
	
	@Autowired
	CaseService caseService;
	

	@GetMapping
	@ResponseBody
	public String getAll() {
		return "OK";
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<CaseModel> save(@RequestBody CaseModel caseModel){
		System.out.println(caseModel.toString());
		caseService.Save(caseModel);
		return ResponseEntity.status(HttpStatus.OK).body(caseModel);
	}
}
