package com.qizi.day4.execl4j;

import com.github.crab2died.ExcelUtils;
import com.github.crab2died.exceptions.Excel4JException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class readContentByExcel4j {
    @Test
    public void readData(){
        String path ="D:\\driver\\user.xlsx";

        List<User> list;
        try {
            list = ExcelUtils.getInstance().readExcel2Objects(path, User.class);
            System.out.println(list);
            for (User user:list) {
                System.out.println(user.toString());
            }
        } catch (Excel4JException|IOException|InvalidFormatException e) {
            e.printStackTrace();
        }


        }
    @DataProvider(name = "userlist")
    public Object[][] user(){

        return new Object[][] {{"mm","pwd","code"},{"user2","pwd2","code2"}};
    }


    @Test(dataProvider = "userlist")
    public void login(String user,String pwd,String code){
        System.out.println(user+"\t"+pwd+"\t"+code);
    }

}
