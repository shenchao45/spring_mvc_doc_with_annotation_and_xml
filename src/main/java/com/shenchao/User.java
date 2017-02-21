package com.shenchao;

import com.fasterxml.jackson.annotation.*;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.Date;

/**
 * Created by shenchao on 2017/2/3.
 */
@JsonIgnoreProperties("name")
@XStreamAlias("user")
public class User {
    public interface WithoutPasswordView {}
    public interface WithPasswordView extends WithoutPasswordView {}
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @JsonIgnore
    @XStreamOmitField
    private Integer id;
    @JsonProperty("HAHAHA")
    private String sex;
    @JsonView(WithPasswordView.class)
    public String getName() {
        return name;
    }
    @JsonView(WithoutPasswordView.class)
    public String getPassword() {
        return password;
    }
    private String password;
    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", id=" + id +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User() {
    }
    public User(String name, Integer id, String sex) {
        this.name = name;
        this.id = id;
        this.sex = sex;
    }
    public User(String name, Integer id, String sex, String password) {
        this.name = name;
        this.id = id;
        this.sex = sex;
        this.password = password;
    }
    public User(String name, Date birthday, Integer id, String sex, String password) {
        this.name = name;
        this.birthday = birthday;
        this.id = id;
        this.sex = sex;
        this.password = password;
    }
}
