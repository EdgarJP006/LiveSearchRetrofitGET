package com.haerul.livesearchretrofitget.Retrofit;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by haerul on 17/03/18.
 */

public interface ApiInterface {

    @GET("getcontacts.php")
    Call<List<Contact>> getContact(
            //Item_type es para verificar de que tabla
            @Query("item_type") String item_type,
            @Query("key") String keyword
    );
}
