# 📦 ProductHub API

[![Java 21](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.1-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.8+-blue.svg)](https://maven.apache.org/)
[![Swagger](https://img.shields.io/badge/Swagger-OpenAPI%203-green.svg)](https://swagger.io/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

O **ProductHub API** é um microsserviço RESTful desenvolvido para o gerenciamento centralizado de catálogo de produtos. A aplicação foi construída com foco em boas práticas de arquitetura de código, utilizando o **Java 21** e **Spring Boot 4.1.1**, fornecendo uma interface simples, performática e bem documentada para operações essenciais de inventário.

---

## 🚀 Funcionalidades Principais

A API disponibiliza um CRUD completo para o ciclo de vida do produto:

* **➕ Cadastrar Produto (`POST`):** Permite a inclusão de novos produtos no catálogo com validação de campos.
* **📋 Listar Produtos com Paginação (`GET`):** Consulta otimizada da lista de produtos com suporte nativo a paginação (`page`, `size`) e ordenação (`sort`).
* **🔍 Buscar por ID (`GET`):** Recupeção detalhada de um produto específico através da sua chave primária.
* **✏️ Atualizar Produto (`PUT`):** Atualização completa dos dados de um produto existente.
* **🗑️ Deletar Produto (`DELETE`):** Remoção de produtos cadastrados da coleção em memória.

---

## 🛠️ Tecnologias Utilizadas

* **[Java 21](https://www.oracle.com/java/):** Versão LTS da linguagem, garantindo recursos modernos como *Record Types*, *Virtual Threads* e sintaxe enxuta.
* **[Spring Boot 4.1.1](https://spring.io/projects/spring-boot):** Framework base para ecossistema web, injeção de dependências e configuração do servidor.
* **[Lombok](https://projectlombok.org/):** Biblioteca para redução de código boilerplate (`@Data`, `@Builder`, `@AllArgsConstructor`, etc.).
* **[Springdoc OpenAPI / Swagger UI](https://springdoc.org/):** Gerador automático de documentação interativa para os endpoints REST.
* **[Apache Maven](https://maven.apache.org/):** Gerenciador de dependências e automação de build.

---

## 💻 Como Executar o Projeto

### Pré-requisitos

Antes de iniciar, certifique-se de ter instalado em sua máquina:

* **JDK 21** ou superior configurado nas variáveis de ambiente (`JAVA_HOME`).
* **Apache Maven 3.8+** (ou utilize o wrapper `./mvnw` incluso no projeto).
* Git para clonagem do repositório.

> ⚠️ **Nota sobre Persistência de Dados:**
> Este projeto **não utiliza um banco de dados externo ou relacional**. A camada de dados é mantida em uma **lista estática em memória** (`Thread-safe`). Dessa forma, todos os dados cadastrados ou alterados serão **resetados** ao reiniciar a aplicação ou reexecutar o build.

### Passo a Passo

1. **Clonar o repositório:**
   ```bash
   git clone https://github.com/iamytz/Fist-CRUD-API.git
   cd Fist-CRUD-API
   ```

2. **Compilar e baixar as dependências:**
   ```bash
   mvn clean package
   ```

3. **Executar a aplicação:**
   ```bash
   mvn spring-boot:run
   ```

Por padrão, o servidor iniciará na porta **8082**.

---

## 📑 Documentação da API (Swagger UI)

A API conta com documentação interativa via **Swagger UI / OpenAPI 3**, onde é possível testar os endpoints diretamente pelo navegador.

* **URL de Acesso Local:**  
  👉 [http://localhost:8082/swagger-ui/index.html](http://localhost:8082/swagger-ui/index.html)

### Resumo dos Endpoints

| Método | Endpoint | Descrição | Parâmetros Principais |
| :--- | :--- | :--- | :--- |
| `POST` | `/api/v1/produtos` | Cadastra um novo produto | Body JSON (`ProdutoDTO`) |
| `GET` | `/api/v1/produtos` | Lista produtos paginados | `page` (int), `size` (int), `sort` (string) |
| `GET` | `/api/v1/produtos/{id}` | Busca produto por ID | `id` (int) no path |
| `PUT` | `/api/v1/produtos/{id}` | Atualiza um produto por ID | `id` (int) no path e Body JSON |
| `DELETE` | `/api/v1/produtos/{id}` | Remove um produto por ID | `id` (int) no path |

---

## 📐 Estrutura do Modelo de Dados

A entidade `Produto` possui a seguinte estrutura básica de atributos:

| Campo | Tipo | Descrição | Exemplo |
| :--- | :--- | :--- | :--- |
| `id` | `Integer` | Identificador único (gerado automaticamente) | `1` |
| `nome` | `String` | Nome comercial do produto | `"Teclado Mecânico RGB"` |
| `preco` | `Float` | Valor unitário do produto | `299.90` |
| `quantidade` | `Integer` | Quantidade disponível em estoque | `50` |

### Exemplo de JSON (Request/Response)

```json
{
  "id": 1,
  "nome": "Teclado Mecânico RGB",
  "preco": 299.90,
  "quantidade": 50
}
```

---

## ✒️ Licença

Este projeto é um exemplo prático desenvolvido para fins de estudos e demonstração técnica. Sinta-se livre para utilizar, modificar e distribuir sob a licença [MIT](LICENSE).