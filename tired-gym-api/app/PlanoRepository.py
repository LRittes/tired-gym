def dtNascValida(ano, mes, dia) -> bool:
    return dia.isnumeric() and mes.isnumeric() and ano.isnumeric() and int(dia) > 0 and int(dia) <= 31 and int(mes) > 0 and int(mes) <= 12 and len(ano) == 4


def isFloat(string) -> bool:
    try:
        numero = float(string)
        return True
    except ValueError:
        return False


def pegarDtVenc() -> str:
    print("Dia de vencimento:")
    dia = str(input())
    print("Mês de vencimento:")
    mes = str(input())
    print("ano de vencimento:")
    ano = str(input())

    while not dtNascValida(ano, mes, dia):
        print("\nData de nascimento inválida!")
        print("Dia de vencimento:")
        dia = str(input())
        print("Mês de vencimento:")
        mes = str(input())
        print("ano de vencimento:")
        ano = str(input())

    if int(dia) < 10:
        dia = f"0{dia}"
    if int(mes) < 10:
        mes = f"0{mes}"
    return f"{ano}-{mes}-{dia}"


def pegarCodPlan() -> str:
    cod = str(input())

    while cod.strip() == "":
        print("Código inválido!")
        print("Insira um código válido:")
        cod = str(input())

    return cod


def pegarCategoria() -> str:
    cat = str(input())

    while cat.strip() == "":
        print("Categoria inválido!")
        print("Insira uma categoria válido:")
        cat = str(input())

    return cat


def pegarPrecoAno() -> float:
    peso = str(input())

    while not isFloat(peso):
        print("Preço inválido!")
        print("Insira um preço válido:")
        peso = str(input())
    return float(peso)


def pegarPrecoMes() -> float:
    peso = str(input())

    while not isFloat(peso):
        print("Preço inválido!")
        print("Insira um preço válido:")
        peso = str(input())
    return float(peso)


def criaPlano() -> dict:
    print("Insira o código do plano:")
    cod = pegarCodPlan()

    print("Insira data de vencimento do plano")
    data = pegarDtVenc()

    print("Insira a categoria do plano:")
    cat = pegarCategoria()

    print("Insira o preço do mês desse plano:")
    pMes = pegarPrecoMes()

    print("Insira o preço do ano desse plano:")
    pAno = pegarPrecoAno()

    return {
        "cod_plan": cod,
        "dt_vencimento": data,
        "preco_ano": pMes,
        "preco_mes": pAno,
        "categoria": cat
    }
