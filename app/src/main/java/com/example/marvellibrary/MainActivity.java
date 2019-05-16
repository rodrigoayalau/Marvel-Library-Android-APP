package com.example.marvellibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView txtSetHero;
    private View btnSearchHero;
    private View imgHero;
    private TextView txtNameHero;
    private TextView txtDescHero;
    private TextView txtJson;



    Retrofit retrofit;
    GsonBuilder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSetHero = findViewById(R.id.txtSetHero);
        btnSearchHero = findViewById(R.id.btnSearchHero);
        txtNameHero = findViewById(R.id.txtNameHero);
        txtDescHero = findViewById(R.id.txtDescHero);
        imgHero = findViewById(R.id.imgHero);
        txtJson = findViewById(R.id.txtJsonResponse);


        builder = new GsonBuilder();
        builder.registerTypeAdapter(MarvelModelDeserealizer.class, new Deserealizer());


        retrofit = new Retrofit.Builder()
                .baseUrl("https://gateway.marvel.com:443/v1/public/")
                .addConverterFactory(GsonConverterFactory.create(builder.create()))
                .build();

        btnSearchHero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                MarvelServiceDeserealizer marvelService = retrofit.create(MarvelServiceDeserealizer.class);

                String getHero = txtSetHero.getText().toString();

                Call<MarvelModelDeserealizer> hero = marvelService.getResponseDeserealizer(
                        getHero,
                        "9834ecaa13e2b0ab01c3a90c857548f9",
                        "a1f5d7ade8cbb76c16a197f87813236e",
                        "1557777677"
                );

        hero.enqueue(new Callback<MarvelModelDeserealizer>() {
            @Override
            public void onResponse(Call<MarvelModelDeserealizer> call, Response<MarvelModelDeserealizer> response) {
                //response.body();
                String nombre = response.body().getName();
                txtNameHero.setText(nombre);
                String description = response.body().getDescription();
                txtDescHero.setText(description);
                String img = response.body().getPath();
                String ext = response.body().getExtension();
                String imgC = img + "." + ext;
                Picasso.get().load(imgC).into((ImageView) imgHero);


                String jres = response.body().toString();
                txtJson.setText(jres);

            }

            @Override
            public void onFailure(Call<MarvelModelDeserealizer> call, Throwable t) {
                Toast.makeText(MainActivity.this, "ERROR!", Toast.LENGTH_LONG).show();
            }
        });

            }
        });



        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gateway.marvel.com:443/v1/public/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MarvelService marvelService = retrofit.create(MarvelService.class);

        Call<MarvelModel> hero = marvelService.getResponse(
                "thor",
                "9834ecaa13e2b0ab01c3a90c857548f9",
                "a1f5d7ade8cbb76c16a197f87813236e",
                "1557777677"
        );

        hero.enqueue(new Callback<MarvelModel>() {
            @Override
            public void onResponse(Call<MarvelModel> call, Response<MarvelModel> response) {
                response.body();
            }

            @Override
            public void onFailure(Call<MarvelModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "ERROR!", Toast.LENGTH_LONG).show();
            }
        });*/


    }
}
