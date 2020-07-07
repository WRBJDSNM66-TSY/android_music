package com.example.bigworkproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class newlist extends AppCompatActivity {
    private String[] names = new String[]
//            {1,2,3,4,5,6};
            {"周杰伦","许嵩","赵雷","张杰","薛之谦","那英","胡歌","冯提莫","刘德华"};
    private String[] songs = new String[]
//            {1,2,3,4,5,6};
            {"等你下课","清明雨上","成都","光","丑八怪","千里之外","六月的雨","学猫叫","忘情水"};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_list);

        Button btn = (Button) findViewById(R.id.button9);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(newlist.this, MainActivity.class);
                startActivity(intent);
            }
        });

        List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();
        for (int i=0; i<names.length; i++)
        {
            Map<String,Object> listItem = new HashMap<String, Object>();
            listItem.put("歌手",names[i]);
            listItem.put("歌曲",songs[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                listItems,
        R.layout.xiaoge,
        new String[] {"歌手","歌曲"},
        new int[] {R.id.textView16, R.id.textView17});

        ListView list = (ListView) findViewById(R.id.mylist);
        list.setAdapter(simpleAdapter);

    }
}
