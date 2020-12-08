package com.example.escola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class alunos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alunos);

        final EditText nome = (EditText) findViewById(R.id.edt_nome);
        final EditText email = (EditText) findViewById(R.id.edt_email);

        Button salvar = (Button) findViewById(R.id.btn_salvar);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("preferencias",
                        Context.MODE_PRIVATE);
                SharedPreferences.Editor ed = prefs.edit();
                ed.putString("nome", nome.getText().toString());
                ed.putString("email", email.getText().toString());
                ed.apply();
                Toast.makeText(getBaseContext(), "salvo com sucesso",
                        Toast.LENGTH_SHORT).show();
            }
        });
        Button recuperar = (Button) findViewById(R.id.btn_rec);
        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("preferencias",
                        Context.MODE_PRIVATE);
                nome.setText(prefs.getString("nome","não encontrado"));
                email.setText(prefs.getString("email","não encontrado"));
            }
        });
        Button limpar = (Button) findViewById(R.id.btn_limpar);
        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nome.setText("");
                email.setText("");
            }
        });

    }
}
