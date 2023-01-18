package com.example.fragmentos_y_mvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ItemModelView extends ViewModel {

    private static final MutableLiveData<String> datosLiveData = new MutableLiveData<>();

    //Definir set y get del atributo.
    public void setDatosLiveData(String item) {
        datosLiveData.setValue(item);
    }

    public LiveData<String> getDatosLiveData() {
        return datosLiveData;
    }
}
