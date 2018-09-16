/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author HP
 */
@Embeddable
public class ChatPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSession")
    private int iDSession;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nickname")
    private String nickname;

    public ChatPK() {
    }

    public ChatPK(int iDSession, String nickname) {
        this.iDSession = iDSession;
        this.nickname = nickname;
    }

    public int getIDSession() {
        return iDSession;
    }

    public void setIDSession(int iDSession) {
        this.iDSession = iDSession;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iDSession;
        hash += (nickname != null ? nickname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChatPK)) {
            return false;
        }
        ChatPK other = (ChatPK) object;
        if (this.iDSession != other.iDSession) {
            return false;
        }
        if ((this.nickname == null && other.nickname != null) || (this.nickname != null && !this.nickname.equals(other.nickname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.entity.ChatPK[ iDSession=" + iDSession + ", nickname=" + nickname + " ]";
    }
    
}
