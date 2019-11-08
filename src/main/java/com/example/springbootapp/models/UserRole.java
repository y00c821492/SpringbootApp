package com.example.springbootapp.models;

/**
 * desc: 用户角色
 * author: yudeshui
 * date: 2019/11/6
 **/
public enum UserRole {

    USER(0, "USER"), MANAGER(1, "MANAGER");

    private int role;
    private String name;

    UserRole(int role, String name) {
        this.role = role;
        this.name = name;
    }

    public int getRole() {
        return role;
    }


    public String getName() {
        return name;
    }
}
