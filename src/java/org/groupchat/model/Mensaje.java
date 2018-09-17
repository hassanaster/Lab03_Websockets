/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.groupchat.model;

/**
 *
 * @author HP
 */
public class Mensaje {
    static String nickname;
    static String message;

    public Mensaje() {
    }

    public String getNickname() {
        return nickname;
    }

    public String getMessage() {
        return message;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
