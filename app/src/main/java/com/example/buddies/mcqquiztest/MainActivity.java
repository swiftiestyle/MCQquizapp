package com.example.buddies.mcqquiztest;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {


    private TextView score,que;
    private TextView question;
    private RadioGroup rg;
    private RadioButton rb1,rb2,rb3 ;
    private int scorevalue = 0;
    private int num =0,b=0,c=1;
    int quno=1;
   private String answer;
   private DatabaseReference mques,mchoice1,mchoice2,mchoice3,manswer,mques1,mq,mqu;

private Button button,showanswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = (RadioGroup) findViewById(R.id.radiogroup);
        rb1 = (RadioButton) findViewById(R.id.radiobutton1);
        rb2 = (RadioButton) findViewById(R.id.radiobutton2);
        rb3 = (RadioButton) findViewById(R.id.radiobutton3);
        que = (TextView) findViewById(R.id.que);
        score = (TextView) findViewById(R.id.score);
        question = (TextView) findViewById(R.id.question);
        button = (Button) findViewById(R.id.button);
        showanswer = (Button) findViewById(R.id.showanswer);
        mques = FirebaseDatabase.getInstance().getReference().child("General Knowledge");
        mques.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String x= dataSnapshot.getKey();
                c= Integer.parseInt(x);
                updatequestion1();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked()) {

                    checkanswer1();
                } else {

                    Toast.makeText(MainActivity.this, "PLEASE SELECT AN OPTION", Toast.LENGTH_LONG).show();

                }

            }
        });
        showanswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b = num;
                mques = FirebaseDatabase.getInstance().getReference().child("General Knowledge");
                mq = mques.child("" + b);
                mqu = mq.child("Answer");
                mqu.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String aa1 = dataSnapshot.getValue().toString();
                        Toast.makeText(MainActivity.this, "The Answer Is " + aa1, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
    void updatescore1(int a)
    {
        score.setText(""+ a);
    }

     void checkanswer1() {

        if(rb1.isChecked()){

            if(rb1.getText().toString().equals(answer)) {
                if (num < (c+1)) {
                    scorevalue = scorevalue + 1;
                    updatescore1(scorevalue);
                    num++;
                    quno++;
                    rg.clearCheck();
                    updatequestion1();
                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_LONG).show();

                }
            }
            else
            {
                if (num < (c+1)) {
                    Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_LONG).show();
                    num++;
                    quno++;
                    rg.clearCheck();
                    updatequestion1();

                }
            }

        }
        if(rb2.isChecked()){


            if(rb2.getText().toString().equals(answer)) {
                if (num < (c+1)) {
                    scorevalue = scorevalue + 1;
                    updatescore1(scorevalue);
                    num++;
                    quno++;
                    rg.clearCheck();
                    updatequestion1();
                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_LONG).show();

                }
            }
            else
            {
                if (num < (c+1)) {
                    Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_LONG).show();
                    num++;
                    quno++;
                    rg.clearCheck();
                    updatequestion1();

                }
            }

        }
        if(rb3.isChecked()){


            if(rb3.getText().toString().equals(answer)) {
                if (num < (c+1)) {
                    scorevalue = scorevalue + 1;
                    updatescore1(scorevalue);
                    num++;
                    quno++;
                    rg.clearCheck();
                    updatequestion1();
                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_LONG).show();

                }
            }
            else
            {
                if (num < (c+1)) {
                    Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_LONG).show();
                    num++;
                    quno++;
                    rg.clearCheck();
                    updatequestion1();

                }
            }

        }


    }
    private void updatequestion1()
    {




        if(scorevalue==(c+1))
        {
            score.setText("You Won and Your Score is "+ scorevalue);

        }
        else{
            if(num==(c+1))
            {
                button.setText("Quiz Over!");
            }
            else if(num<(c+1))
            {
                que.setText("Ques. " + quno + " of " + (c+1));
                mques= FirebaseDatabase.getInstance().getReference().child("General Knowledge");
                mques1= mques.child(""+num);
                mq=mques1.child("Question");

                mq.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String qq= dataSnapshot.getValue().toString();
                        question.setText(qq);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                mchoice1= mques1.child("Choice1");
                mchoice1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String cc1= dataSnapshot.getValue().toString();
                        rb1.setText(cc1);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                mchoice2= mques1.child("Choice2");
                mchoice2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String cc2= dataSnapshot.getValue().toString();
                        rb2.setText(cc2);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                mchoice3= mques1.child("Choice3");
                mchoice3.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String cc3= dataSnapshot.getValue().toString();
                        rb3.setText(cc3);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                manswer= mques1.child("Answer");
                manswer.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        answer= dataSnapshot.getValue().toString();

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


            }

        }
    }}


