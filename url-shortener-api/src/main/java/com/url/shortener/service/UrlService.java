package com.url.shortener.service;

public interface UrlService {
	
	public String encodeUrl(String url);
	
	public String decodeUrl(String id);
	
}
