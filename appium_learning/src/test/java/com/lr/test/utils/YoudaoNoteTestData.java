package com.lr.test.utils;

import org.testng.annotations.DataProvider;

//测试数据
public class YoudaoNoteTestData {
	@DataProvider(name="addNewNoteData")
	public static Object[][] getaddNewNoteData(){
		Object[][] obj=new Object[][] {
			{"test11","","保存成功"},
			{"test22","123321","保存成功"},
			{"","没标题，有内容","保存成功"}
		};
		return obj;
	}

}
