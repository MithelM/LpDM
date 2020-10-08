package com.aula2.toca_do_coelho;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Locale;

public class CronometroExpediente extends AppCompatActivity {

    private int seg =0;
    private boolean exec;
    private boolean estavaExec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronometro_expediente);
        exec = false;
        estavaExec = false;

        if(savedInstanceState != null){
            seg = savedInstanceState.getInt("segundos");
            exec = savedInstanceState.getBoolean("executando");
            estavaExec = savedInstanceState.getBoolean("estavaExecutando");

        }

        executarTemporizdor();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("segundos", seg);
        savedInstanceState.putBoolean("executando", exec);
        savedInstanceState.putBoolean("estavaExecutando",estavaExec);

        super.onSaveInstanceState((savedInstanceState));
    }
    @Override
    protected void onPause() {
        super.onPause();
        estavaExec = exec;
        exec = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        exec = estavaExec;
    }

    @Override
    protected void onStop(){
        super.onStop();
        estavaExec = estavaExec;
        exec = false;
    }
    @Override
    protected void onStart(){
        super.onStart();
        exec = estavaExec;
    }

    public void onClickIniciar(View view){
        exec = true;
    }
    public void onClickStop(View view){
        exec = false;
    }
    public void onClickEncerrar(View view){
        exec = false;
        seg = 0;
    }

    private void executarTemporizdor(){
        final TextView textView = (TextView) findViewById(R.id.textHora);

        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {

                int hr = seg/3600;
                int min = (seg%3600)/60;
                int seg_interno = seg%60;

                String time = String.format(Locale.getDefault(), "%d:%02d:%02d",
                hr, min, seg_interno);

                textView.setText(time);

                if( exec){
                    seg ++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }

    public void mudarTela(View view){
        Intent intent = new Intent(this, TocaDoCoelho.class);
        startActivity(intent);
    }
}
