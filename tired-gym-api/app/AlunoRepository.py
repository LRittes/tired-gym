import Conexao
import time
import random
import string


def gerar_string(tamanho):
    letras = string.ascii_letters + string.digits
    return ''.join(random.choice(letras) for _ in range(tamanho))


def pegarPrimeiraChaveDici(di: dict):
    w = 0
    for i in di.keys():
        if w == 0:
            return i


def checkTel(telefone) -> bool:
    telSplited = telefone.split(" ")
    telSplited = "".join(telSplited)
    sizeTel = 0
    for s in telSplited:
        if (not s.isdigit()):
            return False
        sizeTel += len(s)
    if sizeTel < 11 or sizeTel > 11:
        return False
    return True


def dtNascValida(ano, mes, dia) -> bool:
    return dia.isnumeric() and mes.isnumeric() and ano.isnumeric() and int(dia) > 0 and int(dia) <= 31 and int(mes) > 0 and int(mes) <= 12 and len(ano) == 4


def isFloat(string) -> bool:
    try:
        numero = float(string)
        return True
    except ValueError:
        return False


def pegarNome() -> str:
    nome = str(input().strip())
    while len(nome) == 0 or nome.isspace():
        print("Nome invalido")
        print("Insira o nome:")
        nome = str(input())
    return nome


def pegarCPF() -> str:
    cpf = str(input().strip())
    while len(cpf) < 11 or len(cpf) > 11 or not cpf.isdigit():
        print("CPF invalido!")
        print("Insira o CPF:")
        cpf = str(input().strip())
    return cpf


def escaneandoDigital() -> str:
    print("Lendo a digital do aluno...")
    time.sleep(1)  # Espera por 1 segundo
    digital = gerar_string(30)
    print(f"Código gerado da digital: {digital}")
    return digital


def pegarTelefone() -> str:
    tel = str(input().strip())
    while not checkTel(tel):
        print("Telefone invalido!")
        print("Insira o telefone:")
        tel = str(input().strip())
    return tel


def pegarDtNasc() -> str:
    print("Dia de nascimento:")
    dia = str(input())
    print("Mês de nascimento:")
    mes = str(input())
    print("ano de nascimento:")
    ano = str(input())

    while not dtNascValida(ano, mes, dia):
        print("\nData de nascimento inválida!")
        print("Dia de nascimento:")
        dia = str(input())
        print("Mês de nascimento:")
        mes = str(input())
        print("ano de nascimento:")
        ano = str(input())

    if int(dia) < 10:
        dia = f"0{dia}"
    if int(mes) < 10:
        mes = f"0{mes}"
    return f"{ano}-{mes}-{dia}"


def pegarCodPlan(cods: list) -> str | None:
    for c in range(0, len(cods)):
        print(f"{c + 1} - {cods[c]['categoria']}")
    print(f"{len(cods) + 1} - Nenhum")
    cod = str(input())

    while not str(cod).isnumeric():
        print("Código do plano inválido!")
        print("Insira o código do plano:")
        cod = int(input())

    cod = int(cod)

    if cod == len(cods) + 1:
        return None

    while cod < 1 or cod > len(cods):
        print("Código do plano inválido!")
        print("Insira o código do plano:")
        cod = int(input())
        while not str(cod).isnumeric():
            print("Código do plano inválido!")
            print("Insira o código do plano:")
            cod = int(input())
        if cod == len(cods) + 1:
            return None

    return cods[cod-1]["cod_plan"]


def pegarSexo() -> str:
    print("F - feminino")
    print("M - masculino")
    sexo = str(input())

    while sexo not in "FfMm" or len(sexo) > 1 or sexo.strip() == "":
        print("Sexo inválido!")
        print("Insira o sexo:")
        sexo = str(input())

    return sexo


def pegarFoto() -> str:
    print("Lendo a foto do aluno...")
    time.sleep(1)  # Espera por 1 segundo
    foto = gerar_string(30)
    print(f"Código gerado da foto: {foto}")
    return foto


def pegarPeso() -> float:
    peso = str(input())

    while not isFloat(peso):
        print("Peso inválido!")
        print("Insira o peso:")
        peso = str(input())
    return float(peso)


def pegarAltura() -> float:
    altura = str(input())

    while not isFloat(altura):
        print("Peso inválido!")
        print("Insira o peso:")
        altura = str(input())
    return float(altura)


def pegarEmail():
    email = str(input())

    while not "@" in email:
        print("Email inválido!")
        print("Insira um email válido:")
        email = str(input())

    return email


def criarListaEmails(cpf) -> list:
    emails = []
    email = pegarEmail()
    emails.append({"cpf": cpf, "email": email})
    resp = 0
    while resp != 2:
        print("Deseja inserir mais 1 email?")
        print("1 - sim")
        print("2 - não")
        resp = int(input())
        if resp == 1:
            print("Insira o email:")
            email = pegarEmail()
            emails.append({"cpf": cpf, "email": email})
        else:
            resp = 2
    return emails


def pegarEndereco() -> dict:
    print("Rua:")
    rua = str(input())
    print("Bairro:")
    bairro = str(input())
    print("Numero:")
    nro = int(input())
    print("Cidade:")
    cidade = str(input())
    print("UF:")
    uf = str(input())
    return {"rua": rua, "bairro": bairro,
            "numero": nro, "cidade": cidade, "uf": uf}


def criarListaEnderecos() -> list:
    enderecos = []
    endereco = pegarEndereco()
    enderecos.append(endereco)

    resp = 0
    while resp != 2:
        print("Deseja inserir mais 1 endereço?")
        print("1 - sim")
        print("2 - não")
        resp = int(input())
        if resp == 1:
            print("Insira o endereço:")
            endereco = pegarEndereco()
            enderecos.append(endereco)
        else:
            resp = 2

        return enderecos


def cadastrarAluno(cods: list) -> dict:
    print("Insira o nome:")
    nome = pegarNome()

    print("Insira o CPF:")
    cpf = pegarCPF()

    digital = escaneandoDigital()

    print("Insira o telefone:")
    tel = pegarTelefone()

    print("Data de nascimento:")
    dt_nascimento = pegarDtNasc()

    print("Insira o código do plano:")
    cod = pegarCodPlan(cods)

    print("Insira o sexo:")
    sexo = pegarSexo()

    foto = pegarFoto()

    print("Insira um email:")
    emails = criarListaEmails(cpf)

    print("Insira um endereço:")
    enderecos = criarListaEnderecos()

    print("Insira o peso:")
    peso = pegarPeso()

    print("Insira a altura:")
    altura = pegarAltura()

    return {
        "cpf": cpf,
        "nome": nome,
        "digital": digital,
        "telefone": tel,
        "sexo": sexo,
        "foto": foto,
        "emails": emails,
        "enderecos": enderecos,
        "cod_plan": cod,
        "dt_nascimento": dt_nascimento,
        "altura": altura,
        "peso": peso
    }
