package com.example.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView result;
    EditText num1,num2;
    Button add,sub,mul,div;

    float result_num;
    int nu1,nu2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result=(TextView)findViewById(R.id.result);

        num1=(EditText) findViewById(R.id.num1);
        num2=(EditText) findViewById(R.id.num2);

        add=(Button)findViewById(R.id.add);
        sub=(Button)findViewById(R.id.sub);
        mul=(Button)findViewById(R.id.mul);
        div=(Button)findViewById(R.id.div);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nu1=Integer.parseInt(num1.getText().toString());
                nu2=Integer.parseInt(num2.getText().toString());
                result_num=nu1+nu2;
                result.setText(String.valueOf(result_num));
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nu1=Integer.parseInt(num1.getText().toString());
                nu2=Integer.parseInt(num2.getText().toString());
                result_num=nu1-nu2;
                result.setText(String.valueOf(result_num));
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nu1=Integer.parseInt(num1.getText().toString());
                nu2=Integer.parseInt(num2.getText().toString());
                result_num=nu1*nu2;
                result.setText(String.valueOf(result_num));
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nu1=Integer.parseInt(num1.getText().toString());
                nu2=Integer.parseInt(num2.getText().toString());
                result_num=nu1/nu2;
                result.setText(String.valueOf(result_num));
            }
        });
    }
}
