package com.sday.encrytOrDecryp;

import java.util.UUID;
/*
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import net.sf.json.JSONObject;
*/
/**
 * <p>Description: [自主UUID算法]</p>
 * Created on 2015年9月14日
 * @author  <a href="mailto: liuxiyang755718048@163.com">刘喜洋</a>
 * @version 1.0 
 * Copyright (c) 2015 JAVA 高级工程师
 */
public class MyUUID {

	/**
	 * <p>Discription:[返回32的UUID串]</p>
	 * Created on 2015年9月14日
	 * @return String uuid
	 * @author:[刘喜洋]
	 */
	public static String UUID_UC() {
		return UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
	}
/*
	*//**
	 * 随机数种子数据
	 *//*
	public static final String ALL_CHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ`-=[]\\;',./~_+{}|:\"<>?";
	public static int ALL_CHAR_LENGTH = ALL_CHAR.length();

	*//**
	 * 获取指定长度的随机数
	 **//*
	public static String getRandomStr(int length) {
		if (0 >= length) {
			return "";
		}
		Random random = new Random();
		int i = 0;
		StringBuffer strDom = new StringBuffer();
		for (; i < length;) {
			i++;
			strDom.append(ALL_CHAR.charAt(random.nextInt(ALL_CHAR_LENGTH)));
		}
		return strDom.toString();
	}

	*//**
	 * 对输入字符串进行MD5加密
	 **//*
	public final static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
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
			System.out.println("MyUUID MD5 ERROR = " + e);
			return "";
		}
	}

	// 字符标记串
	public static JSONObject mark = JSONObject
			.fromObject("{\"0\":\"0\",\"1\":\"1\",\"2\":\"2\",\"3\":\"3\",\"4\":\"4\",\"5\":\"5\",\"6\":\"6\",\"7\":\"7\",\"8\":\"8\",\"9\":\"9\",\"10\":\"a\",\"11\":\"b\",\"12\":\"c\",\"13\":\"d\",\"14\":\"e\",\"15\":\"f\",\"16\":\"g\",\"17\":\"h\",\"18\":\"i\",\"19\":\"j\",\"20\":\"k\",\"21\":\"l\",\"22\":\"m\",\"23\":\"n\",\"24\":\"o\",\"25\":\"p\",\"26\":\"q\",\"27\":\"r\",\"28\":\"s\",\"29\":\"t\",\"30\":\"u\",\"31\":\"v\",\"32\":\"w\",\"33\":\"x\",\"34\":\"y\",\"35\":\"z\",\"36\":\"A\",\"37\":\"B\",\"38\":\"C\",\"39\":\"D\",\"40\":\"E\",\"41\":\"F\",\"42\":\"G\",\"43\":\"H\",\"44\":\"I\",\"45\":\"J\",\"46\":\"K\",\"47\":\"L\",\"48\":\"M\",\"49\":\"N\",\"50\":\"O\",\"51\":\"P\",\"52\":\"Q\",\"53\":\"R\",\"54\":\"S\",\"55\":\"T\",\"56\":\"U\",\"57\":\"V\",\"58\":\"W\",\"59\":\"X\",\"60\":\"Y\",\"61\":\"Z\",\"a\":\"10\",\"b\":\"11\",\"c\":\"12\",\"d\":\"13\",\"e\":\"14\",\"f\":\"15\",\"g\":\"16\",\"h\":\"17\",\"i\":\"18\",\"j\":\"19\",\"k\":\"20\",\"l\":\"21\",\"m\":\"22\",\"n\":\"23\",\"o\":\"24\",\"p\":\"25\",\"q\":\"26\",\"r\":\"27\",\"s\":\"28\",\"t\":\"29\",\"u\":\"30\",\"v\":\"31\",\"w\":\"32\",\"x\":\"33\",\"y\":\"34\",\"z\":\"35\",\"A\":\"36\",\"B\":\"37\",\"C\":\"38\",\"D\":\"39\",\"E\":\"40\",\"F\":\"41\",\"J\":\"45\",\"H\":\"43\",\"I\":\"44\",\"K\":\"46\",\"L\":\"47\",\"M\":\"48\",\"N\":\"49\",\"O\":\"50\",\"P\":\"51\",\"Q\":\"52\",\"R\":\"53\",\"S\":\"54\",\"T\":\"55\",\"U\":\"56\",\"V\":\"57\",\"W\":\"58\",\"X\":\"59\",\"Y\":\"60\",\"Z\":\"61\"}");

	*//**
	 * 获取2(包含特殊字符),42(包含特殊字符), 8,16,32,64位唯一码
	 **//*
	public static String getMark(int numL) {
		// 2,4,8,16,32,64
		String x64 = UUID() + MD5(getRandomStr(8000));
		if (64 == numL) {
			return x64;
		} else {
			if (32 == numL) {
				String x32 = MD5(x64);
				return x32;
			} else if (16 == numL) {
				StringBuffer sb = new StringBuffer();
				String x32 = MD5(x64);
				for (int i = 0; i <= (x32.length() - 2); i += 2) {
					String a = x32.substring(i, (i + 2));
					int b = 0;
					for (int c = 0; c < a.length(); c++) {
						b += mark.getInt(a.charAt(c) + "");
					}
					sb.append(mark.getString(b + ""));
				}
				return sb.toString();
			} else if (8 == numL) {
				StringBuffer sb = new StringBuffer();
				String x32 = MD5(x64);
				for (int i = 0; i <= (x32.length() - 4); i += 4) {
					String a = x32.substring(i, (i + 4));
					int b = 0;
					for (int c = 0; c < a.length(); c++) {
						b += mark.getInt(a.charAt(c) + "");
					}
					sb.append(mark.getString(b + ""));
				}
				return sb.toString();
			} else if (4 == numL) {
				return getRandomStr(4);
			} else if (2 == numL) {
				return getRandomStr(2);
			} else {
				return x64;
			}
		}

	}

	// 简单测试
	static Map<String, String> maptt = new HashMap<String, String>();
	static long mtt = 0;

	public static void dg() {
		for (int i = 0; i < 999999999; i++) {
			mtt++;
			String mm = getMark(8);
			System.out.println(mtt + "--" + mm);
			if (maptt.containsKey(mm)) {
				System.out.println(mm + "====" + maptt.size());
				return;
			} else {
				maptt.put(mm, mm);
			}
		}
	}
*/
	public static void main(String[] arg) {
//		dg();
		System.out.println(UUID_UC());
	}
}
