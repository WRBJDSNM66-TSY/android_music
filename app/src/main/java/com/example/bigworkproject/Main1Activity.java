package com.example.bigworkproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class Main1Activity extends AppCompatActivity {

    Button lastBtn;
    Button nextBtn;
    Button playBtn;
    Button backToList;
    Button style;
    Button backBtn;
    SeekBar positionBar;
    SeekBar volumeBar;
    TextView leftTime;
    TextView rightTime;
    TextView musicname;
    MediaPlayer mp;
    int totalTime;
    Handler mHandler = new Handler();
    static int position=1;
    static int position_get;
    int stylePosition=0;

    Runnable r=new Runnable() {
        @Override
        public void run() {
            if(!mp.isPlaying()&&((stylePosition%3)==0)){
                position++;
                init(position);
                mp.start();
            }else if(!mp.isPlaying()&&((stylePosition%3)==1)) {
                position=(int)Math.random()%3;
                init(position);
                mp.start();
            }else if(!mp.isPlaying()&&((stylePosition%3)==2)){
                init(position);
                mp.start();
            }
            mHandler.postDelayed(this,1000);
        }
    };

    Runnable g=new Runnable() {
        @Override
        public void run() {
            if(music_list.boolean_po){
                position=position_get;
                init(position);
                mp.start();
                playBtn.setBackgroundResource(R.drawable.ic_pause);
                music_list.boolean_po=false;
            }
            mHandler.postDelayed(this,1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        //进度条时间
        leftTime = (TextView) findViewById(R.id.leftTime);
        rightTime = (TextView) findViewById(R.id.rightTime);

        //media
        init(position);

        //调用监听来自播放列表的信息
        mHandler.postDelayed(g, 1000);

        switch (position_get) {
            case 0:
                musicname = (TextView) findViewById(R.id.textView);
                musicname.setText("背对背拥抱");
                break;
            case 1:
                musicname = (TextView) findViewById(R.id.textView);
                musicname.setText("蝶恋花");
                break;
            case 2:
                musicname = (TextView) findViewById(R.id.textView);
                musicname.setText("浮生未歇");
                break;
            case 3:
                musicname = (TextView) findViewById(R.id.textView);
                musicname.setText("干物语");
                break;
            case 4:
                musicname = (TextView) findViewById(R.id.textView);
                musicname.setText("幻听");
                break;
            case 5:
                musicname = (TextView) findViewById(R.id.textView);
                musicname.setText("静悄悄");
                break;

        }


        //播放暂停
        playBtn = (Button) findViewById(R.id.playBtn);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mp.isPlaying()) {
                    mp.start();
                    playBtn.setBackgroundResource(R.drawable.ic_pause);
                    mHandler.postDelayed(r, 1000);
                } else {
                    mp.pause();//暂停播放
                    mHandler.removeCallbacks(r);
                    playBtn.setBackgroundResource(R.drawable.ic_play);
                }
            }
        });
        //上一首
        lastBtn = (Button) findViewById(R.id.lastBtn);
        lastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
                position--;
                if (position < 0)
                    position = 5;

                switch (position) {
                    case 0:
                        musicname = (TextView) findViewById(R.id.textView);
                        musicname.setText("背对背拥抱");
                        break;
                    case 1:
                        musicname = (TextView) findViewById(R.id.textView);
                        musicname.setText("蝶恋花");
                        break;
                    case 2:
                        musicname = (TextView) findViewById(R.id.textView);
                        musicname.setText("浮生未歇");
                        break;
                    case 3:
                        musicname = (TextView) findViewById(R.id.textView);
                        musicname.setText("干物语");
                        break;
                    case 4:
                        musicname = (TextView) findViewById(R.id.textView);
                        musicname.setText("幻听");
                        break;
                    case 5:
                        musicname = (TextView) findViewById(R.id.textView);
                        musicname.setText("静悄悄");
                        break;

                }
                init(position);
                mp.start();
                playBtn.setBackgroundResource(R.drawable.ic_pause);
                mHandler.postDelayed(r, 1000);
            }
        });
        //下一首
        nextBtn = (Button) findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
                position++;
                if (position == 5)
                    position = 0;


                switch (position) {
                    case 0:
                        musicname = (TextView) findViewById(R.id.textView);
                        musicname.setText("背对背拥抱");
                        break;
                    case 1:
                        musicname = (TextView) findViewById(R.id.textView);
                        musicname.setText("蝶恋花");
                        break;
                    case 2:
                        musicname = (TextView) findViewById(R.id.textView);
                        musicname.setText("浮生未歇");
                        break;
                    case 3:
                        musicname = (TextView) findViewById(R.id.textView);
                        musicname.setText("干物语");
                        break;
                    case 4:
                        musicname = (TextView) findViewById(R.id.textView);
                        musicname.setText("幻听");
                        break;
                    case 5:
                        musicname = (TextView) findViewById(R.id.textView);
                        musicname.setText("静悄悄");
                        break;

                }
                init(position);
                mp.start();
                playBtn.setBackgroundResource(R.drawable.ic_pause);
                mHandler.postDelayed(r, 1000);
            }
        });

        backToList = (Button) findViewById(R.id.backToList);
        backToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Main1Activity.this, music_list.class);
                startActivity(intent);
            }
        });

        style = (Button) findViewById(R.id.style);
        style.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stylePosition = styleChange(stylePosition);
            }
        });

        //initMediaPlayer();
//
//        //进度条
        positionBar = (SeekBar) findViewById(R.id.positionBar);
        positionBar.setMax(totalTime);
        positionBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mp.seekTo(progress);
                    positionBar.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //音量
        volumeBar = (SeekBar) findViewById(R.id.volumeBar);
        volumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volume = progress / 100f;
                mp.setVolume(volume, volume);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Thread 子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mp != null) {
                    try {
                        Message msg = new Message();
                        msg.what = mp.getCurrentPosition();

                        handler.sendMessage(msg);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        backBtn = (Button) findViewById(R.id.back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main1Activity.this, music_list.class);
                startActivity(i);
            }
        });

    }


    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);

            positionBar.setProgress(msg.what);

            String leftTime_=createTime(msg.what);
            leftTime.setText(leftTime_);
            //
            String rightTime_=createTime(totalTime-msg.what);
            rightTime.setText("-"+rightTime_);
        }
    };

    public String createTime(int time){
        String timeP="";
        int min=time/1000/60;
        int sec=time/1000%60;

        timeP=min+":";
        if(sec<10)
            timeP+="0";
        timeP+=sec;

        return timeP;
    }

    public void init(int position)
    {
        if((position)==0) {
            mp = MediaPlayer.create(this, R.raw.beiduibeiyongbao);
        }else if (position==1){
            mp = MediaPlayer.create(this, R.raw.qiangu);
        }else if(position==2) {
            mp = MediaPlayer.create(this, R.raw.jinnianyong);
        }else if(position==3){
            mp = MediaPlayer.create(this, R.raw.nihaiyaowozenyang);
        }else if(position==4){
            mp = MediaPlayer.create(this, R.raw.huanting);
        }else if(position==5){
            mp = MediaPlayer.create(this, R.raw.suyan);
        }

        mp.setLooping(true);
        mp.seekTo(0);
        mp.setVolume(0.5f,0.5f);
        totalTime = mp.getDuration();
    }

    public int styleChange(int stylePosition){

        if((stylePosition%3)==0){
            style.setBackgroundResource(R.drawable.random);
        }else if((stylePosition%3)==1) {
            style.setBackgroundResource(R.drawable.single);
        }else{
            style.setBackgroundResource(R.drawable.loop);
        }

        return ++stylePosition;
    }

}
















