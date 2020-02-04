package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mastek.training.basics.ProblemOne;

class ProblemOneTest {

	@Test
	void testGetRemainderValid() {
		assertEquals("4,1", ProblemOne.getRemainder(9, 2), "invalid result");
	}

	@Test
	void testGetRemainderOneNegitive() {
		assertEquals("-4,-1", ProblemOne.getRemainder(-9, 2), "invalid result");
	}
	
	@Test
	void testGetRemainderBothNegitive() {
		assertEquals("4,-1", ProblemOne.getRemainder(-9, -2), "invalid result");
	}
	
	@Test
	void testGetRemainderNoRemainder() {
		assertEquals("5,0", ProblemOne.getRemainder(10, 2), "invalid result");
	}
}
