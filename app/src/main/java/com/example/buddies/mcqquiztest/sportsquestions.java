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

public class sportsquestions extends AppCompatActivity {

    private TextView scoreview,quest;
    private TextView question1;
    private RadioGroup rg1;
    private RadioButton radiob1,radiob2,radiob3,radiob ;
    private int scorevalue1 = 0;
    private int num1=0,ans1=0,d=1,b=0,e=0;
    int quno1=1;
    private String answer1;
    private DatabaseReference mmques,mmchoice1,mmchoice2,mmchoice3,mmanswer,mmques1,mq,mqu,mque;

    private Button but1,showanswer1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sportsquestions);
        rg1 = (RadioGroup) findViewById(R.id.radiogroup2);
        radiob1 = (RadioButton) findViewById(R.id.radiobt1);
        radiob2 = (RadioButton) findViewById(R.id.radiobt2);
        radiob3 = (RadioButton) findViewById(R.id.radiobt3);
        quest= (TextView)findViewById(R.id.quest1);
        scoreview = (TextView) findViewById(R.id.scoreview1);
        question1 = (TextView) findViewById(R.id.question2);
        but1=(Button)findViewById(R.id.button2);
        showanswer1=(Button)findViewById(R.id.showanswer2);
        mmques = FirebaseDatabase.getInstance().getReference().child("Sports");

        mmques.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String x= dataSnapshot.getKey();
                d= Integer.parseInt(x);
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



        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ( radiob1.isChecked() || radiob2.isChecked() || radiob3.isChecked() ) {

                    checkanswer1();
                }
                else {

                    Toast.makeText(sportsquestions.this,"PLEASE SELECT AN OPTION",Toast.LENGTH_LONG).show();

                }

            }
        });
        showanswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b = num1;
                mmques = FirebaseDatabase.getInstance().getReference().child("Sports");
                mq = mmques.child("" + b);
                mqu = mq.child("Answer");
                mqu.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String aa1 = dataSnapshot.getValue().toString();
                        Toast.makeText(sportsquestions.this, "The Answer Is " + aa1, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
    private void updatescore1(int a)
    {
        scoreview.setText(""+ a);
    }

    private void checkanswer1() {

        if(radiob1.isChecked()){

            if(radiob1.getText().toString().equals(answer1)) {
                if (num1 < (d+1)) {
                    scorevalue1 = scorevalue1 + 1;
                    updatescore1(scorevalue1);
                    num1++;
                    quno1++;
                    rg1.clearCheck();
                    updatequestion1();
                    Toast.makeText(sportsquestions.this, "Correct", Toast.LENGTH_LONG).show();

                }
            }
            else
            {
                if (num1 < (d+1)) {
                    Toast.makeText(sportsquestions.this, "Wrong", Toast.LENGTH_LONG).show();
                    num1++;
                    quno1++;
                    rg1.clearCheck();
                    updatequestion1();

                }
            }

        }
        if(radiob2.isChecked()){


            if(radiob2.getText().toString().equals(answer1)) {
                if (num1 < (d+1)) {
                    scorevalue1 = scorevalue1 + 1;
                    updatescore1(scorevalue1);
                    num1++;
                    quno1++;
                    rg1.clearCheck();
                    updatequestion1();
                    Toast.makeText(sportsquestions.this, "Correct", Toast.LENGTH_LONG).show();

                }
            }
            else
            {
                if (num1 < (d+1)) {
                    Toast.makeText(sportsquestions.this, "Wrong", Toast.LENGTH_LONG).show();
                    num1++;
                    quno1++;
                    rg1.clearCheck();
                    updatequestion1();

                }
            }

        }
        if(radiob3.isChecked()){


            if(radiob3.getText().toString().equals(answer1)) {
                if (num1 < (d+1)) {
                    scorevalue1 = scorevalue1 + 1;
                    updatescore1(scorevalue1);
                    num1++;
                    quno1++;
                    rg1.clearCheck();
                    updatequestion1();
                    Toast.makeText(sportsquestions.this, "Correct", Toast.LENGTH_LONG).show();

                }
            }
            else
            {
                if (num1 < (d+1)) {
                    Toast.makeText(sportsquestions.this, "Wrong", Toast.LENGTH_LONG).show();
                    num1++;
                    quno1++;
                    rg1.clearCheck();
                    updatequestion1();

                }
            }

        }


    }
    private void updatequestion1()
    {

        if(scorevalue1==(d+1))
        {
            scoreview.setText("You Won and Your Score is "+ scorevalue1);

        }
        else{


            if(num1==(d+1))
            {
                but1.setText("Quiz Over!");
            }
            else if(num1<(d+1))
            {
                quest.setText("Ques. " + quno1 + " of "+(d+1));
                mmques= FirebaseDatabase.getInstance().getReference().child("Sports");
                mmques1= mmques.child(""+num1);
                mqu=mmques1.child("Question");
                mqu.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String qq= dataSnapshot.getValue().toString();
                        question1.setText(qq);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                mmchoice1= mmques1.child("Choice1");
                mmchoice1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String cc1= dataSnapshot.getValue().toString();
                        radiob1.setText(cc1);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                mmchoice2= mmques1.child("Choice2");
                mmchoice2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String cc2= dataSnapshot.getValue().toString();
                        radiob2.setText(cc2);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                mmchoice3= mmques1.child("Choice3");
                mmchoice3.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String cc3= dataSnapshot.getValue().toString();
                        radiob3.setText(cc3);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                mmanswer= mmques1.child("Answer");
                mmanswer.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        answer1= dataSnapshot.getValue().toString();

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


            }

        }
    }}
