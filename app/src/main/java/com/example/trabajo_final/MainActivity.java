package com.example.trabajo_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText usuario;
    private EditText Contrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = (EditText) findViewById(R.id.nombreP_id);
        Contrasenia = (EditText) findViewById(R.id.contrasenia_id);
    }




   // public void registrar(View view) {
        //Intent intent = new Intent(this, RegistroActivity.class);
        //startActivity(intent);
    //}
    public void iniciarSesion(View view) {
        String cuenta, clave;
        cuenta = usuario.getText().toString();
        clave = Contrasenia.getText().toString();
        if ((cuenta.equals("admin@admin.com"))&&(clave.equals("1111"))) {
            Intent intent = new Intent(this, IngresosActivity.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"ADMIN",Toast.LENGTH_SHORT).show();
        }else if ((cuenta.equals("invitado@invitado.com"))&&(clave.equals("2222"))){
            Toast.makeText(getApplicationContext(),"INVITADO",Toast.LENGTH_SHORT).show();
        }else if ((cuenta.equals("usuario@usuario.com"))&&(clave.equals("3333"))){
            Toast.makeText(getApplicationContext(),"USUARIO",Toast.LENGTH_SHORT).show();
        }else if ((cuenta.equals("anonimo@anonimo.com"))&&(clave.equals("4444"))){
            Toast.makeText(getApplicationContext(),"ANONIMO",Toast.LENGTH_SHORT).show();
        }else if ((cuenta.equals("tester@tester.com"))&&(clave.equals("5555"))) {
            Toast.makeText(getApplicationContext(), "TESTER", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "email y/o contraseña invalidos", Toast.LENGTH_SHORT).show();

        }
    };
}