package com.example.andproject11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {
    private static final String GAME_STATE_CREATE = "1";
    private static final String TEXT_VIEW_CREATE = "1";
    private TextView textView;

    //estado persistente entre ejecuciones de la actividad
    private int gameState;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //se instancia la clase base para poder usar todos sus miembros correctamente
        super.onCreate(savedInstanceState);
        //se recupera la información de estado de la actividad
        if (savedInstanceState != null) {
            gameState = savedInstanceState.getInt(GAME_STATE_CREATE);
        }
        // se asigna la interfaz gráfica a la actividad
        setContentView(R.layout.activity_main);
        //se inicializa el componente de texto para manejarlo más tarde.
        textView = (TextView) findViewById(R.id.tvTexto);
        //se registra el componente observador del ciclo de vida de la actividad.
        getLifecycle().addObserver(new TextViewComponent(this,this.textView));
        final Button btDialog = findViewById(R.id.btDialog);
        btDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dActivity = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(dActivity);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    //este método nos permite recuperar la información de estado almacenada en onCreate después
    //de que se reinicie la aplicación
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        textView.setText(savedInstanceState.getString(TEXT_VIEW_CREATE));
    }

    //este método se invoca cuando la actividad se ha detenido y todavía no está completamente
    //destruida
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(GAME_STATE_CREATE, gameState);
        outState.putString(TEXT_VIEW_CREATE, textView.getText().toString());

        //se comunica el nuevo estado a la clase base
        super.onSaveInstanceState(outState);
    }
}