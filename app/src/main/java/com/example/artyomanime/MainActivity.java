package com.example.artyomanime;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.artyomanime.home.ItemFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.recList,new ItemFragment()).commit();
    }
}