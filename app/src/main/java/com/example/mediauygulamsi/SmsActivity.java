package com.example.mediauygulamsi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SmsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        Button btnGonder = findViewById(R.id.btnGonder);
        btnGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextNumara = findViewById(R.id.editText4);
                String numara = editTextNumara.getText().toString();

                if(numara.length()>11 || numara.length()<10){
                    Toast.makeText(SmsActivity.this,"lütfen uygun bir numara giriniz",Toast.LENGTH_LONG).show();
                    return;
                }
                if(numara.length()==10) {

                    if (numara.charAt(0) == '0') {

                        Toast.makeText(SmsActivity.this, "lütfen uygun bir numara giriniz", Toast.LENGTH_LONG).show();
                        return;

                    }
                    numara = "0" + numara;
                }
                EditText editTextMesaj = findViewById(R.id.editTextMesaj);
                String mesaj = editTextMesaj.getText().toString();
                Uri uri = Uri.parse("smsto:"+numara);
                Intent intent = new Intent(Intent.ACTION_SENDTO,uri);
                intent.putExtra("sms_body", mesaj);
                startActivity(intent);
            }
        });
    }
}
