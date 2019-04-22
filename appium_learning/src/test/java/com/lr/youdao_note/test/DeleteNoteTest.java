package com.lr.youdao_note.test;

import org.testng.annotations.Test;

import com.lr.youdao_note.pages.MainActivity;

public class DeleteNoteTest extends BaseTest{
	
	@Test(description="删除一篇笔记")
	public void deleteNoteTest() {
		MainActivity mainactivity=new MainActivity(driver);
		mainactivity.deleteNoteByIndex(4);
	}
	
	@Test
	public void deleteNote() {
		MainActivity mainactivity=new MainActivity(driver);
		mainactivity.deleteNote(1);
	}

}
