package com.url.shortener.controller;

import java.util.HashMap;
import java.util.Map;

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
	public Map<String, String> encode(@RequestBody String url) {
		Map<String, String> _mapEncode = new HashMap<String, String>();
		_mapEncode.put("Input-URL", url);
		_mapEncode.put("Shortened-URL", urlService.encodeUrl(url));		
		return _mapEncode;
	}
	
	@GetMapping("/{id}")
	public Map<String, String> decode(@PathVariable String id) {
		Map<String, String> _mapDecode = new HashMap<String, String>();
		_mapDecode.put("Input Short-URL/ID", id);
		_mapDecode.put("Complete-URL", urlService.decodeUrl(id));
		return _mapDecode;
	}

}
