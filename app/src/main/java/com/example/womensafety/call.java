package com.example.womensafety;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class call extends AppCompatActivity {
    EditText phoneNo;
    FloatingActionButton callbtn;
    static int PERMISSION_CODE= 100;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_call);
        phoneNo = findViewById(R.id.editTextPhone);
        callbtn = findViewById(R.id.callbtn);

        if (ContextCompat.checkSelfPermission(call.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(call.this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSION_CODE);

    }

    callbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String phoneno = phoneNo.getText().toString();
            Intent i = new Intent(Intent.ACTION_CALL);
            i.setData(Uri.parse("tel:"+phoneno));
            startActivity(i);
        }
    });

    }
}