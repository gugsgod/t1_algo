with open('resultados.txt', 'r') as arquivo:
    read_data = arquivo.readlines()

def criacao_listas():
    for i in range(len(read_data)):
        x = read_data[i][0:4]
        match x:
            case "100k":
                print("oi")
            case "200k":
                print("dois")
            case "400k":
                print("tres")
            case "800k":
                print("quatro")
            case "16kk":
                print("cinco")
            case _:
                pass
                

criacao_listas()





