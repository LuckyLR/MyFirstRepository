package appium_learning;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo {
    @BeforeClass
    public void beforeClass() {
    	System.out.println("invoke beforeClass");
    }
    @AfterClass
    public void afterClass() {
    	System.out.println("invoke afterClass");
    }
	@BeforeMethod
    public void beforeMethod() {
    	System.out.println("invoke beforeMethod");
    }
    @AfterMethod
    public void afterMethod() {
    	System.out.println("invoke afterMethod");
    }
	@Test(groups= {"g1","gm"})//既属于g1组，也属于gm组
    public void test1() {
    	System.out.println("invoke test1......");
    }
    @Test(groups= {"g2","gm"})
    public void test2() {
    	System.out.println("invoke test2......");
    	//assertEquals(1,1);//断言
    }
    @Test(groups= {"gm"})
    public void test3() {
    	System.out.println("invoke test3......");
    }
    @Test(enabled=false)//本次test4不执行
    public void test4() {
    	System.out.println("invoke test4......");
    }
    @Test(invocationCount=4,successPercentage=50)//test5执行4次,成功2次（50%）即可算通过
    public void test5() {
    	System.out.println("invoke test5......");
    }
    

}
