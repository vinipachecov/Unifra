import numpy

def multiplicaVetorMatriz(vetor, matriz,tam):
        print("bla")

 def multiplicavetor(vetor1,vetor2):
     vecres = list()
     for a,b in zip(vetor1,vetor2):
         vecres.append(a*b)
     return vecres

def multiplicavetorOtimizado(vetor1,vetor2):
     return [a+b for a,b in zip(vetor1,vetor2)]



mat = numpy.matrix([[1,2],[3,4]])
vec = numpy.matrix([1,2])
multiplicaVetorMatriz(vec,mat,2)
