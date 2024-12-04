Sistema de Cadastro e Login - Android
Este repositório contém um sistema simples de cadastro e login para Android, utilizando um banco de dados local SQLite. O sistema permite que os usuários se registrem, armazenem suas credenciais de forma segura e realizem login para acessar a aplicação.

Visão Geral
O sistema de cadastro e login permite que os usuários se registrem com nome, email e senha e, em seguida, façam login utilizando suas credenciais. As informações são armazenadas localmente no dispositivo utilizando SQLite.

Estrutura do Projeto
O projeto é dividido nas seguintes classes e componentes principais:

DBHelper: Gerencia a criação e a atualização do banco de dados SQLite.
UsuarioDAO: Realiza as operações de inserção e verificação de login no banco de dados.
MainActivityLogin: Tela responsável pelo login, onde o usuário entra com suas credenciais.
MainActivityRegistro: Tela de cadastro, onde o usuário se registra com nome, email e senha.
Tecnologias Usadas
Android SDK (para desenvolvimento de apps móveis)
SQLite (para persistência de dados local)
Banco de Dados
O banco de dados é criado e gerenciado pela classe DBHelper, e as operações são realizadas através da classe UsuarioDAO.

Estrutura do Banco de Dados
Nome do Banco de Dados: usuarios.db
Versão do Banco de Dados: 1

Tabela: usuarios
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
Classe responsável pela criação e atualização do banco de dados. Ela estende SQLiteOpenHelper e implementa os métodos necessários para gerenciar a criação e a atualização do banco de dados.

java
Copiar código
public class DBHelper extends SQLiteOpenHelper {
    // Código para criar o banco de dados e tabelas
}
UsuarioDAO
Classe que realiza as operações de inserção e verificação no banco de dados. É usada tanto na tela de cadastro quanto na tela de login.

java
Copiar código
public class UsuarioDAO {
    public void inserirUsuario(String nome, String email, String senha) {
        // Insere um novo usuário no banco de dados
    }

    public boolean verificarLogin(String nome, String senha) {
        // Verifica se o nome e senha correspondem no banco de dados
        return userExists;
    }
}
Telas do Aplicativo
Tela de Registro - MainActivityRegistro
A tela de registro permite ao usuário se cadastrar fornecendo nome, email e senha. Após o preenchimento dos campos e clique no botão "Cadastrar", os dados são inseridos no banco de dados.

Fluxo:
O usuário preenche os campos de nome, email e senha.
O botão "Cadastrar" é pressionado.
A validação dos campos é realizada.
O usuário é inserido no banco de dados, e uma mensagem de sucesso é exibida.
Tela de Login - MainActivityLogin
A tela de login permite que o usuário faça login fornecendo nome e senha. O sistema valida as credenciais no banco de dados.

Fluxo:
O usuário fornece seu nome e senha.
O botão "Login" é pressionado.
O sistema valida as credenciais com o banco de dados.
Se a autenticação for bem-sucedida, o usuário é redirecionado para a tela principal da aplicação.
Requisitos Funcionais
Cadastro de Usuário:

O sistema deve permitir o cadastro de um novo usuário com nome, email e senha.
O cadastro deve validar se todos os campos estão preenchidos corretamente.
Login de Usuário:

O sistema deve permitir que o usuário faça login fornecendo nome e senha.
O login deve ser validado com os dados armazenados no banco de dados.
Persistência Local de Dados:

As informações dos usuários (nome, email, senha) devem ser armazenadas no banco de dados SQLite.
Validação de Login:

Se o nome de usuário ou a senha estiverem incorretos, uma mensagem de erro deve ser exibida.
Requisitos Não Funcionais
Desempenho:

O sistema deve ser eficiente, com tempos rápidos de resposta para operações de cadastro e login.
Segurança:

As senhas dos usuários devem ser armazenadas de forma segura. (Recomenda-se usar criptografia ou hash para proteger as senhas).
Manutenibilidade:

O código deve ser modular e bem documentado, facilitando a manutenção e a adição de novas funcionalidades.
