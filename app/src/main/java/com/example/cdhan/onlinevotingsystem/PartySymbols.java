package com.example.cdhan.onlinevotingsystem;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PartySymbols extends AppCompatActivity {
    String party=null;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference myRef = database.getReference("message");
    String aadh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_symbols);
        Bundle bundle=new Bundle();
        bundle=getIntent().getExtras();
        aadh=bundle.getString("e1");
    }
    public void onClickjana(View view)
    {
        party="janasena";
        setvote();
    }
    public void onClickcongress(View view)
    {
        party="congress";
        setvote();
    }
    public void onClickycp(View view)
    {
        party="ycp";
        setvote();
    }
    public void onClicktdp(View view)
    {
        party="tdp";
        setvote();
    }
    public void onClicktrs(View view)
    {
        party="trs";
        setvote();
    }
    public void setvote()
    {
        ValueEventListener valueEventListener = myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postsnapshot : dataSnapshot.getChildren()) {
                    user use = postsnapshot.getValue(user.class);
                    if (use.getAadhar().equals(aadh)) {
                        use.setVote(party);
                        myRef.child(aadh).setValue(use);
                        Intent intent=new Intent(PartySymbols.this,thanku.class);
                        startActivity(intent);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
