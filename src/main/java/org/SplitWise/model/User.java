package org.SplitWise.model;

public class User {
    private String name;
    private String emailID;
    private String phoneNo;
    private String id;
    // constructor
    public User(String id,String name,String emailID,String phoneNo){
        this.id=id;
        this.name=name;
        this.emailID=emailID;
        this.phoneNo=phoneNo;
    }

    // getters and setters
    public String getId(){
        return this.id;
    }
    public String getEmailID(){
        return this.emailID;
    }
    public String getPhoneNo(){
        return this.phoneNo;
    }
    public String getName(){
        return this.name;
    }

    public void setID(String id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setPhoneNo(String phoneNo){
        this.phoneNo=phoneNo;
    }
    public void setEmailID(String emailID){
        this.emailID=emailID;
    }



}
