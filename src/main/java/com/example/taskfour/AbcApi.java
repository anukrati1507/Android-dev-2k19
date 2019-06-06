package com.example.taskfour;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AbcApi {

    String baseUrl = "https://abhayrpatellist.herokuapp.com/";

    @GET("https://abhayrpatellist.herokuapp.com/list")
    public Call<List<Abc> > getAbc();

    // the return type of the function is the "Call" of type List containing all elements of type Abc
    // as each json Array consists of json Objects which is of type Abc class which we have created

}
