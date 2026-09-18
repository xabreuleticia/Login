# 🔐 LoginPUC

Sistema completo de autenticação e cadastro de usuários desenvolvido com **Spring Boot** e **Thymeleaf**, como parte da Atividade 02 da disciplina de Desenvolvimento e Integração de Aplicações Web — PUC.

Este projeto implementa uma aplicação web com telas de login, registro e recuperação de senha, com interface visual própria e mecanismos seguros de autenticação.

---

## 🎯 Objetivo

Praticar e demonstrar conceitos de:

- ☕ Spring Boot
- 🎨 Thymeleaf
- 🔐 Autenticação de usuários
- 👤 Cadastro de usuários
- 🌐 Endpoints HTTP e Controllers
- 🔑 Criptografia e segurança de senhas
- 📧 Integração com serviços externos de e-mail (recuperação de senha)

---

## 🚀 Funcionalidades

- ✅ Tela de login (`/login`) com validação de credenciais
- ✅ Tela de cadastro de novos usuários (`/register`)
- ✅ Validações de formulário (campos obrigatórios, e-mail inválido, senhas incompatíveis, usuários duplicados)
- ✅ Armazenamento seguro de senhas (hash/criptografia)
- ✅ Controle de sessão e logout
- ✅ Proteção de rotas para usuários não autenticados
- 🏆 *(Opcional)* Recuperação de senha via e-mail (`/recoverpassword`)
- 📱 Layout responsivo

---

## 🛠️ Tecnologias utilizadas

- **Java**
- **Spring Boot** [versão]
- **Spring Security** — autenticação e autorização
- **Thymeleaf** — renderização de páginas HTML no backend
- **Spring Data JPA** — persistência de dados
- **[Banco de dados]** — ex: H2, MySQL ou PostgreSQL
- **Maven** — gerenciamento de dependências e build
- **[Biblioteca de envio de e-mail, se aplicável]** — ex: Spring Mail / JavaMailSender
- **HTML5, CSS3, JavaScript** — interface visual

---

## 🌐 Endpoints

| Método | Endpoint            | Descrição                                      |
|--------|----------------------|-------------------------------------------------|
| GET    | `/login`             | Exibe a tela de login                          |
| GET    | `/register`          | Exibe a tela de cadastro                       |
| POST   | `/register`          | Processa os dados do cadastro                  |
| GET    | `/recoverpassword`   | Exibe a tela de recuperação de senha           |
| POST   | `/recoverpassword`   | Processa a solicitação de recuperação de senha |

> O endpoint `POST /login` é gerenciado automaticamente pelo Spring Security.

---

## 📁 Estrutura do projeto

```
src/
└── main/
    ├── java/
    │   └── com/puc/loginpuc/
    │       ├── application/       # Regras de negócio / services
    │       ├── controller/        # Controllers (endpoints)
    │       ├── config/            # Configurações (Spring Security, etc.)
    │       ├── model/             # Entidades JPA
    │       └── repository/        # Repositórios de dados
    │
    └── resources/
        ├── static/
        │   ├── css/
        │   ├── images/
        │   └── videos/
        │
        ├── templates/
        │   ├── login.html
        │   ├── register.html
        │   └── recoverpassword.html
        │
        └── application.properties
```

---

## ⚙️ Pré-requisitos

Antes de rodar o projeto, certifique-se de ter instalado:

- [Java JDK 17+](https://adoptium.net/)
- [Apache Maven 3.9+](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/)
- [Banco de dados, se aplicável — ex: MySQL 8+]

---

## ▶️ Como executar o projeto

1. **Clone o repositório**
   ```bash
   git clone https://github.com/[seu-usuario]/LoginPUC.git
   cd LoginPUC
   ```

2. **Configure as variáveis de ambiente / credenciais**

   Copie o arquivo de exemplo e preencha com suas credenciais:
   ```bash
   cp src/main/resources/application.properties.example src/main/resources/application.properties
   ```

   Edite o arquivo `application.properties` com as configurações do seu ambiente (banco de dados, e-mail, etc.) — veja a seção [Configuração e credenciais](#-configuração-e-credenciais).

3. **Compile o projeto**
   ```bash
   mvn clean install
   ```

4. **Execute a aplicação**
   ```bash
   mvn spring-boot:run
   ```

5. **Acesse no navegador**
   ```
   http://localhost:8080/login
   ```

---

## 🔑 Configuração e credenciais

Este projeto utiliza credenciais externas que **não devem ser publicadas no repositório**. Configure-as via `application.properties` local (não versionado) ou variáveis de ambiente.

Exemplo de `application.properties`:

```properties
# Banco de dados
spring.datasource.url=jdbc:mysql://localhost:3306/loginpuc
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

# Envio de e-mail (recuperação de senha)
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=${EMAIL_USERNAME}
spring.mail.password=${EMAIL_PASSWORD}
```

> ⚠️ **Nunca** faça commit de senhas, tokens ou chaves de API reais. Utilize variáveis de ambiente ou um arquivo `.env` incluído no `.gitignore`.

---

## 🧪 Rodando os testes

```bash
mvn test
```

---

## 👥 Equipe

| Nome              | GitHub                                    |
|-------------------|--------------------------------------------|
| [Integrante 1]    | [@usuario1](https://github.com/usuario1)   |
| [Integrante 2]    | [@usuario2](https://github.com/usuario2)   |

---

## 📚 Projetos de referência

Este projeto foi desenvolvido com base nos seguintes materiais de estudo da disciplina:

- [SecureLoginPUC](https://github.com/)
- [SecureLoginPUC_2](https://github.com/)
- [SendEmail — exemplo de envio de e-mails](https://github.com/)

---

## 📄 Licença

Este projeto foi desenvolvido para fins acadêmicos, como parte da disciplina [nome da disciplina] da PUC.
