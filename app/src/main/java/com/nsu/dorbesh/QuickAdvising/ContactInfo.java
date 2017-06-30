package com.nsu.dorbesh.QuickAdvising;

public class ContactInfo
{
    private String Sub;
    private String Credit;
    private String GPA;
    private String LetterGrade;
    private String subject;
    private String TotalCredit;
    private String TotalCreditGpa;
    
    
    public ContactInfo(String subject, String credit, String gpa, String letter,String TotalCredit,String Totalcrgpa) {
        this.Sub = subject;
        this.Credit = credit;
        this.GPA = gpa;
        this.subject=subject;
        this.TotalCredit = TotalCredit;
        this.TotalCreditGpa = Totalcrgpa;
        this.LetterGrade = letter;
    }

    public String getClassN() {
        return Sub;
    }

    public void setClassN(String Sub) {
        this.Sub = Sub;
    }

    public String getTime() {
        return Credit;
    }

    public void setTime(String Credit) {
        this.Credit = Credit;
    }

    public String getRoomNo() {
        return GPA;
    }

    public void setRoomNo(String GPA) {
        this.GPA = GPA;
    }

    public String getject() {
        return subject;
    }

    public void setject(String subject) {
        this.subject = subject;
    }

    public String getTotalCredit()
    {
        return TotalCredit;
    }
    public void setTotalCredit(String TotalCredit)
    {
        this.TotalCredit = TotalCredit;
    }
    public String getTotalCreditGpa(){return TotalCreditGpa;}
    public void setTotalCreditGpa(String Totalcrgpa){this.TotalCreditGpa=Totalcrgpa;}
    public String getLetterGrade(){return  LetterGrade;}
    public void setLetterGrade(String letterGrade){this.LetterGrade=letterGrade;}
}
