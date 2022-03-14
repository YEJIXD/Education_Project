package com.edu.java;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CmmService {
	// jsonString To HashMap
		@SuppressWarnings("unchecked") // Ajax 통신으로 json 형태 보장
		public HashMap<String, Object> jsonStringToHashMap(String json) throws IOException {
			HashMap<String, Object> resultMap = new HashMap<>();
			ObjectMapper mapper = new ObjectMapper();
			
			try {
				resultMap = mapper.readValue(json, HashMap.class);
				
			} catch (JsonMappingException e) {
				e.printStackTrace();
				
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			
			return resultMap;
		}
}
