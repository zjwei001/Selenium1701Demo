package com.qizi.day4;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriverTest {
    @DataProvider(name = "loginUser")
    public Object[][] data1(){
        return new  Object[][] {{"wzjg13002","wzj4663050","VerifiedCode"},{"user2","pwd1",""}};
    }
    @Test(dataProvider = "data1")
    public void loginTest(String user,String pwd){
        System.out.println(user+pwd);
    }
    @Test(dataProvider = "data1")
    public void loginTest(String user,String pwd,String code){
        System.out.println(user+pwd+code);
    }
}
