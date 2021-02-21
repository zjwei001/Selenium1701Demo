package com.qizi.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class openBrowserTest {
    WebDriver webDriver;

    @BeforeMethod
    public void openBrowser() {
        //指定Firefox exe安装路径
        String driver = "D:\\driver\\geckodriver-v0.29.0-win64\\geckodriver.exe";
        System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
        //DesiredCapabilities cap = new DesiredCapabilities();
        //加载驱动
        System.setProperty("webdriver.gecko.driver", driver);

        FirefoxProfile profile= new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        //System.setProperty("webdriver.firefox.driver", driver);
        //启动FF浏览器
        webDriver = new FirefoxDriver();

    }

    @Test
    public void openFF() throws InterruptedException {
        //open baidu web
        webDriver.get("http://www.baidu.com");
        //webDriver.navigate().to("http://www.baidu.com"); //和webDriver.get()相等


        Thread.sleep(3000);

        //windows最大化
        webDriver.manage().window().maximize();
        webDriver.navigate().back();

        Thread.sleep(3000);

        webDriver.navigate().forward();
        // webDriver.close();//只关闭当前窗口（tab），进程还在
        webDriver.quit(); //关闭进程以及浏览器
    }

    /**
     * 启动百度
     * 等3s
     * 前进
     * 等3s
     * 关闭浏览器
     */
    @Test
    public void TestForwardWithFF() throws InterruptedException {

        webDriver.navigate().to("http://www.baidu.com");
        Thread.sleep(3000);
        webDriver.navigate().back();
        Thread.sleep(3000);
        webDriver.quit();
    }

    @Test
    public void testRefreshFF() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        Thread.sleep(3000);
        webDriver.navigate().refresh();
        Thread.sleep(3000);
        webDriver.quit();
    }

    @Test
    public void getURLFF() throws InterruptedException {

        webDriver.get("https://www.baidu.com");
        //设置窗口500*500
        Dimension di = new Dimension(800, 800);
        webDriver.manage().window().setSize(di);

        Thread.sleep(3000);
        //窗口最大化
        webDriver.manage().window().maximize();
        //获取UR
        String url = webDriver.getCurrentUrl();
        System.out.println("curentURL:" + url);
        Assert.assertEquals(url, "https://www.baidu.com/", "是当前地址");
        Thread.sleep(3000);

        //  webDriver.quit(); //提取到@AfterMethod

    }

    @Test
    public void getTitleFF() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        Thread.sleep(3000);
        //获取title
        String title = webDriver.getTitle();
        System.out.println("getTitle:" + title);
        Thread.sleep(3000);
        String tit = "百度一下，你就知道00";
        Assert.assertEquals(title, tit, "correct title");
        webDriver.quit();
    }

    @Test
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver_win32\\chromedriver.exe");
       webDriver = new ChromeDriver();
        webDriver.get("https://www.baidu.com");
    }

    @Test
    public void openIE() {
        System.setProperty("webdriver.ie.driver", "D:\\魏昭君\\selenium\\driver\\IEDriverServer.exe");
        DesiredCapabilities ieCapa = DesiredCapabilities.internetExplorer();
        //ieCapa.se
        WebDriver webDriver = new InternetExplorerDriver();
        webDriver.get("https://www.baidu.com");
        webDriver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser() {
        webDriver.quit();
    }
}