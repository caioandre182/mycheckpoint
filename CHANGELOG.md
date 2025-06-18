# 📦 Changelog

## [v1.0.0] - 2025-06-17

### ✨ Features
- CRUD completo de Usuário (`POST`, `GET`, `PATCH`, `DELETE`)
- Login com geração de token JWT
- Atualização automática do campo `lastLogin` após login
- Documentação da API com Swagger habilitada

### 🔒 Segurança
- Proteção de todas as rotas com autenticação via token Bearer
- Liberação explícita dos endpoints públicos:
  - `POST /auth/login`
  - `POST /users`
