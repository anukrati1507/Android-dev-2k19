import os

l=['Akshit','Ankit','Aryaman','Devansh','Harshit','Ishaan','Ishika','Mitushi','Navdeep','Sagar','Sajid','Sanya','Saurabh','sejal','Shruti','Shubaankar','Siddhart','Umang','Yuvraj','Guneshwar','Nitish','Anukrati','Uddhav','Bhavesh','Raunaq','Mayank','Jayati','Bhavya','Satya','Mirza']

for i in range(0,len(l)):
    os.mkdir('./'+l[i])
    os.chdir('./'+l[i])
    for j in range(1,5):
        os.mkdir('./Task'+str(j))
        os.chdir('./Task'+str(j))
        f=open('README.md',"w+")
        f.write("Upload your task Here")
        f.close()
        os.chdir('..')

    

    os.chdir('..')