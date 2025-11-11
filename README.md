# devops-atividade-5

## Como Rodar
### Usando Docker

1. Rodar o PostgreSQL
```
docker run -d --name todo-postgres -e POSTGRES_DB=todo -e POSTGRES_USER=user -e POSTGRES_PASSWORD=password -p 5432:5432 postgres:latest
```
2. Rodar o backend
```
docker run -d --name todo-backend -p 8080:8080 -e SPRING_DATASOURCE_URL=jdbc:postgresql://todo-postgres:5432/todo -e SPRING_DATASOURCE_USERNAME=user -e SPRING_DATASOURCE_PASSWORD=password gabrielavelarbr/devops-atividade-5:latest
```
## Usando Kubernetes (Kind)

1. Clonar o repositório
```
git clone https://github.com/gabrielvavelar/devops-atividade-5.git
cd devops-atividade-5
```
2. Criar o cluster Kind
```
kind create cluster
```
3. Aplicar o deployment
```
kubectl apply -f deploy.yaml
```
4. Acessar o backend localmente
```
kubectl port-forward service/todo-backend-service 8080:8080
```
## Exemplo de Requsição 
POST
```
http://localhost:8080/todo
```
```json
{
  "description": "Realizar tarefa",
  "completed": false
}
```
GET
```
http://localhost:8080/todo
```

