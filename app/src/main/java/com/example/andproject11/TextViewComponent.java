package com.example.andproject11;

import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * Componente observador de los cambios de estado de una actividad
 */
public class TextViewComponent implements LifecycleObserver {
    private LifecycleOwner activity;
    private TextView textView;
    public TextViewComponent(LifecycleOwner activity, TextView textView){
        this.activity = activity;
        this.textView = textView;
    }
    //manejador de vento on_create
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void initializeTextView() {
        textView.setText(R.string.espere);
    }
    //manejador de evento on_resume
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void resumeTextView() {
        textView.setText(R.string.app_name);
    }
    //manejador de evento on_pause
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void pauseTextView(){
        textView.setText(R.string.actividad_pausada);
    }
}
