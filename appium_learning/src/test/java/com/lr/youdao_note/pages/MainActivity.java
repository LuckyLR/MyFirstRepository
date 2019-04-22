package com.lr.youdao_note.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

import static org.testng.Assert.fail;
import static org.testng.asserts.Assertion.*;


public class MainActivity {
	
	private AndroidDriver<AndroidElement> driver;
	
	private Logger logger=LogManager.getLogger();
	
	@AndroidFindBy(xpath="//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout")
	private List<AndroidElement> note_links;
	
	@AndroidFindBy(id="com.youdao.note:id/add_note")
	private AndroidElement add_note_btn;
	
	@AndroidFindBy(id="com.youdao.note:id/add_icon")
	private AndroidElement add_new_note_btn;
	
	public MainActivity(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//点击+按钮
	public void clickAddNoteButton() {
		add_note_btn.click();
	}
	//点击添加新的笔记
	public void clickAddNewNoteButton() {
		add_new_note_btn.click();
	}
	//删除笔记
	@SuppressWarnings({ "rawtypes", "static-access" })
	public void deleteNoteByIndex(int index) {
		Dimension dim=driver.manage().window().getSize();	

		if(index >=note_links.size()) {
			logger.error("超出笔记数量范围");
			fail("超出笔记数量范围");
		}else {
			driver.performTouchAction(new TouchAction(driver).longPress(new PointOption().point(dim.width/2, 498+335*(index-1))));
			
			driver.findElementByXPath("//android.widget.TextView[@text='删除']").click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.findElementById("com.youdao.note:id/btn_ok").click();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//删除笔记方法2
	@SuppressWarnings("rawtypes")
	public void deleteNote(int index) {
		Dimension dim=driver.manage().window().getSize();
		
		if(index>note_links.size()) {
			logger.error("超出笔记数量范围");
			fail("超出笔记数量范围了");
		}else {
			//点击要删除的笔记
			driver.performTouchAction(new TouchAction(driver).tap(PointOption.point(dim.width/2, 498+335*(index-1))));
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//点击...更多按钮
			driver.findElementById("com.youdao.note:id/menu_more").click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//点击删除按钮
			//driver.findElementById("com.youdao.note:id/delete").click();
			driver.findElementByXPath("//android.widget.TextView[@text='删除']").click();
			//点击确定按钮
			driver.findElementById("com.youdao.note:id/btn_ok").click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	

}
