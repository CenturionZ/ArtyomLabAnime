package com.example.artyomanime.core.service;

import com.example.artyomanime.core.models.AnimeQuote;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;
import io.reactivex.Observable;

public interface APIService {

    /** Возвращает список Аниме */
    @GET("quotes")
    Observable<List<AnimeQuote>> getAvailableAnimes();

    /** Возвращает Аниме, найденное по названию */
    @GET("quotes/anime")
    Call<AnimeQuote> getAnimeByTitle(@Query("title") String animeTitle);

    /** Возвращает рандомное Аниме */
    @GET("random")
    Observable<AnimeQuote> getRandomAnime();

}

// asset/bitcoin?id=12&xyi=25
