package com.ubs.rec.wordcount;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * command line interface for running the program for word count
 * @author Admin
 *
 */
public class WordCountRunner {

	public static void main(String[] args){
		WordGrouper grouper = new WordGrouper();
		System.out.println("Please enter the String:- ");
		Scanner sc = new Scanner(System.in);
		String stmt = sc.nextLine();
		
		Map<String, Long> words = grouper.extractWordsAndCount(stmt);
		for(Entry<String, Long> entry :words.entrySet()){
			System.out.println(entry.getKey()+ " - "+entry.getValue());
		}
	}
}
