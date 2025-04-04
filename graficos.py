import matplotlib.pyplot as plt
import numpy as np
import ast
import statistics


with open('resultados.txt', 'r') as arquivo:
    read_data = arquivo.readlines()

v100k = []
v200k = []
v400k = []
v800k = []
v1m6k = []

def criacao_listas():
    for i in range(len(read_data)):
        x = read_data[i][0:4]
        match x:
            case "100k":
                v100k.append(ast.literal_eval(read_data[i][4:]))
            case "200k":
                v200k.append(ast.literal_eval(read_data[i][4:]))
            case "400k":
                v400k.append(ast.literal_eval(read_data[i][4:]))
            case "800k":
                v800k.append(ast.literal_eval(read_data[i][4:]))
            case "16kk":
                v1m6k.append(ast.literal_eval(read_data[i][4:]))
            case _:
                pass

criacao_listas()

def criar_graficos(algoritmo):
    match algoritmo:
        case "insertionsort":
            data = [statistics.mean(v100k[1]), statistics.mean(v200k[1]), statistics.mean(v400k[1]), statistics.mean(v800k[1]), statistics.mean(v1m6k[1])]
            horizontal = ["100k", "200k", "400k", "800k", "1.6M"]
            xpoints = np.array(horizontal)
            ypoints = np.array(data)
            plt.plot(xpoints,ypoints)
            plt.show()
        case "selectionsort":
            data = [statistics.mean(v100k[0]), statistics.mean(v200k[0]), statistics.mean(v400k[0]), statistics.mean(v800k[0]), statistics.mean(v1m6k[0])]
            horizontal = ["100k", "200k", "400k", "800k", "1.6M"]
            xpoints = np.array(horizontal)
            ypoints = np.array(data)
            plt.plot(xpoints,ypoints)
            plt.show()
        case "bubblesort":
            data = [statistics.mean(v100k[2]), statistics.mean(v200k[2]), statistics.mean(v400k[2]), statistics.mean(v800k[2]), statistics.mean(v1m6k[2])]
            horizontal = ["100k", "200k", "400k", "800k", "1.6M"]
            xpoints = np.array(horizontal)
            ypoints = np.array(data)
            plt.plot(xpoints,ypoints)
            plt.show()
criar_graficos("selectionsort")
criar_graficos("insertionsort")
criar_graficos("bubblesort")
