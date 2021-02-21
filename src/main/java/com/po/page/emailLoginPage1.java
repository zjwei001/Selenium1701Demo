package com.po.page;

import org.openqa.selenium.By;

public  class emailLoginPage1 {
    //定义email 文本框的定位方式
    public static By emailInput = By.name("email");
    //定义password文本框的定位方式
    public static By passwordInput = By.name("password");
    //定义登录按钮的定位方式
    public static By loginBUtton = By.id("dologin");
    //定义注册按钮的定位方式
    public static By registerButton = By.xpath("//*[@id=\"normalLoginTab\"]/div[1]/div[2]/a[1]");

}
