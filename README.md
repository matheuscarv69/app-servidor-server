# 💻 App Servidor 📝

Esta é a uma API Restful de envios e busca de formulários. 
 
[![GitHub stars](https://img.shields.io/github/stars/matheuscarv69/app-servidor-server?color=7159)](https://github.com/matheuscarv69/app-servidor-server/stargazers)
![badges](https://img.shields.io/github/issues/matheuscarv69/app-servidor-server)
![Maven Central with version prefix filter](https://img.shields.io/maven-central/v/org.apache.maven/apache-maven/3.6.3?color=7159)
![GitHub](https://img.shields.io/github/license/matheuscarv69/app-servidor-server?color=1)

## 🤔 O que é o App Servidor ?
Visando auxiliar os cursos de Educação física, Enfermagem e Biomedicina que diariamente realizam o atendimento de muitas pessoas, dessa maneira preenchendo inúmeros documentos e formulários referentes aos seus pacientes, foi feito o desenvolvimento de uma API que é responsável pelo recebimento e envio de formulários dos cursos citados, para facilitar o processo de entrevista dos pacientes, assim tornando menos burocrático o procedimento de consultas.

## 🔧 Pré-Requisitos 

Antes de começar você precisa ter instalado em sua máquina as seguintes ferramentas:

- [Java JDK 8](https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html)
- [Maven 3.6.3](https://maven.apache.org/download.cgi)
- [Postgres 13](https://www.postgresql.org/download/)

## 🎲 Executando o servidor - JAR 
```bash
# Clone este repositório
$ git clone <https://github.com/matheuscarv69/app-servidor-server>

# Acesse a pasta do projeto no terminal/cmd
$ cd app-servidor-server

# Faça o build da aplicação
$ mvn clean package -P dev

# Acesse a pasta target
# cd target

# Execute a aplicação em modo de desenvolvimento
$ java -jar api-app-servidor-1.0-SNAPSHOT.jar

# O servidor iniciará na porta 8080
# Acesse - http://localhost:8080/swagger-ui.html
```

## ⚙ Fazendo o Deploy do servidor - WAR
```bash
# Dentro da raiz do projeto

# Faça o build da aplicação
$ mvn clean package -P build
```
## 📖 Documentação
O projeto foi documentado utilizando a ferramenta Swagger, para acessa-la entre no endereço:

Caso esteja executando o servidor localmente, acesse:
```bash
http://localhost:8080/swagger-ui.html
```
Caso esteja executando o servidor em uma VPS, acesse:
```bash
http://ip-da-vps:8080/swagger-ui.html
```
![Swagger-home](https://i.imgur.com/JeMIlco.png)
Temos dois métodos no controller do Formulário Social: Salvar e Buscar formulários.

### 💾 Salvar
Esse método recebe um arquivo .JSON com os dados do formulário preenchido e salva na base de dados.

Você pode testar a API usando o [Insomnia](https://insomnia.rest/download/) e importando este [arquivo](https://liveestacio-my.sharepoint.com/:u:/g/personal/201901296441_alunos_estacio_br/EXIoVQGF7qhBsoMbixEnlj4BQFzqjX6NJjmUxHSXE8BBSA?e=eK3jaj), ou pode usar o próprio Swagger clicando em Try it Out e preenchendo os dados.

Neste [arquivo](https://liveestacio-my.sharepoint.com/:x:/g/personal/201901296441_alunos_estacio_br/ETja0J4yZqdDiXzl0bvakHoB9PGyl9Pnh1NrDXd-aHd25A?e=hfLNPg) é possível visualizar todos os ID's referentes às propriedades para realizar a inserção de forma correta. 

![Swagger-saveform](https://i.imgur.com/Jl591mr.png)
### Insomnia
![save-insomnia](https://i.imgur.com/zMceHt8.png)
### 🔎 Buscar
Consiste basicamente em fazer mandar um requisição do tipo GET para o mesmo end-point: /api/formsocial.

![get-Insomnia](https://i.imgur.com/qLWHyTg.png)

## 🛠 Tecnologias
As seguintes tecnologias foram utilizadas no desenvolvimento do projeto:
- [Java JDK 8](https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html)
- [Spring Boot 2.2.4](https://spring.io/)
   - spring-boot-starter
   - spring-boot-starter-web
   - spring-boot-starter-data-jpa
   - Spring-boot-starter-jdbc
- [Postgres 13](https://www.postgresql.org/download/)
- [Tomcat](http://tomcat.apache.org/) (Embutido no Spring Boot na versão JAR)
- [Swagger](https://swagger.io/)

## 📱 Versão mobile

🚧 Em construção... 🚧

>Repositório:<a href="https://github.com/douglasgomes98/app-servidor-mobile"> app-servidor-mobile</a>

### 👥 Contribuidores
---
<table>
  <tr>
    <td align="center">
    <a href="https://github.com/douglasgomes98"><img style="border-radius: 50%;" src="https://avatars0.githubusercontent.com/u/47008462?s=460&u=b2eb1ac84e8b28f9bba4fede5be97d9ca6478678&v=4" width="100px;" alt=""/><br /><sub><b>Douglas Gomes</b></sub></a><br /><a href="https://github.com/douglasgomes98" title="Douglas">👨‍🚀</a>
    </td>
  </tr>
</table>

### 👨🏻‍💻 Autor
---

<a href="https://github.com/matheuscarv69">
 <img style="border-radius: 50%;" src="https://avatars1.githubusercontent.com/u/55814214?s=460&u=ffb1e928527a55f53df6e0d323c2fd7ba92fe0c3&v=4" width="100px;" alt=""/>
 <br />
 <sub><b>Matheus Carvalho</b></sub></a> <a href="https://github.com/matheuscarv69" title="Matheus Carvalho">🚀</a>


Feito por Matheus Carvalho, entre em contato!✌🏻

[![Linkedin Badge](https://img.shields.io/badge/-Matheus_Carvalho-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https:https://www.linkedin.com/in/matheus-carvalho69//)](https://www.linkedin.com/in/matheus-carvalho69/)
[![Gmail Badge](https://img.shields.io/badge/-matheus9126@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:matheus9126@gmail.com)](mailto:matheus9126@gmail.com)

## 📝 Licença

Este projeto esta sob a licença MIT.
