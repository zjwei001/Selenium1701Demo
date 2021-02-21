package com.qizi.day1;

import org.testng.annotations.*;

public class TestNGDemo1 {
  @BeforeTest
  public  void beforeTest01(){
    System.out.println("This is @beforeTest annotation");
  }
  @BeforeMethod
  public void beforeMethod01(){
    System.out.println("This is @beforemethod");
  }
  @Test
    public void testCase1(){
      System.out.println("This is @test");
  }
  @Test
  public  void testCase2(){
    System.out.println("This is @test2");
  }
  @AfterTest
  public void afterTest01(){
    System.out.println("This is @afterTest01");
  }
  @AfterMethod
  public  void afterMethod01(){
    System.out.println("This is @aftermethod");
  }
}
