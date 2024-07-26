package com.url.shortener.service;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;

@Service
public class UrlServiceImpl implements UrlService {
	
	Map<String, String> _mapShortUrlsCache = new HashMap<String,String>();

	@Override
	public String encodeUrl(String url) {	
		String returnUrl = null;
		// Throw exception when URL not submitted - for Junit exception case
		if(url == null)
			throw new RuntimeException("Invalid URL");	
		// check in cache if found return value from cache otherwise generate one
		returnUrl = _mapShortUrlsCache.get(url);
		if( returnUrl != null){
			//found in cache
			return returnUrl;
		} else {		
			//creating new in cache
			StringBuilder sb = new StringBuilder("http://short.est/");
			
			// Generate HashCode
			String id = Hashing.murmur3_32_fixed().hashString(url, StandardCharsets.UTF_8).toString();
			
			returnUrl = sb.append(id).toString();
			// Storing  original url as key and short url as value.
			_mapShortUrlsCache.put(url,returnUrl.toString());

		}
		return returnUrl;
	}

	@Override
	public String decodeUrl(String shortUrl) {
		String decodedUrl = null;

		//Read the original/decoded url from cache and return when match found
		Optional<Entry<String, String>> origUrl = _mapShortUrlsCache.entrySet().stream().filter(x->x.getValue().equals(shortUrl)).findFirst();
		
		if (origUrl.isPresent())				
			decodedUrl = origUrl.get().getKey();
		
		return decodedUrl;
	}


}
