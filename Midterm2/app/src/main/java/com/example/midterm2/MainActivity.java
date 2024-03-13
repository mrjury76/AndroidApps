package com.example.midterm2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

        Counter counter1 = new Counter(100);
        Counter counter2 = new Counter(200);
        Counter counter3 = new Counter(300);
        Button start = findViewById(R.id.startButton);
        Button stop = findViewById(R.id.stopButton);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executor.submit(counter1);
                executor.submit(counter2);
                executor.submit(counter3);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter1.stop();
                counter2.stop();
                counter3.stop();
            }
        });

    }
}