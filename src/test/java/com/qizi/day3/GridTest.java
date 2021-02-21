package com.qizi.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {
    WebDriver driver;
    @BeforeMethod
    public void initDriver(String browser, String url) throws MalformedURLException {
        DesiredCapabilities dc=null;
        //DesiredCapabilities dc = DesiredCapabilities.chrome();
        //实例化webdriver
        // driver= new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"),dc);
        //driver.get("https://www.baidu.com");
        if (browser.equals("chrome")) {
            dc = DesiredCapabilities.chrome();
        } else if (browser.equals("firefox")) {
            dc = DesiredCapabilities.firefox();
        } else if (browser.equals("ie")){
            dc = DesiredCapabilities.internetExplorer();
        }else {
            System.out.println("error");
        }

        //实例化webdriver
        String uri = url + "/wd/hub";
        driver = new RemoteWebDriver(new URL(uri), dc);
        driver.get("https://www.baidu.com");
    }

    @Test
    public void testChrome() throws MalformedURLException, InterruptedException {
        //创建一个DesiredCapabilities 类型
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        //实例化webdriver
        driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), dc);
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);
    }

    @Test
    public void testChromeWithmethod() throws MalformedURLException {
        String url = "http://localhost:4445";
        String browser = "chrome";
        initDriver(url, browser);
    }

    @DataProvider(name = "data")
    public Object[][] dataTest() {
        return new Object[][]{{"chrome", "http://localhost:4445"},{"ie","http://localhost:4446"},{"firefox", "http://localhost:4445"}};
    }

    @Test(dataProvider = "data")
    public void testGrid2(String browser, String url) throws MalformedURLException {
        initDriver(browser, url);
    }

    @AfterMethod
    public void closeBroswer() {
        driver.quit();
    }


}
