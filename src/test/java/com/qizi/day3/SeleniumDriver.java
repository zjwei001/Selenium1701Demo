package com.qizi.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class SeleniumDriver {
   static String path = System.getProperty("user.dir");

   static WebDriver webDriver;

    public static WebDriver initDriver(String browser) {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", path + "/drivers/chromedriver.exe");
            webDriver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("", path + "");
            webDriver = new FirefoxDriver();

        } else if (browser.equals("ie")) {
            System.setProperty("", path + "");
            webDriver = new InternetExplorerDriver();
        } else if (browser.equals("edge")) {
            webDriver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser,please confirm!!");
        }
        return webDriver;
    }

    @Test
    public static void test() {
        System.out.println(System.getProperty("user.dir"));
    }
}
