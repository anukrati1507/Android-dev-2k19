package com.example.myfirebase;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class Register extends AppCompatActivity {

    EditText etEmail,etPass;
    ImageButton imageButton;
    Button btRegister;
    Uri imageUri = null,imageDownloadUri;

    ProgressDialog progressDialog;

    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    StorageReference storageReference;

    public static final int GALLERY_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Firebase.setAndroidContext(this);

        progressDialog = new ProgressDialog(this);

        etEmail = findViewById(R.id.RegisterEmail);
        etPass = findViewById(R.id.RegisterPass);
        btRegister = findViewById(R.id.registerRegister);
        imageButton = findViewById(R.id.registerImage);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");
        firebaseAuth = FirebaseAuth.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Registering...");
                progressDialog.show();
                signUp();
                progressDialog.dismiss();
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(intent,GALLERY_IMAGE);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == GALLERY_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null){
            imageUri = data.getData();
            Picasso.get().load(imageUri).into(imageButton);
        }

    }

    public void signUp(){
        final String email = etEmail.getText().toString();
        final String pass = etPass.getText().toString();

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(pass) || imageUri == null){
            Toast.makeText(Register.this, "Please fill the entries", Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                uploadProfilePic();

                /*if(imageDownloadUri == null){
                    return;
                }*/

                DatabaseReference dr = databaseReference.child(firebaseAuth.getUid());
                dr.child("Email").setValue(email);
                dr.child("Password").setValue(pass);
                dr.child("Profile Pic").setValue(imageDownloadUri);

                Toast.makeText(Register.this,"Registration Successful",Toast.LENGTH_LONG).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Register.this,"Registration Error",Toast.LENGTH_LONG).show();
            }
        });

    }


    public void uploadProfilePic(){

        StorageReference pic = storageReference.child("Profile Pic").child(firebaseAuth.getUid());
        pic.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                imageDownloadUri = taskSnapshot.getUploadSessionUri();

            }
        });

    }

}
