package com.chanaka.navigationdrawer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.chanaka.navigationdrawer.ui.Data;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class sub_details extends Fragment {



/*    RecyclerView recyclerView;
    ArrayList images, names;*/

    private RecyclerView book_recycler;
    private  book_adapter adapter;
    private List<BookModel> booklist;
    public  static BookModel bookModel;
    private DatabaseReference mDatabaseReference,removeborrowbook;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_sub_details, container, false);
//       recyclerView=(RecyclerView) view.findViewById(R.id.my_recycler);
//       images = new ArrayList();
//       names  = new ArrayList();
//
//       for (int i=0; i< Data.names.length;i++){
//           images.add(Data.images);
//           names.add(Data.names);
//       }
//
//       helpAdapter_recycler helpAdapter= new helpAdapter_recycler(getContext(),images,names);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setAdapter(helpAdapter);

        book_recycler =(RecyclerView) view.findViewById(R.id.my_recycler);
        book_recycler.setHasFixedSize(true);
        book_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        booklist = new ArrayList<>();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("Book");



       return  view;
    }

    @Override
    public void onStart() {
        super.onStart();

        if(mDatabaseReference !=null){
            mDatabaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    if(!snapshot.exists())
                    {}
                    else{   for (DataSnapshot postsnapshot:snapshot.getChildren()){

                        bookModel   =postsnapshot.getValue(BookModel.class);
                        booklist.add(bookModel);
                    }

                        adapter = new book_adapter(getContext(),booklist);
                        book_recycler.setAdapter(adapter);}

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                    Toast.makeText(getContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                }
            });
        }


    }
}































