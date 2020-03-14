package com.motus.assosuite.enums;

import java.util.HashMap;
import java.util.Map;

public enum GenderType {

	MALE("male"), FEMALE("female");

	private String representation;

	private static final Map<String, GenderType> enumMap = new HashMap<>();

	static {
		for (GenderType enumInstance : values()) {

			enumMap.put(enumInstance.toString(), enumInstance);
		}
	}

	private GenderType(String representation) {
		this.representation = representation;
	}

	@Override
	public String toString() {
		return representation;
	}

	public static GenderType fromString(String representation) {
		return enumMap.get(representation);
	}

}
