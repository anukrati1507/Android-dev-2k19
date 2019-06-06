package com.example.taskfour;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<Abc> list;

    RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.mainRecycler);
        progressDialog = new ProgressDialog(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Content is Loading\nPlease wait...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(AbcApi.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AbcApi abcApi = retrofit.create(AbcApi.class);

        Call<List<Abc>> call = abcApi.getAbc();
        call.enqueue(new Callback<List<Abc>>() {
            @Override
            public void onResponse(Call<List<Abc>> call, Response<List<Abc>> response) {

                list = response.body();
                recyclerView.setAdapter(new Adapter(getApplicationContext(),list));

            }

            @Override
            public void onFailure(Call<List<Abc>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        progressDialog.dismiss();

    }


}
