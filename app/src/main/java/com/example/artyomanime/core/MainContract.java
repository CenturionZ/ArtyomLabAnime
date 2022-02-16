package com.example.artyomanime.core;

import com.example.artyomanime.core.models.AnimeQuote;

import java.util.List;

public interface MainContract {

    interface ItemViewFragment{
        void SetTitlesList();
        void SwitchToDetailInfo();
    }

    interface DetailViewFragment{
        void SetDetailData();
    }

    interface MainActivityView {
        void ReloadTitlesList();
        void GetRandomeTitle();
    }

    interface Presenter {
        List<AnimeQuote> GetAnimeList();
        AnimeQuote GetRandomAnime();
        AnimeQuote GetAnimeByTitle(String animeTitle);
    }


    interface Repository {
        List<AnimeQuote> GetAnimeList();
        AnimeQuote GetRandomAnime();
        AnimeQuote GetAnimeByTitle(String animeTitle);
    }

}
