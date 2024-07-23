package com.url.shortener.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.url.shortener.exception.UrlNotFoundException;
import com.url.shortener.service.UrlService;

@RestController
public class UrlController {
	
	@Autowired
	UrlService urlService;

	@PostMapping("/encode")
	public ResponseEntity<Object> encode(@RequestBody String url) {
		Map<String, String> _mapEncode = new HashMap<String, String>();
		_mapEncode.put("Input-URL", url);
		_mapEncode.put("Shortened-URL", urlService.encodeUrl(url));		
		return new ResponseEntity<>(_mapEncode,HttpStatus.OK);
	}
	
	@GetMapping("/decode/{id}")
	public ResponseEntity<Object> decode(@PathVariable String id) {
		if(urlService.decodeUrl(id) == null) throw new UrlNotFoundException();
		Map<String, String> _mapDecode = new HashMap<String, String>();
		_mapDecode.put("Input Short-URL/ID", id);
		_mapDecode.put("Complete-URL", urlService.decodeUrl(id));
		return new ResponseEntity<>(_mapDecode,HttpStatus.OK);
	}

}
