# Descomposición en factores primos

def factoring(n): #descomposición en factores primos
  text= '[' +str(n) + ' = '
  i = 1
  for i in range(1, int(n/2)+1, 2):      # recorre los impares
    if i==1: i=2                         # salvo el 1 que será 2
    counter = 0
    while n % i == 0:
      n /= i
      counter += 1
    if counter == 1:
      text += str(i)+ ','
    elif counter > 1:
      text += str(i) + '^' + str (counter) + ' × '
  if text[-2] == "=":       # si no hay divisores
    text += str(n) + ','  # en ese caso el propio n será primo
  text += '1'
  return text +']'

def factor(listaNum):
  num1 = listaNum[0]
  lista = listaNum[1:]
  listabool = []
  print(num1)
  print(lista)
  for n in listaNum:
    if num1 % n != 0:
      listabool.append(False)
    else:
      listabool.append(True)
  print(listabool)

def faaac(listaNum):
  listabool = []
  lista = listaNum[1:]
  for n in lista:
    if n == 1 or n == 2 or n == 3 or n == 5 or n == 7 or n == 11:
      listabool.append(True)
    else:
      listabool.append(False)

  if False in listabool:
    print("NEL")
  else:
    print(listaNum)

if __name__ == "__main__":
         # contador = 1
         # while contador <= 2010:
         #    numero = (17**contador) % 2011
         #    print(factoring(numero))
         #    contador+=1
