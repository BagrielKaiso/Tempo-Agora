Documentação do Sistema de Cadastro e Login
Visão Geral
O sistema de cadastro e login implementado permite que os usuários se registrem, armazenem suas credenciais (nome, email e senha) de forma segura, e realizem login para acessar a aplicação. O armazenamento dos dados é feito localmente no dispositivo utilizando um banco de dados SQLite.

Arquitetura
A arquitetura do sistema é baseada nas classes principais:

DBHelper: Gerencia a criação e atualização do banco de dados.
UsuarioDAO: Realiza as operações no banco de dados relacionadas aos usuários, como inserção e verificação de login.
MainActivityLogin: Tela de login que verifica se o usuário e senha estão corretos.
MainActivityRegistro: Tela de registro de novos usuários.
Banco de Dados
Estrutura do Banco de Dados
O banco de dados SQLite utilizado possui a seguinte estrutura:

Nome do Banco de Dados: usuarios.db
Versão do Banco de Dados: 1

Tabela: usuarios
A tabela armazena os dados dos usuários registrados. Sua estrutura é:

Campo	Tipo	Descrição
_id	INTEGER	Chave primária (auto incremento)
nome	TEXT	Nome do usuário
email	TEXT	Email do usuário
senha	TEXT	Senha do usuário
SQL de Criação da Tabela:

sql
Copiar código
CREATE TABLE usuarios (
    _id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT,
    email TEXT,
    senha TEXT
);
Classes
DBHelper
A classe DBHelper é responsável por criar e gerenciar o banco de dados. Ela estende SQLiteOpenHelper e implementa os métodos necessários para criar e atualizar o banco de dados.

Métodos Importantes:

onCreate(SQLiteDatabase db): Cria a tabela de usuários ao inicializar o banco de dados.
onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion): Atualiza o banco de dados se necessário.
UsuarioDAO
A classe UsuarioDAO é responsável pelas operações de inserção e verificação de dados no banco de dados.

Métodos Importantes:

open(): Abre o banco de dados para leitura e escrita.
close(): Fecha o banco de dados.
inserirUsuario(String nome, String email, String senha): Insere um novo usuário na tabela.
verificarLogin(String nome, String senha): Verifica se um usuário existe no banco de dados com o nome e senha fornecidos.
Tela de Registro - MainActivityRegistro
A MainActivityRegistro permite ao usuário se cadastrar no sistema. O cadastro envolve o fornecimento de três campos: nome, email e senha.

Fluxo:
O usuário preenche os campos de nome, email e senha.
O botão de "Cadastrar" é pressionado.
A validação é feita para garantir que todos os campos estejam preenchidos.
O usuário é então registrado no banco de dados localmente.
Códigos Relevantes:
java
Copiar código
buttonCadastrar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String nome = editTextNome.getText().toString();
        String email = editTextEmail.getText().toString();
        String senha = editTextSenha.getText().toString();

        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
            Toast.makeText(CadastroActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
        } else {
            usuarioDAO.open();
            usuarioDAO.inserirUsuario(nome, email, senha);  // **Aqui a senha poderia ser criptografada**
            usuarioDAO.close();
            Toast.makeText(CadastroActivity.this, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show();
            finish(); // Volta para a tela de login
        }
    }
});
Tela de Login - MainActivityLogin
A MainActivityLogin permite ao usuário fazer login na aplicação, fornecendo seu nome e senha. O sistema verifica se o nome de usuário e a senha fornecidos correspondem aos dados registrados no banco de dados.

Fluxo:
O usuário fornece seu nome e senha.
O botão de "Login" é pressionado.
A validação é realizada no banco de dados local, verificando se o usuário e a senha correspondem a um registro existente.
Caso o login seja bem-sucedido, o usuário é redirecionado para a tela principal da aplicação.
Códigos Relevantes:
java
Copiar código
btn_login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String usuario = editusuario.getText().toString();
        String senha = editsenha.getText().toString();

        if (usuario.isEmpty() || senha.isEmpty()) {
            Toast.makeText(MainActivityLogin.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
        } else {
            usuarioDAO.open();
            boolean isValid = usuarioDAO.verificarLogin(usuario, senha);  // Verifica no banco
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
Requisitos Funcionais
Cadastro de Usuário:

O sistema deve permitir o cadastro de um novo usuário com nome, email e senha.
O cadastro deve validar se todos os campos foram preenchidos corretamente.
Login de Usuário:

O sistema deve permitir que o usuário faça login fornecendo nome e senha.
O login deve ser validado pelo banco de dados.
Persistência Local de Dados:

O sistema deve armazenar as informações de usuários em um banco de dados local SQLite.
As senhas devem ser armazenadas de forma segura (idealmente com criptografia).
Mensagem de Erro:

Se o usuário tentar fazer login com credenciais incorretas, uma mensagem de erro deve ser exibida.
Requisitos Não Funcionais
Desempenho:

O sistema deve ser responsivo, com baixo tempo de resposta nas operações de login e cadastro.
Segurança:

O sistema deve garantir a segurança dos dados dos usuários, especialmente no que diz respeito ao armazenamento das senhas.
Utilizar técnicas de hashing ou criptografia para proteger as senhas dos usuários.
Manutenibilidade:

O código deve ser modular e bem documentado, facilitando futuras modificações e melhorias.
