package com.example.parcial2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView txt_usuario, txt_contrasena;
    EditText edt_usuario, edt_contrasena;
    Button btn_enviar;
    String dato;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public static final String dataUser= "dataUser";
    private static final int modo_privado = Context.MODE_PRIVATE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_usuario = findViewById(R.id.txt_usuario);
        txt_contrasena = findViewById(R.id.txt_contrasena);
        edt_usuario = findViewById(R.id.edt_usuario);
        edt_contrasena = findViewById(R.id.edt_contrasena);
        btn_enviar = findViewById(R.id.btn_enviar);

        sharedPreferences = getSharedPreferences(dataUser, modo_privado);
        editor = sharedPreferences.edit();

        dato = getApplicationContext().getSharedPreferences(dataUser, modo_privado).getString("usuario", "0");

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usuario = edt_usuario.getText().toString();
                String contrasena = edt_contrasena.getText().toString();

                if (!usuario.equals("") && !contrasena.equals("")){
                    editor.putString("usuario", edt_usuario.getText().toString());
                    editor.commit();
                    Intent ingresar = new Intent(MainActivity.this, Inicio.class);
                    startActivity(ingresar);
                }else {
                    Toast.makeText(MainActivity.this, "Por favor llenar los campos", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}