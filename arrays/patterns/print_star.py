'''PATTERN 1: 
*****
****
***
**
* '''
# for i in range(5, 0,-1):
#     for j in range(i):
#         print("*", end="")
#     print()

'''PATTERN 1:
*
**
***
****
****
***
**
* '''

# n = int(input("enter the value of n "))
# for i in range(0, n):
#     for j in range(i):
#         print("*", end="")
#     print()
# for i in range(n, 0,-1):
#     for j in range(i):
#         print("*", end="")
#     print()


'''PATTERN 3:
    *
   **
  ***
 ****
*****
 ****
  ***
   **
    *
 '''

# APPROACH 1:
# n = int(input("enter the value of n "))
# for i in range(1, n):
#     for j in range(n):

#         if j < n-i:
#             print(" ", end="")
#         else:
#             print("*", end="")
#     print()
# for i in range(n, 0,-1):
#     for j in range(5):
#         if j < n-i:
#             print(" ", end="")
#         else:
#             print("*", end="")
#     print()

# APPROACH 2:
# n = int(input("Enter the value of n: "))

# # Upper half of the diamond
# for i in range(1, n + 1):
#     # Print leading spaces
#     print(" " * (n - i), end="")
#     # Print stars with spaces
#     print("*" * i)


# # Lower half of the diamond
# for i in range(n - 1, 0, -1):
#     # Print leading spaces
#     print(" " * (n - i), end="")
#     # Print stars with spaces
#     print("*" * i)


'''PATTERN 3:
      *
     * *
    * * *
   * * * *
  * * * * *
 * * * * * *
  * * * * *
   * * * *
    * * *
     * *
      * '''


# n = int(input("enter the value of n "))
# for i in range(n, 0,-1):
#     for j in range(n+1):
#         print(" ", end="")
#         if i <= j: 
#             print("*", end="")
            
#     print()
# for i in range(n+1):
#     for j in range(n+1):
#         print(" ", end="")
#         if i <= j: 
#             print("*", end="")
            
#     print()

'''PATTERN:
__*_*_*_*_*_
___*_*_*_*___
____*_*_*_____
_____*_*_______
______*_________
______*
_____*_*
____*_*_*
___*_*_*_*
__*_*_*_*_*'''

# APPROACH 1:
# n = int(input("Enter the value of n"))
# for i in range(1,n+1):
#     print("_"*i, end="")
#     for j in range(n, 0, -1):
#         print("_", end="")
#         if i<=j:
#             print("*", end="")
#     print("_"*(i), end="")
#     print()
# for i in range(n, 0, -1):
#     for j in range(n+1):
#         print("_", end="")
#         if i<=j:
#             print("*", end="")
#     print()


# APPROACH 2:

# n = int(input("Enter the value of n: "))
# for i in range(1, n + 1):
#     print("_" * i, end="") 
#     print("*_" * (n - i + 1), end="") 
#     print("_" * (i - 1)) 
# for i in range(1, n + 1):
#     print("_" * (n - i), end="")  
#     print("*_" * i, end="")  
#     print("_" * (n - i))  

'''PATTERN:
*     
 *    
  *   
   *  
    * 
     *'''

n= int(input("Enter a value for n"))
for i in range(n):
    for j in range(n+1):
        if i==j:
            print("*", end="")
        else: 
            print(" ", end="")
    print()

'''PATTERN:
     *
    * 
   *  
  *   
 *    
'''
# n= int(input("Enter a value for n"))
# for i in range(n,0,-1):
#     for j in range(n+1):
#         if i==j:
#             print("*", end="")
#         else: 
#             print(" ", end="")
#     print()

n = int(input("Enter the value of n"))
for i in range(1, n+1):
    print("_"*i, end="")
    for j in range(1, n+1):
        if i==j:
            print("*", end="")
        elif n == j:
            print("*", end="")
        else:
            print(" ", end="")
    print("_"*i)