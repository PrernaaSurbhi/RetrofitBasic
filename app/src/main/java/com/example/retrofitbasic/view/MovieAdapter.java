package com.example.retrofitbasic.view;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retrofitbasic.R;
import com.example.retrofitbasic.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieAdapterViewHolder> {
    Context context;
    private ArrayList<Movie> movieArrayList;

    public MovieAdapter(Context context, ArrayList<Movie> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    ///remove this

    @NonNull
    @Override
    public MovieAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_items, parent, false);
        return new MovieAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapterViewHolder holder, int position) {
        holder.movieTitle.setText(movieArrayList.get(position).getOriginalTitle());
        holder.rate.setText(Double.toString(movieArrayList.get(position).getVoteAverage()));

        String imagePath = "https://image.tmdb.org/t/p/w500" + movieArrayList.get(position).getPosterPath();

        Glide.with(context)
                .load(imagePath)
                .into(holder.movieImage);


    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }


    public class MovieAdapterViewHolder extends RecyclerView.ViewHolder {
        public ImageView movieImage;
        public TextView movieTitle, rate;

        public MovieAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            movieImage = itemView.findViewById(R.id.imgMovie);
            movieTitle = itemView.findViewById(R.id.tvTitle);
            rate = itemView.findViewById(R.id.tvRating);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Integer position = getAdapterPosition();

                    if(position!= RecyclerView.NO_POSITION){
                        Movie selectedMovie = movieArrayList.get(position);
//                        Intent intent = new Intent(context,)
                    }
                }
            });

//            //adding onClickListener
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                  Integer position = getAdapterPosition();
//
//                    if(position!=RecyclerView.NO_POSITION) {
//
//                        Movie selectedMovie = movieArrayList.get(position);
//
//                        Intent intent = new Intent(context, MovieActivity.class);
//                        intent.putExtra("movie",selectedMovie);
//                        context.startActivity(intent);
//
//                    }
//
//                }
//
//            }

//            );
        }
    }
}
