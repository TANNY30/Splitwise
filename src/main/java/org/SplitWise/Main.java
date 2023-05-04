package org.SplitWise;

import org.SplitWise.controller.ExpenseManager;
import org.SplitWise.model.EqualSplit;
import org.SplitWise.model.ExpenseType;
import org.SplitWise.model.Split;
import org.SplitWise.model.User;
import org.SplitWise.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        ExpenseManager expenseManager=new ExpenseManager();
        expenseManager.addUser(new User("u1","User1","abs@email.com","978912439"));
        expenseManager.addUser(new User("u2","User2","asdc@email.com","908912889"));
        expenseManager.addUser(new User("u3","User3","loop@email.com","911112899"));
        expenseManager.addUser(new User("u4","User4","qpwle@email.com","978900899"));
        Scanner scanner=new Scanner(System.in);
        while(true){
            String command = scanner.nextLine();
            String[] commands = command.split(" ");
            String commandType = commands[0];
            switch (commandType){
                case "SHOW":
                    if (commands.length==1){
                        expenseManager.showBalances();
                    }
                    else{
                        expenseManager.showBalance(commands[1]);

                    }
                    break;

                case "EXPENSE":
                    String PaidBy=commands[1];
                    Double amount = Double.parseDouble(commands[2]);
                    int noOfUsers=Integer.parseInt(commands[3]);
                    String expenseType = commands[4 + noOfUsers];
                    List<Split>splits =new ArrayList<>();
                    switch (expenseType){
                        case "EQUAL":
                            for(int i=0;i<noOfUsers;i++){
                                splits.add(new EqualSplit(expenseManager.userMap.get(commands[i+4])));
                            }
                            expenseManager.addExpense(ExpenseType.EQUAL,amount,PaidBy,splits,null);
                            break;
                        case "EXACT":
                            for (int i = 0; i < noOfUsers; i++) {
                                splits.add(new ExactSplit(expenseManager.userMap.get(commands[4 + i]), Double.parseDouble(commands[5 + noOfUsers + i])));
                            }
                            expenseManager.addExpense(ExpenseType.EXACT, amount, PaidBy, splits, null);
                            break;
                        case "PERCENT":
                            for (int i = 0; i < noOfUsers; i++) {
                                splits.add(new PercentSplit(expenseManager.userMap.get(commands[4 + i]), Double.parseDouble(commands[5 + noOfUsers + i])));
                            }
                            expenseManager.addExpense(ExpenseType.PERCENT, amount, PaidBy, splits, null);
                            break;
                    }
                    break;
            }

                    }




        }



    }
