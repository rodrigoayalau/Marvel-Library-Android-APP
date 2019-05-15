package com.example.marvellibrary;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelServiceDeserealizer {
    @GET("characters")
    Call<MarvelModelDeserealizer> getResponseDeserealizer(
            @Query("name") String name,
            @Query("apikey") String key,
            @Query("hash") String hash,
            @Query("ts") String timestamp);

}
