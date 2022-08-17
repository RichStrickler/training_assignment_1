package com.training.assignments.hw1_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App 
{
	private static final int LIST_SET_LENGTH = 12;
	private static final Integer MAP_LENGTH = 5;
	
	
	public static void main(String[] args) throws IOException {
		
		Map<List<String>,Set<Integer>> setListMap = new HashMap<>();
		List<String> listString = new ArrayList<>();
		Set<Integer> setInt = new HashSet<>();
		String fileLocation = "default.csv";
		String regexInput = "";
		Pattern regPattern = Pattern.compile("([a-zA-Z0-9.]+)");
		Matcher regMatch;
		String[] fileContent = new String[]{};
		Boolean invalidFile = false;
		int listSetLength = LIST_SET_LENGTH;
		
		BufferedReader userInput = new BufferedReader( new InputStreamReader(System.in));
		
		System.out.println("Please input the name of the file:");
		
		regexInput = userInput.readLine();
		regMatch = regPattern.matcher(regexInput.toString());

		if (regMatch.matches()) {
			 System.out.println("valid regex input");
		}
		else{
			System.out.println("invalid regex input");
		}
		
		fileLocation = regexInput;
		
		File inputFile = new File(fileLocation);
		
		try {
			BufferedReader bufferedInputFile  = new BufferedReader(new FileReader(inputFile));
			
			String line = bufferedInputFile.readLine();
			fileContent = line.split(",").clone();
		}
		catch(FileNotFoundException e){
			invalidFile = true;
			e.printStackTrace();
		}
		catch(IOException e) {
			invalidFile = true;
			e.printStackTrace();
		}
		
		
		if(!invalidFile) {
			listSetLength = fileContent.length;
		}
			
        for(int i = 0; i < listSetLength ; i++) {
        	
        	setInt.add(i);
        	if(!invalidFile) {
        		listString.add(fileContent[i]);
        	}
        	else {
        		listString.add((listSetLength - i)+"");
        	}
        	
        }
        
        for(int i = 0; i < MAP_LENGTH ; i++) {
        	
        	setListMap.put(listString, setInt);
			
		}
        
        System.out.println(setInt + " " + listString);
        System.out.print(setListMap);
        
        
    }
}
