package com.example.trabajo_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OpcionActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcion);


    }

    public void Cargar(View view){
      Intent intent = new Intent(this, IngresosActivity.class);
      startActivity(intent);
    }

    public void Ver(View view){
        Intent intent = new Intent(this, VerProductosActivity.class);
        startActivity(intent);
    }
}