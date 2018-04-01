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
@Table(name = "bookslist", catalog = "LibraryManagement", schema = "")
@NamedQueries({
    @NamedQuery(name = "Bookslist.findAll", query = "SELECT b FROM Bookslist b")
    , @NamedQuery(name = "Bookslist.findByBookid", query = "SELECT b FROM Bookslist b WHERE b.bookid = :bookid")
    , @NamedQuery(name = "Bookslist.findByName", query = "SELECT b FROM Bookslist b WHERE b.name = :name")
    , @NamedQuery(name = "Bookslist.findByAuthor", query = "SELECT b FROM Bookslist b WHERE b.author = :author")
    , @NamedQuery(name = "Bookslist.findByPublisher", query = "SELECT b FROM Bookslist b WHERE b.publisher = :publisher")
    , @NamedQuery(name = "Bookslist.findByQuantity", query = "SELECT b FROM Bookslist b WHERE b.quantity = :quantity")
    , @NamedQuery(name = "Bookslist.findByIssued", query = "SELECT b FROM Bookslist b WHERE b.issued = :issued")})
public class Bookslist implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "bookid")
    private String bookid;
    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "issued")
    private Integer issued;

    public Bookslist() {
    }

    public Bookslist(String bookid) {
        this.bookid = bookid;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        String oldBookid = this.bookid;
        this.bookid = bookid;
        changeSupport.firePropertyChange("bookid", oldBookid, bookid);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        String oldAuthor = this.author;
        this.author = author;
        changeSupport.firePropertyChange("author", oldAuthor, author);
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        String oldPublisher = this.publisher;
        this.publisher = publisher;
        changeSupport.firePropertyChange("publisher", oldPublisher, publisher);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        Integer oldQuantity = this.quantity;
        this.quantity = quantity;
        changeSupport.firePropertyChange("quantity", oldQuantity, quantity);
    }

    public Integer getIssued() {
        return issued;
    }

    public void setIssued(Integer issued) {
        Integer oldIssued = this.issued;
        this.issued = issued;
        changeSupport.firePropertyChange("issued", oldIssued, issued);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookid != null ? bookid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bookslist)) {
            return false;
        }
        Bookslist other = (Bookslist) object;
        if ((this.bookid == null && other.bookid != null) || (this.bookid != null && !this.bookid.equals(other.bookid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.Bookslist[ bookid=" + bookid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
