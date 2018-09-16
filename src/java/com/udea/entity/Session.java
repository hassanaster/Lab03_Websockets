/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "session")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Session.findAll", query = "SELECT s FROM Session s")
    , @NamedQuery(name = "Session.findById", query = "SELECT s FROM Session s WHERE s.id = :id")
    , @NamedQuery(name = "Session.findByDateBegin", query = "SELECT s FROM Session s WHERE s.dateBegin = :dateBegin")
    , @NamedQuery(name = "Session.findByDateFinish", query = "SELECT s FROM Session s WHERE s.dateFinish = :dateFinish")
    , @NamedQuery(name = "Session.findByMaxNumber", query = "SELECT s FROM Session s WHERE s.maxNumber = :maxNumber")})
public class Session implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateBegin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateBegin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateFinish")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFinish;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaxNumber")
    private int maxNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "session", fetch = FetchType.EAGER)
    private Collection<Chat> chatCollection;

    public Session() {
    }

    public Session(Integer id) {
        this.id = id;
    }

    public Session(Integer id, Date dateBegin, Date dateFinish, int maxNumber) {
        this.id = id;
        this.dateBegin = dateBegin;
        this.dateFinish = dateFinish;
        this.maxNumber = maxNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    @XmlTransient
    public Collection<Chat> getChatCollection() {
        return chatCollection;
    }

    public void setChatCollection(Collection<Chat> chatCollection) {
        this.chatCollection = chatCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Session)) {
            return false;
        }
        Session other = (Session) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.entity.Session[ id=" + id + " ]";
    }
    
}
