

import random


n =  10

   
 

with open("random_" + str(n) + ".txt", "w") as fp:
    fp.write(str(n) + "\n")
    for i in range(1, n):
        x = random.random()
        fp.write(str(int(x * n)) + "\n")
    x = random.random()
    fp.write(str(int(x * n)) + "\n")
fp.close()
