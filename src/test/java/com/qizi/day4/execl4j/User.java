package com.qizi.day4.execl4j;

import com.github.crab2died.annotation.ExcelField;
import lombok.*;

import java.util.Collections;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User{
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @ExcelField(title = "用户名")
    private String username;
    @ExcelField(title = "密码")
    private String pwd;

}
