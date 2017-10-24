#coding=utf-8
import ZODB, ZODB.FileStorage
import BTrees.OOBTree
from account import Account
import persistent
import transaction




storage = ZODB.FileStorage.FileStorage('meusdados.fs')
db = ZODB.DB(storage)
connection = db.open()
dbroot = connection.root()
if not dbroot.has_key('account'):
    from BTrees.OOBTree import OOBTree
    dbroot['account'] = OOBTree()

userdb = dbroot['account']

newaccount = Account()
newaccount.id = 2
newaccount.balance = 2000
newaccount.first_name = 'joao'

userdb[newaccount.id] = newaccount

transaction.commit()

# root.accounts = BTrees.OOBTree.BTree()
# root.accounts['account-1'] = Account()

# transaction.commit()