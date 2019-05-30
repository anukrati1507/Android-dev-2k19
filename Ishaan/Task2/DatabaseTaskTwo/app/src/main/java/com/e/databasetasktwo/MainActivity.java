package com.e.databasetasktwo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText inputTextView;
    Button btnAdd, btnSee;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        inputTextView = findViewById(R.id.inputTextView);
        btnAdd = findViewById(R.id.btnAdd);
        btnSee = findViewById(R.id.btnSee);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseReference.push().setValue(inputTextView.getText().toString());
                Toast.makeText(MainActivity.this, "Item Added to database!", Toast.LENGTH_SHORT).show();
                inputTextView.setText(null);

            }
        });

        btnSee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(R.drawable.ic_launcher_background)
                        .setTitle("Next Activity")
                        .setMessage("Do you want to proceed?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(MainActivity.this,RecycleView.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No",null)
                        .show();

            }
        });

    }
}
