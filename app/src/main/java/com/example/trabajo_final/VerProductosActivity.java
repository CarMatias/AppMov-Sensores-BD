package com.example.trabajo_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trabajo_final.entidades.Producto;
import com.example.trabajo_final.utilidades.Utilidades;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VerProductosActivity extends AppCompatActivity {

    EditText busqueda;
    ConexionSQlite conn;
    TextView nom,pre,cat,des,foto;

    static TextView usuario;
    ImageView fot;
    Button display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_productos);
        usuario = (TextView) findViewById(R.id.user);
        display = (Button) findViewById(R.id.compra);
        busqueda = (EditText) findViewById(R.id.cat_id);
        nom = (TextView) findViewById(R.id.nombre_idv);
        pre = (TextView) findViewById(R.id.precio_idv);
        cat = (TextView) findViewById(R.id.categoria_idv);
        des = (TextView) findViewById(R.id.descripcion_idv);
        fot = (ImageView) findViewById(R.id.fot);
        conn = new ConexionSQlite(getApplicationContext(), "productos1", null, 1);

    }


    public void buscar(View view){
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros= {busqueda.getText().toString()};
        String[] campos = {Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_PRECIO,Utilidades.CAMPO_CATEGORIA,Utilidades.CAMPO_DESCIPCION,Utilidades.CAMPO_FOTO};
        try {
            Cursor cursor = db.query(Utilidades.TABLA_PRODUCTO,campos,Utilidades.CAMPO_CATEGORIA+"=?",parametros,null,null,null);
            if(cursor.moveToFirst()) {
                nom.setText(cursor.getString(0).toString());
                pre.setText("$"+cursor.getString(1).toString());
                cat.setText(cursor.getString(2).toString());
                des.setText(cursor.getString(3).toString());
                Bitmap imgBitMap = BitmapFactory.decodeFile(cursor.getString(4).toString());
                fot.setImageBitmap(imgBitMap);
            }
             display.setVisibility(View.VISIBLE);
             limpiar();
             cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"No hay productos con esa categoria",Toast.LENGTH_SHORT).show();
        }
    }
    public void vib(View view){
        Vibrator vibrator = (Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(1000);
        Toast.makeText(getApplicationContext(),"Articulo Comprado",Toast.LENGTH_SHORT).show();
        display.setVisibility(View.GONE);
    }

    private void limpiar() {
        busqueda.setText("");

    }

}