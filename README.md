💄 API - Clínica Estética








📖 Sobre o Projeto

API REST desenvolvida para gerenciamento de uma clínica estética, permitindo controle completo de clientes, serviços e upload de imagens utilizando AWS S3.

🚀 Tecnologias Utilizadas

✔️ Java 17+
✔️ Spring Boot
✔️ Spring Data JPA
✔️ Spring Web
✔️ Spring Validation
✔️ AWS S3
✔️ MySQL / PostgreSQL
✔️ Maven

📌 Funcionalidades
👤 Clientes

✅ Cadastro de clientes

📄 Listagem de clientes

✏️ Atualização de dados

❌ Remoção de clientes

💆 Serviços Estéticos

✅ Cadastro de serviços

📄 Listagem de serviços

✏️ Atualização de serviços

❌ Remoção de serviços

🖼️ Upload de Imagens

☁️ Upload de imagens

🗂️ Armazenamento na AWS S3

🔗 Retorno da URL pública

🏗️ Arquitetura do Projeto
src/main/java/com/clinicaestetica
│
├── 📁 controller     # REST Controllers
├── 📁 service        # Regras de negócio
├── 📁 repository     # Persistência de dados
├── 📁 model          # Entidades
├── 📁 dto            # Transferência de dados
├── 📁 config         # Configurações (AWS, CORS)
└── 📁 exception      # Tratamento de erros
☁️ Integração com AWS S3
🔐 Configuração
aws.accessKey=SEU_ACCESS_KEY
aws.secretKey=SEU_SECRET_KEY
aws.region=us-east-1
aws.bucket-name=nome-do-bucket
📡 Endpoints da API
👤 Clientes
Método	Endpoint	Descrição
🟢 POST	/clientes	Criar cliente
🔵 GET	/clientes	Listar clientes
🟡 PUT	/clientes/{id}	Atualizar cliente
🔴 DELETE	/clientes/{id}	Remover cliente
💆 Serviços
Método	Endpoint	Descrição
🟢 POST	/servicos	Criar serviço
🔵 GET	/servicos	Listar serviços
🟡 PUT	/servicos/{id}	Atualizar serviço
🔴 DELETE	/servicos/{id}	Remover serviço
🖼️ Upload de Imagem
Método	Endpoint	Descrição
🟢 POST	/servicos/{id}/imagem	Upload de imagem

📌 Exemplo de requisição:

curl -X POST \
  http://localhost:8080/servicos/1/imagem \
  -H "Content-Type: multipart/form-data" \
  -F "file=@imagem.jpg"
⚙️ Como Executar o Projeto
🔧 Pré-requisitos

☕ Java 17+

📦 Maven

☁️ Conta AWS

🗄️ Banco de dados

▶️ Passo a passo
# Clonar repositório
git clone https://github.com/seu-usuario/seu-repo.git

# Entrar na pasta
cd seu-repo

# Rodar aplicação
mvn spring-boot:run

🌐 Acesse:

http://localhost:8080
🧪 Testes

Você pode testar com:

📮 Postman

⚡ Insomnia

💻 cURL

📄 Exemplo de Resposta
{
  "id": 1,
  "nome": "Limpeza de Pele",
  "descricao": "Procedimento estético facial",
  "preco": 120.0,
  "imagemUrl": "https://bucket.s3.amazonaws.com/imagem.jpg"
}
⚠️ Tratamento de Erros
{
  "timestamp": "2026-03-19T12:00:00",
  "status": 404,
  "error": "Recurso não encontrado",
  "message": "Serviço não encontrado",
  "path": "/servicos/99"
}
🔮 Melhorias Futuras

🔐 Autenticação com JWT

📅 Sistema de agendamentos

📊 Painel administrativo

🖼️ Upload múltiplo

☁️ Deploy na AWS (EC2 + RDS)

👨‍💻 Autor

Marcelo Gomes
🚀 Backend Developer | Java | Cibersegurança

⭐ Objetivo

Este projeto foi criado para:

📚 Praticar Spring Boot

☁️ Trabalhar com AWS S3

💼 Construir portfólio profissional
