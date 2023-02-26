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

public class Fragmento2 extends Fragment {

    private EditText mEtDatosParaCompartir2;
    private TextView mTvDatosCompartidos2;
    private Button mBtnCompartirDatos2;
    private ItemModelView mItemModelView2;

    public Fragmento2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragmento_2, container, false);
        mEtDatosParaCompartir2 = v.findViewById(R.id.ET_DatosParaEnviar2);
        mBtnCompartirDatos2 = v.findViewById(R.id.BTN_EnviarDatos2);
        mTvDatosCompartidos2 = v.findViewById(R.id.TV_DatosRecibidos2);
        mItemModelView2 = new ViewModelProvider(this).get(ItemModelView.class);

        mItemModelView2.getDatosLiveData().observe(getViewLifecycleOwner(), itemObservado -> {
            mTvDatosCompartidos2.setText(itemObservado);
        });

        mBtnCompartirDatos2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvDatosCompartidos2.setText(
                        mEtDatosParaCompartir2.getText().toString());
                mItemModelView2.setDatosLiveData(
                        mEtDatosParaCompartir2.getText().toString());
            }
        });
        return v;
    }
}