package com.example.bigworkproject;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.List;

public class music_list extends AppCompatActivity {

    //View

    List<music> mData = null;
    Context mContext;
    musicAdapter mAdapter = null;
    ListView list;
    MediaPlayer mp;
    int totalTime;
    static boolean boolean_po=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list1);


        mp = MediaPlayer.create(this, R.raw.suyan);

        mContext = music_list.this;
        list = (ListView) findViewById(R.id.list);
        mData = new LinkedList<music>();

        mData.add(new music("背对背拥抱", "艾辰"));
        mData.add(new music("蝶恋花", "邓紫棋"));
        mData.add(new music("浮生未歇", "音频怪物"));
        mData.add(new music("干物语", "洛天依"));
        mData.add(new music("幻听", "许嵩"));
        mData.add(new music("静悄悄", "仇志"));



        mAdapter = new musicAdapter((LinkedList<music>) mData, mContext);
        list.setAdapter(mAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                boolean_po=true;
                Main1Activity.position_get=position;
                Intent intent = new Intent();
                intent.setClass(music_list.this,Main1Activity.class);
                startActivity(intent);
                finish();
            }
        });

    }


}