package com.example.longmemoryv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class remember_oldword extends Activity implements View.OnClickListener {
    Button Answer,back,next;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remember_oldword);
        init();
    }
    public void init(){
        Answer = (Button) findViewById(R.id.Answer);
        back = (Button) findViewById(R.id.back_old);
        next = (Button) findViewById(R.id.next_old);

        Answer.setOnClickListener(this);
        back.setOnClickListener(this);
        next.setOnClickListener(this);

    }
    @Override
    public void onClick (View view){
        Intent intent = null;
        switch (view.getId()){
            case R.id.Answer:

                break;
            case R.id.back_old:
                intent = new Intent(getApplicationContext(),showWord.class);
                break;
            case R.id.next_old:

                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
