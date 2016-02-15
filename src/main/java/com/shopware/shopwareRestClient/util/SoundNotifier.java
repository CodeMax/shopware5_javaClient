package com.shopware.shopwareRestClient.util;

public class SoundNotifier {

	public void beepAlarm() throws InterruptedException{
		for(int i = 0; i < 2; i++){
			Thread.sleep(400);
		java.awt.Toolkit.getDefaultToolkit().beep();
		}
	}
	
}
