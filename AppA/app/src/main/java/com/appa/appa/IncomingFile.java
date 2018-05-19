package com.appa.appa;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by Gerald PC on 17/05/2018.
 */

public class IncomingFile extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {

        // Retrieves a map of extended data from the intent.
        final Bundle bundle = intent.getExtras();

        try {

            if (bundle != null) {

                final String mNombreArchivo = (String) bundle.getString("nombre");
                final String mContenidoArchivo = (String) bundle.getString("contenido");

                Log.i("FileReceiver", "Archivo: " + mNombreArchivo + "; Contenido: " + mContenidoArchivo);

                int duration = Toast.LENGTH_SHORT;

                try {
                    File ruta_sd = Environment.getExternalStorageDirectory();

                    File file = new File(ruta_sd.getAbsolutePath(), mNombreArchivo);
                    //File file = new File(context.getExternalFilesDir(null), mNombreArchivo);

                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));

                    Toast toast = Toast.makeText(context, "Archivo: " + mNombreArchivo + "; Contenido: " + mContenidoArchivo, duration);
                    toast.show();

                    outputStreamWriter.write(mContenidoArchivo);
                    outputStreamWriter.close();

                } catch (Exception ex) {
                    Log.e("Ficheros", "Error al escribir fichero a tarjeta SD");
                    Toast toast1 = Toast.makeText(context, "Error al escribir fichero a tarjeta SD", duration);
                    toast1.show();
                }

            } // bundle is null

        } catch (Exception e) {
            Log.e("FileReceiver", "Exception fileReceiver" + e);

        }
    }
}