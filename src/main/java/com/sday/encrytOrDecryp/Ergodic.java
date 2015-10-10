package com.sday.encrytOrDecryp;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.filechooser.FileSystemView;

/**
 * <p>Description: [文件目录操作，及遍历寻找操作]</p>
 * Created on 2015年9月14日
 * @author  <a href="mailto: liuxiyang755718048@163.com">刘喜洋</a>
 * @version 1.0 
 * Copyright (c) 2015 JAVA 高级工程师
 */
public class Ergodic {

	private static ArrayList<String> filelist = new ArrayList<String>();
	/**
	 * <p>Discription:[遍历指定路径，并将遍历结果放入ArrayList<String> 数组中]</p>
	 * Created on 2015年9月14日
	 * @param strPath
	 * @author:[刘喜洋]
	 */
    public static void refreshFileList(String strPath) { 
        File dir = new File(strPath); 
        File[] files = dir.listFiles(); 
        
        if (files == null) 
            return; 
        for (int i = 0; i < files.length; i++) { 
            if (files[i].isDirectory()) { 
                refreshFileList(files[i].getAbsolutePath()); 
            } else { 
//                String strFileName = files[i].getAbsolutePath().toLowerCase();
//                System.out.println("---"+strFileName);
                filelist.add(files[i].getAbsolutePath());                    
            } 
        } 
    }
    
    /**
     * <p>Discription:[计算盘符大小]</p>
     * Created on 2015年9月14日
     * @param fileS
     * @return
     * @author:[刘喜洋]
     */
    public static long FILE_SIZE_K = 1024L;
    public static long FILE_SIZE_M = 1048576L;
    public static long FILE_SIZE_G = 1073741824L;
    public static long FILE_SIZE_T = 1099511627776L;
    public static DecimalFormat df = new DecimalFormat("#.00");    
	public static String FormetFileSize(long fsB) {
		String size = "0.00";
		if(FILE_SIZE_K>fsB){
			size = df.format((double)fsB)+"B";
		}else if(FILE_SIZE_M>fsB){
			size = df.format(((double)fsB)/FILE_SIZE_K)+"K";
		}else if(FILE_SIZE_G>fsB){
			size = df.format(((double)fsB)/FILE_SIZE_M)+"M";
		}else if(FILE_SIZE_T>fsB){
			size = df.format(((double)fsB)/FILE_SIZE_G)+"G";
		}else{
			size = df.format(((double)fsB)/FILE_SIZE_T)+"T";
		}
		return size;
	}
 
    /**
     * <p>Discription:[获得每一个盘符]</p>
     * Created on 2015年9月14日
     * @author:[刘喜洋]
     */
    public static void driver(){
        // 当前文件系统类
        FileSystemView fsv = FileSystemView.getFileSystemView();
        // 列出所有windows 磁盘
        File[] fs = File.listRoots();
        // 显示磁盘卷标
        for(File f : fs){
        	System.out.println(fsv.getSystemDisplayName(f));
        	System.out.println(f.getAbsolutePath());
        	System.out.println(FormetFileSize(f.getFreeSpace())+"可用,共 "+FormetFileSize(f.getTotalSpace()));
        }
    }
    
    
    // 测试
    public static void main(String[] args) {
    	// 获取盘符信息
    	driver();
    	String userDir = System.getProperty("user.dir");
    	System.out.println(userDir);
    	refreshFileList(userDir);
    	for(String path : filelist){
        	System.out.println("----------------------------- "+path);
        }      
	}
    
}
