package com.example.escola;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button btn_tela1;
    Button btn_tela2;
    Button btn_tela3;
    Button btn_alunos;
    Button btn_feedback;


    private Button btn_tela5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_tela1 = (Button) findViewById(R.id.btn_tela1);

        btn_alunos = (Button) findViewById(R.id.btn_aluno);

        btn_feedback = (Button) findViewById(R.id.btn_feedback);

        btn_tela1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent inmap = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(inmap);

            }
        });

        btn_tela2 = (Button) findViewById(R.id.btn_tela2);

        btn_tela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent incursos = new Intent(MainActivity.this, cursos.class);
                startActivity(incursos);

            }
        });

        btn_alunos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent incursos = new Intent(MainActivity.this, alunos.class);
                startActivity(incursos);

            }
        });

        btn_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent incursos = new Intent(MainActivity.this, fedback.class);
                startActivity(incursos);

            }
        });

        btn_tela3 = (Button) findViewById(R.id.btn_tela3);

        btn_tela3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent incont = new Intent(MainActivity.this, Contatos.class);
                startActivity(incont);

            }
        });
                btn_tela5 = (Button) findViewById(R.id.btn_tela5);

                btn_tela5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://basilides.com.br/")));
                    }
                });

    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

}
