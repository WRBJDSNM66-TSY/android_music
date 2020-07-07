package com.example.bigworkproject;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);



        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText1=findViewById(R.id.editText);
                EditText editText2=findViewById(R.id.editText2);
                EditText editText3=findViewById(R.id.editText3);

                String text1 = String.valueOf(editText1.getText());
                String text2 = String.valueOf(editText2.getText());
                String text3 = String.valueOf(editText3.getText());

if (text1.equals("zhangsan")&&text2.equals("123")&&text2.equals(text3)) {

            Intent intent = new Intent();
            intent.setClass(Login.this, MainActivity.class);
            startActivity(intent);

}else if (!text2.equals(text3)){
    Toast.makeText(Login.this, "两次密码不一致！", Toast.LENGTH_SHORT).show();
}else if (text1.equals("")|text2.equals("")){
    Toast.makeText(Login.this, "账号或密码为空！", Toast.LENGTH_SHORT).show();
}else{
    Toast.makeText(Login.this, "您输入的账号或密码有误！", Toast.LENGTH_SHORT).show();
}

            }
        });


        Button button1=(Button)findViewById(R.id.button8);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Login.this, Sign.class);
                startActivity(intent);
            }
        });
        Button button2=(Button)findViewById(R.id.button10);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}

