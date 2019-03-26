package com.example.mediauygulamsi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnHarita = findViewById(R.id.btnHarita);
        btnHarita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"haritaya gite tıkladınız",Toast.LENGTH_LONG).show();
                Uri uri = Uri.parse("geo:40.9778244,27.5196842,17");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
            Button btnWeb = findViewById(R.id.btnWeb);
            btnWeb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Uri uri = Uri.parse("http://www.google.com.tr");
                    //Intent intent = new Intent(Intent.ACTION_VIEW,uri);

                    Intent intent = new Intent(MainActivity.this,WebActivity.class);
                    startActivity(intent);
                }
            });

            Button btnfotograf = findViewById(R.id.btnfoto);
            btnfotograf.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, KameraActivity.class);
                    startActivity(intent);
                }
            });
            Button btnSes = findViewById(R.id.btnSes);
            btnSes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,KayitActivity.class);
                    startActivity(intent);
                }
            });
            Button btnSms = findViewById(R.id.btnSms);
            btnSms.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,SmsActivity.class);
                    startActivity(intent);
                }
            });
            Button btnAra = findViewById(R.id.btnAra);
            btnAra.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, AramaActivity.class);
                    startActivity(intent);
                }
            });



    }
}
