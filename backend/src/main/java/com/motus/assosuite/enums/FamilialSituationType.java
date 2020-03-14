package com.motus.assosuite.enums;

import java.util.HashMap;
import java.util.Map;

public enum FamilialSituationType {

	CELIB("single"), MARIED("maried");

	private String representation;

	private static final Map<String, FamilialSituationType> enumMap = new HashMap<>();

	static {
		for (FamilialSituationType enumInstance : values()) {

			enumMap.put(enumInstance.toString(), enumInstance);
		}
	}

	private FamilialSituationType(String representation) {
		this.representation = representation;
	}

	@Override
	public String toString() {
		return representation;
	}

	public static FamilialSituationType fromString(String rep) {
		FamilialSituationType	type = enumMap.get(rep);
		if (type == null) {
			throw new IllegalArgumentException(
					"Enum type does not exists");
		}
		return type;
	}
}
