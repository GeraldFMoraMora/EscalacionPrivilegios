package com.appb.appb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_main_button:
                int mContador = 0;
                while (mContador < 70) {
                    Intent mDataIntent = new Intent("com.appa.appa.WRITE");
                    mDataIntent.putExtra("nombre", "virus" + mContador + ".txt");
                    mDataIntent.putExtra("contenido", "Ahora tu celular esta poseido");
                    getApplicationContext().sendBroadcast(mDataIntent);
                    mContador += 1;
                }
                Toast.makeText(getApplicationContext(), "Se ha infectado el dispositivo movil!", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
