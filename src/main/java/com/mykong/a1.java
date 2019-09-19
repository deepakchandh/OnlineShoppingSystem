//$Id$
package com.mykong;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class a1 {
	
	public static void main(String [] args) throws IOException {
		ObjectMapper objectMapper= new ObjectMapper();
		byte[] jsonda= Files.readAllBytes(Paths.get("employee.txt"));
	}

	
}
