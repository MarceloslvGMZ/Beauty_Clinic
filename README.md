# 💄 API - Clínica Estética

---

## 📖 Sobre o Projeto

API REST desenvolvida para gerenciamento de uma clínica estética, permitindo controle completo de clientes, serviços e upload de imagens utilizando **AWS S3**.

---

## 🚀 Tecnologias Utilizadas

| Tecnologia | Descrição |
|---|---|
| ☕ Java 17+ | Linguagem principal |
| 🌱 Spring Boot | Framework base |
| 🗃️ Spring Data JPA | Persistência de dados |
| 🌐 Spring Web | Camada HTTP/REST |
| ✅ Spring Validation | Validação de dados |
| ☁️ AWS S3 | Armazenamento de imagens |
| 🗄️ MySQL / PostgreSQL | Banco de dados |
| 📦 Maven | Gerenciador de dependências |

---

## 📌 Funcionalidades

<details>
<summary>👤 Clientes</summary>

- ✅ Cadastro de clientes
- 📄 Listagem de clientes
- ✏️ Atualização de dados
- ❌ Remoção de clientes

</details>

<details>
<summary>💆 Serviços Estéticos</summary>

- ✅ Cadastro de serviços
- 📄 Listagem de serviços
- ✏️ Atualização de serviços
- ❌ Remoção de serviços

</details>

<details>
<summary>🖼️ Upload de Imagens</summary>

- ☁️ Upload de imagens
- 🗂️ Armazenamento na AWS S3
- 🔗 Retorno da URL pública

</details>

---

## 🏗️ Arquitetura do Projeto

```
src/main/java/com/clinicaestetica
│
├── 📁 controller     # REST Controllers
├── 📁 service        # Regras de negócio
├── 📁 repository     # Persistência de dados
├── 📁 model          # Entidades
├── 📁 dto            # Transferência de dados
├── 📁 config         # Configurações (AWS, CORS)
└── 📁 exception      # Tratamento de erros
```

---

## ☁️ Integração com AWS S3

### 🔐 Configuração

Adicione as seguintes variáveis no seu `application.properties`:

```properties
aws.accessKey=SEU_ACCESS_KEY
aws.secretKey=SEU_SECRET_KEY
aws.region=us-east-1
aws.bucket-name=nome-do-bucket
```

> ⚠️ **Atenção:** Nunca versione suas credenciais. Use variáveis de ambiente ou AWS IAM Roles em produção.

---

## 📡 Endpoints da API

### 👤 Clientes

| Método | Endpoint | Descrição |
|---|---|---|
| 🟢 `POST` | `/clientes` | Criar cliente |
| 🔵 `GET` | `/clientes` | Listar clientes |
| 🟡 `PUT` | `/clientes/{id}` | Atualizar cliente |
| 🔴 `DELETE` | `/clientes/{id}` | Remover cliente |

### 💆 Serviços

| Método | Endpoint | Descrição |
|---|---|---|
| 🟢 `POST` | `/servicos` | Criar serviço |
| 🔵 `GET` | `/servicos` | Listar serviços |
| 🟡 `PUT` | `/servicos/{id}` | Atualizar serviço |
| 🔴 `DELETE` | `/servicos/{id}` | Remover serviço |

### 🖼️ Upload de Imagem

| Método | Endpoint | Descrição |
|---|---|---|
| 🟢 `POST` | `/servicos/{id}/imagem` | Upload de imagem |

#### 📌 Exemplo de requisição:

```bash
curl -X POST \
  http://localhost:8080/servicos/1/imagem \
  -H "Content-Type: multipart/form-data" \
  -F "file=@imagem.jpg"
```

#### 📄 Exemplo de resposta:

```json
{
  "id": 1,
  "nome": "Limpeza de Pele",
  "descricao": "Procedimento estético facial",
  "preco": 120.0,
  "imagemUrl": "https://bucket.s3.amazonaws.com/imagem.jpg"
}
```

---

## ⚠️ Tratamento de Erros

Erros são retornados no seguinte formato padronizado:

```json
{
  "timestamp": "2026-03-19T12:00:00",
  "status": 404,
  "error": "Recurso não encontrado",
  "message": "Serviço não encontrado",
  "path": "/servicos/99"
}
```

---

## ⚙️ Como Executar o Projeto

### 🔧 Pré-requisitos

- ☕ Java 17+
- 📦 Maven
- ☁️ Conta AWS com bucket S3 configurado
- 🗄️ Banco de dados MySQL ou PostgreSQL

### ▶️ Passo a passo

```bash
# Clonar repositório
git clone https://github.com/seu-usuario/seu-repo.git

# Entrar na pasta
cd seu-repo

# Rodar aplicação
mvn spring-boot:run
```

🌐 Acesse: `http://localhost:8080`

---

## 🧪 Testes

Você pode testar os endpoints com:

| Ferramenta | Tipo |
|---|---|
| 📮 Postman | GUI |
| ⚡ Insomnia | GUI |
| 💻 cURL | Terminal |

---

## 🔮 Melhorias Futuras

- [ ] 🔐 Autenticação com JWT
- [ ] 📅 Sistema de agendamentos
- [ ] 📊 Painel administrativo
- [ ] 🖼️ Upload múltiplo de imagens
- [ ] ☁️ Deploy na AWS (EC2 + RDS)

---

## 👨‍💻 Autor

**Marcelo Gomes**
🚀 Backend Developer | Java | Cibersegurança

---

## ⭐ Objetivo

Este projeto foi criado para:

- 📚 Praticar Spring Boot
- ☁️ Trabalhar com AWS S3
- 💼 Construir portfólio profissional
