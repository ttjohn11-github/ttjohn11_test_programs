package com.ubs.rec.wordcount;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordGrouper {
	public static final String PATTERN="[^a-zA-Z0-9]";
	
	public Map<String, Long> extractWordsAndCount(String str){
		
		Map<String, Long> collect = 
		        Stream.of(str.replaceAll(PATTERN," ")
		        .split(" "))
		        .filter(m->!m.equals(""))
		        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		return collect;
		
	}
	
	
}
