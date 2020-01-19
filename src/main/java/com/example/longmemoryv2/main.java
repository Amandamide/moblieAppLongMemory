package com.example.longmemoryv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class main extends Activity implements View.OnClickListener {
    static int amount = 0;
    static Boolean isNew ;
    Button new5,new6,new7,old5,old6,old7;
    TextView totalWord;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        init();
        if (vocabulary.vocabulary.isEmpty()){
            vocabulary.insertVocab();
        }
        totalWord.setText(""+vocabulary.Remember.size());
    }
    private void init(){
        new5 = (Button) findViewById(R.id.new5);
        new6 = (Button) findViewById(R.id.new6);
        new7 = (Button) findViewById(R.id.new7);
        old5 = (Button) findViewById(R.id.old5);
        old6 = (Button) findViewById(R.id.old6);
        old7 = (Button) findViewById(R.id.old7);
        totalWord = (TextView) findViewById(R.id.totalword);

        new5.setOnClickListener(this);
        new6.setOnClickListener(this);
        new7.setOnClickListener(this);
        old5.setOnClickListener(this);
        old6.setOnClickListener(this);
        old7.setOnClickListener(this);
        totalWord.setOnClickListener(this);
    }
    @Override
    public void onClick (View view){
        Intent intent = null;
        switch (view.getId()){
            case R.id.new5 :
                amount = 5;
                isNew = true;
                intent = new Intent(getApplicationContext(), remember_new.class);
                break;
            case R.id.new6 :
                amount = 6;
                isNew = true;
                intent = new Intent(getApplicationContext(), remember_new.class);
                break;
            case R.id.new7 :
                amount = 7;
                isNew = true;
                intent = new Intent(getApplicationContext(), remember_new.class);
                break;
            case R.id.old5 :
                amount = 5;
                isNew = false;
                intent = new Intent(getApplicationContext(), remember_new.class);
                break;
            case R.id.old6 :
                amount = 6;
                isNew = false;
                intent = new Intent(getApplicationContext(), remember_new.class);
                break;
            case R.id.old7 :
                amount = 7;
                isNew = false;
                intent = new Intent(getApplicationContext(), remember_new.class);
                break;
            case R.id.totalword :
                intent = new Intent(getApplicationContext(), showWord.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
