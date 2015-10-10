package com.sday.encrytOrDecryp;

import java.security.MessageDigest;

/**
 * <p>
 * Description: [md5加密]
 * </p>
 * Created on 2015年9月13日
 * 
 * @author <a href="mailto: liuxiyang755718048@163.com">刘喜洋</a>
 * @version 1.0 Copyright (c) 2015 JAVA 高级工程师
 */
public class MD5 {
	public final static String Str2MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 测试
	public static void main(String[] args) {
		System.out.println(MD5.Str2MD5("redRose+123def哈哈"));
		System.out.println(MD5.Str2MD5("123def哈哈"));
		System.out.println(MD5.Str2MD5("test123好"));
	}
}
