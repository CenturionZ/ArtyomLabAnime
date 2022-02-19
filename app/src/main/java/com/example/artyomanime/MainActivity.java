package com.example.artyomanime;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.example.artyomanime.core.MainContract;
import com.example.artyomanime.core.models.AnimeQuote;
import com.example.artyomanime.features.deatil.DetailFragment;
import com.example.artyomanime.features.home.ItemFragment;
import com.example.artyomanime.features.home.Presenter;

public class MainActivity extends AppCompatActivity implements MainContract.MainActivityView {

    MainContract.Presenter presenter;
    Button reloadListButton;
    Button randomAnimeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new Presenter(this);

        reloadListButton = findViewById(R.id.reload_list);
        randomAnimeButton = findViewById(R.id.random_anime);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.recList,new ItemFragment()).commit();

        reloadListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reloadTitlesList();
            }
        });

        randomAnimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRandomAnime();
            }
        });


    }

    private void reloadTitlesList() {
        presenter.ReloadItemFragment();
    }

    private void getRandomAnime(){
        presenter.GetRandomAnime();
    }

    @Override
    public void ReloadTitlesList() {
        destroyActiveFragmentView();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.recList,new ItemFragment())
                .commit();
    }

    @Override
    public void GetRandomTitle(AnimeQuote anime) {
        destroyActiveFragmentView();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.recList,new DetailFragment(anime)).commit();
    }

    private void destroyActiveFragmentView() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.remove((getSupportFragmentManager().getFragments().get(0))).commit();

    }

}