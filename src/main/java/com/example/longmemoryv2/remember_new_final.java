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
import java.util.List;

public class remember_new_final extends Activity implements View.OnClickListener {
    int i=0;
    Button btn_good,btn_normal,btn_bad;
    TextView word_eng,word_read,word_tha;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remember_final);
        init();
        showWord(remember_new.word);
    }
    public void showWord(ArrayList<String> word){
        String[] vocabs = word.toArray(new String[main.amount]);
        String[] vocab = vocabs[0].split(" ");
        word_eng.setText(vocab[0]);
        word_read.setText(vocab[1]);
        word_tha.setText(vocab[2]);
        i++;
    }
    protected void init(){
        btn_good = (Button) findViewById(R.id.btn_good);
        btn_normal = (Button) findViewById(R.id.btn_normal);
        btn_bad = (Button) findViewById(R.id.btn_bad);
        word_eng = (TextView) findViewById(R.id.word_eng_final);
        word_read = (TextView) findViewById(R.id.word_read_final);
        word_tha = (TextView) findViewById(R.id.word_tha_final);

        btn_good.setOnClickListener(this);
        btn_normal.setOnClickListener(this);
        btn_bad.setOnClickListener(this);
    }
    @Override
    public void onClick (View view){
        Intent intent = null;
            Boolean status ;
            if (view.getId() == R.id.btn_good) {
                status = vocabulary.addVocabularyToRemember(remember_new.word);
                if (status) {
                    Toast.makeText(getApplicationContext(), "Very Good!!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Something Wrong", Toast.LENGTH_LONG).show();
                }
                vocabulary.removeVocab(remember_new.word);
            }
            if (view.getId() == R.id.btn_normal) {
                status = vocabulary.addVocabularyToRemember(remember_new.word);
                if (status) {
                    Toast.makeText(getApplicationContext(), "Fighting!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Something Wrong", Toast.LENGTH_LONG).show();
                }
                vocabulary.removeVocab(remember_new.word);
            }
            if (view.getId() == R.id.btn_bad) {
                status = vocabulary.addVocabularyToNonRemember(remember_new.word);
                if (status) {
                    Toast.makeText(getApplicationContext(), "Don't Give Up!!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Something Wrong", Toast.LENGTH_LONG).show();
                }
                vocabulary.removeVocab(remember_new.word);
            }
        if(i > main.amount){
            intent = new Intent(getApplicationContext(),main.class);

            Toast.makeText(getApplicationContext(),"❤You Good Today❤",Toast.LENGTH_LONG).show();
        }
        if (intent != null) {
                startActivity(intent);
        }
        showWord(remember_new.word);
    }
}
