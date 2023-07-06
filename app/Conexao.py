
import requests

# URL da API
urlBase = "http://localhost:8080"


def cadastrarAluno(aluno: dict):
    # Envia a requisição POST
    response = requests.post(f"{urlBase}/aluno", json=aluno)

    # Verifica o código de status da resposta
    if response.status_code == 200 or response.status_code == 201:
        # Requisição bem-sucedida
        print("Aluno cadastrado com sucesso!")
    elif response.status_code == 406:
        print("Erro! Aluno já cadastrado!")
    else:
        # Requisição com erro
        print("Erro ao cadastrar o aluno!")


def pegarTodosAlunos() -> list:
    # Envia a requisição POST
    response = requests.get(f"{urlBase}/aluno")

 # Verifica o código de status da resposta
    if response.status_code == 200 or response.status_code == 201:
        # Requisição bem-sucedida
        return response.json()
    else:
        # Requisição com erro
        print("Erro ao Pegar os aluno!")
        return []


def cadastrarPlano(plano: dict):
    # Envia a requisição POST
    response = requests.post(f"{urlBase}/plano", json=plano)

    # Verifica o código de status da resposta
    if response.status_code == 200 or response.status_code == 201:
        # Requisição bem-sucedida
        print("Plano cadastrado com sucesso!")
    elif response.status_code == 406:
        print("Erro! Plano já cadastrado!")
    else:
        # Requisição com erro
        print("Erro ao cadastrar o plano!")


def pegarTodosPlanos() -> list:
    response = requests.get(f"{urlBase}/plano")

 # Verifica o código de status da resposta
    if response.status_code == 200 or response.status_code == 201:
        # Requisição bem-sucedida
        return response.json()
    else:
        # Requisição com erro
        print("Erro ao Pegar os aluno!")
        return []


def pegarTodosAlunosPorCategoria(categoria):
    response = requests.get(f"{urlBase}/aluno/{categoria}")

 # Verifica o código de status da resposta
    if response.status_code == 200 or response.status_code == 201:
        # Requisição bem-sucedida
        return response.json()
    else:
        # Requisição com erro
        print("Erro ao Pegar os aluno!")
        return []
