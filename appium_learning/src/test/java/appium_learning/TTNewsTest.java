package appium_learning;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TTNewsTest {
	
	public static AndroidDriver<AndroidElement> driver;
	
	@BeforeClass
	public void initDriver() {
		URL url=null;
		try {
			url = new URL("http://localhost:4723/wd/hub");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		DesiredCapabilities caps=new DesiredCapabilities();
	
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "LRTest7");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.ss.android.article.news");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".activity.SplashBadgeActivity");
		caps.setCapability(MobileCapabilityType.NO_RESET, true);
		driver=new AndroidDriver<>(url,caps);
	}
	
	@AfterClass
	public void closeDriver() {
		driver.closeApp();
		driver.quit();
	}
	@Test
	public void testOpen() {
		System.out.println(driver.getOrientation());//获取方向（竖屏or横屏）
		
		Dimension dim=driver.manage().window().getSize();//获取屏幕像素大小
		System.out.println(dim.width+","+dim.height);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
