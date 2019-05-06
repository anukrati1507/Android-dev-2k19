package vitadg.calculator;

import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.zip.InflaterOutputStream;

public class MainActivity extends AppCompatActivity {

    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private Button zero;
    private Button clear;
    private Button equal;
    private TextView expr;
    private TextView result;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLY = '*';
    private final char DIVIDE = '/';
    private final char EQU = '0';
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr.setText(expr.getText().toString() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr.setText(expr.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr.setText(expr.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr.setText(expr.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr.setText(expr.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr.setText(expr.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr.setText(expr.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr.setText(expr.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr.setText(expr.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr.setText(expr.getText().toString() + "9");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION=ADDITION;
                result.setText(String.valueOf(val1) + "+");
                expr.setText(null);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION=SUBTRACTION;
                result.setText(String.valueOf(val1) + "-");
                expr.setText(null);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION=MULTIPLY;
                result.setText(String.valueOf(val1) + "*");
                expr.setText(null);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION=DIVIDE;
                result.setText(String.valueOf(val1) + "/");
                expr.setText(null);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION=EQU;
                result.setText(result.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1) );
                expr.setText(null);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expr.getText().length() > 0){
                    CharSequence name = expr.getText().toString();
                    expr.setText(name.subSequence(0, name.length()-1));
                }
                else {
                    val1=Double.NaN;
                    val2=Double.NaN;
                    expr.setText(null);
                    result.setText(null);
                }
            }
        });


    }

    private void setupUIViews(){
        zero=(Button)findViewById(R.id.btn0);
        one=(Button)findViewById(R.id.btn1);
        two=(Button)findViewById(R.id.btn2);
        three=(Button)findViewById(R.id.btn3);
        four=(Button)findViewById(R.id.btn4);
        five=(Button)findViewById(R.id.btn5);
        six=(Button)findViewById(R.id.btn6);
        seven=(Button)findViewById(R.id.btn7);
        eight=(Button)findViewById(R.id.btn8);
        nine=(Button)findViewById(R.id.btn9);
        mul=(Button)findViewById(R.id.btnmul);
        div=(Button)findViewById(R.id.btndiv);
        add=(Button)findViewById(R.id.btnadd);
        sub=(Button)findViewById(R.id.btnsub);
        equal=(Button)findViewById(R.id.btneq);
        clear=(Button)findViewById(R.id.btnclr);
        expr=(TextView)findViewById(R.id.txcontrol);
        result=(TextView)findViewById(R.id.txres);




    }
    private void compute(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(expr.getText().toString());

            switch(ACTION){
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLY:
                    val1 = val1 * val2;
                    break;
                case DIVIDE:
                    val1 = val1 / val2;
                    break;
                case EQU:
                    break;
            }

        }
        else{
            val1= Double.parseDouble(expr.getText().toString());
        }
    }
}
