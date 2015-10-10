package com.sday.billTask;
/**
 * <p>Description: [起始接口]</p>
 * Created on 2015年9月14日
 * @author  <a href="mailto: liuxiyang755718048@163.com">刘喜洋</a>
 * @version 1.0 
 * Copyright (c) 2015 JAVA 高级工程师
 */
public class Start {

	public static void main(String[] args) {
		//TODO 1。检索或构建3sdayTools完整目录
		String basePath = "D:/service/war/3sday";
		BuildCriteriaCatalog.build(basePath);//构建目录结构
		//创建管理员文档
		//32位(MD5(管理员名称+管理员密码)) 加上  12位(加密机器的mac) 加上 不确定位数(Base64(用户名:用户名长度小于等于12,且只能是英文或数字))
		
		//TODO 2. 初始化管理员列表或数据
		
		//TODO 3. 初始化加密的文件列表或数据
		
	}

}
