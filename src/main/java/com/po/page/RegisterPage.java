package com.po.page;

import org.openqa.selenium.By;

public class RegisterPage {
    public static By registerButton = By.xpath("//*[@id=\"normalLoginTab\"]/div[1]/div[2]/a[1]");
    public static By titleInput=By.xpath("//div[@class='title']/h2");
    public static  By usernameInput=By.id("username");
    public static By paswwordInput=By.id("password");
    public static By phoneInput=By.id("phone");
    public static By buttonForregister=By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[4]");
    public static By messgeForWrongphone=By.xpath("//*[@class='phone-desc f-dn']");

}
