package com.ubs.rec.wordcount;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WordGrouperTest {

	private WordGrouper wg;
	
	@Before
	public void setUp(){
		wg = new WordGrouper();
	}
	
	@Test
	public void verifyWordCountWithMultiSpace(){
		Map<String, Long> words = wg.extractWordsAndCount("hello     hello! hello    world!");
		assertEquals(2, words.size());
		assertEquals(3, words.get("hello").longValue());
		assertEquals(1, words.get("world").longValue());
	}
	@Test
	public void verifyWordCountWithSpecialSeperatorsMultiSpace(){
		Map<String, Long> words = wg.extractWordsAndCount("hello!! hello! hello    world!");
		assertEquals(2, words.size());
		assertEquals(3, words.get("hello").longValue());
		assertEquals(1, words.get("world").longValue());
	}
	@Test
	public void verifyProblemMentioned(){
		Map<String, Long> words = wg.extractWordsAndCount("This is a statement, and so is this.");
		assertEquals(6, words.size());
		assertEquals(2, words.get("this").longValue());
		assertEquals(2, words.get("is").longValue());
		assertEquals(1, words.get("a").longValue());
		assertEquals(1, words.get("statement").longValue());
		assertEquals(1, words.get("and").longValue());
		assertEquals(1, words.get("so").longValue());
	}
}
