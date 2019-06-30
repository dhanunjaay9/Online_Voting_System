package com.example.cdhan.onlinevotingsystem;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class FingerprintHandler extends FingerprintManager.AuthenticationCallback {
    private Context context;
    private String aadh;
    public FingerprintHandler(Context mContext,String aad)
    {
        context=mContext;
        aadh=aad;
    }
    public void startAuth(FingerprintManager manager, FingerprintManager.CryptoObject cryptoObject) {
        CancellationSignal cancellationSignal = new CancellationSignal();
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        manager.authenticate(cryptoObject, cancellationSignal, 0, this, null);
    }


    @Override
    public void onAuthenticationError(int errMsgId, CharSequence errString) {
        this.update("Fingerprint Authentication error\n" + errString, false);
    }


    @Override
    public void onAuthenticationHelp(int helpMsgId, CharSequence helpString) {
        this.update("Fingerprint Authentication help\n" + helpString, false);
    }


    @Override
    public void onAuthenticationFailed() {
        this.update("Fingerprint Authentication failed.", false);
    }


    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
        this.update("Fingerprint Authentication succeeded.", true);
    }


    public void update(String e, Boolean success){
        if(success){
            Intent i = new Intent(context,PartySymbols.class);
            Bundle bundle=new Bundle();
            bundle.putString("e1",aadh);
            i.putExtras(bundle);
            context.startActivity(i);
            //textView.setTextColor(ContextCompat.getColor(context,R.color.colorPrimaryDark));
        }
        else
         Toast.makeText(context,"Invalid finger print detected",Toast.LENGTH_SHORT).show();
    }
}
