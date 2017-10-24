import persistent
from BTrees.OOBTree import TreeSet

class Book(persistent.Persistent):

   publisher = 'UNKNOWN'

   def __init__(self, title, publisher):
       self.title = title
       self.publisher = publisher
       self.authors = TreeSet()

   def add_author(self, author):
       self.authors.add(author)