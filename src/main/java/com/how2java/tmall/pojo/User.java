package com.how2java.tmall.pojo;

public class User {
    private Integer id;

    private String name;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAnonymousName() {
        if (name == null) {
            return null;
        }
        if (name.length() <= 1) {
            return "*";
        }
        char[] cs = name.toCharArray();
        for(int i = 1;i<cs.length;i++) {
            cs[i] = '*';
        }
        return new String(cs);
    }
}