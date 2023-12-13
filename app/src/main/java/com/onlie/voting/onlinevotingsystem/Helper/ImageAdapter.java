package com.onlie.voting.onlinevotingsystem.Helper;

import android.content.Context;
import android.media.Image;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.onlie.voting.onlinevotingsystem.ExampleItemClickListener;
import com.onlie.voting.onlinevotingsystem.Model.Upload;
import com.onlie.voting.onlinevotingsystem.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class ImageAdapter extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView partyName, partCategory;
    public CircleImageView partyImage;
    public ExampleItemClickListener listner;

    public ImageAdapter(@NonNull View itemView) {
        super(itemView);

        partyImage = (CircleImageView) itemView.findViewById(R.id.image_view_upload);
        partyName = (TextView) itemView.findViewById(R.id.text_view_party);
        partCategory = (TextView)itemView.findViewById(R.id.text_view_category);

    }


    public void setOnItemClickListener(ExampleItemClickListener listener){
        this.listner = listener;
    }
    @Override
    public void onClick(View v) {
        listner.onClick(v,getAdapterPosition(), false);
    }
}
