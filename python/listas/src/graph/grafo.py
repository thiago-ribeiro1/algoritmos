class Grafo:

    def __init__(self, numVertices):
        self.numVertices = numVertices
        self.adjacencyList = []

        for i in range(numVertices):
            self.adjacencyList.append([])


    def addEdge(self, v, w):
        self.adjacencyList[v].append(w)
        self.adjacencyList[w].append(v)


    def __str__(self):
        result = ''

        for i in range(self.numVertices):
            result += f'Vértice: {i}:\n'
            for j in self.adjacencyList[i]:
                result += f'-> {j}\n'
            result += '\n'

        return result


if __name__ == '__main__':
    grafo = Grafo(5)

    grafo.addEdge(0, 1)
    grafo.addEdge(0, 4)
    grafo.addEdge(1, 2)
    grafo.addEdge(1, 3)
    grafo.addEdge(1, 4)
    grafo.addEdge(2, 3)
    grafo.addEdge(3, 4)

    print(grafo)
