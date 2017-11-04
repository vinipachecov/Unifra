#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Thu Mar  9 08:20:29 2017

@author: root
"""

import numpy as np
import math
import pygame as pg
import sys
from pygame.locals import *




#Usando coordenadas polares
# x = miraintesidade * cos(angulo(radianos))
# y = miraintesidade * sin(angulo(radianos))

 # O vector de forca eh na verdade o valor do vetor do canhao (direcao)
 # e com iss0 basta ir somando esse vector, transformar ele em unitario( se quiser)
 # e fazer com que ele atualize a posicao do circulo cada vez com que ele for desenhado
 # Com isso fataria o caculo do vetor de forca estaria resolvido e faltaria apenas
 # a programacao da soma do offset(deslocamento) - gravidade para simular a queda
 # do tiro.

class bola:

    cor = (0,0,60)
    pos = (0,0)
    radius = 10
    vel = (0,0)
    screen = 0
    res = 0

    def __init__(self,screen ,pos , radius ):
        self.pos = pos
        self.vel = pos
        self.radius=radius
        self.screen = screen

    def lanca(self, start, gravity):
        self.pos((self.pos + start))

    def desenha(self):
        pg.draw.circle(self.screen, (0,0,255),(int(self.pos[0]),int(self.pos[1])), self.radius)
        self.pos = (self.pos[0] + 1, (self.pos[1] + 1 - 0.1))
        self.res +=1
        print(self.pos)

class canhao:
    Height = 0
    Width = 0
    gravity = 1
    forca = 5
    ang = 45
    miraintes = 50
    mira = 0
    origem = (0,0)
    screen = 0
    running = 1
    ball = 0

    def __init__(self,screen, Width, Height):
        self.screen = screen
        self.Height = Height
        self.Width = Width
        self.origem = (0,self.Height)
        self.mira = (self.miraintes*np.cos((self.ang * np.pi) / 180) ,  self.Height - self.miraintes*np.sin((self.ang * np.pi) / 180)  )

    def desenha_canhao(self):
        print (self.mira)
        pg.draw.line(self.screen,(255,0,0),self.origem, self.mira)


    def tiro(self):
        self.ball.desenha()



class tela:
    Height = 300
    Width = 400
    screen = 0
    running = 1


    def Mainloop(self):

        #setup da tela
        pg.init()
        self.screen = pg.display.set_mode((self.Width, self.Height ))
        self.screen.fill((255,255,255))
        pg.display.set_caption('Tiro de Canhão!')
        #inicializando variaveis
        cannon = canhao(self.screen,self.Width, self.Height)
        cannon.desenha_canhao()


        while self.running:
            event = pg.event.poll()
            if event.type == pg.QUIT:
                self.running = 0
                sys.exit()
            pg.display.update()


jogo = tela()
jogo.Mainloop()
