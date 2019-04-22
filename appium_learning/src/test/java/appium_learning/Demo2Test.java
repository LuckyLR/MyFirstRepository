package appium_learning;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lr.test.Demo2;

public class Demo2Test {
	@Parameters({"x_value","y_value","expected_value"})
	@Test
	public void testCompute1(int x,int y,int expected) {
		Demo2 de=new Demo2();
		/*
		int x=10,y=20;
		int expected=30;*/
		int actual=de.compute(x, y);
		assertEquals(actual,expected);
	}
	
	@DataProvider(name="testData1")
	public Object[][] getTestComputeData(){  //必须是public的，返回一个Object的二维数组
		return new Object[][] {
			{10,20,30},//可定义三组测试值
			{40,10,30},
			{20,20,41}
		};
	}
	
	@Test(dataProvider="testData1")
	public void testCompute2(int x,int y,int expected) {
		Demo2 de=new Demo2();
		int actual=de.compute(x, y);
		assertEquals(actual,expected);
	}

}
