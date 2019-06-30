package com.example.cdhan.onlinevotingsystem;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

import static com.example.cdhan.onlinevotingsystem.Wifi_unique.getMacAddr;

public class Loginpage extends AppCompatActivity {
    EditText e1,e2;
    String mac;
    int flag=0,flag1=0;
    String TAG="123";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        e1=findViewById(R.id.editText);
        mac=getMacAddr();
    }
    public void onClick(View view)
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://onlinevotingsystem-e3727.firebaseio.com/");
        final DatabaseReference myRef = database.getReference("message");
        String aad=e1.getText().toString();
        String vote="";
        Log.d(TAG,"Logged in");
        user some=new user();
        some.setAadhar("1234");
        some.setVote("0");
        //some.setMacaddr("1");
        //myRef.child("1234").setValue(some);
        if(aad.equals("123456"))
        {
            Intent intent=new Intent(this,admincheck.class);
            startActivity(intent);
        }
        else{
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String TAG="123";
                Log.d(TAG,"Entered event listener");
                //Toast.makeText(this,"Entered login",Toast.LENGTH_SHORT).show();
                String aadh = e1.getText().toString();
                int count=0;
                for (DataSnapshot postsnapshot : dataSnapshot.getChildren()) {
                    user use = postsnapshot.getValue(user.class);
                    if(count==1)
                    Toast.makeText(Loginpage.this,"You have already cast your vote from this device",Toast.LENGTH_SHORT).show();
                    if (use.getAadhar().equals(aadh)) {
                        flag1=1;
                        //break;
                    }
                    if(use.getMacaddr().equals(mac))
                    {
                        flag=1;
                        if(count==0)
                        {
                            //Toast.makeText(Loginpage.this,"You have already cast your vote from this device",Toast.LENGTH_SHORT).show();
                            count=1;
                        }
                    }
                }
                if(flag1==1&&flag==0)
                {
                    for (DataSnapshot postsnapshot : dataSnapshot.getChildren()) {
                        user use = postsnapshot.getValue(user.class);
                        if (use.getAadhar().equals(aadh)) {
                            use.setMacaddr(mac);
                            myRef.child(aadh).setValue(use);
                        }
                    }
                    Intent intent=new Intent(Loginpage.this,MainActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putString("e1",aadh);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });}
    }
    public static String getMacAddr() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    res1.append(Integer.toHexString(b & 0xFF) + ":");
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception ex) {
            //handle exception
        }
        return  "";
    }
}
