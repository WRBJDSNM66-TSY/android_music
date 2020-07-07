package com.example.bigworkproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int [] images = new int[]{R.drawable.lunzhuan1,R.drawable.lunzhuan2, R.drawable.lunzhuan3,
            R.drawable.lunzhuan4,R.drawable.lunzhuan5,R.drawable.lunzhuan6,R.drawable.lunzhuan7,
            R.drawable.lunzhuan9
    };
    private ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flipper = (ViewFlipper) findViewById(R.id.flipper);
        for (int i = 0; i < images.length; i++) {
            flipper.addView(getImageView(i));
        }
        flipper.setInAnimation(MainActivity.this, R.anim.left_in);
        flipper.setOutAnimation(MainActivity.this, R.anim.right_out);
        flipper.setFlipInterval(3000);
        flipper.startFlipping();



        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, music_list.class);
                startActivity(intent);
                finish();
            }
        });


        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, music_list2.class);
                startActivity(intent);
            }
        });
        Button btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, newlist.class);
                startActivity(intent);
            }
        });
        Button btn4= (Button) findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, uplist.class);
                startActivity(intent);
            }
        });

        Button btn5= (Button) findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });

        Button but6 = (Button)findViewById(R.id.button6);
        but6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,refresh.class);
                startActivity(intent);
            }
        });

        Button but7 = (Button)findViewById(R.id.button7);
        but7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,refresh.class);
                startActivity(intent);
            }
        });

    }

    private View getImageView(int res){
        ImageView image = new ImageView(this);
        image.setBackgroundResource(images[res]);
        return image;
    }


}
