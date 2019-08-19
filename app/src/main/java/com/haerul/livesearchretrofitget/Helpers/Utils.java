package com.kotlin.myapplication.Helpers;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.kotlin.myapplication.R;
import com.kotlin.myapplication.Retrofit.Scientist;
import com.yarolegovich.lovelydialog.LovelyStandardDialog;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Una clase de utilidad. Contiene métodos de utilidad reutilizables que utilizaremos a lo largo de nuestro proyecto.
   * La clase nos salvará de escribir muchos códigos repetitivos.
 */
public class Utils {

    private  static  final String base_url = "http://sibiup.up.ac.pa/api/koha/";
    private static Retrofit retrofit;

    /**
     * Este método nos devolverá nuestra instancia de Retrofit que podemos usar para iniciar llamadas HTTP.
     */
    public static Retrofit getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit;
    }
    /**
     * Este método nos permitirá mostrar mensajes Toast en todas las actividades
     */
    public static void show(Context c,String message){
        Toast.makeText(c, message, Toast.LENGTH_SHORT).show();
    }


    /**
     * Este método de utilidad nos permitirá abrir cualquier actividad.
     */
    public static void openActivity(Context c,Class clazz){
        Intent intent = new Intent(c, clazz);
        c.startActivity(intent);
    }


    /**
     * Este método nos permitirá mostrar una barra de progreso
     */
    public static void showProgressBar(ProgressBar pb){
        pb.setVisibility(View.VISIBLE);
    }
    /**
     * Este método nos permitirá ocultar una barra de progreso
     */
    public static void hideProgressBar(ProgressBar pb){
        pb.setVisibility(View.GONE);
    }

    public static void sendScientistToActivity(Context c, Scientist scientist,
                                               Class clazz){
        Intent i=new Intent(c,clazz);
        //Le enviamos al activity que acabamos de crear la nposición del cientifico, con la clave de SCIENTIST_KEY
        i.putExtra("SCIENTIST_KEY",scientist);
        c.startActivity(i);
    }

    /**
     * Este método nos permitirá recibir un científico serializado, deserializarlo y devolverlo.
     */
    public  static Scientist receiveScientist(Intent intent, Context c){
        try {
            //Extrae del Itent la posicion del cientifico que mnecesito y lo envia a donde los llamo Detail
            Scientist scientist= (Scientist) intent.getSerializableExtra("SCIENTIST_KEY");
            return scientist;
        }catch (Exception e){
            e.printStackTrace();
            show(c,"RECEIVING-SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }

    /**
     * Este método nos permitirá mostrar un diálogo de información en cualquier lugar de nuestra aplicación.
     */
    public static void showInfoDialog(final AppCompatActivity activity, String title,
                                      String message) {
        new LovelyStandardDialog(activity, LovelyStandardDialog.ButtonLayout.HORIZONTAL)
                .setTopColorRes(R.color.colorAccent)
                .setButtonsColorRes(R.color.colorPrimaryDark)
                .setIcon(R.drawable.m_info)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("Relax", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                })
                .setNeutralButton("Go Home", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                })
                .setNegativeButton("Go Back", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        activity.finish();
                    }
                })
                .show();
    }
}
//end
