/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author sbaba2220
 */
@Entity
@Table(name = "issuedbooks", catalog = "LibraryManagement", schema = "")
@NamedQueries({
    @NamedQuery(name = "Issuedbooks.findAll", query = "SELECT i FROM Issuedbooks i")
    , @NamedQuery(name = "Issuedbooks.findById", query = "SELECT i FROM Issuedbooks i WHERE i.id = :id")
    , @NamedQuery(name = "Issuedbooks.findByBookid", query = "SELECT i FROM Issuedbooks i WHERE i.bookid = :bookid")
    , @NamedQuery(name = "Issuedbooks.findByStudentid", query = "SELECT i FROM Issuedbooks i WHERE i.studentid = :studentid")
    , @NamedQuery(name = "Issuedbooks.findByStudentname", query = "SELECT i FROM Issuedbooks i WHERE i.studentname = :studentname")
    , @NamedQuery(name = "Issuedbooks.findByStudentcontact", query = "SELECT i FROM Issuedbooks i WHERE i.studentcontact = :studentcontact")})
public class Issuedbooks implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "bookid")
    private String bookid;
    @Column(name = "studentid")
    private String studentid;
    @Column(name = "studentname")
    private String studentname;
    @Column(name = "studentcontact")
    private String studentcontact;

    public Issuedbooks() {
    }

    public Issuedbooks(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        String oldBookid = this.bookid;
        this.bookid = bookid;
        changeSupport.firePropertyChange("bookid", oldBookid, bookid);
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        String oldStudentid = this.studentid;
        this.studentid = studentid;
        changeSupport.firePropertyChange("studentid", oldStudentid, studentid);
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        String oldStudentname = this.studentname;
        this.studentname = studentname;
        changeSupport.firePropertyChange("studentname", oldStudentname, studentname);
    }

    public String getStudentcontact() {
        return studentcontact;
    }

    public void setStudentcontact(String studentcontact) {
        String oldStudentcontact = this.studentcontact;
        this.studentcontact = studentcontact;
        changeSupport.firePropertyChange("studentcontact", oldStudentcontact, studentcontact);
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
        if (!(object instanceof Issuedbooks)) {
            return false;
        }
        Issuedbooks other = (Issuedbooks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.Issuedbooks[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
