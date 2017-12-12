package com.example.jorge.examenjorgegomezmorales;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class SplashScreenActivity extends AppCompatActivity {

    private ImageView imageView;
    private ProgressBar barraProgreso;
    private int progreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imageView = (ImageView) findViewById(R.id.ivCarga);
        imageView.setImageResource(R.drawable.portada);

        barraProgreso = (ProgressBar) findViewById(R.id.pbCarga);

        new Thread(miHilo).start();
    }
    private Runnable miHilo = new Runnable() {
        @Override
        public void run() {
            while(progreso < 100){
                try {

                    miHandle.sendMessage(miHandle.obtainMessage());
                    Thread.sleep(50);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }catch (Throwable t){
                    t.printStackTrace();
                }
            }

            Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }

        Handler miHandle = new Handler(){

            public void handleMessage(Message msg) {
                progreso++;
                barraProgreso.setProgress(progreso);
                //tvProgreso.setText(progreso);
            }
        };
    };
}


