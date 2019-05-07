package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Stack;

class ShowAnswer
{
    private String result;
    // A utility function to return precedence of a given operator
    // Higher returned value means higher precedence
    static int Prec(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    // The main method that converts given infix expression
    // to postfix expression.
    public void infixToPostfix(String exp)
    {
        // initializing empty String for result
        result = "";
        String temp="";

        // initializing empty stack
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);

            // If the scanned character is an operand, add it to output.
            if (Character.isLetterOrDigit(c))
                temp += c;

                // If the scanned character is an '(', push it to the stack.
            else if (c == '(') {
                stack.push(c);
            }
            // If the scanned character is an ')', pop and output from the stack
            // until an '(' is encountered.
            else if (c == ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop()+" ";
                stack.pop();
            }
            else // an operator is encountered
            {
                result+=temp+" ";
                temp="";
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek()))
                    result += stack.pop()+" ";
                stack.push(c);
            }

        }
        if(temp!="") {
            result+=temp+" ";
        }
        // pop all the operators from the stack
        while (!stack.isEmpty())
            result += stack.pop()+" ";
    }
    public int evaluatePostfix()
    {

        String exp=result;
        //create a stack
        Stack<Integer> stack=new Stack<>();
        int k=0;
        // Scan all characters one by one
        for(int i=0;i<exp.length();i++)
        {
            char c=exp.charAt(i);

            // If the scanned character is an operand (number here),
            // push it to the stack.
            if(Character.isDigit(c))
                k=k*10+c-'0';
            else if(c==' ') {
                if(k!=0)
                    stack.push(k);
                k=0;
            }
            // If the scanned character is an operator, pop two
            // elements from stack apply the operator
            else
            {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch(c)
                {
                    case '+':
                        stack.push(val2+val1);
                        break;

                    case '-':
                        stack.push(val2- val1);
                        break;

                    case '/':
                        stack.push(val2/val1);
                        break;

                    case '*':
                        stack.push(val2*val1);
                        break;
                    case '%':
                        stack.push(val2%val1);
                        break;
                }
            }
        }
        return stack.pop();
    }
}

public class MainActivity extends AppCompatActivity {

    EditText working;

    public void clearAll(View view) {
        working.setText("");
    }

    public void clearLastOne(View view){
        String a=working.getText().toString();
        working.setText(a.substring(0,a.length()-1));
    }

    public void showAnswer(View view){
        ShowAnswer a=new ShowAnswer();
        a.infixToPostfix(working.getText().toString());
        int k=a.evaluatePostfix();
        String b=Integer.toString(k);
        working.setText(b);
    }

    public void addingValue(View view){
        Button b=(Button) view;
        String a,c;
        a=working.getText().toString();
        c=b.getText().toString();
        a+=c;
        working.setText(a);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        working=(EditText)findViewById(R.id.editText);
    }
}
