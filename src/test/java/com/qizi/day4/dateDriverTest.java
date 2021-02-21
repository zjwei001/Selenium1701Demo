package com.qizi.day4;

import com.qizi.day4.execl4j.User;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dateDriverTest {


    @DataProvider(name = "userlist")
    public Object[][] user(){
        return new Object[][] {{"user","pwd","code"},{"user2","pwd2","code2"}};
    }
    @Test(dataProvider = "userlist")
    public void login(String user,String pwd,String code){
        System.out.println(user+"\t"+pwd+"\t"+code);
    }
}
