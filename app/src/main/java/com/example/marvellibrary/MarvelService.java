package com.example.marvellibrary;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelService {
    @GET("characters")
    Call<MarvelModel> getResponse(
            @Query("name") String name,
            @Query("apikey") String key,
            @Query("hash") String hash,
            @Query("ts") String timestamp);


}

/*
characters
?
name=thor
&
apikey=9834ecaa13e2b0ab01c3a90c857548f9
&
hash=a1f5d7ade8cbb76c16a197f87813236e
&
ts=1557777677
*/
