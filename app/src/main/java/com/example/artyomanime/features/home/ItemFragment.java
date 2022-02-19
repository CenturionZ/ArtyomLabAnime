package com.example.artyomanime.features.home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.artyomanime.R;
import com.example.artyomanime.core.MainContract;
import com.example.artyomanime.core.models.AnimeQuote;

import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class ItemFragment extends Fragment implements MainContract.ItemViewFragment {


    public ItemFragment() {
    }

    HomeRecyclerViewAdapter adapter;
    Presenter mPresenter;

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mPresenter = new Presenter(this);
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        Context context = view.getContext();
        recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        Log.d("FRAGMENT:", "ITEM FRAGMENT CREATED");

        getTitlesList();

        return view;
    }

    private void getTitlesList() {
        Log.d("FRAGMENT", "Call Presenter.GetAnimeList -> PRESENTER");
        mPresenter.GetAnimeList();
    }

    @Override
    public void DisplayTitlesList(List<AnimeQuote> animeTitles) {
        if (animeTitles != null) {
            adapter = new HomeRecyclerViewAdapter(animeTitles);
            recyclerView.setAdapter(adapter);
            Log.d("FRAGMENT:", "ITEMS WAS RENDERED");
        } else {
            Log.d("FRAGMENT:", "Response is NULL");
        }
    }

}