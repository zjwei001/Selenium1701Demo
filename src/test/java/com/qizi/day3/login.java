package com.qizi.day3;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class login {
    static WebDriver driver;
    @Test
    public static void login() throws InterruptedException {
        register.openBrowser1("https://mail.163.com/");
        register.loginPO("wzjg13002","wzj4663050");
       // register.closeBrowserAll();

    }
}

