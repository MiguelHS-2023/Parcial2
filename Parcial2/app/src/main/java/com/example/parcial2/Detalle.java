package com.example.parcial2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.parcial2.clases.Usuario;
import com.squareup.picasso.Picasso;

public class Detalle extends AppCompatActivity {

    TextView txt_titulo, txt_curso;
    ImageView imagen;
    Button btn_cerrar;
    public static final String dataUser= "dataUser";
    private static final int modo_privado = Context.MODE_PRIVATE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Usuario dato = (Usuario) getIntent().getSerializableExtra("Usuario");

        txt_titulo = findViewById(R.id.txt_titulo);
        txt_curso = findViewById(R.id.txt_curso);
        imagen = findViewById(R.id.imagen);

        txt_titulo.setText(dato.getNombre());
        txt_curso.setText(dato.getCurso());
        Picasso.get().load(dato.getImagen()).into(imagen);

        btn_cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences configuracion =  getApplicationContext().getSharedPreferences(dataUser, modo_privado);
                configuracion.edit().clear().commit();
                Intent i = new Intent(Detalle.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}