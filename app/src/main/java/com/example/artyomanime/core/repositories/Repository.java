package com.example.artyomanime.core.repositories;

import android.util.Log;
import com.example.artyomanime.core.MainContract;
import com.example.artyomanime.core.models.AnimeQuote;
import com.example.artyomanime.core.service.RetrofitInstance;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class Repository implements MainContract.Repository {

    RetrofitInstance retrofitClient;

    public Repository() {
        retrofitClient = new RetrofitInstance();
    }

    @Override
    public Observable<List<AnimeQuote>> GetAnimeList() {
        return retrofitClient
                .retrofitAPI
                .getAvailableAnimes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<AnimeQuote> GetRandomAnime() {
        return retrofitClient
                .retrofitAPI
                .getRandomAnime()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
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
