package com.project.shoes.loginrealm.vo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by carlos on 1/5/18.
 */

public class UserVO extends RealmObject {

    @PrimaryKey
    private Integer id;
    private String user;
    private String password;

    public UserVO() {
    }

    public UserVO(Integer id, String user, String password) {
        this.id = id;
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
