package com.lr.test.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


//读取配置文件
public class Configuration {
	private Properties prop=new Properties();
	public  Configuration(String configFile) {
		//获取当前类——然后获取当前类加载器，即获取到了类所在的classpath路径
		InputStream is=this.getClass().getClassLoader().getResourceAsStream(configFile);
		try {
			prop.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public String getConfig(String key) {
		String value=prop.getProperty(key);
		return value;
	}

}
