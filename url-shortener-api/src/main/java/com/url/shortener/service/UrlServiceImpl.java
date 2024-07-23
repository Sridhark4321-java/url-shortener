package com.url.shortener.service;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;

@Service
public class UrlServiceImpl implements UrlService {
	
	Map<String, String> _mapShortUrlsCache = new HashMap<String,String>();

	@Override
	public String encodeUrl(String url) {
		String encodedUrl = null;
		StringBuilder sb = new StringBuilder("http://short.est/");
		// Throw exception when URL not submitted 
		if(url == null)
			throw new RuntimeException("Invalid URL");	
		
		// Generate HashCode
		String id = Hashing.murmur3_32_fixed().hashString(url, StandardCharsets.UTF_8).toString();
		
		encodedUrl = sb.append(id).toString();
		// Storing short url as key and original url as value.
		_mapShortUrlsCache.put(encodedUrl.toString(),url);
		return encodedUrl;
	}

	@Override
	public String decodeUrl(String shortUrl) {
		//Read the original/decoded url from cache and return when match found
		String origUrl = _mapShortUrlsCache.get(shortUrl);
		return origUrl;
	}


}
