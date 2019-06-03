package com.example.myfirebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

public class WelcomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Post Images");
        databaseReference.keepSynced(true);
        firebaseAuth = FirebaseAuth.getInstance();


        recyclerView = findViewById(R.id.welcomeRecycler);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_welcome, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.welcomeAdd) {
            startActivity(new Intent(WelcomeActivity.this, ImagePostActivity.class));
        }

        if(item.getItemId() == R.id.menuLogout){
            firebaseAuth.signOut();
            Toast.makeText(getApplicationContext(),"Successfully Logout",Toast.LENGTH_SHORT).show();
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<UploadRecyclerImage,UploadImage> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<UploadRecyclerImage, UploadImage>(
                UploadRecyclerImage.class,
                R.layout.recycler_view_layout,
                UploadImage.class,
                databaseReference
        ) {
            @Override
            protected void populateViewHolder(UploadImage viewHolder, UploadRecyclerImage model, int position) {
                viewHolder.setDesc(model.getDesc());
                viewHolder.setTitle(model.getTitle());
                viewHolder.setImage(model.getImage());
            }
        };

        recyclerView.setAdapter(firebaseRecyclerAdapter);

    }

    public static class UploadImage extends RecyclerView.ViewHolder {

        View view;

        public UploadImage(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }

        public void setTitle(String title){
            TextView textView = view.findViewById(R.id.recyclerTitle);
            textView.setText(title);
        }

        public void setDesc(String desc){
            TextView textView = view.findViewById(R.id.recyclerDesc);
            textView.setText(desc);
        }

        public void setImage(String image){
            ImageView imageView = view.findViewById(R.id.recyclerImage);
            Picasso.get().load(image).fit().into(imageView);
        }

    }
}