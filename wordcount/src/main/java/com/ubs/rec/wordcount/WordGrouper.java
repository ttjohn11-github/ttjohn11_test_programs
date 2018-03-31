/*
 * Program for tests
 */
package com.ubs.rec.wordcount;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * returns Map of words and counts in a string
 * @author Admin
 *
 */
public class WordGrouper {
	public static final String PATTERN="[^a-zA-Z0-9]";
	
	
	
	public Map<String, Long> extractWordsAndCount(String str){
		Map<String, Long> words = new LinkedHashMap<String, Long>();//for maintaining the order as in problem statement
		String[] wordsArr = str.split(PATTERN);
		for(int i =0 ;i<wordsArr.length; i++){
			String lexeme = wordsArr[i];
			if(lexeme.matches(PATTERN+"|^$")){
				continue;
			}
			lexeme = lexeme.trim().toLowerCase();
			if(words.containsKey(lexeme)){
				long wc = words.get(lexeme);
				words.put(lexeme, wc+1);
			}else{
				words.put(lexeme, Long.valueOf(1));
			}
			
			
		}
		      
		
		return words;
		
	}
	
	/** java 8 method */
//	public Map<String, Long> extractWordsAndCount8(String str){
//		
//		Map<String, Long> words = 
//		        Stream.of
//		        (str
//		        .split(PATTERN))
//		        .filter(m->m.matches(PATTERN+"|^$") == false)
//		        .map(m->m.toLowerCase())
//		        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		
//		return words;
//		
//	}
	
}
