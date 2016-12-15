package com.android.havietduc.karaokerating.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.havietduc.karaokerating.R;
import com.android.havietduc.karaokerating.model.Song;

import java.util.List;

/**
 * Created by havietduc on 12/13/16.
 */

public class SongAdapter  extends ArrayAdapter{
   private Activity context;
    private int resource;
    private List objects;

    private TextView SongCode, SongName,Singer;
    private ImageButton btnLike, btnDislike;

    public SongAdapter(Activity context, int resource, List objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = this.context.getLayoutInflater();
        View song_view = inflater.inflate(this.resource,null);
        SongCode = (TextView) song_view.findViewById(R.id.txtCode);
        SongName = (TextView) song_view.findViewById(R.id.txtSongName);
        Singer = (TextView) song_view.findViewById(R.id.txtSinger);
        btnLike = (ImageButton) song_view.findViewById(R.id.btnLike);
        btnDislike = (ImageButton) song_view.findViewById(R.id.btnDislike);

        final Song song = (Song) this.objects.get(position);
        SongCode.setText(song.getId());
        SongName.setText(song.getName());
        Singer.setText(song.getSinger());
        if (song.isLike()) {
            btnDislike.setVisibility(View.INVISIBLE);
        }
        else {btnLike.setVisibility(View.INVISIBLE);}
        
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                likeSongProcess(song);
                Toast.makeText(context, "You disliked " + song.getName(), Toast.LENGTH_LONG).show();
            }
        });

        btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disLikeSongProcess(song);
                Toast.makeText(context, "You like " + song.getName(), Toast.LENGTH_LONG).show();
            }
        });

        return song_view;
    }

    private void disLikeSongProcess(Song song) {
        song.setLike(true);
    }


    private void likeSongProcess(Song song) {
        song.setLike(false);
    }


}
