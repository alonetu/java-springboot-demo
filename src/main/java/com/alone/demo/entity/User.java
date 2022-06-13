package com.alone.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String username;
//  作用是忽略该字段，不展示给前端
    @JsonIgnore
    private String password;
    private String nickname;
    private String email;
}
