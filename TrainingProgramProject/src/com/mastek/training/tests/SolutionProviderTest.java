package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mastek.training.basics.SolutionProvider;

class SolutionProviderTest {

	@Test
	void testGetMaxNumberValid() {
		assertEquals(10, SolutionProvider.getMaxNumber(10, 2), "Invalid Max Number Returned");
	} //assert<condition>(<expected-result>,<call the function for actual result>, <message to display if expected result doesn't match actual result>);

	@Test
	void testGetMaxNumberEqualValueParams() {
		assertEquals(9, SolutionProvider.getMaxNumber(9, 9), "invalid max number returned");
	}

	@Test
	void testGetMaxNumberNegitiveValueParams() {
		assertEquals(-2, SolutionProvider.getMaxNumber(-2, -9), "invalid max number returned");
	}
	
	@Test
	void testGetMaxNumberMaxLimitParams() {
		assertEquals(9999999, SolutionProvider.getMaxNumber(9999999, 2), "invalid max number returned");
	}
}
