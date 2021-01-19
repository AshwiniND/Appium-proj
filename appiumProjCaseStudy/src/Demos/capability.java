package Demos;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class capability {

	public static AndroidDriver<AndroidElement> capability() throws Exception {
		//when i am running my project on a remote device
		//remote device is an emulator
		// i want to check do my emulator has this capability
		DesiredCapabilities rep= new DesiredCapabilities();
		rep.setCapability(MobileCapabilityType.DEVICE_NAME,"Ashwini Android");
		rep.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		//this is not mandatory, if i remove this it will work.but for ios this is mandate
		rep.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
		//this is my first web app
		rep.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		//There are specific capabilities
		rep.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Users\\AshwiniND\\Downloads\\chromedriver_win32\\chromedriver.exe");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),rep);
		
		return driver;

	}

}
