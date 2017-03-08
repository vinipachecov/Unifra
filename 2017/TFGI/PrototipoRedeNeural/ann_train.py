#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Thu Mar  2 18:16:47 2017

@author: root
"""

import numpy as np
import matplotlib.pyplot as plt

from sklearn.utils import shuffle
from process_data import get_data


def y2indicator(y, K):
    N = len(y)
    ind = np.zeros((N, K))
    for i in xrange(N):
        ind[i, y[i]] = 1
    return ind

#Predicao
def softmax(a):
    expA = np.exp(a)
    return expA / expA.sum(axis=1, keepdims=True)

#Forward propagation nos permite chegar nos resultos que nos levam
#para a probabilidade nas previsoes
def forward(X, W1, b1, W2, b2):
    Z = np.tanh(X.dot(W1) + b1)
    return softmax(Z.dot(W2) + b2), Z

#Funcao para previsao
def predict(P_Y_given_X):
    return np.argmax(P_Y_given_X, axis=1)

# calcula a acuracia
def classification_rate(Y, P):
    return np.mean(Y == P)

#funcao de custo somatorio de media(T * log(pY))
def cross_entropy(T, pY):
    return -np.mean(T*np.log(pY))



##Setup data
X , Y = get_data()
X,  Y = shuffle(X, Y)
Y = Y.astype(np.int32)
M = 5
D = X.shape[1]
K = len(set(Y))

##Sets de treino e de teste

Xtrain= X[:-39]
Ytrain = Y[:-39]
Ytrain_ind = y2indicator(Ytrain, K)

Xtest= X[60:]
Ytest = Y[60: ]
Ytest_ind = y2indicator(Ytest, K)


##Pesos aleatorios iniciais
W1 = np.random.randn(D, M)
b1 = np.zeros(M)
W2 = np.random.randn(M,K)
b2 = np.zeros(K)



#Loop de treino

train_costs = []
test_costs = []
learning_rate = 0.001
for i in xrange(10000):
    pYtrain, Ztrain = forward(Xtrain, W1, b1, W2, b2)
    pYtest, Ztest = forward(Xtest, W1, b1, W2, b2)

    ctrain = cross_entropy(Ytrain_ind, pYtrain)
    ctest = cross_entropy(Ytest_ind, pYtest)
    train_costs.append(ctrain)
    test_costs.append(ctest)

    # gradient descent
    W2 -= learning_rate*Ztrain.T.dot(pYtrain - Ytrain_ind)
    b2 -= learning_rate*(pYtrain - Ytrain_ind).sum(axis=0)
    dZ = (pYtrain - Ytrain_ind).dot(W2.T) * (1 - Ztrain*Ztrain)
    W1 -= learning_rate*Xtrain.T.dot(dZ)
    b1 -= learning_rate*dZ.sum(axis=0)
    if i % 1000 == 0:
        print i, ctrain, ctest

print "Taxa de classificacao do set de treino:", classification_rate(Ytrain, predict(pYtrain))
print "Taxa de classificacao do set de teste:", classification_rate(Ytest, predict(pYtest))

legend1, = plt.plot(train_costs, label='custo de treino')
legend2, = plt.plot(test_costs, label='custo de teste')
plt.legend([legend1, legend2])
plt.show()
