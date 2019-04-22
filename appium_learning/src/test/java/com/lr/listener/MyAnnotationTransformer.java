package com.lr.listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class MyAnnotationTransformer implements IAnnotationTransformer{
    //失败之后重运行监听器
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		IRetryAnalyzer retry=annotation.getRetryAnalyzer();//重试的分析器
		if(retry==null) {
			annotation.setRetryAnalyzer(MyRetryAnalyzer.class);//将一个分析器放到了annotation里，这个annotation能发现哪些是需要重跑的
		}
	}
	

}
