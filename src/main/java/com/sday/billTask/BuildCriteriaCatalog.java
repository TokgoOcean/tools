package com.sday.billTask;

import java.io.File;
import java.io.IOException;

/**
 * <p>Description: [建立标准目录]</p>
 * Created on 2015年9月14日
 * @author  <a href="mailto: liuxiyang755718048@163.com">刘喜洋</a>
 * @version 1.0 
 * Copyright (c) 2015 JAVA 高级工程师
 */
public class BuildCriteriaCatalog {

	/**
	 * <p>Discription:[在制定路径建立标准目录结构]</p>
	 * Created on 2015年9月14日
	 * @param path
	 * @author:[刘喜洋]
	 */
	public static void build(String path){
		String dirPath = path+"\\3sdayTools";
		newDir(dirPath);
		newDir(dirPath+"\\encryt");
		newDir(dirPath+"\\decryp");
		newDir(dirPath+"\\root");
	}
	
	/**
	 * <p>Discription:[创建文件]</p>
	 * Created on 2015年9月14日
	 * @param filePath
	 * @author:[刘喜洋]
	 */
	public static void newFiel(String filePath) {
		File file = new File(filePath);// "C:\\Users\\QPING\\Desktop\\JavaScript\\2.htm""C:\\Users\\QPING\\Desktop\\JavaScript\\2.htm"
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * <p>Discription:[创建文件夹]</p>
	 * Created on 2015年9月14日
	 * @param dirPath
	 * @author:[刘喜洋]
	 */
	public static void newDir(String dirPath) {
		File file = new File(dirPath);// "C:\\Users\\QPING\\Desktop\\JavaScript"
		// 如果文件夹不存在则创建
		if (!file.exists() && !file.isDirectory()) {
			System.out.println("//不存在,已创建");
			file.mkdir();
		} else {
			System.out.println("//目录存在");
		}
	}
	
}
