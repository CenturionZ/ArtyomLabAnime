package com.example.artyomanime.home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.artyomanime.R;
import com.example.artyomanime.core.MainContract;
import com.example.artyomanime.core.repositories.Repository;

/**
 * A fragment representing a list of Items.
 */
public class ItemFragment extends Fragment implements MainContract.ItemViewFragment {


//    // TODO: Customize parameter argument names
//    private static final String ARG_COLUMN_COUNT = "column-count";
//    // TODO: Customize parameters
//    private final int mColumnCount = 1;
//
    private MainContract.Repository repository;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */

    public ItemFragment() {
    }

//    // TODO: Customize parameter initialization
//    @SuppressWarnings("unused")
//    public static ItemFragment newInstance(int columnCount) {
//        ItemFragment fragment = new ItemFragment();
//        Bundle args = new Bundle();
//        args.putInt(ARG_COLUMN_COUNT, columnCount);
//        fragment.setArguments(args);
//        return fragment;
//    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        if (getArguments() != null) {
//            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
//        }
//
//    }
HomeRecyclerViewAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        repository = new Repository();

        View view = inflater.inflate(R.layout.fragment_item_list, container, false);


        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view;

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        Log.d("FRAGMENT:", "ITEM FRAGMENT CREATED");
        adapter = new HomeRecyclerViewAdapter(repository.GetAnimeList());
        recyclerView.setAdapter(adapter);
        recyclerView.getAdapter().notifyDataSetChanged();
        Log.d("FRAGMENT:", "ITEMS WAS RENDERED");
        return view;
    }

    @Override
    public void SetTitlesList() {

    }

    @Override
    public void SwitchToDetailInfo() {

    }
}