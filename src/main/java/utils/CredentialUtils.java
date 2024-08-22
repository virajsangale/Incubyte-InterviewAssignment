package utils;

import java.util.UUID;

public class CredentialUtils {
	public static String generateFirstName() {
		return "FirstName" + UUID.randomUUID().toString().substring(0, 4);
	}

	public static String generateLastName() {
		return "LastName" + UUID.randomUUID().toString().substring(0, 4);
	}

	public static String generateEmail() {
		return "user" + UUID.randomUUID().toString() + "@example.com";
	}

	public static String generatePassword() {
		return "Password@" + UUID.randomUUID().toString().substring(0, 8);
	}

}
