package appium_learning;

import static org.testng.Assert.fail;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class YoudaoNoteTest {
  private AndroidDriver<AndroidElement> driver;
	
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
		caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\lirong3\\eclipse-workspace\\appium_learning\\app\\youdaonote_android_6.6.6_youdaoweb.apk");//值是所在的url
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.youdao.note");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".activity2.SplashActivity");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		caps.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "D:\\appiumWD\\chromedriver_2.22\\chromedriver.exe");
		caps.setCapability(MobileCapabilityType.NO_RESET, true);//这样就不会每次都按首次运行，请求权限了，即不会全新的运行了
		
		driver=new AndroidDriver<>(url,caps);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//做全局的超时等待，即如果一个元素找不到会持续的找5秒
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
		
		/*
		File file=driver.getScreenshotAs(OutputType.FILE);//截屏
		file.renameTo(new File("d:\\youdao.png"));//截的屏图片放到d盘
		*/
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_POWER);//按下电源键
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_POWER);//再按下电源键
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Test
	public void testAddNote() {
		driver.findElementById("com.youdao.note:id/add_note").click();
		/*
		List<AndroidElement> imageViews=driver.findElementsByClassName("android.widget.ImageView");
		System.out.println(imageViews.size());
		imageViews.get(3).click();
		*/
		//driver.findElementByAccessibilityId("云文档").click();
		driver.findElementById("com.youdao.note:id/add_icon").click();
		driver.findElementById("com.youdao.note:id/note_title").sendKeys("test-demo1");
		driver.findElementById("com.youdao.note:id/actionbar_complete_text").click();		
	}
	
	@Test
	public void testTouchAction() {
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_POWER);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_POWER);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//上滑出九宫格
		driver.performTouchAction(new TouchAction(driver)
				//.press(driver.findElementById("com.android.systemui:id/keyguard_indication_text"))//点击
				//.moveTo(driver.findElementById("com.android.systemui:id/clock_view"))//移动
				.press(PointOption.point(540, 1700))
				.moveTo(PointOption.point(540, 200))
				.waitAction()
				.release()//松手
		);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		//手势密码解锁L
		Dimension dim=driver.manage().window().getSize();	
		Point startPoint=new Point(dim.width/4,dim.height/2);//获得九宫格的第一个点
		int stepX=dim.width/4;
		int stepY=dim.width/4+20;
		driver.performTouchAction(new TouchAction(driver)
				.press(PointOption.point(startPoint.x,startPoint.y))
				.moveTo(PointOption.point(startPoint.x,startPoint.y+stepY))
				.waitAction()
				.moveTo(PointOption.point(startPoint.x,startPoint.y+2*stepY))
				.moveTo(PointOption.point(startPoint.x+stepX,startPoint.y+2*stepY))
				.moveTo(PointOption.point(startPoint.x+2*stepX,startPoint.y+2*stepY))
				.release()			
		);		
	}
	
	@Test
	public void testXpath() {
		/*
		driver.findElementByXPath("//android.view.ViewGroup[@resource-id='com.youdao.note:id/toolbar']/android.widget.ImageButton").click();
		driver.findElementByXPath("//android.view.ViewGroup[contains(@resource-id,'toolbar')]/android.widget.ImageButton").click();
		
		AndroidElement element= driver.findElementByXPath(
				"//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout[last()]/android.widget.LinearLayout[1]/android.widget.TextView");
		*/
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AndroidElement element=driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"欢迎来到全新的有道云笔记\")");
		System.out.println(element.getTagName());
		System.out.println(element.getText());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEdit() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"test\")").click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElementById("com.youdao.note:id/edit").click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(driver.getContextHandles());//这个页面有哪些内容：[NATIVE_APP, WEBVIEW_com.youdao.note]
		driver.context("WEBVIEW_com.youdao.note");//上下文切换，切到webview上
		driver.findElementByXPath("//textarea").sendKeys("abcabc");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.context("NATIVE_APP");//切回native_app，执行在native区域的操作
		driver.findElementById("com.youdao.note:id/actionbar_complete_text").click();//点击“完成”按钮
		//断言（需要加一个全局的超时等待，即持续找5s,5秒内找不到那就是失败了）
		try {
			driver.findElementByXPath("//*[@text='保存成功']");//定位toast
		}catch(Exception e) {
			e.printStackTrace();
			fail("未找到toast提示——保存成功");
		}
		
	}
	
	
}
