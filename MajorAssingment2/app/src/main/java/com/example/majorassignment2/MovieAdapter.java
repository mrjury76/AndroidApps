package com.example.majorassignment2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    //declaring variables, application context and an arraylist with MovieCard generic type
    private int counter = 0;
    private final int MAX = 2;
    private String firstTitle = "";
    private String secondTitle;
    Context context;
    ArrayList<MovieCard> arrayList;

    //Creating constructor with context and an array as inputs
    MovieAdapter(Context context, ArrayList<MovieCard> array) {
        this.context = context;
        this.arrayList = array;
    }

    //onCreateViewHolder method just creates(inflates) the movie.xml layout file
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate your item layout here and return a new ViewHolder
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_card_layout, parent, false);
        return new MovieViewHolder(itemView);
    }

    //onBindViewHolder binds the data from the array into the MovieViewHolder class i created.
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.image.setImageResource(arrayList.get(position).image);
        holder.title.setText(arrayList.get(position).title);
        holder.showingDates.setText(arrayList.get(position).showingDates);

        //creates an on long click listener on the entire view with colour changing logic
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {

            public boolean onLongClick(View v) {
                int backgroundColor = ((ColorDrawable) holder.title.getBackground()).getColor();

                    //if the background color is red then this "unselects" the movie.
                    if (backgroundColor == ContextCompat.getColor(context, R.color.red)) {
                        holder.title.setBackgroundColor(ContextCompat.getColor(context, R.color.blue));
                        holder.showingDates.setBackgroundColor(ContextCompat.getColor(context, R.color.blue));
                        Toast.makeText(context, "You have unselected: " + holder.title.getText().toString(), Toast.LENGTH_SHORT).show();
                        counter -= 1;
                    } else {
                        //if not unselecting a movie, this selects one. But if the counter is 2 you cannot pick another movie.
                        if(counter == MAX) {
                            Toast.makeText(context, "Cannot pick more than 2 movies", Toast.LENGTH_SHORT).show();
                        } else {
                             // If red, change back to blue
                             holder.title.setBackgroundColor(ContextCompat.getColor(context, R.color.red));
                             holder.showingDates.setBackgroundColor(ContextCompat.getColor(context, R.color.red));
                             counter++; //increase

                             if(counter == 1) {
                                 firstTitle = holder.title.getText().toString();
                                 Toast.makeText(context, "You have selected: " + firstTitle, Toast.LENGTH_SHORT).show();
                             } else {
                                 secondTitle = holder.title.getText().toString();
                                 Toast.makeText(context, "You have selected: " + firstTitle + " , " + secondTitle, Toast.LENGTH_SHORT).show();
                             }

                        }
                    }
                return true;
            }
        });
    }

    //simply returns the array size
    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    //custom class that extends the recycler view holder that assigns the MovieCard data to this view
    public static class MovieViewHolder extends RecyclerView.ViewHolder{
        TextView title,showingDates;
        ImageView image;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.movieCard);
            title = itemView.findViewById(R.id.movieTitle);
            showingDates = itemView.findViewById(R.id.showDates);
        }
    }
}