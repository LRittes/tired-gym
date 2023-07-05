import Conexao
from AlunoRepository import cadastrarAluno
from PlanoRepository import criaPlano


def printTabela(header: list, body: list):
    colunasTam = list(body[0].keys())

    tamanhos_colunas = [max(len(str(dado[coluna]))
                            for dado in body) for coluna in colunasTam]

  # Atualizar tamanhos das colunas com base no tamanho do nome da coluna
    tamanhos_colunas = [max(tamanho, len(coluna))
                        for tamanho, coluna in zip(tamanhos_colunas, header)]

    # Imprimir cabeçalho da tabela
    for coluna, tamanho in zip(header, tamanhos_colunas):
        print(f"{coluna:{tamanho}s}", end="  ")
    print()

    # Imprimir linhas da tabela
    for dado in body:
        for coluna, tamanho in zip(colunasTam, tamanhos_colunas):
            print(f"{str(dado[coluna]):{tamanho}s}", end="  ")
        print()


def painel():
    print("1 - inserir um aluno")
    print("2 - inserir um plano")
    print("3 - mostrar todos os alunos")
    print("4 - mostrar todos os plano")
    print("5 - mostrar todos os alunos em um plano")
    print("6 - sair")


painel()

opcao = int(input())
while opcao != 6:
    print("-"*120)
    if opcao == 1:
        Conexao.cadastrarAluno(cadastrarAluno(Conexao.pegarTodosPlanos()))
    elif opcao == 2:
        Conexao.cadastrarPlano(criaPlano())
    elif opcao == 3:
        colunas = ["CPF", "NOME", "DIGITAL", "TELEFONE", "SEXO", "FOTO", "DATA DE NASCIMENTO", "PLANO",
                   "ALTURA", "PESO"]
        printTabela(colunas, Conexao.pegarTodosAlunos())
    elif opcao == 4:
        colunas = ["CÓDIGO PLANO", "DATA DE VENCIMENTO",
                   "PREÇO ANO", "PREÇO MÊS", "CATEGORIA"]
        printTabela(colunas, Conexao.pegarTodosPlanos())
    elif opcao == 5:
        print("Alunos de qual categoria:")
        cods = Conexao.pegarTodosPlanos()
        for c in range(0, len(cods)):
            print(f"{c + 1} - {cods[c]['categoria']}")
        print(f"{len(cods) + 1} - Nenhum")
        catIdx = int(input())
        if (catIdx == len(cods) + 1):
            pass
        else:
            colunas = ["CPF", "NOME", "DIGITAL", "TELEFONE", "SEXO", "FOTO", "DATA DE NASCIMENTO", "PLANO",
                       "ALTURA", "PESO"]

            printTabela(colunas, Conexao.pegarTodosAlunosPorCategoria(
                cods[catIdx - 1]["categoria"]))
    print("-"*120)
    painel()
    opcao = int(input())
