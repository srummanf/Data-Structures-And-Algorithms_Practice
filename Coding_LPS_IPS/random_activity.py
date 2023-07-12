import random
n = 1000
fp = open("randomact_"+str(n)+".txt","w")
fp.write(str(n)+" "+'\n')  
for i in range(1,n+1):
    x = random.uniform(0,0.5)
    y=random.uniform(0.5,1)
    fp.write('a'+str(i)+" "+str(int(x*n))+" "+ str(int(y*n))+'\n') 
fp.close()
