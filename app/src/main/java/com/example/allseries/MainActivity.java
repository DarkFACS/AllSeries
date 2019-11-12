package com.example.allseries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.allseries.Adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Serie> lstSerie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstSerie = new ArrayList<>();
        lstSerie.add(new Serie("The Flash", "Categorie serie", "Description serie", R.drawable.theflash));
        lstSerie.add(new Serie("Arrow", "Categorie serie", "Description serie", R.drawable.arrow));
        lstSerie.add(new Serie("Breaking Bad", "Categorie serie", "Description serie", R.drawable.breakingbad));
        lstSerie.add(new Serie("Chernobyl", "Categorie serie", "Description serie", R.drawable.chernobyl));
        lstSerie.add(new Serie("Game Of Thrones", "Categorie serie", "Description serie", R.drawable.got));
        lstSerie.add(new Serie("Rick And Morty", "Categorie serie", "Description serie", R.drawable.rickandmorty));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter mAdapter = new RecyclerViewAdapter(this, lstSerie);

    }
}
