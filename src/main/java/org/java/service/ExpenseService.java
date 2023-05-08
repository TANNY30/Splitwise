package org.java.service;

import org.java.model.*;

import java.util.List;

public class ExpenseService {
    public static Expense createExpense(ExpenseType expenseType, double amount, User paidBy, List<Split> splits, ExpenseMetaData metaData){

        switch(expenseType){
            case EXACT :
                return new ExactExpense(amount, paidBy, metaData,splits);
            case EQUAL :
                int totalSplits= splits.size();
                double splitAmount = (double) Math.round(amount*100/totalSplits)/100.0;
                for(Split split:splits){
                    split.setAmount(splitAmount);
                }
                splits.get(0).setAmount(splitAmount+(amount-splitAmount*totalSplits));
                return new EqualExpense(amount,paidBy,metaData,splits);

            case PERCENT:
                for (Split split: splits){
                    PercentSplit percentSplit = (PercentSplit) split;
                    split.setAmount( (amount*percentSplit.getPercent())/100.0 );
                }
                return new PercentExpense(amount, paidBy, metaData,splits);
            default:
                return null;
        }
    }
}
