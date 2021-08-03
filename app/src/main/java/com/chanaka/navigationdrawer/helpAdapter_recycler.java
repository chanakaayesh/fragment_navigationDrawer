package com.chanaka.navigationdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chanaka.navigationdrawer.ui.Data;

import java.util.ArrayList;
import java.util.List;

public class helpAdapter_recycler extends RecyclerView.Adapter {
    Context context;
    ArrayList arrayList, arrayListName;
    public helpAdapter_recycler(Context context, ArrayList arrayList,ArrayList arrayListName) {
        this.context = context;
        this.arrayList = arrayList;
        this.arrayListName= arrayListName;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.display_items, parent, false);
        Viewholderclass viewholderclass = new Viewholderclass((view));

        return viewholderclass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Viewholderclass viewholderclass =(Viewholderclass)holder;
//        viewholderclass.imageViews.setImageResource(Data.images[position]);
        viewholderclass.textView.setText(Data.names[position]);
        viewholderclass.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "item Selected", Toast.LENGTH_LONG).show();;
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public  class Viewholderclass extends RecyclerView.ViewHolder{
        ImageView imageViews;
        TextView textView;
        public Viewholderclass(@NonNull View itemView) {
            super(itemView);
         /*  imageViews=(ImageView)itemView.findViewById(R.id.item_image);
            textView=(TextView)itemView.findViewById(R.id.item_name);*/
        }
    }
}
