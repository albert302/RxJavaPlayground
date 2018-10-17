package com.alportela.rxjavaplayground.retrofit;

import com.alportela.rxjavaplayground.retrofit.model.Info;
import com.alportela.rxjavaplayground.retrofit.model.User;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface GetCountryDataService {

    @GET("country/get/all")
    Call<Info> getCountries();

    @GET("country/get/iso2code/{alpha2_code}")
    Call<Info> getCountry(@Path("alpha2_code") String countryCode);

    @GET("users/list")
    Call<List<User>> getUsers(@QueryMap Map<String, String> queryValues);

    Call<String> getName(int userId);
}
