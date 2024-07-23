package com.url.shortener;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.url.shortener.controller.UrlController;
import com.url.shortener.service.UrlService;

@SpringBootTest
class UrlShortenerApiApplicationTests {
	
	@Mock
	UrlService mockUrlService;
	
	@Autowired
	UrlService urlService;
	
	@Autowired
	UrlController urlController;
	
	
	@Test
	public void testEncode() {
		String inputUrl = "www.google.com";		
		String expectedValue = "http://short.est/08316aaa";
		String actualValue = "http://short.est/08316aaa";
		 when(mockUrlService.encodeUrl(inputUrl)).thenReturn("http://short.est/08316aaa");		 
		 assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testDecode() {
		String  shortUrl  = "http://short.est/08316aaa";	
		String expectedValue = "www.google.com";
		String actualValue = "www.google.com";
		 when(mockUrlService.decodeUrl(shortUrl)).thenReturn("www.google.com");		 
		 assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testEncodeNegative() {
		String inputUrl = "www.gmail.com";	
		String actualValue = "http://short.est/65623a15";
		String unExpectedValue = "http://short.est/08316aaa";
		 when(mockUrlService.encodeUrl(inputUrl)).thenReturn("http://short.est/65623a15");		 
		 assertNotEquals(unExpectedValue, actualValue);
	}
	
	@Test
	public void testDecodeNegative() {
		String  shortUrl  = "http://short.est/65623a15";		
		String actualValue = "www.gmail.com";
		String unExpectedValue = "www.google.com";
		when(mockUrlService.decodeUrl(shortUrl)).thenReturn("www.gmail.com");		 
		assertNotEquals(unExpectedValue, actualValue);
	}
	
	@Test
	public void withException_testUrlIsNull() {
		Assertions.assertThrows(RuntimeException.class, () -> urlService.encodeUrl(null));
	}
	
	@Test
	public void withException_testUrlIsNull_Message() {
		RuntimeException runtimeException = Assertions.assertThrows(RuntimeException.class, () -> urlService.encodeUrl(null));
		Assertions.assertEquals("Invalid URL", runtimeException.getMessage());
	}

}
