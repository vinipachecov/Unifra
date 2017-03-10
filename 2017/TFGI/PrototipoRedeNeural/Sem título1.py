#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Thu Mar  9 08:20:29 2017

@author: root
"""

import matplotlib.pyplot as plt


class canhao:
    
    def desenha_limites(self):
        plt.xlim(-20,200)
        plt.ylim(-20,200)
        
        
    
    def desenha_canhao(self):
        plt.plot([0, 20], [0, 20], 'k-', lw=2)
        

cannon = canhao()
cannon.desenha_canhao()
#plt.plot([-1, 1], [-1, 1], 'k-', lw=2)
plt.figure(1)
cannon.desenha_limites()
circle = plt.Circle((0,0),2)
plt.title("Tiro de Canhao")





