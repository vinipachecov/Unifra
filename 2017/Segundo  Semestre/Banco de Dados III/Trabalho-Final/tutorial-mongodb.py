#encoding=utf-8

from pymongo import MongoClient
import datetime
#criando conexão do banco
cliente = MongoClient('localhost', 27017)

#selecionando uma base de dados
banco = cliente['test-database'] 

#selecionando uma collection

album = banco['album']

#criando um item para inserir na collection

musica = {
              "nome": "Nothing left to say",
              "banda": "Imagine Dragons",
              "categorias": ["indie", "rock"],
              "lancamento": datetime.datetime.now()
             }

musica_id = album.insert_one(musica).inserted_id


