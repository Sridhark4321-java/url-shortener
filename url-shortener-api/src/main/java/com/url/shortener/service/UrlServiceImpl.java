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
		// Throw exception when URL not submitted 
		if(url == null)
			throw new RuntimeException("Submit valid URL.");	
		
		// Generate HashCode
		String id = Hashing.murmur3_32_fixed().hashString(url, StandardCharsets.UTF_8).toString();
		
		// Storing short url as key and original url as value.
		_mapShortUrlsCache.put(id,url);
		return id;
	}

	@Override
	public String decodeUrl(String id) {
		//Read the original/decoded url from cache and return when match found
		String origUrl = _mapShortUrlsCache.get(id);
		
		//entry not found in the cache then return failure message
		if(origUrl == null)
			return "URL match not found";
		
		return origUrl;
	}


}
