package com.example.basiccalci;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt1, edt2;
    Button add, sub, multiply, divide, ans;
    TextView tv1;
    float result = 0;
    float num1, num2;
    boolean addition, subtraction, multiplication, division;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        ans = findViewById(R.id.ans);
        tv1=findViewById(R.id.tv1);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Float.parseFloat(edt1.getText().toString());
                num2 = Float.parseFloat(edt2.getText().toString());

                if (TextUtils.isEmpty(edt1.getText().toString()) && TextUtils.isEmpty(edt2.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Enter the Numbers Correctly", Toast.LENGTH_LONG).show();

                } else {
                    addition = true;
                }
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Float.parseFloat(edt1.getText().toString());
                num2 = Float.parseFloat(edt2.getText().toString());

                if (TextUtils.isEmpty(edt1.getText().toString()) && TextUtils.isEmpty(edt2.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Enter the Numbers Correctly", Toast.LENGTH_LONG).show();

                } else {
                    subtraction = true;

                }

            }

        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Float.parseFloat(edt1.getText().toString());
                num2 = Float.parseFloat(edt2.getText().toString());

                if (TextUtils.isEmpty(edt1.getText().toString()) && TextUtils.isEmpty(edt2.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Enter the Numbers Correctly", Toast.LENGTH_LONG).show();

                } else {
                    multiplication = true;
                    edt1.setText(null);
                    edt2.setText(null);
                }

            }

        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Float.parseFloat(edt1.getText().toString());
                num2 = Float.parseFloat(edt2.getText().toString());

                if (TextUtils.isEmpty(edt1.getText().toString()) && TextUtils.isEmpty(edt2.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Enter the Numbers Correctly", Toast.LENGTH_LONG).show();

                } else {
                    division = true;
                    edt1.setText(null);
                    edt2.setText(null);
                }

            }

        });

        ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (addition == true) {
                    result=num1+num2;

                    addition = false;
                }


                if (subtraction == true) {
                    result=num1-num2;
                                        subtraction = false;
                }

                if (multiplication == true) {
                    result=num1*num2;

                    multiplication = false;
                }

                if (division == true) {
                    result=num1/num2;
                    division = false;


                }
                tv1.setText(Float.toString(result));
            }

        });

    }
}
