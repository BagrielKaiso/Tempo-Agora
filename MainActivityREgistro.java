package com.example.apiusandoglobal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityREgistro extends AppCompatActivity {

    EditText editTextNome, editTextEmail, editTextSenha;
    Button buttonCadastrar;
    DBHelper.UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registro);


        editTextNome = findViewById(R.id.editTextNome);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSenha = findViewById(R.id.editTextSenha);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);


        usuarioDAO = new DBHelper.UsuarioDAO(this);


        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                String email = editTextEmail.getText().toString();
                String senha = editTextSenha.getText().toString();


                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(MainActivityREgistro.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    usuarioDAO.open();
                    usuarioDAO.inserirUsuario(nome, email, senha);
                    usuarioDAO.close();

                    Toast.makeText(MainActivityREgistro.this, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
package com.example.apiusandoglobal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityREgistro extends AppCompatActivity {

    EditText editTextNome, editTextEmail, editTextSenha;
    Button buttonCadastrar;
    DBHelper.UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registro);


        editTextNome = findViewById(R.id.editTextNome);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSenha = findViewById(R.id.editTextSenha);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);


        usuarioDAO = new DBHelper.UsuarioDAO(this);


        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                String email = editTextEmail.getText().toString();
                String senha = editTextSenha.getText().toString();


                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(MainActivityREgistro.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    usuarioDAO.open();
                    usuarioDAO.inserirUsuario(nome, email, senha);
                    usuarioDAO.close();

                    Toast.makeText(MainActivityREgistro.this, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
package com.example.apiusandoglobal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityREgistro extends AppCompatActivity {

    EditText editTextNome, editTextEmail, editTextSenha;
    Button buttonCadastrar;
    DBHelper.UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registro);


        editTextNome = findViewById(R.id.editTextNome);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSenha = findViewById(R.id.editTextSenha);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);


        usuarioDAO = new DBHelper.UsuarioDAO(this);


        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                String email = editTextEmail.getText().toString();
                String senha = editTextSenha.getText().toString();


                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(MainActivityREgistro.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    usuarioDAO.open();
                    usuarioDAO.inserirUsuario(nome, email, senha);
                    usuarioDAO.close();

                    Toast.makeText(MainActivityREgistro.this, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
package com.example.apiusandoglobal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityREgistro extends AppCompatActivity {

    EditText editTextNome, editTextEmail, editTextSenha;
    Button buttonCadastrar;
    DBHelper.UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registro);


        editTextNome = findViewById(R.id.editTextNome);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSenha = findViewById(R.id.editTextSenha);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);


        usuarioDAO = new DBHelper.UsuarioDAO(this);


        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                String email = editTextEmail.getText().toString();
                String senha = editTextSenha.getText().toString();


                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(MainActivityREgistro.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    usuarioDAO.open();
                    usuarioDAO.inserirUsuario(nome, email, senha);
                    usuarioDAO.close();

                    Toast.makeText(MainActivityREgistro.this, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
package com.example.apiusandoglobal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityREgistro extends AppCompatActivity {

    EditText editTextNome, editTextEmail, editTextSenha;
    Button buttonCadastrar;
    DBHelper.UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registro);


        editTextNome = findViewById(R.id.editTextNome);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSenha = findViewById(R.id.editTextSenha);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);


        usuarioDAO = new DBHelper.UsuarioDAO(this);


        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                String email = editTextEmail.getText().toString();
                String senha = editTextSenha.getText().toString();


                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(MainActivityREgistro.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    usuarioDAO.open();
                    usuarioDAO.inserirUsuario(nome, email, senha);
                    usuarioDAO.close();

                    Toast.makeText(MainActivityREgistro.this, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
package com.example.apiusandoglobal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityREgistro extends AppCompatActivity {

    EditText editTextNome, editTextEmail, editTextSenha;
    Button buttonCadastrar;
    DBHelper.UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registro);


        editTextNome = findViewById(R.id.editTextNome);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSenha = findViewById(R.id.editTextSenha);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);


        usuarioDAO = new DBHelper.UsuarioDAO(this);


        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                String email = editTextEmail.getText().toString();
                String senha = editTextSenha.getText().toString();


                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(MainActivityREgistro.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    usuarioDAO.open();
                    usuarioDAO.inserirUsuario(nome, email, senha);
                    usuarioDAO.close();

                    Toast.makeText(MainActivityREgistro.this, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
package com.example.apiusandoglobal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityREgistro extends AppCompatActivity {

    EditText editTextNome, editTextEmail, editTextSenha;
    Button buttonCadastrar;
    DBHelper.UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registro);


        editTextNome = findViewById(R.id.editTextNome);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSenha = findViewById(R.id.editTextSenha);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);


        usuarioDAO = new DBHelper.UsuarioDAO(this);


        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                String email = editTextEmail.getText().toString();
                String senha = editTextSenha.getText().toString();


                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(MainActivityREgistro.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    usuarioDAO.open();
                    usuarioDAO.inserirUsuario(nome, email, senha);
                    usuarioDAO.close();

                    Toast.makeText(MainActivityREgistro.this, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
package com.example.apiusandoglobal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityREgistro extends AppCompatActivity {

    EditText editTextNome, editTextEmail, editTextSenha;
    Button buttonCadastrar;
    DBHelper.UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registro);


        editTextNome = findViewById(R.id.editTextNome);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSenha = findViewById(R.id.editTextSenha);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);


        usuarioDAO = new DBHelper.UsuarioDAO(this);


        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                String email = editTextEmail.getText().toString();
                String senha = editTextSenha.getText().toString();


                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(MainActivityREgistro.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    usuarioDAO.open();
                    usuarioDAO.inserirUsuario(nome, email, senha);
                    usuarioDAO.close();

                    Toast.makeText(MainActivityREgistro.this, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
package com.example.apiusandoglobal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityREgistro extends AppCompatActivity {

    EditText editTextNome, editTextEmail, editTextSenha;
    Button buttonCadastrar;
    DBHelper.UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registro);


        editTextNome = findViewById(R.id.editTextNome);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSenha = findViewById(R.id.editTextSenha);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);


        usuarioDAO = new DBHelper.UsuarioDAO(this);


        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                String email = editTextEmail.getText().toString();
                String senha = editTextSenha.getText().toString();


                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(MainActivityREgistro.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    usuarioDAO.open();
                    usuarioDAO.inserirUsuario(nome, email, senha);
                    usuarioDAO.close();

                    Toast.makeText(MainActivityREgistro.this, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
