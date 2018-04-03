package com.chori.springsecuritybook.user;

public class NewUser {
    private String name;
    private String password;
    private String confirm;

    public String getName() {
        return name;
    }

    public NewUser setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public NewUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirm() {
        return confirm;
    }

    public NewUser setConfirm(String confirm) {
        this.confirm = confirm;
        return this;
    }

    public boolean isPasswordAndConfirmSame() {
        return password.equals(confirm);
    }
}
