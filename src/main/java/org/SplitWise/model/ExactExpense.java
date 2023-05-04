package org.SplitWise.model;

import java.util.List;

public class ExactExpense extends Expense{
    public ExactExpense(double amount, User paidBy, ExpenseMetaData metaData, List<Split> splits){
        super(amount,paidBy,metaData,splits);
    }

    @Override
    public boolean validate(){
        for ( Split split: getSplits()){
            if(!(split instanceof ExactSplit)){
                return false;
            }
        }

        double totalAmount=getAmount();
        double sumSplitAmount=0;
        for(Split split:getSplits()){
            ExactSplit exactSplit = (ExactSplit) split;
            sumSplitAmount+= exactSplit.getAmount();

        }
        if (totalAmount!=sumSplitAmount){
            return false;
        }
        return true;

    }

}
