package com.qizi.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testDemo02 {
    @Test
    public void testEquals(){
        String a ="as";
        String b ="as11";
        Assert.assertEquals(a,b,"a不等于b");
        System.out.println("---------");
    }
    @Test
    public  void AssertNoEqual(){
        int a =1;
        int b=2;
        Assert.assertNotEquals(a,b,"true");
    }
}
