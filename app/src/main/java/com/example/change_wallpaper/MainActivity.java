package com.example.change_wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn;
    boolean running;
    int [] ia = new int[]{R.drawable.spiderbat,R.drawable.kakashi,R.drawable.miguel,R.drawable.goku};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn_wall);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(!running){
            new Timer().schedule(new MyTimer(), 0, 3000);
            running = true;
        }
    }

    private class MyTimer extends TimerTask {
        @Override
        public void run() {
            try {
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(getBaseContext());
                Random random = new Random();
                wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(),ia[random.nextInt(5)]));
                }catch (IOException e){}
            }
        }
    }
