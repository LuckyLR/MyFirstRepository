package com.lr.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo3 {
	public static void main(String[] args) {
	//  日志分为5个级别，从低到高分别是：Trace、Debug、Info、Warn、Error、Fatal
		Logger logger=LogManager.getLogger();
		logger.error("--> 这是个error");
		logger.warn("--> 这是个warn");
		Thread t = new Thread(new Th2(),"th2");
		t.start();
	}

}

class Th2 implements Runnable{

	@Override
	public void run() {	
		Logger logger = LogManager.getLogger();
		logger.fatal("--> 这是个fatal");
	}
}
