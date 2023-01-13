package com.example.fragmentos_y_mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.UiAutomation;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnCargarFragmento1, mBtnCargarFragmento2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnCargarFragmento1 = findViewById(R.id.BTN_Fragmento1);
        mBtnCargarFragmento2 = findViewById(R.id.BTN_Fragmento2);

        CargarFragmento(new Fragmento1());
        /*getSupportFragmentManager().beginTransaction()
                .replace(R.id.FL_ContenidoFragmentos, new Fragmento1())
                .commit();*/

        mBtnCargarFragmento1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Cargamos el fragmento1
                CargarFragmento(new Fragmento1());
                /*getSupportFragmentManager().beginTransaction()
                        .replace(R.id.FL_ContenidoFragmentos, new Fragmento1())
                        .commit();*/
            }
        });

        mBtnCargarFragmento2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Cargamos el fragmento2
                CargarFragmento(new Fragmento2());
                /*getSupportFragmentManager().beginTransaction()
                        .replace(R.id.FL_ContenidoFragmentos, new Fragmento2())
                        .commit();*/
            }
        });
    }

    private void CargarFragmento(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.FL_ContenidoFragmentos, fragment)
                .commit();
    }
}