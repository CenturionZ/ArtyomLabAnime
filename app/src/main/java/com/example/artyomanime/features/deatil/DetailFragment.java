package com.example.artyomanime.features.deatil;

import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.artyomanime.R;
import com.example.artyomanime.core.models.AnimeQuote;

public class DetailFragment extends Fragment {

    AnimeQuote animeInfo;

    TextView animeTitle;
    TextView characters;
    TextView description;

    public DetailFragment() {
        // Required empty public constructor
    }

    public DetailFragment(AnimeQuote animeQuote) {
        this.animeInfo = animeQuote;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        animeTitle = view.findViewById(R.id.detail_anime_title);
        characters = view.findViewById(R.id.character);
        description = view.findViewById(R.id.description);

        animeTitle.setText(animeInfo.getAnime());
        characters.setText(animeInfo.getCharacter());
        description.setText(animeInfo.getQuote());

        return view;
    }
}