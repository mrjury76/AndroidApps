package com.example.majorassignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    //declaring application context and an arraylist with moviecard generic type
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

    //onBindViewHolder binds the data from the array into the movieviewholder class i created.
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.image.setImageResource(arrayList.get(position).image);
        holder.title.setText(arrayList.get(position).title);
        holder.showingDates.setText(arrayList.get(position).showingDates);
    }

    //simply returns the array size
    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    //custom class that extends the recycler view holder that assigns the moviecard data to this view
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