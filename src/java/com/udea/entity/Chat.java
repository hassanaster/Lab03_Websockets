/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "chat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chat.findAll", query = "SELECT c FROM Chat c")
    , @NamedQuery(name = "Chat.findByIDSession", query = "SELECT c FROM Chat c WHERE c.chatPK.iDSession = :iDSession")
    , @NamedQuery(name = "Chat.findByNickname", query = "SELECT c FROM Chat c WHERE c.chatPK.nickname = :nickname")
    , @NamedQuery(name = "Chat.findByMessage", query = "SELECT c FROM Chat c WHERE c.message = :message")
    , @NamedQuery(name = "Chat.findByPosition", query = "SELECT c FROM Chat c WHERE c.position = :position")})
public class Chat implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChatPK chatPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "message")
    private String message;
    @Basic(optional = false)
    @NotNull
    @Column(name = "position_")
    private int position;
    @JoinColumn(name = "IDSession", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Session session;
    @JoinColumn(name = "nickname", referencedColumnName = "nickname", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User user;

    public Chat() {
    }

    public Chat(ChatPK chatPK) {
        this.chatPK = chatPK;
    }

    public Chat(ChatPK chatPK, String message, int position) {
        this.chatPK = chatPK;
        this.message = message;
        this.position = position;
    }

    public Chat(int iDSession, String nickname) {
        this.chatPK = new ChatPK(iDSession, nickname);
    }

    public ChatPK getChatPK() {
        return chatPK;
    }

    public void setChatPK(ChatPK chatPK) {
        this.chatPK = chatPK;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chatPK != null ? chatPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chat)) {
            return false;
        }
        Chat other = (Chat) object;
        if ((this.chatPK == null && other.chatPK != null) || (this.chatPK != null && !this.chatPK.equals(other.chatPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.entity.Chat[ chatPK=" + chatPK + " ]";
    }
    
}
