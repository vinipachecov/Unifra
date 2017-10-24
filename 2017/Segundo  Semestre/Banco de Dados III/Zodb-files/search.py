from ZODB.FileStorage import FileStorage
storage = FileStorage('meusdados.fs', read_only=1)
iter = storage.iterator()
try:
while True:
transaction = iter.next()
except:
pass
for rec in transaction:
print repr(rec.oid)