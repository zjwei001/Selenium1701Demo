package com.qizi.day3;

import org.testng.annotations.Test;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.setOut;

public class testing {
    @Test
    public void test() {
        String s = String.valueOf(currentTimeMillis());
        System.out.println(s);
        String s2 = (String) String.valueOf(System.currentTimeMillis() / 100);
        System.out.println(s2);
    }
}