package com.lr.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer{
	private static int MAX_TRY=2;//失败后重运行的最大次数
	private int retryCount=1;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(retryCount<=MAX_TRY) {
			System.out.println("----->"+result.getName()+"方法正要被重运行！");
			retryCount++;
			return true;
		}
		return false;
	}
	

}
