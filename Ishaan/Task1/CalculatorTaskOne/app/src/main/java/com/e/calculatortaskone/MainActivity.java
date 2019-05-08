package com.e.calculatortaskone;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button additionButton, subtractionButton, multiplicationButton, divisionButton;
    TextView output,sign;
    EditText numberOne, numberTwo;

    double result, numOne, numTwo;

    public void onClick(View view)
    {
        if (numberOne.getText().toString().trim().length() == 0 || numberTwo.getText().toString().trim().length() == 0)
        {
            Snackbar.make(view,"Please Input Numbers",Snackbar.LENGTH_SHORT).show();
        }
        else
        {   String tag = view.getTag().toString();
            numOne = Double.parseDouble(numberOne.getText().toString());
            numTwo = Double.parseDouble(numberTwo.getText().toString());

            if(tag.equals("add"))
            {
                result = numOne + numTwo;
                sign.setText("+");
            }
            else if(tag.equals("sub"))
            {
                result = numOne - numTwo;
                sign.setText("-");
            }
            else if(tag.equals("mul"))
            {
                result = numOne * numTwo;
                sign.setText("*");
            }
            else if(tag.equals("div"))
            {
                result = numOne / numTwo;
                sign.setText("/");
            }

            output.setText(String.valueOf(result));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        additionButton = findViewById(R.id.additionButton);
        subtractionButton = findViewById(R.id.subtractionButton);
        multiplicationButton = findViewById(R.id.multiplicationButton);
        divisionButton = findViewById(R.id.divisionButton);
        output = findViewById(R.id.output);
        sign = findViewById(R.id.sign);
        numberOne = findViewById(R.id.numberOne);
        numberTwo = findViewById(R.id.numberTwo);
    }
}
