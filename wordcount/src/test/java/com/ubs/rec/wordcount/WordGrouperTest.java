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
}
