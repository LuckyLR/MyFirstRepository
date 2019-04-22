package com.lr.youdao_note.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NoteEditActivity {
	@AndroidFindBy(id="com.youdao.note:id/note_title")
	private AndroidElement note_title_input;
	
	@FindBy(xpath="//textarea")
	private AndroidElement note_content_input;
	
	@AndroidFindBy(id="com.youdao.note:id/actionbar_complete_text")
	private AndroidElement finish_btn;
	
	private AndroidDriver<AndroidElement> driver;
	public NoteEditActivity(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//写入标题和内容
	public void editNote(String title,String content) {
		note_title_input.sendKeys(title);
		driver.context("WEBVIEW_com.youdao.note");
		note_content_input.sendKeys(content);
	}
	
	//点击完成按钮
	public void clickFinishButton() {
		driver.context("NATIVE_APP");
		finish_btn.click();
	}

}
