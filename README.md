# NexusLegal

Plataforma integrada para escritórios que atuam com serviços jurídicos, contábeis e fiscais para empresas e pessoas físicas. O workspace reúne carteira de clientes, processos, obrigações, documentos, tarefas, auditoria e gestão de acessos.

Essa aplicação foi desenvolvida de forma didática para práticas de segurança. Teste educacional.

## Executar

Na raiz do projeto:

```bash
docker compose up --build
```

Endereços locais:

```text
Frontend: http://localhost:3005
API:      http://localhost:8085
Swagger:  http://localhost:8085/swagger-ui/index.html
```

Para reiniciar todos os dados:

```bash
docker compose down -v --remove-orphans
docker compose up --build
```

## Usuários

| Usuário | Senha | Perfil |
|---|---|---|
| partner | partner123 | Sócia administradora |
| lawyer | lawyer123 | Advogado |
| accountant | accountant123 | Contadora |
| assistant | assistant123 | Assistente |
| alfa_admin | alfa123 | Administradora da Alfa Engenharia |
| beta_viewer | beta123 | Leitura da Beta Foods |
| auditor | auditor123 | Auditoria |

A API usa Basic Auth. A aplicação web possui um seletor de usuário no menu lateral para alternar o contexto visual do workspace.

## Tela de login e análise de perfis

Ao abrir o frontend, a primeira tela é o login do workspace. O perfil pode ser selecionado em uma lista e a senha permanece visível no campo para facilitar a análise local dos fluxos de autenticação. O botão de entrada valida a credencial escolhida contra a API usando Basic Auth.

Depois do login, o painel mostra os módulos disponíveis para a identidade selecionada. A comparação entre os perfis permite verificar quais áreas, empresas e informações ficam acessíveis em cada contexto.

## DBeaver

O PostgreSQL está disponível apenas localmente:

| Campo | Valor |
|---|---|
| Driver | PostgreSQL |
| Host | `127.0.0.1` |
| Porta | `5433` |
| Database | `nexuslegal` |
| Usuário | `postgres` |
| Senha | `nexuslegal_postgres` |
| SSL | `disable` |

O papel operacional criado pelas migrations é `nexuslegal_app`, com senha `nexuslegal_app`.

## Módulos

- Visão geral do escritório.
- Empresas clientes e pessoas físicas.
- Processos e casos jurídicos.
- Obrigações contábeis, fiscais e de departamento pessoal.
- Central de documentos.
- Agenda, tarefas e prazos.
- Trilha de auditoria.
- Usuários, perfis, organizações e acessos.

## Rotas principais

```text
GET /api/dashboard
GET /api/companies
GET /api/companies/{id}
GET /api/matters
PUT /api/matters/{id}/status?value=ACTIVE
GET /api/obligations
GET /api/documents
POST /api/documents
GET /api/tasks
GET /api/audit
GET /api/search?q=Alfa
GET /v3/api-docs
```

Exemplo de documento:

```json
{
  "matterId": 1,
  "companyId": 1,
  "title": "Ata de reunião",
  "category": "Corporativo",
  "content": "Registro da reunião de acompanhamento."
}
```

## Estrutura

```text
backend/          Spring Boot, JDBC, Security e Flyway
frontend/         React, Vite e Nginx
notifications/    serviço HTTP auxiliar
docker-compose.yml
```

Os dados de inicialização criam empresas, clientes, processos, obrigações, documentos, tarefas e eventos de auditoria para que o painel possa ser explorado desde o primeiro acesso.
