package com.lr.youdao_note.test;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import com.lr.youdao_note.pages.MainActivity;
import com.lr.youdao_note.pages.NoteEditActivity;


public class NewNoteTest extends BaseTest{
	@Test(description = "添加一份新笔记，有标题，但是没内容")
	public void addNewNoteWithTitleNoContent() {
		driver.findElementById("com.youdao.note:id/add_note").click();
		driver.findElementById("com.youdao.note:id/add_icon").click();
		driver.findElementById("com.youdao.note:id/note_title").sendKeys("test-demo2");
		//内容没写
		driver.findElementById("com.youdao.note:id/actionbar_complete_text").click();
		//断言
		try {
			driver.findElementByXPath("//*[@text='保存成功']");//定位toast
		}catch(Exception e) {
			e.printStackTrace();
			fail("未找到toast提示——保存成功");
		}
	}
	
	@Test(description = "添加一份新笔记，有标题，且有内容")
	public void addNewNoteWithTitleContent() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElementById("com.youdao.note:id/add_note").click();
		driver.findElementById("com.youdao.note:id/add_icon").click();
		driver.findElementById("com.youdao.note:id/note_title").sendKeys("test-demo3");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//切到webview
		driver.context("WEBVIEW_com.youdao.note");
		driver.findElementByXPath("//textarea").sendKeys("你好");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.context("NATIVE_APP");
		driver.findElementById("com.youdao.note:id/actionbar_complete_text").click();
		//断言
		try {
			driver.findElementByXPath("//*[@text='保存成功']");
		}catch(Exception e) {
			e.printStackTrace();
			fail("未找到toast提示——保存成功");
		}		
	}
	
	@Test(dataProviderClass=com.lr.test.utils.YoudaoNoteTestData.class,dataProvider="addNewNoteData")
	public void addNewNote(String title,String content,String toastMsg) {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElementById("com.youdao.note:id/add_note").click();
		driver.findElementById("com.youdao.note:id/add_icon").click();
		driver.findElementById("com.youdao.note:id/note_title").sendKeys(title);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//切到webview
		driver.context("WEBVIEW_com.youdao.note");
		driver.findElementByXPath("//textarea").sendKeys(content);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.context("NATIVE_APP");
		driver.findElementById("com.youdao.note:id/actionbar_complete_text").click();
		//断言
		try {
			driver.findElementByXPath("//*[@text='"+toastMsg+"']");
		}catch(Exception e) {
			e.printStackTrace();
			fail("未找到toast提示——"+toastMsg);
		}
	}
	
	@Test(dataProviderClass=com.lr.test.utils.YoudaoNoteTestData.class,dataProvider="addNewNoteData")
	public void addNewNoteTest(String title,String content,String toastMsg) {
		MainActivity mainActivity=new MainActivity(driver);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		mainActivity.clickAddNoteButton();
		mainActivity.clickAddNewNoteButton();
		
		NoteEditActivity noteEditActivity=new NoteEditActivity(driver);
		noteEditActivity.editNote(title, content);
		noteEditActivity.clickFinishButton();
		
		try {
			driver.findElementByXPath("//*[@text='"+toastMsg+"']");			
		}catch(Exception e) {
			e.printStackTrace();
			fail("未找到toast提示——"+toastMsg);
		}
		
	}
	

}
