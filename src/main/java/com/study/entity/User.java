package com.study.entity;

/**
 * 用户实体类
 * Created by Administrator on 2017/8/20.
 */
public class User {

    private  String use_id;
    private  String  userName;
    private  Integer  age;
    private  String  sex;

    public String getUse_id() {
        return use_id;
    }

    public void setUse_id(String use_id) {
        this.use_id = use_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
