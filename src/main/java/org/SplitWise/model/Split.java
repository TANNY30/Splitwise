package org.SplitWise.model;

public abstract class Split {
    private User user;
    public double amount;
    public Split(User user){
        this.user=user;
    }

    // getters and setters

    public User getUser(){
        return this.user;
    }
    public double getAmount(){
        return this.amount;
    }

    public void setUser(User user){
        this.user=user;
    }

    public void setAmount(double amount){
        this.amount=amount;
    }


}
