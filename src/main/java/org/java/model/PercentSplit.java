package org.java.model;

public class PercentSplit extends Split{
    double percent;
    public PercentSplit(User user,double percent){
        super(user);
        this.percent=percent;
    }

    // getters and setters

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
