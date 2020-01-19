package com.example.longmemoryv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class remember_new extends Activity implements View.OnClickListener {
    String[] phase12 = {"phase 1 คำศัพท์+คำอ่าน+คำแปล(จำ)","phase 2 คำศัพท์+คำอ่าน"};
    int i=0,j=0;
    Button btn_next;
    TextView word_eng1,word_read1,word_tha1,phase;
    vocabulary vocabulary = new vocabulary();
    public static ArrayList<String> word = null;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remember);
        init();
        if (main.isNew){
            word = vocabulary.vocabulary;
        }else {
            word = vocabulary.NonRemember;
        }
        showWord(word);

    }
    public void showWord(ArrayList<String> word){
        String[] vocabs = word.toArray(new String[main.amount]);
        String[] vocab = vocabs[i++].split(" ");
        word_eng1.setText(vocab[0]);
        word_read1.setText(vocab[1]);
        word_tha1.setText(vocab[2]);
    }
    protected void init(){
        btn_next = (Button) findViewById(R.id.btn_next);
        word_eng1 = (TextView) findViewById(R.id.word_eng1);
        word_read1 = (TextView) findViewById(R.id.word_read);
        word_tha1 = (TextView) findViewById(R.id.word_tha);
        phase = (TextView) findViewById(R.id.phase1);

        btn_next.setOnClickListener(this);
    }
    @Override
    public void onClick (View view){
        Intent intent = null;
        if (i >= main.amount){
            intent = new Intent(getApplicationContext(), remember_new_final.class);
        }else {
            if (view.getId() == R.id.btn_next){
                showWord(word);
            }
        }
        if (intent != null){
            startActivity(intent);
        }
    }
}
