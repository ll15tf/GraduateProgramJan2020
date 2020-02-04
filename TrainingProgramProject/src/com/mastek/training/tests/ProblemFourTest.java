package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mastek.training.basics.ProblemFour;

class ProblemFourTest {

	@Test
	void testTimeTaken() {
		assertEquals (4, ProblemFour.TimeTaken(100, 25));
	}
	
}
