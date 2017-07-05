package com.nsu.advising.QuickAdvising.modal;

public class SellerBook {

    private String bookName;
    private String bookEdition;
    private String bookPrice;
    private String phnNumber;
    private String bookAuthor;
    private String bookDate;

    public SellerBook(String bookName, String bookEdition, String bookPrice, String phnNumber) {

        this.bookName = bookName;
        this.bookEdition = bookEdition;
        this.bookPrice = bookPrice;
        this.phnNumber = phnNumber;
    }

    public SellerBook(String bookName, String bookEdition, String bookPrice, String phnNumber, String bookAuthor, String bookDate) {
        this.bookName = bookName;
        this.bookEdition = bookEdition;
        this.bookPrice = bookPrice;
        this.phnNumber = phnNumber;
        this.bookAuthor = bookAuthor;
        this.bookDate = bookDate;
    }

    public String getBookAuthor() {

        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(String bookEdition) {
        this.bookEdition = bookEdition;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getPhnNumber() {
        return phnNumber;
    }

    public void setPhnNumber(String phnNumber) {
        this.phnNumber = phnNumber;
    }
}
