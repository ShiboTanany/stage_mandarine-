/**
* DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER. Copyright 1997-2016 NTG Clarity and/or its affiliates. All
* rights reserved. NTG CLARITY is a leader in delivering network, telecom, IT and infrastructure solutions to network
* service providers and medium and large enterprises. www.ntgclarity.com The contents of this file are subject to the
* terms of "NTG Clarity License". You must not use this file except in compliance with the License. You can obtain a
* copy of the License at http://www.ntgclarity.com/ See the License for the specific language governing permissions and
* limitations under the License. Contributor(s): The Initial Developer of the Original Software is NTG Clarity . , Inc.
* Copyright 1997-2016 NTG Clarity. All Rights Reserved. CLASS NAME
* <h4>Description</h4>
* <h4>Notes</h4>
* <h4>References</h4>
* 
 * @author: mandarineDeveloper <A HREF="mailto:hr@ntgclarity.com">mandarine Development Team</A>
* @version Revision: 1.0 Date: 12/10/16 10:22 AM
* @see [String]
* @see [URL]
* @see [Class name#method name]
*/
package com.ntgclarity.mandarine.util;

import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

public class EncryptionUtil {

	public static String encrypt(String value, String encryptionKey, String method) throws Exception {
		if (Utils.isEmptyString(value) || Utils.isEmptyString(encryptionKey) || Utils.isEmptyString(method)) {
			return "";
		} else {
			if (method.toLowerCase().trim().equals("blowfish")) {
				return encryptBlowfish(value, encryptionKey);
			} else if (method.toLowerCase().trim().equals("aes")) {
				return encryptAES(value, encryptionKey);
			} else {
				throw new Exception();
			}
		}
	}

	private static String encryptBlowfish(String value, String encryptionKey) throws Exception {
		byte[] keyData = (encryptionKey).getBytes("UTF8");
		SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish");
		Cipher cipher = Cipher.getInstance("BLOWFISH/CBC/PKCS5Padding");
		byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0 };
		IvParameterSpec ivspec = new IvParameterSpec(iv);
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivspec);
		byte[] hasil = cipher.doFinal(value.getBytes("UTF8"));
		return bytesToHex(hasil);
	}

	private static String encryptAES(String value, String encryptionKey) throws Exception {
		byte[] keyData = (encryptionKey).getBytes("UTF8");
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		KeySpec spec = new PBEKeySpec(encryptionKey.toCharArray(), keyData, 65536, 256);
		SecretKey tmp = factory.generateSecret(spec);
		SecretKeySpec secretKeySpec = new SecretKeySpec(tmp.getEncoded(), "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		IvParameterSpec ivspec = new IvParameterSpec(keyData);
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivspec);
		byte[] hasil = cipher.doFinal(value.getBytes("UTF8"));
		return Base64.encodeBase64String(hasil);
	}

	private static String bytesToHex(byte[] data) {
		if (data == null) {
			return null;
		} else {
			int len = data.length;
			String str = "";
			for (int i = 0; i < len; i++) {
				if ((data[i] & 0xFF) < 16)
					str = str + "0" + java.lang.Integer.toHexString(data[i] & 0xFF);
				else
					str = str + java.lang.Integer.toHexString(data[i] & 0xFF);
			}
			return str.toUpperCase();
		}
	}

	public static String decrypt(String value, String encryptionKey, String method) throws Exception {
		if (Utils.isEmptyString(value) || Utils.isEmptyString(encryptionKey) || Utils.isEmptyString(method)) {
			return "";
		} else {
			if (method.toLowerCase().trim().equals("blowfish")) {
				return decryptBlowfish(value, encryptionKey);
			} else if (method.toLowerCase().trim().equals("aes")) {
				return decryptAES(value, encryptionKey);
			} else {
				throw new Exception();
			}
		}
	}

	public static String decryptBlowfish(String value, String encryptionKey) throws Exception {
		byte[] keyData = (encryptionKey).getBytes("UTF8");
		SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish");
		Cipher cipher = Cipher.getInstance("BLOWFISH/CBC/PKCS5Padding");
		byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0 };
		IvParameterSpec ivspec = new IvParameterSpec(iv);
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivspec);
		byte[] hasil = cipher.doFinal(hexToBytes(value));
		return new String(hasil);
	}

	private static byte[] hexToBytes(String str) {
		if (str == null) {
			return null;
		} else if (str.length() < 2) {
			return null;
		} else {
			int len = str.length() / 2;
			byte[] buffer = new byte[len];
			for (int i = 0; i < len; i++) {
				buffer[i] = (byte) Integer.parseInt(str.substring(i * 2, i * 2 + 2), 16);
			}
			return buffer;
		}

	}

	public static String decryptAES(String value, String encryptionKey) throws Exception {
		byte[] keyData = (encryptionKey).getBytes("UTF8");
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		KeySpec spec = new PBEKeySpec(encryptionKey.toCharArray(), keyData, 65536, 256);
		SecretKey tmp = factory.generateSecret(spec);
		SecretKeySpec secretKeySpec = new SecretKeySpec(tmp.getEncoded(), "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		IvParameterSpec ivspec = new IvParameterSpec(keyData);
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivspec);
		byte[] hasil = cipher.doFinal(Base64.decodeBase64(value));
		return new String(hasil);
	}

}
