package com.example.bigworkproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;


public class Sign extends AppCompatActivity {
    private AutoCompleteTextView autoCompleteTextView;
    private String[] places ={
            "北京",  "浙江","天津市" ,"安徽省" ,"上海市" ,"福建省" ," 重庆市" ," 江西省" ," 台湾省",
            "香港特别行政区" ,"山东省" ,"澳门特别行政区" ,"河南省" ,"内蒙古自治区" ,"湖北省" ,"新疆维吾尔自治区" ,
            "湖南省" ,"宁夏回族自治区" ,"广东省" ,"西藏自治区" ,"海南省" ,"广西壮族自治区" ,"四川省" ,"江苏省",
            "河北省" ,"贵州省" ,"山西省" ,"云南省" ,"辽宁省" ," 陕西省" ,"吉林省" ,"甘肃省" ,"黑龙江省" ," 青海省"
  };

    private Spinner spinner;
    private String[] sex ={"男","女","保密"};

    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign);

        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,places);
        autoCompleteTextView.setAdapter(arrayAdapter);


        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sex);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter1);

        final DatePicker datePicker = (DatePicker) findViewById(R.id.DatePicker);
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        datePicker.init(year,month,day,new DatePicker.OnDateChangedListener()
        {
            public void onDateChanged(DatePicker arg0,int year,int month,int day){
                Sign.this.year=year;
                Sign.this.month=month;
                Sign.this.day=day;
                showDate(year,month,day);
            }
        });


        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText1=findViewById(R.id.editText);
                String text1 = String.valueOf(editText1.getText());
                EditText editText2=findViewById(R.id.editText2);
                String text2 = String.valueOf(editText2.getText());
                Spinner spinner=findViewById(R.id.spinner);
                String text3 =spinner.getSelectedItem().toString();
                TextView textView1=findViewById(R.id.autoCompleteTextView);
                String text4=String.valueOf(textView1.getText());
                TextView textView2=findViewById(R.id.textView14);
                String text5=String.valueOf(textView2.getText());

if (!text1.equals("")&&!text2.equals("")&&!text3.equals("")&&!text4.equals("")&&!text5.equals("")) {
    Toast.makeText(Sign.this, "注册成功，现在去登录吧！", Toast.LENGTH_SHORT).show();
    Intent intent = new Intent();
    intent.setClass(Sign.this, Login.class);
    startActivity(intent);
}else{
    Toast.makeText(Sign.this, "请补全信息！", Toast.LENGTH_SHORT).show();
}

            }
        });


        Button button1=(Button)findViewById(R.id.button8);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Sign.this, Login.class);
                startActivity(intent);
            }
        });

    }
    public void showDate(int year,int month,int day){
        TextView show = (TextView) findViewById(R.id.textView14);
        show.setText(year+"年"+(month+1)+"月"+day+"日");
    }

}
