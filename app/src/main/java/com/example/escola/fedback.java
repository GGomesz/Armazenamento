package com.example.escola;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class fedback extends AppCompatActivity {

    private EditText titulo;
    private EditText conteudo;
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fedback);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
        }

        titulo = (EditText) findViewById(R.id.edt_titulo);
        conteudo = (EditText) findViewById(R.id.edt_conteudo);
        enviar = (Button) findViewById(R.id.btn_enviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String conteud = conteudo.getText().toString();
                salvarArquivo(conteud);
            }
        });

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1000:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "permissão concedida!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "permissão negada!", Toast.LENGTH_SHORT).show();
                    finish();
                }
        }
    }

    private void salvarArquivo(String conteudoArquivo) {
        File folder = new File(Environment.getExternalStorageDirectory() + "save feedback/");
        if (folder.exists()) {
            folder.mkdir();
        }
        String nomearquivo = titulo.getText().toString();
        File arquivo = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "save feedback/" + nomearquivo);
        try {
            FileOutputStream enviar = new FileOutputStream(arquivo);
            enviar.write(conteudoArquivo.getBytes());
            enviar.close();
            Toast.makeText(this, "Arquivo salvo", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Arquivo salvo", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Erro", Toast.LENGTH_SHORT).show();
        }
    }
}

