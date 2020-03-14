package com.motus.assosuite.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EnumTests {

	@Test
	public void testFromStringFamilyType() {
		final String marie = "maried";
		final String incorrectType = "incorectType";
		FamilialSituationType expected = FamilialSituationType.fromString(marie);
		assertEquals(expected, FamilialSituationType.MARIED);
		assertThrows(IllegalArgumentException.class, ()-> {
			FamilialSituationType.fromString(incorrectType);
		});
	}
}
