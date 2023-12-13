package com.onlie.voting.onlinevotingsystem.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.onlie.voting.onlinevotingsystem.Helper.ImageAdapter;
import com.onlie.voting.onlinevotingsystem.Model.Upload;
import com.onlie.voting.onlinevotingsystem.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AllPartiesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DatabaseReference mDatabaseRef;
    RecyclerView.LayoutManager layoutManager;

    private ProgressBar progressBar;
    private ValueEventListener mDBListener;
    String Phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_parties);

        Intent i=getIntent();
        Phone=i.getStringExtra("phone");

        recyclerView = findViewById(R.id.recycler_view);

//        progressBar = findViewById(R.id.progress_circle);

        mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("uploads");
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        partiesList();

    }

    private void partiesList() {
        FirebaseRecyclerOptions<Upload> options = new FirebaseRecyclerOptions.Builder<Upload>()
                .setQuery(mDatabaseRef, Upload.class)
                .build();

        FirebaseRecyclerAdapter<Upload, ImageAdapter> adapter = new FirebaseRecyclerAdapter<Upload, ImageAdapter>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ImageAdapter holder, int position, @NonNull Upload model) {

//                homeProgressBar.setVisibility(View.INVISIBLE);

                holder.partyName.setText(model.getName());
                holder.partCategory.setText(model.getCategory());
                Picasso.get().load(model.getImageUrl()).into(holder.partyImage);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AllPartiesActivity.this, PartyDetailsActivity.class);
                        intent.putExtra("phone", Phone);
                        intent.putExtra("pid", model.getPid());
                        intent.putExtra("category", model.getCategory());
                        startActivity(intent);
                    }
                });
            }

            @NonNull
            @Override
            public ImageAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item,parent,false);
                ImageAdapter holder = new ImageAdapter(view);
                return holder;
            }
        };

        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }
}