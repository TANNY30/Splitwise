package org.java;

import org.java.controller.ExpenseManager;
import org.java.model.EqualSplit;
import org.java.model.ExpenseType;
import org.java.model.Split;
import org.java.model.User;
import org.java.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    /*
        There will be 3 types of input:

        Expense in the format: EXPENSE <user-id-of-person-who-paid> <Paid Amount> <no-of-users> <space-separated-list-of-users> <EQUAL/EXACT/PERCENT> <space-separated-values-in-case-of-non-equal>

        Show balances for all: SHOW

        Show balances for a single user: SHOW <user-id>
         This is also included in README.md
     */

    public static void main(String[] args) {

        ExpenseManager expenseManager=new ExpenseManager();


        expenseManager.addUser(new User("u1","User1","abs@email.com","978912439"));
        expenseManager.addUser(new User("u2","User2","asdc@email.com","908912889"));
        expenseManager.addUser(new User("u3","User3","loop@email.com","911112899"));
        expenseManager.addUser(new User("u4","User4","qpwle@email.com","978900899"));
        System.out.println("There are 4 users u1 u2 u3 u4 registered.");
        System.out.println("Command formats");
        System.out.println("Expense in the format: EXPENSE <user-id-of-person-who-paid> <Paid Amount> <no-of-users> <space-separated-list-of-users> <EQUAL/EXACT/PERCENT> <space-separated-values-in-case-of-non-equal>");
        System.out.println("Show balances for all: SHOW \n Show balances for a single user: SHOW <user-id>");

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

