package com.example.calcme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    EditText intext;
    public void Add(View view){
        Log.i("Info","Add Button Pressed");


        EditText InEditText=(EditText)findViewById(R.id.InEditText);
        String Number1=InEditText.getText().toString();
        Double Number1double=Double.parseDouble(Number1);

        EditText InnEditText=(EditText)findViewById(R.id.InnEditText);
        String Number2=InnEditText.getText().toString();
        Double Number2double=Double.parseDouble(Number2);

        Double output=Number1double+Number2double;
        String Output=Double.toString(output);
        Toast.makeText(this, "Addition gives "+Output, Toast.LENGTH_LONG).show();

    }
    public void Subs(View view){
        EditText InEditText=(EditText)findViewById(R.id.InEditText);
        String Number1=InEditText.getText().toString();
        Double Number1double=Double.parseDouble(Number1);

        EditText InnEditText=(EditText)findViewById(R.id.InnEditText);
        String Number2=InnEditText.getText().toString();
        Double Number2double=Double.parseDouble(Number2);

        Double output=Number1double-Number2double;
        String Output=Double.toString(output);
        Toast.makeText(this, "Substraction gives "+Output, Toast.LENGTH_LONG).show();
    }
    public void Mul(View view){
        EditText InEditText=(EditText)findViewById(R.id.InEditText);
        String Number1=InEditText.getText().toString();
        Double Number1double=Double.parseDouble(Number1);

        EditText InnEditText=(EditText)findViewById(R.id.InnEditText);
        String Number2=InnEditText.getText().toString();
        Double Number2double=Double.parseDouble(Number2);

        Double output=Number1double*Number2double;
        String Output=Double.toString(output);
        Toast.makeText(this, "Multiplication gives "+Output, Toast.LENGTH_LONG).show();
    }
    public void Div(View view){
        EditText
        String Number1=InEditText.getText().toString();
        Double Number1double=Double.parseDouble(Number1);

        EditText InnEditText=(EditText)findViewById(R.id.InnEditText);
        String Number2=InnEditText.getText().toString();
        Double Number2double=Double.parseDouble(Number2);

        Double output=Number1double/Number2double;
        String Output=Double.toString(output);
        Toast.makeText(this, "Division gives "+Output, Toast.LENGTH_LONG).show();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InEditText=(EditText)findViewById(R.id.InEditText);



    }
}
