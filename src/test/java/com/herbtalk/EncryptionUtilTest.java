package com.herbtalk;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.herbtalk.util.EncryptionUtil;

/**
 * This class contains tests to verify the Encryption Utility.
 * 
 * @author zoheb.nawaz
 *
 */
public class EncryptionUtilTest {

	@Test
	public void testEncryption() {
		List<String> userPasswords = new ArrayList<>();
		userPasswords.add("ohsnap!");
		userPasswords.add("4cpZQzd");
		userPasswords.add("RahRV8i");
		userPasswords.add("2kbSs0KCRYG");
		userPasswords.add("TkHNtRxhfJ8N");
		userPasswords.add("OuSKqaq40dSJ");
		userPasswords.add("8gqzTK6");
		userPasswords.add("p6QbTsU");
		userPasswords.add("Kt2t5yJG8CoL");
		List<String> encryptedPasswords = new ArrayList<>();
		for (String password : userPasswords) {
			try {
				encryptedPasswords.add(EncryptionUtil.encrypt(password, "blowfish"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < userPasswords.size(); i++) {
			System.out.println(userPasswords.get(i) + "-------------------->" + encryptedPasswords.get(i));
		}
		System.out.println(
				"*********************************************************************************************************************");
		for (int i = 0; i < userPasswords.size(); i++) {
			try {
				System.out.println(encryptedPasswords.get(i) + "-------------------->"
						+ EncryptionUtil.decrypt(encryptedPasswords.get(i), "blowfish"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
