package com.example.longmemoryv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class showWord extends Activity implements View.OnClickListener {
    Button oldWord,back;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showword);
        init();
    }
    public void init(){
        oldWord = (Button) findViewById(R.id.oldword);
        back = (Button) findViewById(R.id.back);

        oldWord.setOnClickListener(this);
        back.setOnClickListener(this);

    }
    @Override
    public void onClick (View view){
        Intent intent = null;
        switch (view.getId()){
            case R.id.oldword:
                intent = new Intent(getApplicationContext(), remember_oldword.class);
                break;
            case R.id.back:
                intent = new Intent(getApplicationContext(),main.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
