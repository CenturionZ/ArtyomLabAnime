package com.example.artyomanime.core.repositories;

import android.util.Log;
import com.example.artyomanime.core.MainContract;
import com.example.artyomanime.core.models.AnimeQuote;
import com.example.artyomanime.core.service.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class Repository implements MainContract.Repository {

    RetrofitInstance retrofitClient;

    public Repository() {
        retrofitClient = new RetrofitInstance();
    }

    @Override
    public List<AnimeQuote> GetAnimeList() {
        final List<AnimeQuote> set = new ArrayList<>();
        Call<List<AnimeQuote>> call = retrofitClient.retrofitAPI.getAvailableAnimes();

        call.enqueue(new Callback<List<AnimeQuote>>() {
            @Override
            public void onResponse(Call<List<AnimeQuote>> call, Response<List<AnimeQuote>> response) {
                assert response.body() != null;
                set.addAll(response.body());
                call.cancel();
            }

            @Override
            public void onFailure(Call<List<AnimeQuote>> call, Throwable t) {
                t.printStackTrace();
            }
        });

        for (AnimeQuote item : set) {
            Log.d("ITEM check", item.getAnime());
        }
        return set;
    }

    @Override
    public AnimeQuote GetRandomAnime() {
        final AnimeQuote anime = new AnimeQuote();
        Call<AnimeQuote> call = retrofitClient.retrofitAPI.getRandomAnime();

        call.enqueue(new Callback<AnimeQuote>() {
            @Override
            public void onResponse(Call<AnimeQuote> call, Response<AnimeQuote> response) {
                anime.setAnime(response.body().getAnime());
                anime.setCharacter(response.body().getCharacter());
                anime.setQuote(response.body().getQuote());
            }

            @Override
            public void onFailure(Call<AnimeQuote> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return anime;
    }

    @Override
    public AnimeQuote GetAnimeByTitle(String animeTitle) {
        final AnimeQuote anime = new AnimeQuote();
        Call<AnimeQuote> call = retrofitClient.retrofitAPI.getAnimeByTitle(animeTitle);

        call.enqueue(new Callback<AnimeQuote>() {
            @Override
            public void onResponse(Call<AnimeQuote> call, Response<AnimeQuote> response) {
                anime.setAnime(response.body().getAnime());
                anime.setCharacter(response.body().getCharacter());
                anime.setQuote(response.body().getQuote());
            }

            @Override
            public void onFailure(Call<AnimeQuote> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return anime;
    }

}
