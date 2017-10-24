#coding=utf-8
import persistent

#This code defines a simple class that holds the 
# balance of a bank account 
# and provides two methods to manipulate the balance: deposit and cash.



class Account(persistent.Persistent):

    id = 0
    first_name = ''

    def __init__(self):
        self.balance = 0.0

    def deposit(self, amount):
        self.balance += amount

    def cash(self, amount):
        assert amount < self.balance
        self.balance -= amount

