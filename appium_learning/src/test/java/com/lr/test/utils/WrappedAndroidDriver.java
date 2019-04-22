package com.lr.test.utils;

import java.net.URL;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

//自己封装的带有日志的AndroidDriver
@SuppressWarnings("unchecked")
public class WrappedAndroidDriver<T extends WebElement> extends AndroidDriver<T>{

	private Logger logger=LogManager.getLogger();

	public WrappedAndroidDriver(URL remoteAddress, Capabilities desiredCapabilities) {
		super(remoteAddress, desiredCapabilities);
		
	}
	
	@Override
	public T findElementByXPath(String using) {	
		try {
			T element=(T) super.findElementByXPath(using);
			logger.info("XPath为"+using+"的元素已找到");
			return element;
		}catch(Exception e) {
			logger.error("XPath为"+using+"的元素未找到");
			e.printStackTrace();
			throw e;
		}		
	}

	@Override
	public T findElementById(String id) {
		try {
			T element = (T) super.findElementById(id);
			logger.info("ID为"+id+"的元素已找到");
			return element;
		}catch(Exception e) {
			logger.error("ID为"+id+"的元素未找到");
			e.printStackTrace();
			throw e;
		}
	}
	

}
