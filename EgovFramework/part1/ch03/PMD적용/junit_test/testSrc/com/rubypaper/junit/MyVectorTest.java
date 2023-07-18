package com.rubypaper.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyVectorTest {
	private MyVector v;

	@Before
	public void setUp() throws Exception {
		v= new MyVector();
	}

	@Test
	public void testIsEmpty() {
		assertTrue(v.isEmpty());
		v.addElement("abc");
		assertTrue(!v.isEmpty());
	}

	@Test
	public void testContains() {
		String str1 = "abc";
		v.addElement(str1);
		assertTrue(v.contains(str1));	
	}

	@Test
	public void testIndexOf() {
		String str1 = "abc";
		String str2 = "def";
		v.addElement(str1);
		v.addElement(str2);	
		assertEquals(1, v.indexOf(str2));
	}

	@Test
	public void testElementAt() {
		String str1 = "abc";
		String str2 = "def";
		v.addElement(str1);
		v.addElement(str2);
		assertSame(str1, v.elementAt(0));
		assertSame(str2, v.elementAt(1));
	}

	@Test
	public void testAddElement() {
		v.addElement("abc");
		v.addElement(new Integer(1));
	}
}




