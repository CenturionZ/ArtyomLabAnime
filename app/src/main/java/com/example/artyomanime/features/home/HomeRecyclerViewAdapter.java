package com.example.artyomanime.features.home;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.artyomanime.R;
import com.example.artyomanime.core.models.AnimeQuote;

import java.util.List;


public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder> {

    private List<AnimeQuote> mValues;

    public HomeRecyclerViewAdapter(List<AnimeQuote> items) {
        mValues = items;
        if (mValues.size() > 0) {
            Log.d("ADAPTER VALUES ", "VALUES EXIST");
            for (AnimeQuote item : mValues){
                Log.d("ANIME", item.getAnime());
            }
        }
        else {
            Log.d("ADAPTER VALUES ", "NULL");
        }
    }

    public void setItems(List<AnimeQuote> items) {
        this.mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        AnimeQuote anum = mValues.get(position);
        holder.mIdView.setText(anum.getAnime());
        holder.mContentView.setText(anum.getQuote());
        Log.d("HOLDER: ", "Holder created!");

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_anime_name);
            mContentView = (TextView) view.findViewById(R.id.content_quote);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}