/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author sbaba2220
 */
class User {
    private String bookId,bookName,author,publisher;
    private int quantity,issued;
    public User(String bookId,String bookName,String author,String publisher,int quan,int issued) {
        this.bookId=bookId;
        this.bookName=bookName;
        this.author=author;
        this.publisher=publisher;
        this.quantity=quan;
        this.issued=issued;
    }
    public String getbookId() {
        return this.bookId;
    }
    public String getbookName() {
        return this.bookName;
    }
    public String getauthor() {
        return this.author;
    }
    public String getpublisher() {
        return this.publisher;
    }
    public int getquantity() {
        return this.quantity;
    }
    public int getissued() {
        return this.issued;
    }
}
