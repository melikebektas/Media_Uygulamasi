package com.example.mediauygulamsi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AramaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arama);

        Button btnArama = findViewById(R.id.btnArama);
        btnArama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtNumara =  findViewById(R.id.editTextNumara);
                String numara = txtNumara.getText().toString();

                if(numara.length()>11 || numara.length()<10){
                    Toast.makeText(AramaActivity.this,"lütfen uygun bir numara giriniz",Toast.LENGTH_LONG).show();
                    return;
                }
                if(numara.length()==10) {

                    if(numara.charAt(0) =='0'){

                        Toast.makeText(AramaActivity.this,"lütfen uygun bir numara giriniz",Toast.LENGTH_LONG).show();
                        return;

                    }
                    numara = "0" + numara;

                }
                Uri uri = Uri.parse("tel:"+numara);
                Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);
            }
        });
    }
}
