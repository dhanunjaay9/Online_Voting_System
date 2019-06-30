package com.example.cdhan.onlinevotingsystem;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class admincheck extends AppCompatActivity {
    int trs=0,ycp=0,congress=0,tdp=0,janasena=0;
    TextView e1,e2,e3,e4,e5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admincheck);
        e1=findViewById(R.id.textView13);
        e2=findViewById(R.id.textView14);
        e3=findViewById(R.id.textView15);
        e4=findViewById(R.id.textView16);
        e5=findViewById(R.id.textView17);
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://onlinevotingsystem-e3727.firebaseio.com/");
        final DatabaseReference myRef = database.getReference("message");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postsnapshot : dataSnapshot.getChildren()) {
                    user use = postsnapshot.getValue(user.class);
                    String s1="trs",s2="janasena",s3="congress",s4="ycp",s5="tdp";
                    if(use.getVote().equals(s1))
                        trs++;
                    if(use.getVote().equals(s2))
                        janasena++;
                    if(use.getVote().equals(s3))
                        congress++;
                    if(use.getVote().equals(s4))
                        ycp++;
                    if(use.getVote().equals(s5))
                        tdp++;
                }

                e1.setText(Integer.toString(janasena));
                e2.setText(Integer.toString(tdp));
                e3.setText(Integer.toString(trs));
                e5.setText(Integer.toString(ycp));
                e4.setText(Integer.toString(congress));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
