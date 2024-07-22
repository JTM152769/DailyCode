arr=[1,2,0,1,2,0,0,3]
nonzeors=[i for i in arr if i != 0]
zeors=[j for j in arr if j == 0]
arr=nonzeors+zeors
print(arr)

n=len(arr)
x=0
for y in range(n):
    if arr[y]!=0:
        arr[x],arr[y]=arr[y],arr[x]
        x+=1
print(arr)

def  Movezeros(arr1,q):
    count=0
    for p in range(q):
        if arr1[p]!=0:
            arr1[count]=arr1[p]
            count+=1
    while count<q:
        arr1[count]=0
        count +=1
arr1=[1,2,2,0,0,3,4,0]
q=len(arr1)
Movezeros(arr1,q)
print(arr1)
