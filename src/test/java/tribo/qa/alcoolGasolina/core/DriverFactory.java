package tribo.qa.alcoolGasolina.core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static AndroidDriver driver;

    public static AndroidDriver getDriver(){
        if(driver == null){
            createLocalConection();
            //createRemoteConection();
        }
        return driver;
    }

    private static void createLocalConection()  {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setCapability("appium:platformName", "Android");
        options.setCapability("appium:deviceName", "Emulator");
        options.setCapability("appium:automationName", "uiautomator2");


        //options.setCapability("appium:appPackage", "br.triboqa.alcool_ou_gasolina");
        //options.setCapability("appium:appActivity", "br.triboqa.alcool_ou_gasolina.MainActivity");

        options.setCapability("appium:noReset", false);
        options.setCapability("appium:fastReset", true);
        options.setCapability("appium:allowTestPackages", true);

        options.setCapability("appium:newCommandTimeout", 3600);
        options.setCapability("appium:connectHardwareKeyboard", true);


        String appPath = System.getProperty("user.dir") + "/src/test/resources/app/app_appium_automation.apk";
        options.setApp(appPath);

        try{
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        }catch (MalformedURLException e){
            e.getStackTrace();
        }
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       }

/*
     private static void createRemoteConection()  {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", "storage:filename=app_appium_automation.apk");
        caps.setCapability("appium:automationName", "UiAutomator2");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", "oauth-leafarccomputacao-a09e8");
        sauceOptions.setCapability("accessKey", "051bee8f-975b-4e53-989a-48418e4fc6b7");
        sauceOptions.setCapability("build", "appium-build-3NSGU");
        sauceOptions.setCapability("name", "Teste automatizado app Alcool ou Gasolina");


        sauceOptions.setCapability("vitals", true);
        caps.setCapability("sauce:options", sauceOptions);


        try{
            driver = new AndroidDriver(new URL("https://oauth-leafarccomputacao-a09e8:051bee8f-975b-4e53-989a-48418e4fc6b7@ondemand.us-west-1.saucelabs.com:443/wd/hub"), caps);

        }catch (MalformedURLException e){
            e.getStackTrace();
        }
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    */

       public static void KillDriver(){
        if(driver !=null){
            driver.quit();
            driver = null;
        }
    }

}
