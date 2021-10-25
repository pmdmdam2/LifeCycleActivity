package com.example.andproject11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Cuadro de diálogo personalizado
 */
public class DialogActivity extends AppCompatActivity {
    private Button btSi;
    private Button btNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        btSi=findViewById(R.id.btSi);
        btNo=findViewById(R.id.btNo);
        //suscripción al evento click
        btSi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //suscripción al evento click
        btNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}