package com.url.shortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.url.shortener.service.UrlService;

@RestController
public class UrlController {
	
	@Autowired
	UrlService urlService;

	@PostMapping
	public String encode(@RequestBody String url) {
		return null;
	}
	
	@GetMapping("/{id}")
	public String decode(@PathVariable String id) {
		return null;
	}

}
