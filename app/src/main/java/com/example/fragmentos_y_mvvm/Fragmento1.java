package com.example.fragmentos_y_mvvm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Fragmento1 extends Fragment {


    private EditText mEtDatosParaCompartir;
    private TextView mTvDatosCompartidos;
    private Button mBtnCompartirDatos;
    private ItemModelView mItemModelView;

    public Fragmento1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragmento_1, container, false);

        mEtDatosParaCompartir = v.findViewById(R.id.ET_DatosParaEnviar);
        mBtnCompartirDatos = v.findViewById(R.id.BTN_EnviarDatos);
        mTvDatosCompartidos = v.findViewById(R.id.TV_DatosRecibidos);

        mItemModelView = new ViewModelProvider(this).get(ItemModelView.class);

        mItemModelView.getDatosLiveData().observe(getViewLifecycleOwner(), itemObservado -> {
            mTvDatosCompartidos.setText(itemObservado);
        });

        mBtnCompartirDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Set de la variable del ModelView.
                mItemModelView.setDatosLiveData(
                        mEtDatosParaCompartir.getText().toString());
                mTvDatosCompartidos.setText(
                        mEtDatosParaCompartir.getText().toString());
            }
        });
        return v;
    }
}