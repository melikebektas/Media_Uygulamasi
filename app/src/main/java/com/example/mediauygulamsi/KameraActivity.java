package com.example.mediauygulamsi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class KameraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamera);

        Button btnResimCek = findViewById(R.id.btnresim);
        btnResimCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,100);
            }
        });
        Button btnVideoCek = findViewById(R.id.btnVideo);
        btnVideoCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(intent, 101);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode !=RESULT_OK) return;

        if (requestCode == 100) //resim geldi
        {
            Bundle extras = data.getExtras();
            ImageView imageViev = findViewById(R.id.imageView);
            imageViev.setImageBitmap((Bitmap) extras.get("data"));
        }
        if (requestCode ==101)//video geldi
        {
            VideoView videoView = findViewById(R.id.videoView);
            videoView.setVideoURI(data.getData());
            videoView.setMediaController(new MediaController(this));
            videoView.requestFocus();
            videoView.start();

        }
    }
}
