package com.onlie.voting.onlinevotingsystem.Helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.onlie.voting.onlinevotingsystem.Model.Vote;
import com.onlie.voting.onlinevotingsystem.R;

public class VoterAdapter extends RecyclerView.ViewHolder{

    public TextView voterName, iVote;
    private final Context context;

    public VoterAdapter(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();

        voterName = (TextView) itemView.findViewById(R.id.voterName);
        iVote = (TextView) itemView.findViewById(R.id.vote);

    }
}
