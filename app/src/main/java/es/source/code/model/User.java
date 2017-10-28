package es.source.code.model;

import java.io.Serializable;

/**
 * Created by LEI on 2017/10/14.
 */

//用户类设计为单例模式
public class User implements Serializable {
    private User() {
    }
    private static User user = null;
    public static User getInstance() {
        if (user == null) {
            user = new User();
        }
        return user;
    }
    String userName;
    String password;
    Boolean oldUser;

    public String GetuserName() {
        return this.userName;
    }
    public String Getpassword() {
        return this.password;
    }
    public Boolean GetoldUser() {
        return this.oldUser;
    }
    public void SetuserName(String string) {
        this.userName = string;
    }
    public void Setpassword(String string) {
        this.password = string;
    }
    public void SetoldUser(Boolean boolean1) {
        this.oldUser = boolean1;
    }
}