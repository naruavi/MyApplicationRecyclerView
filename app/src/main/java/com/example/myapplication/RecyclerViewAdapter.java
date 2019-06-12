package com.example.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.model.ResultsItem;

import java.util.List;

import javax.xml.transform.Result;

public class RecyclerViewAdapter extends
        RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>{

    public List<ResultsItem> list;

    public RecyclerViewAdapter(List<ResultsItem> list){
        this.list =list;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_item,viewGroup, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {
        recyclerViewHolder.bind(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(ResultsItem item){
            TextView title = itemView.findViewById(R.id.title);
            TextView description = itemView.findViewById(R.id.description);
            title.setText(item.getTitle());
            //Log.d("some", item.getPosterPath());
            description.setText(item.getOverview());
            ImageView imageView = itemView.findViewById(R.id.movieImage);
            Glide.with(itemView.getContext())
                    .load("http://image.tmdb.org/t/p/w185/" + item.getPosterPath())
                    .into((ImageView) itemView.findViewById(R.id.movieImage));
        }
    }

}
