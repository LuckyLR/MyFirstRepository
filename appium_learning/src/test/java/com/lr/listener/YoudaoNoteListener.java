package com.lr.listener;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

//失败之后自动截屏
public class YoudaoNoteListener extends TestListenerAdapter{
	
	private AndroidDriver<AndroidElement> driver;
	
	@SuppressWarnings("unchecked")
	@Override
	public void onTestFailure(ITestResult tr) {
		
		String directory="screenshot";
		String filename=tr.getTestClass().getName()+"."+tr.getMethod().getMethodName()+"_"
		          +new SimpleDateFormat("yyyy-MM-dd.HHmmss.SSS").format(new Date())+".png";
		try {
			//通过反射获取到执行的那个driver
			driver=(AndroidDriver<AndroidElement>)tr.getTestClass().getRealClass().getField("driver").get(tr.getInstance());
			//自动截屏
			File file=driver.getScreenshotAs(OutputType.FILE);
			File dir=new File(directory);
			if(!dir.exists()) {
				dir.mkdir();
			}
			File png=new File(dir,filename);
			file.renameTo(png);		
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
