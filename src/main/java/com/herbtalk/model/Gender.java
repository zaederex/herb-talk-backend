package com.herbtalk.model;

/**
 * This enum represents the gender of a user.
 * 
 * @author zoheb.nawaz
 *
 */
public enum Gender {
	/**
	 * Represents male.
	 */
	MALE("MALE"),
	/**
	 * Represents female.
	 */
	FEMALE("FEMALE"),
	/**
	 * Represents unspecified.
	 */
	UNSPECIFIED("UNSPECIFIED");

	private String value;

	private Gender(String value) {
		this.value = value;

	}

	public static Gender getGenderByChar(String gender) {
		switch (gender) {
		case "MALE":
			return Gender.MALE;
		case "FEMALE":
			return Gender.FEMALE;
		case "UNSPECIFIED":
			return Gender.UNSPECIFIED;
		default:
			throw new IllegalArgumentException("No gender defined for given character");
		}
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}