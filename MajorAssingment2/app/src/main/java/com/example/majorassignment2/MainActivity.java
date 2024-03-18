package com.example.majorassignment2;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent backgroundMusicIntent = new Intent(MainActivity.this, BackgroundMusic.class);
        startService(backgroundMusicIntent);

        RecyclerView recyclerView = findViewById(R.id.movieRecyclerView);

        ArrayList<MovieCard> array = new ArrayList<>();
        array.add(new MovieCard(R.drawable.inception, "Inception", "Jan 1-10"));
        array.add(new MovieCard(R.drawable.dark_knight, "The Dark Knight", "Sept 1-10"));
        array.add(new MovieCard(R.drawable.citizen_cane, "Citizen Cane", "May 1971"));
        array.add(new MovieCard(R.drawable.django, "Django", "Oct 5"));
        array.add(new MovieCard(R.drawable.mandalorian, "Mandalorian", "Oct 31"));

        MovieAdapter adapter = new MovieAdapter(this, array);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

    }
}