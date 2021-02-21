package com.qizi.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class phtantom {


    @Test
    public void pthantomTest(){
        System.setProperty("phantomjs.binary.path","D:\\IdeaProjects\\SeleniumDemo1701\\drivers\\phantomjs.exe");


        WebDriver driver = new PhantomJSDriver();
        driver.get("http://www.baidu.com");
       driver.findElement(By.xpath("//*[text()='新闻']")).click();
       String handle=driver.getWindowHandle();
        for (String handles:driver.getWindowHandles()){
        if(handles.equals(handle)){
            continue;
        }
           driver.switchTo().window(handles);
        }
        String title =driver.getCurrentUrl();
        Assert.assertEquals(title,"http://news.baidu.com/");
    }
}
