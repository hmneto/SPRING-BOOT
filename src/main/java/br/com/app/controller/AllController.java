package br.com.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/all")
@CrossOrigin
public class AllController {
	@GetMapping
	public String index() {
		return "All";
	}

}
