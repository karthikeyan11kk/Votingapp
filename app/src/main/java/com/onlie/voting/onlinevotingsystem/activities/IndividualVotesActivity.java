package com.onlie.voting.onlinevotingsystem.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.onlie.voting.onlinevotingsystem.Helper.VoterAdapter;
import com.onlie.voting.onlinevotingsystem.Model.Vote;
import com.onlie.voting.onlinevotingsystem.R;

public class IndividualVotesActivity extends AppCompatActivity {

    private DatabaseReference mRef;
    private RecyclerView individualRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_votes);

        mRef = FirebaseDatabase.getInstance().getReference().child("Users");
        individualRecyclerView = findViewById(R.id.individualRecyclerView);
        individualRecyclerView.setHasFixedSize(true);
        individualRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        individualItems();
    }

    private void individualItems() {
        FirebaseRecyclerOptions<Vote> options = new FirebaseRecyclerOptions.Builder<Vote>()
                .setQuery(mRef, Vote.class)
                .build();
        FirebaseRecyclerAdapter<Vote, VoterAdapter> adapter =
                new FirebaseRecyclerAdapter<Vote, VoterAdapter>(options) {
                    @SuppressLint("SetTextI18n")
                    @Override
                    protected void onBindViewHolder(@NonNull VoterAdapter holder, int position, @NonNull Vote model) {
                        holder.voterName.setText("Voter: "+ model.getName());
                        holder.iVote.setText("Vote to: "+model.getParty());
                    }

                    @NonNull
                    @Override
                    public VoterAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vote, parent, false);
                        VoterAdapter holder = new VoterAdapter(view);
                        return holder;
                    }
                };
        individualRecyclerView.setAdapter(adapter);
        adapter.startListening();
    }
}