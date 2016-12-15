package com.android.havietduc.karaokerating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;


import com.android.havietduc.karaokerating.adapter.SongAdapter;
import com.android.havietduc.karaokerating.model.Song;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    private List<Song>  allSongList;
    private SongAdapter allSongAdapter;
    private ListView lvAllSong;

    private List<Song>  likedSongList;
    private SongAdapter likedSongAdapter;
    private ListView lvLikedSong;

    private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
        initMusicData();
    }

    private void initMusicData() {
        allSongList.add(new Song("1111", "My Love", "Weslife", false));
        allSongList.add(new Song("1310", "Beautiful White", "Weslife", false));
        allSongList.add(new Song("2954", "Cost to Cost", "Weslife", false));
        allSongList.add(new Song("3425", "Season in the Sun", "Weslife", false));
        allSongList.add(new Song("6364", "Fool Again", "Weslife", false));
        allSongList.add(new Song("2510", "Why do I love you", "Weslife", false));
        allSongList.add(new Song("8373", "Tonight", "Weslife", false));
        allSongList.add(new Song("3262", "Soledad", "Weslife", false));

        allSongAdapter.notifyDataSetChanged();
    }

    private void addEvents() {
         tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
             @Override
             public void onTabChanged(String tabId) {
                    if (tabId.equalsIgnoreCase("tab1")) {
                        displayAllSongProcess();
                    }
                    else if (tabId.equalsIgnoreCase("tab2")){
                         displayLikedSongProcess();
                    }
             }
         });
    }

    private void displayAllSongProcess() {

    }

    private void displayLikedSongProcess() {
         likedSongList.clear(); // clear songs in list
         for(Song song:allSongList) {
            if( song.isLike()) {
                likedSongList.add(song);
            }
         }
        likedSongAdapter.notifyDataSetChanged();
    }

    private void addControls() {
        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

         TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1");
         tab1.setIndicator("", getResources().getDrawable(R.drawable.tab1));
         tab1.setContent(R.id.tab1);
         tabHost.addTab(tab1);


        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2");
        tab2.setIndicator("", getResources().getDrawable(R.drawable.tab2));
        tab2.setContent(R.id.tab2);
        tabHost.addTab(tab2);

        //
        allSongList = new ArrayList<>();
        lvAllSong = (ListView) findViewById(R.id.lvAllsong);
        allSongAdapter = new SongAdapter(
                MainActivity.this,
                R.layout.allsong_layout,
                allSongList);
        lvAllSong.setAdapter(allSongAdapter);


        likedSongList = new ArrayList<>();
        lvLikedSong = (ListView) findViewById(R.id.lvLikedSong);
        likedSongAdapter = new SongAdapter(
                MainActivity.this,
                R.layout.allsong_layout,
                likedSongList
        );
        lvLikedSong.setAdapter(likedSongAdapter);

    }
}
