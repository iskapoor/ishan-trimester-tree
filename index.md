## Welcome to Ishan's T3 Github Page!

### Cod Cod Cod ([Review Ticket](https://github.com/iskapoor/ishan-trimester-tree/issues/1))
![Gadus_morhua_Cod-2b-Atlanterhavsparken-Norway](https://user-images.githubusercontent.com/86839713/158218256-044df80a-5e35-4ec9-ad4d-240a4e7ccbdd.jpg)

### Tech Talk Notes

TT0 - Paradigms:
Paradigms are a strategy to be followed for writing software applications
Imperative paradigms: Uses statements to change a program’s state. Imperative programs are built from procedures and a series of commands to perform a task.
Object Oriented paradigms: Uses classes as blueprints to make objects out of. These class structures can be reused, and Java follows OOP.

TT1 - Linked Lists P.2
- enqueue means append to list
- dequeue means remove the first elemet from a list
- Queue has head and tail: head is the first element in the linked list and tail is the last element
- After adding one element, the head remains the same, the tail changes
- When removing an element, the tail remains the same, the head changes

TT2 
- calculator class has toString that returns the mathematic result
- Tokenize - string to math expression
- Example: 200 + 100 to 200, +, 100
- Reverse Polish Notation: used in older computers as input for math, we take the Tokenize list and convert it to this
- We create operators and separators hashmaps and give each thing a precedence

TT3
- Sort algorithms will measure time in ns, gather 12 runs and take average of every data point but high and low
- We need to test multiple runtimes so we can get a accurate value from enough data.

Future Plans for TT - I plan to review over the concepts alongside my scrum team 

### Test Prep Plans

- I will study alongside other members of our group to review key knowledge for the AP exam
- I will distribute my study time as per the allocation of points shown by CollegeBoard
- I will help akhil... or smth like that

### Replit for Runtime!

[Current Replit](https://replit.com/@iskapoor/ishan-t3)

[Replit Old1](https://replit.com/@iskapoor/ishan-trimester-tree#com/ishan/Menu.java)

[Replit Old2](https://replit.com/@iskapoor/t3-tt1-project#Main.java)


### Code Snippets

TT0: 
I struggled with HashMaps
![image](https://user-images.githubusercontent.com/86839713/158223086-cc536940-9fa4-43b4-9115-6dceacee3b4f.png)

I also enjoyed working through the try catch logic for the Menu
![image](https://user-images.githubusercontent.com/86839713/158223200-dfedcd51-0fa0-48a8-b0a0-7e074e28d5cb.png)

TT1:
Linked Lists are lists of vars where each variable is connected in an order such that you can identify what's before and after it based on it.
![image](https://user-images.githubusercontent.com/86839713/159311015-bd581e70-04ff-453a-b165-79c643620384.png)

I have comments, implementation of add and delete (can be seen running on replit)
![image](https://user-images.githubusercontent.com/86839713/159311431-186a1380-693d-44c7-9027-cf51a0a40055.png)

Below is the printQueue method, we can take 2 int lists and run a simple double for loop to order them into one list. Afterwards, we can convert to Object list and feed into this method to print. 
![image](https://user-images.githubusercontent.com/86839713/159311818-df6d44e0-b575-45ff-8138-4b406a02a3b1.png)

Stack class definition below
![image](https://user-images.githubusercontent.com/86839713/159312377-a8d537d8-65b9-47b1-915f-7267c1d64bd4.png)

This is my tester and the reverse order test case from Queue to Stack is in it. 
![image](https://user-images.githubusercontent.com/86839713/159312610-117e30c6-95d4-4af3-917d-8ee58464a08a.png)

### Reflection For Calculator

My key points of reflection:
- Tokenizing an expression was an interesting challenge; to take a string and identify parts then split it on the basis of those components
![image](https://user-images.githubusercontent.com/86839713/160671414-deaa69f4-545d-4786-9823-4ffb5f8a8f25.png)
![image](https://user-images.githubusercontent.com/86839713/160671516-737c5f26-0377-44fc-a282-6f830812becd.png)
- I overcame that challege by identitfying spaces and seperating tokens from the start of the remaining string to the character before the space until the string if finished.
- RPN was also an interesting logic point. It was fun to work through the logic and address the stack vs queue orderings.
![image](https://user-images.githubusercontent.com/86839713/160671681-2ea77a6e-0c8b-4aec-9b95-b1ed59918696.png)

### Support or Contact

Contact our technical support officer, John Mortensen at jmortensen.1979@outlook.com
