package com.example.buddies.mcqquiztest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class topicspage extends AppCompatActivity {
   Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topicspage);

    b1=(Button)findViewById(R.id.button3);
        b2=(Button)findViewById(R.id.button4);
        b3=(Button)findViewById(R.id.button5);
    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i1 = new Intent(topicspage.this,moviequestions.class);
            startActivity(i1);
        }
    });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(topicspage.this,sportsquestions.class);
                startActivity(i2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(topicspage.this,MainActivity.class);
                startActivity(i3);
            }
        });
    }
}
