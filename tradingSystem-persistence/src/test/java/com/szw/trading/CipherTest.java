package com.szw.trading;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import com.szw.util.PasswordUtil;

import sun.misc.BASE64Decoder;


public class CipherTest {

	public static String _salt = "!@#ZDVT*()QWER$%^BNM";
	public static String _key = "G#$%^1234MasWQlZ";

	public static void main(String args[])
			throws IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {

		String password = "654321";

		String password2 = PasswordUtil.GenHashBySHA256(password, PasswordUtil._salt);

		System.out.println("sha256 : " + password2);

		String password3 = "";

		try {
			password3 = PasswordUtil.aesEncrypt(password2, PasswordUtil._key);
			System.out.println("aes : " + password3);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(_key.getBytes("utf-8"), "AES"));
		byte[] bytes = new BASE64Decoder().decodeBuffer(password3);
		bytes = cipher.doFinal(bytes);

		System.out.println(new String(bytes, "utf-8"));
	}
}
