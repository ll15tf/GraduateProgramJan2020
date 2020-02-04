package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mastek.training.basics.ProblemThree;

class ProblemThreeTest {

	@Test
	void testAreaOfRectangleValid() {
		assertEquals(8, ProblemThree.AreaOfRectangle(2, 4), "invalid result");
	}

}
