package com.chanaka.navigationdrawer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import com.squareup.picasso.Picasso;

import java.util.List;

public class book_adapter extends RecyclerView.Adapter<book_adapter.book_image> {

    private Context context;
    private List<BookModel> list;

    public book_adapter(Context context, List<BookModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public book_image onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.display_items,parent,false);
        return new book_image(v);
    }

    @Override
    public void onBindViewHolder(@NonNull book_image holder, int position) {
        BookModel bookModel = list.get(position);
        holder.book_resouce_title.setText(bookModel.getTitle());
        holder.book_resouce_description.setText(bookModel.getDescription());
        holder.book_resouce_genre.setText(bookModel.getGenre());
        holder.book_resouce_price.setText(String.valueOf(bookModel.getPrice()));
        Picasso.with(context).load(bookModel.getBooktImageUrk())
                .fit()
                .centerCrop()
                .into(holder.book_image);




    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class  book_image extends RecyclerView.ViewHolder{
        public ImageView book_image;
        public RelativeLayout book_viewclicker;
        public TextView book_resouce_title,book_resouce_description,book_resouce_genre,book_resouce_price;
        public book_image(@NonNull View itemView) {
            super(itemView);

            book_resouce_title=(TextView) itemView.findViewById(R.id.book_resouce_title);
            book_resouce_description=(TextView)itemView.findViewById(R.id.book_resouce_description);
            book_resouce_genre=(TextView)itemView.findViewById(R.id.book_resouce_genre);
            book_resouce_price=(TextView)itemView.findViewById(R.id.book_resouce_price);
            book_image =(ImageView)itemView.findViewById(R.id.book_image);
            book_viewclicker=(RelativeLayout)itemView.findViewById(R.id.book_viewclicker);

        }
    }

}
