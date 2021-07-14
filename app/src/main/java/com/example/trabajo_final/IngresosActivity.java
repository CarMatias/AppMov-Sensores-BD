package com.example.trabajo_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.trabajo_final.utilidades.Utilidades;

import java.io.File;
import java.io.IOException;

public class IngresosActivity extends AppCompatActivity {
    private ImageView img;
    public Button button;
    private EditText nom, pre, cat, des;
    String rutaImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresos);

        img = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.button);
        nom = (EditText) findViewById(R.id.nombreP_id);
        pre = (EditText) findViewById(R.id.precioP_id);
        cat = (EditText) findViewById(R.id.categoriaP_id);
        des = (EditText) findViewById(R.id.descripcionP_id);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCamara();

            }
        });
    }
    public void registrar(View view) throws IOException {
        ConexionSQlite conn = new ConexionSQlite(this,"productos1", null,1);

        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Utilidades.CAMPO_NOMBRE, nom.getText().toString());
        values.put(Utilidades.CAMPO_PRECIO, pre.getText().toString());
        values.put(Utilidades.CAMPO_CATEGORIA, cat.getText().toString());
        values.put(Utilidades.CAMPO_DESCIPCION, des.getText().toString());
        values.put(Utilidades.CAMPO_FOTO, rutaImagen);

        db.insert(Utilidades.TABLA_PRODUCTO, null,values);

        Toast.makeText(getApplicationContext(), "Producto Cargado", Toast.LENGTH_SHORT).show();


    }

        private void abrirCamara(){
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
         // if (intent.resolveActivity(getPackageManager()) != null) {


               File imagenArchivo = null;

               try {
                   imagenArchivo = crearImagen();

               }catch (IOException exception){

                   Log.e("Error", exception.toString());

               };

               if(imagenArchivo != null){
                   Uri fotoUri = FileProvider.getUriForFile(this, "com.example.trabajo_final.fileprovider", imagenArchivo);
                   intent.putExtra(MediaStore.EXTRA_OUTPUT, fotoUri);
                   startActivityForResult(intent, 1);
          //    }


            }
        }

        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 1 && resultCode == RESULT_OK) {
                Bitmap imgBitMap = BitmapFactory.decodeFile(rutaImagen);
                img.setImageBitmap(imgBitMap);
            }
        }
        private File crearImagen() throws IOException {
            String nombreImagen = "foto_";
            File directorio = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            File imagen = File.createTempFile(nombreImagen,".jpg", directorio);

            rutaImagen = imagen.getAbsolutePath();
            return imagen;
        }


}



