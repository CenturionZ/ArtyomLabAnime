package com.example.artyomanime.features.home;

import android.util.Log;
import com.example.artyomanime.core.MainContract;
import com.example.artyomanime.core.models.AnimeQuote;
import com.example.artyomanime.core.repositories.Repository;
import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Presenter implements MainContract.Presenter {

    MainContract.Repository repository;
    MainContract.ItemViewFragment mItemViewFragment;
    MainContract.MainActivityView mMainActivityView;

    public Presenter(MainContract.ItemViewFragment view) {
        this.repository = new Repository();
        this.mItemViewFragment = view;
    }

    public Presenter(MainContract.MainActivityView view) {
        this.repository = new Repository();
        this.mMainActivityView = view;
    }

    public Observable<List<AnimeQuote>> getObservableAnimeList(){
        return repository.GetAnimeList();
    }

    public Observable<AnimeQuote> getObservableAnimeTitle(){
        return repository.GetRandomAnime();
    }

    public DisposableObserver<AnimeQuote> getObserverAnimeTitleResponce(){
        return new DisposableObserver<AnimeQuote>() {

            @Override
            public void onNext(@NotNull AnimeQuote movieResponse) {
                mMainActivityView.GetRandomTitle(movieResponse);
            }

            @Override
            public void onError(@NotNull Throwable e) {
                e.printStackTrace();
//                mvi.displayError("Error fetching Movie Data");
            }

            @Override
            public void onComplete() {
                Log.d("PRESENTER","Completed");
            }
        };
    }

    public DisposableObserver<List<AnimeQuote>> getObserverAnimeListResponce(){
        return new DisposableObserver<List<AnimeQuote>>() {

            @Override
            public void onNext(@NotNull List<AnimeQuote> movieResponse) {
                Log.d("PRESENTER","Call mItemViewFragment.DisplayTitlesList(movieResponse) -> FRAGMENT");
                mItemViewFragment.DisplayTitlesList(movieResponse);
            }

            @Override
            public void onError(@NotNull Throwable e) {
                e.printStackTrace();
//                mvi.displayError("Error fetching Movie Data");
            }

            @Override
            public void onComplete() {
                Log.d("PRESENTER","Completed");
            }
        };
    }

    @Override
    public void GetAnimeList() {
        Log.d("PRESENTER", "Subscripe on network call");
        getObservableAnimeList().subscribeWith(getObserverAnimeListResponce());
    }

    @Override
    public void GetRandomAnime() {
        getObservableAnimeTitle().subscribeWith(getObserverAnimeTitleResponce());
    }

    @Override
    public AnimeQuote GetAnimeByTitle(String animeTitle) {
        return null;
    }

    @Override
    public void ReloadItemFragment() {
        mMainActivityView.ReloadTitlesList();
    }
}
