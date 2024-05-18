package com.example.virtualmathtutor;

import java.util.Scanner;
public class Calculator{
    long clculate(long number1, long number2, String operation)
    {
        long result =0;
        String arithmatic_expression = operation;
        if(operation != "+" || operation != "-" || operation != "*" ||operation != "/")
         arithmatic_expression = operation.toLowerCase();
        switch(arithmatic_expression)
        {
            case "add":
            case "addintion":
            case "added":
            case "plus":
            case "adding":
            case "addition":
            case "+":
               result = number1 + number2; 
                break;

            case "minus":
            case "subtract":
            case "subtracted":
            case "subtracting":
            case "subtraction":
            case "remove":
            case "-":
            result = number1 - number2; 
            break;

            case "multipy":
            case "times":
            case "time":
            case "multiplied":
            case "multiplying":
            case "multiplication":
            case "*":
            result = number1 * number2; 
            break;

            case "divide":
            case "divided" :
            case "dividing": 
            case "division":        
            case "/":
            if(number2 == 0)
            {
                System.out.println("Can't Divide with zero..");
                break;
            }
            result = number1 / number2; 
            break;
            default:
              {  System.out.printf("Oop!! I did't got the question :(");
              result =0;
        }
    }
    return result;
    }

        public static int g_c_d(int x,int y)
        {
            while(x!=y)
            {
                if(x>y)
                {
                    x=x-y;
                }
                else
                {
                    y=y-x;
                }


            }
            return x;
        }

    public static int gcd(int x,int y)
    {
        if(x==0)
        {
            return y;
        }
        return gcd(y%x,x);
    }

    static int l_c_m(int x,int y)
    {
        return(x/gcd(x,y))*y;
    }


}