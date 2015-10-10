package com.sday.encrytOrDecryp;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

/**
 * <p>Description: [获取本机相关信息]</p>
 * Created on 2015年9月13日
 * @author  <a href="mailto: liuxiyang755718048@163.com">刘喜洋</a>
 * @version 1.0 
 * Copyright (c) 2015 JAVA 高级工程师
 */
public class IPOrMac {

	private static final Logger logger = Logger.getLogger(IPOrMac.class);

	/**
	 * <p>Discription:[获取本机Ip地址]</p>
	 * Created on 2015年9月13日
	 * @return String TCP/IPv4 地址
	 * @author:[刘喜洋]
	 */
	public static String getIp() {
		try {
			InetAddress ia = InetAddress.getLocalHost();
			return ia.getHostAddress();// 本机名称：ia.getHostName();
		} catch (UnknownHostException e) {
			logger.info("======================== getLIp() 获取本机ip地址发生 UnknownHostException 错误：" + e.getMessage());
		}
		return "127.0.0.1";
	}

	/**
	 * <p>Discription:[获取本机mac]</p>
	 * Created on 2015年9月13日
	 * @return String mac
	 * @author:[刘喜洋]
	 */
	public static String getMac() {
		try {
			InetAddress ia = InetAddress.getLocalHost();
			NetworkInterface ni = NetworkInterface.getByInetAddress(ia);
			byte[] mByte = ni.getHardwareAddress();
			String mac = "";
			for (byte deci : mByte) {
				String hexa = Integer.toHexString((int) (deci & 0xff));// 10 to
																		// 16
				if (1 == hexa.length()) {
					hexa = "0" + hexa; // 单字符0补全
				}
				mac += hexa.toUpperCase() + "-";
			}
			return mac.substring(0, (mac.length() - 1));
		} catch (SocketException e) {
			logger.info("======================== getLMac() 获取本机mac地址发生 SocketException 错误：" + e.getMessage());
		} catch (UnknownHostException e) {
			logger.info("======================== getLMac() 获取本机mac地址发生 UnknownHostException 错误：" + e.getMessage());
		}
		return "";
	}

	// 测试
	public static void main(String[] args) {
		System.out.println("IP :" + getIp());
		System.out.println("MAC :" + getMac());
		System.out.println("MAC :" + getMac().replaceAll("-", ""));
		/*
		// 获取Java环境信息和操作系统环境信息
		Properties props = System.getProperties();
		System.out.println("Java的运行环境版本：" + props.getProperty("java.version"));
		System.out.println("Java的运行环境供应商：" + props.getProperty("java.vendor"));
		System.out.println("Java供应商的URL："+ props.getProperty("java.vendor.url"));
		System.out.println("Java的安装路径：" + props.getProperty("java.home"));
		System.out.println("Java的虚拟机规范版本："+ props.getProperty("java.vm.specification.version"));
		System.out.println("Java的虚拟机规范供应商："	+ props.getProperty("java.vm.specification.vendor"));
		System.out.println("Java的虚拟机规范名称："+ props.getProperty("java.vm.specification.name"));
		System.out.println("Java的虚拟机实现版本："+ props.getProperty("java.vm.version"));
		System.out.println("Java的虚拟机实现供应商："	+ props.getProperty("java.vm.vendor"));
		System.out.println("Java的虚拟机实现名称：" + props.getProperty("java.vm.name"));
		System.out.println("Java运行时环境规范版本："	+ props.getProperty("java.specification.version"));
		System.out.println("Java运行时环境规范供应商："+ props.getProperty("java.specification.vender"));
		System.out.println("Java运行时环境规范名称："	+ props.getProperty("java.specification.name"));
		System.out.println("Java的类格式版本号："+ props.getProperty("java.class.version"));
		System.out.println("Java的类路径：" + props.getProperty("java.class.path"));
		System.out.println("加载库时搜索的路径列表："	+ props.getProperty("java.library.path"));
		System.out.println("默认的临时文件路径：" + props.getProperty("java.io.tmpdir"));
		System.out.println("一个或多个扩展目录的路径：" + props.getProperty("java.ext.dirs"));
		System.out.println("操作系统的名称：" + props.getProperty("os.name"));
		System.out.println("操作系统的构架：" + props.getProperty("os.arch"));
		System.out.println("操作系统的版本：" + props.getProperty("os.version"));
		System.out.println("文件分隔符：" + props.getProperty("file.separator"));  //在 unix 系统中是＂／＂
		System.out.println("路径分隔符：" + props.getProperty("path.separator")); // 在 unix 系统中是＂:＂
		System.out.println("行分隔符：" + props.getProperty("line.separator")); // 在 unix系统中是＂/n＂
		System.out.println("用户的账户名称：" + props.getProperty("user.name"));
		System.out.println("用户的主目录：" + props.getProperty("user.home"));
		System.out.println("用户的当前工作目录：" + props.getProperty("user.dir"));
		*/
	}
	
}
