package com.example.apiusandoglobal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityLogin extends AppCompatActivity {

    EditText editusuario, editsenha;
    Button btn_login, btn_registro, btnPular;
    DBHelper.UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);


        editusuario = findViewById(R.id.editusuario);
        editsenha = findViewById(R.id.editsenha);
        btn_login = findViewById(R.id.btn_login);
        btn_registro = findViewById(R.id.btn_registro);
        btnPular = findViewById(R.id.btnPular);


        usuarioDAO = new DBHelper.UsuarioDAO(this);

        btnPular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tela02 = new Intent(MainActivityLogin.this, MainActivity.class);
                startActivity(tela02);
                finish();
            }
        });

        btn_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registro = new Intent(MainActivityLogin.this, MainActivityREgistro.class);
                startActivity(registro);
            }
        });


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = editusuario.getText().toString();
                String senha = editsenha.getText().toString();


                if (usuario.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(MainActivityLogin.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {

                    usuarioDAO.open();
                    boolean isValid = usuarioDAO.verificarLogin(usuario, senha);
                    usuarioDAO.close();

                    if (isValid) {

                        Intent tela = new Intent(MainActivityLogin.this, MainActivity.class);
                        startActivity(tela);
                        finish();
                    } else {
                        Toast.makeText(MainActivityLogin.this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
