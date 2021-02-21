package com.qizi.day4.execl4j;

import com.github.crab2died.annotation.ExcelField;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    @ExcelField(title = "用户名")
    private String username;
    @ExcelField(title = "密码")
    private String pwd;

}
