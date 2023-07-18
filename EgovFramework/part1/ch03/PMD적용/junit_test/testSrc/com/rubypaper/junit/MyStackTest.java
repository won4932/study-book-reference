package com.rubypaper.junit;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MyStackTest {
	private MyStack s;

	@Before
	public void setUp() throws Exception {
		s = new MyStack();
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue(s.isEmpty());
		s.push("abc");
		assertTrue(!s.isEmpty());
	}
	@Test
	public void testPush() {
		s.push("abc");
		s.push("def");
		s.push(new Integer(1));
		assertEquals(2, s.size());
	}

	@Test
	public void testPop() {
		s.push("abc");
		s.push("def");
		String str = (String)s.pop();
		assertEquals("def",str);	
		assertEquals(0,s.size());
	}
}
