package com.qizi.day3;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class sendEmailPO {

    @Test
    public static void sendEmail() throws InterruptedException {
        register.openBrowser1("https://mail.163.com/");
        register.loginPO("wzjg13002","wzj4663050");
        sendEmail.sendEmailPO("wzjg13002@163.com","qizi","C:\\Users\\86134\\Pictures\\王忠杰.jpg","LOve qizi!");
    }
}
