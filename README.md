Documentação do Projeto - App de Previsão Climática
Visão Geral
Esse aplicativo foi criado para oferecer previsões climáticas detalhadas, baseado no CEP ou cidade que o usuário digitar. Com ele, é possível ver a temperatura atual, as condições climáticas e as previsões para os próximos dias. A informação climática vem de uma API externa, que fornece dados em tempo real.
________________________________________
Requisitos Funcionais
Tela de Login
•	O usuário deve inserir um nome de usuário e senha para acessar o app.
•	Se o login for bem-sucedido, ele é redirecionado para a tela de previsões climáticas.
•	As credenciais de login são fixas no código: Nome de usuário: gabriel e Senha: 91821484.
Tela de Previsão Climática
•	O usuário deve poder digitar um CEP ou o nome de uma cidade para obter a previsão.
•	O aplicativo vai buscar as informações dessa localidade usando uma API externa.
•	As previsões para 3 dias devem ser exibidas, com as condições climáticas e as temperaturas mínimas e máximas.
Exibição de Dados
•	A tela de previsão vai mostrar:
o	Temperatura atual
o	Última atualização dos dados
o	Previsões para os próximos 3 dias, incluindo a condição do clima (ex: Sol, Chuva, etc.) e as temperaturas mínima e máxima.
Integração com a API
•	O aplicativo consome dados de uma API externa para obter as previsões climáticas.
•	A resposta da API vem em JSON, e o app processa esses dados para exibir as informações para o usuário.
________________________________________
Requisitos Não Funcionais
Interface de Usuário
•	A interface deve ser simples e de fácil entendimento.
•	As informações climáticas precisam ser apresentadas de maneira clara e objetiva.
Desempenho
•	O app deve carregar rapidamente as previsões climáticas, sem grandes delays.
Segurança
•	As credenciais de login são fixas e não são seguras para um ambiente de produção. Uma solução de autenticação mais segura seria ideal.
Conectividade
•	O app depende de uma conexão com a internet para acessar a API e pegar os dados em tempo real.
Manutenibilidade
•	O código deve ser bem organizado, facilitando a manutenção e futuras melhorias.
________________________________________
Estrutura do Projeto
Classes
•	MainActivityLogin: É a tela de login, onde o usuário digita o nome de usuário e a senha. Após a validação, ele é redirecionado para a tela de previsões.
•	MainActivity: É a tela principal, onde as previsões climáticas são exibidas. Nela, o usuário digita o CEP ou nome da cidade e o app faz a requisição à API para trazer os dados.
Variáveis
MainActivityLogin
•	editusuario: EditText para o nome de usuário.
•	editsenha: EditText para a senha.
•	btn_login: Botão de login.
MainActivity
•	editcep: EditText para o CEP ou cidade.
•	txt1, txt2, txt3, txt4: TextViews que mostram informações gerais sobre a cidade e o clima.
•	txt_temperatura: TextView que exibe a temperatura atual.
•	txt_previsao_semanal: TextView com um resumo das previsões.
•	txt_previsao_dia1, txt_max_temp_dia1, txt_min_temp_dia1: TextViews para o primeiro dia da previsão.
•	txt_previsao_dia2, txt_max_temp_dia2, txt_min_temp_dia2: TextViews para o segundo dia.
•	txt_previsao_dia3, txt_max_temp_dia3, txt_min_temp_dia3: TextViews para o terceiro dia.
________________________________________
API Utilizada
O app utiliza a WeatherAPI (https://www.weatherapi.com/) para buscar dados climáticos. A API oferece informações sobre o clima atual, previsão para os próximos dias, condições do tempo, entre outros.
A API responde com dados em formato JSON e requer uma chave de API para fazer as requisições. O app utiliza essa chave para buscar as previsões climáticas de 3 dias.
Exemplo de Requisição à API:
plaintext
Copiar código
https://api.weatherapi.com/v1/forecast.json?key=b2e45f29d2e5460cb19164741242911&q={localizacao}&days=3
Onde {localizacao} pode ser um nome de cidade ou um CEP. A resposta será um objeto JSON contendo as previsões.
________________________________________
Fluxo de Dados
1.	O usuário abre o app e é levado para a tela de login.
2.	O usuário insere as credenciais (nome de usuário e senha).
3.	Se as credenciais estiverem corretas, o app redireciona o usuário para a tela de previsões.
4.	Na tela de previsões, o usuário digita o CEP ou cidade e o app faz uma requisição à API para buscar as informações.
5.	O app processa os dados JSON recebidos da API e exibe as informações na tela de previsão climática.
________________________________________
Fluxo de Tela (UI)
