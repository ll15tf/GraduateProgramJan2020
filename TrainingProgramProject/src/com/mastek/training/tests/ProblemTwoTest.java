package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mastek.training.basics.ProblemTwo;

class ProblemTwoTest {

	@Test
	void testKilometersToMilesValid() {
		assertEquals(8, ProblemTwo.KilometersToMiles(12.872), "invalid result");
	}
	
}
