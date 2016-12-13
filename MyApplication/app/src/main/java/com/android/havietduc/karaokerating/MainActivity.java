package com.android.havietduc.karaokerating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {
    private
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
    }

    private void addControls() {
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

         TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1");
         tab1.setIndicator("", getResources().getDrawable(R.drawable.tab1));
         tab1.setContent(R.id.tab1);
         tabHost.addTab(tab1);


        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2");
        tab2.setIndicator("", getResources().getDrawable(R.drawable.tab2));
        tab2.setContent(R.id.tab2);
        tabHost.addTab(tab2);
    }
}
