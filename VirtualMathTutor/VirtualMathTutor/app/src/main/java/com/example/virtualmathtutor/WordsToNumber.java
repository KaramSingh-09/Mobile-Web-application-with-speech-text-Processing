package com.example.virtualmathtutor;

public class WordsToNumber extends Calculator{
    
    private String number[] = new String[30];
    private final int MAX_ArrLen = 30;
    private long num[] = new long[MAX_ArrLen], answer = 0;
    private long num1[] = new long[MAX_ArrLen];
    private int num1Top = 0, tensDigitFlag = 0;
    private long leftOpr, rightOpr;
    public long solution;
    private String operation;
    private static String num_names[]={
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
    "ten",
    "eleven",
    "twelve",
    "thirteen",
    "fourteen",
    "fifteen",
    "sixteen",
    "seventeen",
    "eighteen",
    "nineteen",
    "twenty",
    "thrity",
    "fourty",
    "fifty",
    "sixty",
    "seventy",
    "eighty",
    "ninety",
    "hundred",
    "thousand",
    "lakh",
    "crore",
    "million",
    "billion"
};

private static String opp[]={
    "plus",
    "add",
    "added",
    "addition", 
    "adding",
    "minus",
    "subtract",
    "subtracted",
    "subtracting",
    "subtraction",
    "remove",
    "multipy",
    "times",
    "time",
    "multiplied",
    "multiplying",
    "multiplication",
    "divide",
    "divided" ,
    "dividing", 
    "division",
        "lcm",
        "gcd",
    "+",
    "-",
    "/",
    "*"
};
private final int l1 = num_names.length;
private final int l2 =opp.length;

void solveThis(String s)
{
    s=s+" ";
    int l =s.length();
    String q ="";
    String p ="";
    String left ="";
    String right ="";
    String left_num ="";
    String right_num ="";
    int dig_enc =0;
    int leftnum_done =0;
    int round =0;
    int found =0;
    for(int i=0;i<l;i++)
    {
        char a=s.charAt(i);
        if(Character.isDigit(a))
        {
            if(leftnum_done == 1)
            {
                right_num = right_num + a;
            }
            else
            left_num = left_num+a;
            dig_enc++;
            continue;
        }
        else{
            // controll will come here if it already has extracted all numbers from string..
            if(dig_enc > 0)
            {
                leftnum_done =1;
                dig_enc =0;
            }
        }
        if(a!=' ')
            p=p+a;
        else
        {
            //check for single number names..
            for(int t=0;t<l1;t++)
            {
                if(num_names[t].equalsIgnoreCase(p))
                {
                    found++;
                    q=q+p+' ';
                    if(round > 0)
                    {
                        right = right+p+' ';
                    }
                    // System.out.println(p +" ");
                }
                else{
                    for(int x=0;x<l2;x++)
                    {
                        if(opp[x].equalsIgnoreCase(p))
                        {
                            // We encountered arithmatic expression here..
                            operation = p;
                            left = q;
                            found =0;
                            round ++;
                            leftnum_done =1;
                        }
                    }
                     
                }
            }
            p="";
    }
}
    // now we have evaluated all type of left and right operand correctly..
// System.out.println("left: "+left+"\t right: "+right+"\t operator: "+ operator + "\tleft_num: "+left_num+"\t right_num: "+right_num);
    if(left != "" || left_num != "")
    {
        WordsToNumber temp;
        if(left != "")
        {
             temp = new WordsToNumber();
             leftOpr = temp.wordtoNumFun(left);
//             System.gc(); //running garbage collector..
        }
        else if(left_num != "")
        {
            leftOpr = Long.parseLong(left_num);
//            System.gc(); //running garbage collector..
        }
    }

    if(right != "" || right_num != "")
    {
        WordsToNumber temp;
        if(right != "")
        {
             temp = new WordsToNumber();
             rightOpr = temp.wordtoNumFun(right);
//             System.gc(); //running garbage collector..
        }
        else if(right_num != "")
        {
            rightOpr = Long.parseLong(right_num);
//            System.gc(); //running garbage collector..
        }
    }
// System.out.println("left: "+leftOpr+"\t right: "+rightOpr);
    solution = clculate(leftOpr, rightOpr, operation);
//System.out.println("Your Answer is "+solution+" :)");
}


void operators(String s1)
{
    s1 = s1+" ";
    int l = s1.length();
    String q = "";
    String p = "";
    for(int i=0;i<l;i++)
    {
        char a=s1.charAt(i);
        if(a!=' ')
            p=p+a;
    else
    {
        for(int t=0;t<=l2-1;t++)
        {
            if(opp[t].equalsIgnoreCase(p))
            q=q+p+' ';
        }
        p="";
    }
}
    operation = q;
    // System.out.println("operators: "+operation);
}
    WordsToNumber() {
        number[0] = "zero";
        number[1] = "one";
        number[2] = "two";
        number[3] = "three";
        number[4] = "four";
        number[5] = "five";
        number[6] = "six";
        number[7] = "seven";
        number[8] = "eight";
        number[9] = "nine";
        number[10] = "ten";
        number[11] = "eleven";
        number[12] = "twelve";
        number[13] = "thirteen";
        number[14] = "fourteen";
        number[15] = "fifteen";
        number[16] = "sixteen";
        number[17] = "seventeen";
        number[18] = "eighteen";
        number[19] = "nineteen";
        number[20] = "twenty";
        number[21] = "thirty";
        number[22] = "fourty";
        number[23] = "fifty";
        number[24] = "sixty";
        number[25] = "seventy";
        number[26] = "eighty";
        number[27] = "ninety";
        number[28] = "hundred";
        number[29] = "thousand";
    }

long wordtoNumFun(String wordNum) {

        // String wordNum = "";
        int length = wordNum.length();
        wordNum = wordNum.toLowerCase();
        String seprateNumString[] = new String[MAX_ArrLen];
        int sepNumCount = 0;
        for (int i = 0; i < MAX_ArrLen; i++) {
            seprateNumString[i] = "";
        }
        
        for (int i = 0; i < length; i++) {
            char C = wordNum.charAt(0);
            if (C == ' ') {
                sepNumCount++;
            } else {
                seprateNumString[sepNumCount] = seprateNumString[sepNumCount] + C;
            }
            wordNum = wordNum.substring(1);
        }
        for (int j = 0; j <= sepNumCount; j++) {
            num[j] = convertWordToNum20(seprateNumString[j]);

        }
        for (int j = 0; j <= sepNumCount; j++) { // 2 1000 5 100 60 4

            if (num[0] == 100000) {
                num1[num1Top] = 100000;
                num1Top++;
            } else if (num[0] == 1000) {
                num1[num1Top] = 1000;
                num1Top++;
            } else if (num[0] == 100) {
                num1[num1Top] = 100;
                num1Top++;
            } else if (num[j] == 100000) {
                num1[num1Top - 1] = num1[num1Top - 1] * 100000;

            } else if (num[j] == 1000) {
                num1[num1Top - 1] = num1[num1Top - 1] * 1000;

            } else if (num[j] == 100) {
                num1[num1Top - 1] = num1[num1Top - 1] * 100;

            } else if (num[j] % 10 == 0) {
                tensDigitFlag = 1;
                if (num[j + 1] == 0) {
                    num1[num1Top] = num[j];
                } else {
                    num1[num1Top] = num[j] / 10;

                }
                // num1Top++;
            } else if (tensDigitFlag == 1) {
                num1[num1Top] = num1[num1Top] * 10 + num[j];
                tensDigitFlag = 0;
                num1Top++;

            } else {
                num1[num1Top] = num[j];
                num1Top++;
            }

        }
        for (int j = 0; j <= num1Top; j++) { // 2 1000 5 100 60 4
            answer = answer + num1[j];
        }

        return answer;
    }


    private long convertWordToNum20(String A1) {

        switch (A1) {
            case "":
            case "zero":
                return 0;
            case "one":
                return 1;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
            case "ten":
                return 10;
            case "eleven":
                return 11;
            case "twelve":
                return 12;
            case "thirteen":
                return 13;
            case "fourteen":
                return 14;
            case "fifteen":
                return 15;
            case "sixteen":
                return 16;
            case "seventeen":
                return 17;
            case "eighteen":
                return 18;
            case "nineteen":
                return 19;
            case "twenty":
                return 20;
            case "thirty":
                return 30;
            case "fourty":
                return 40;
            case "fifty":
                return 50;
            case "sixty":
                return 60;
            case "seventy":
                return 70;
            case "eighty":
                return 80;
            case "ninety":
                return 90;
            case "hundred":
                return 100;
            case "thousand":
                return 1000;
            case "lakh":
                return 100000;
            
        }

        long A = 1;
        return A;
    }
    

}