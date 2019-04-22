package com.lr.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Demo {
	public static void main(String[]args) {
		URL url=null;
		try {
			url = new URL("http://localhost:4723/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//这个url地址是指向服务器的（需要开启appium的server)
		DesiredCapabilities caps=new DesiredCapabilities();//负责启动服务端时的参数设置
		//指定要测访问哪个测试机
		caps.setCapability("deviceName", "Nexus_5_API_24");//使用的设备名称（必写）
		caps.setCapability("platformName", "Android");//测试的手机操作系统（可选）
		caps.setCapability("platformVersion", "7.0");//手机系统版本（可选）
		//指定要测哪个软件
		caps.setCapability("appPackage", "com.android.calculator2");//软件包名
		caps.setCapability("appActivity", ".Calculator");//确定启动界面的activity
		AndroidDriver<AndroidElement> driver=new AndroidDriver<>(url,caps);//需远程运行
		//定位元素
		driver.findElementById("com.android.calculator2:id/digit_7").click();
		driver.findElementById("com.android.calculator2:id/op_add").click();
		driver.findElementById("com.android.calculator2:id/digit_6").click();
		driver.findElementById("com.android.calculator2:id/eq").click();
		//写检查点
		String actual=driver.findElementById("com.android.calculator2:id/result").getText();//拿出实际值
		String expected="13";
		System.out.println(actual.equals(expected)?"pass":"fail");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.closeApp();
		driver.quit();
	}

}
