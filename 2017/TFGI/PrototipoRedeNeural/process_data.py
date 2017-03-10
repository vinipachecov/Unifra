     

import numpy as np
import pandas as pd

def get_data():
    df = pd.read_csv('ex2data1.txt')
    data = df.as_matrix()
    
    X = data[:, :-1]
    Y = data[:, -1]
    
    #Normalizacao dos dados
    X[:,0] = (X[:,0] - X[:,0].mean()) / X[:,0].std()
    X[:,1] = (X[:,1] - X[:,1].mean()) / X[:,1].std()
        
    return X,Y

          
def get_binary_data():
    X, Y = get_data()
    X2 = X[Y <= 1]
    Y2 = Y[Y <= 1]
    return X2,Y2
     