#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Thu Mar  9 08:20:29 2017

@author: root
"""

import matplotlib.pyplot as plt
import numpy as np
import math
import pygame as pg
import sys
from pygame.locals import *




#Usando coordenadas polares
# x = miraintesidade * cos(angulo(radianos))
# y = miraintesidade * sin(angulo(radianos))

class canhao:
    Height = 300
    Width = 400
    gravity = 1
    forca = 5
    ang = 45
    miraintes = 20
    mira = pg.math.Vector2(miraintes*np.cos((ang * np.pi) / 180) , Height - miraintes*np.sin((ang * np.pi) / 180) )
    origem = (0,Height)
    screen = 0
    running = 1


    def desenha_canhao(self):
        print (self.mira[0], self.mira[1])
        pg.draw.line(self.screen,(255,0,0),self.origem, self.mira, width=5)


    def tiro(self):
        print (10)

    def Mainloop(self):
        pg.init()
        self.screen = pg.display.set_mode((self.Width, self.Height ))
        self.screen.fill((255,255,255))
        pg.display.set_caption('Tiro de Canhão!')
        while self.running:
            event = pg.event.poll()
            self.desenha_canhao()
            if event.type == pg.QUIT:
                self.running = 0
                sys.exit()
            pg.display.update()




cannon = canhao()
cannon.Mainloop()
