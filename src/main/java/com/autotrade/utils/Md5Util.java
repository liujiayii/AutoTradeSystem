package com.autotrade.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @ClassName: Md5Util
 * @description 密码加密算法用于对照Shiro框架加密算法
 * @author ZhaoSong
 * @createDate 2019年1月3日
 */
public class Md5Util {

	/**
	 * @Title: md5
	 * @description 密码加密算法
	 * @param @param password 密码 
	 * @param @param salt 盐值
	 * @return String 返回与SHIRO加密条件一致的字符串   
	 * @author ZhaoSong
	 * @createDate 2019年1月3日
	 */
	public final static String md5(String password, String salt){
	    //加密方式
	    String hashAlgorithmName = "MD5";
	    //盐：为了即使相同的密码不同的盐加密后的结果也不同
	    ByteSource byteSalt = ByteSource.Util.bytes(salt);
	    //密码
	    Object source = password;
	    //加密次数
	    int hashIterations = 1024;
	    SimpleHash result = new SimpleHash(hashAlgorithmName, source, byteSalt, hashIterations);
	    return result.toString();
	}
}
