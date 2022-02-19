package com.example.artyomanime.core;

import com.example.artyomanime.core.models.AnimeQuote;
import io.reactivex.Observable;

import java.util.List;

public interface MainContract {

    interface ItemViewFragment{
        void DisplayTitlesList(List<AnimeQuote> animeTitle);
    }

    interface DetailViewFragment{
        void DisplayDetailInfo();
    }

    interface MainActivityView {
        void ReloadTitlesList();
        void GetRandomTitle(AnimeQuote anime);
    }

    interface Presenter {
        void GetAnimeList();
        void GetRandomAnime();
        void ReloadItemFragment();
        AnimeQuote GetAnimeByTitle(String animeTitle);
    }


    interface Repository {
        Observable<List<AnimeQuote>> GetAnimeList();
        Observable<AnimeQuote> GetRandomAnime();
        AnimeQuote GetAnimeByTitle(String animeTitle);
    }

}
