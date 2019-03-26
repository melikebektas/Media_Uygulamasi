package com.example.mediauygulamsi;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class KayitActivity extends AppCompatActivity {
MediaRecorder recorder;
final String filePath = Environment.getExternalStorageDirectory().getPath() +"/kayit.3gp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);
        Button btnKaydet = findViewById(R.id.btnKaydet);
        btnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = ContextCompat.checkSelfPermission(KayitActivity.this, Manifest.permission.RECORD_AUDIO);
                int result1 = ContextCompat.checkSelfPermission(KayitActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if (result != PackageManager.PERMISSION_GRANTED || result1 != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(KayitActivity.this, new String[]{Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                    return;
                }
                recorder =new MediaRecorder();
                recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_WB);
                recorder.setOutputFile(filePath);

                try {
                    recorder.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                recorder.start();
                Toast.makeText(KayitActivity.this,"kayıt başladı", Toast.LENGTH_LONG).show();
            }


         });
        Button btndur = findViewById(R.id.btnDur);
        btndur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recorder.stop();
                Toast.makeText(KayitActivity.this,"kayit durdu",Toast.LENGTH_LONG).show();
            }
        });
        Button btnCal = findViewById(R.id.btnCal);
        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                try{
                    mediaPlayer.setDataSource(filePath);
                    mediaPlayer.prepare();
                    mediaPlayer.start();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        boolean yetkiAldikMi = grantResults[0] ==PackageManager.PERMISSION_GRANTED;

        if(yetkiAldikMi ==true)

            Toast.makeText(this,"yetki aldık",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"yetki almadık",Toast.LENGTH_LONG).show();
    }
}
