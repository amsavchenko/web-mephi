package com.amsavchenko.web.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hashlogin")
public class LoginHash {

    @Id
    private String hash;
    private String login;

    public LoginHash() {
    }

    public LoginHash(String login, String hash) {
        this.login = login;
        this.hash = hash;
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String login){

        this.login = login;
    }

    public String getHash(){

        return  hash;
    }

    public void setHash(String hash){

        this.hash = hash;
    }

    @Override
    public String toString(){

        return "login: " + login;
    }
}
