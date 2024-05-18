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

            case "lcm":
                result = l_c_m(number1, number2);
                break;
            case "gcd":
                result = g_c_d(number1, number2);
                break;
            default:
              {  System.out.printf("Oop!! I did't got the question :(");
              result =0;
        }
    }
    return result;
    }

    static long g_c_d(long a, long b)
    {
        // Everything divides 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return g_c_d(a-b, b);
        return g_c_d(a, b-a);
    }

    static long gcd(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // method to return LCM of two numbers
    static long l_c_m(long a, long b)
    {
        return (a / gcd(a, b)) * b;
    }

}