package org.java.model;

import java.util.List;

public class EqualExpense extends Expense{
    public EqualExpense(double amount,User paidBy,ExpenseMetaData metaData,List<Split> splits){
        super(amount,paidBy,metaData,splits);
    }


    @Override
    public boolean validate(){
        for (Split split: getSplits()){
            if(!(split instanceof EqualSplit)){
                return false;
            }
        }
        return true;

    }

}
