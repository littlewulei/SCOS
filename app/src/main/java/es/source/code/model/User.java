package es.source.code.model;

/**
 * Created by LEI on 2017/10/14.
 */

//用户类设计为单例模式
public class User {
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

    public String GetteruserName() {
        return this.userName;
    }
    public String Getterpassword() {
        return this.password;
    }
    public Boolean GetteroldUser() {
        return this.oldUser;
    }
    public void SetteruserName(String string) {
        this.userName = string;
    }
    public void Setterpassword(String string) {
        this.password = string;
    }
    public void SetteroldUser(Boolean boolean1) {
        this.oldUser = boolean1;
    }
}