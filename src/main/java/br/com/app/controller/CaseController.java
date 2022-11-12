package br.com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("case")
public class CaseController {

	@GetMapping
	public String getAll() {
		return "OK";
	}
}
