package com.lr.listener;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class MyTestListener extends TestListenerAdapter{
	@Override
	public void onTestFailure(ITestResult tr) {
		Reporter.log("监测到有测试方法执行失败，方法名称为："+tr.getName()
		+",该方法在"+tr.getTestClass().getName()+"类中");//结果信息打印到测试报告中
	}


}
