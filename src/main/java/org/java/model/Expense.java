package org.java.model;

import java.util.List;

public abstract class Expense {
    private String id;
    double amount;
    private User paidBy;
    private List<Split> splits;
    private ExpenseMetaData metaData;


    public Expense(double amount,User paidBy,ExpenseMetaData metaData,List<Split> splits){
        this.amount=amount;
        this.paidBy=paidBy;
        this.metaData=metaData;
        this.splits=splits;
    }

    //getters and setters

    public double getAmount() {
        return amount;
    }

    public String getId() {
        return id;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public ExpenseMetaData getMetaData() {
        return metaData;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMetaData(ExpenseMetaData metaData) {
        this.metaData = metaData;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }
    public abstract boolean validate();
}
