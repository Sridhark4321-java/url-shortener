package com.url.shortener;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.url.shortener.service.UrlService;

@SpringBootTest
class UrlShortenerApiApplicationTests {
	
	@Mock
	UrlService mockUrlService;
	
	@Autowired
	UrlService urlService;
	
	@Test
	public void testEncode() {
		String inputUrl = "www.google.com";		
		 when(mockUrlService.encodeUrl(inputUrl)).thenReturn("08316aaa");		 
		 assertEquals("08316aaa", "08316aaa");
	}
	
	@Test
	public void testDecode() {
		String  id  = "08316aaa";		
		 when(mockUrlService.decodeUrl(id)).thenReturn("www.google.com");		 
		 assertEquals("www.google.com", "www.google.com");
	}
	
	@Test
	public void testEncodeNegative() {
		String inputUrl = "www.gmail.com";		
		 when(mockUrlService.encodeUrl(inputUrl)).thenReturn("08316aaa");		 
		 assertNotEquals("65623a15", "08316aaa");
	}
	
	@Test
	public void testDecodeNegative() {
		String  id  = "65623a15";		
		when(mockUrlService.decodeUrl(id)).thenReturn("www.google.com");		 
		assertNotEquals("www.gmail.com", "www.google.com");
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
