# A6: Unit Testing
The goal of this assignment is to reinforce the importance of unit testing in Java using `JUnit`. You are provided with a solution to A2 written in Java. The solution compiles and runs, but contains 10 bugs. Your task is to design and implement a suite of unit tests in `ShopTest.java` to identify the bugs. You will edit `ShopTest.java` but we recomment you **DO NOT edit** `Computer.java` nor `ResaleShop.java` (or if you do keep careful track of what you changed).     



## Step 1: Getting Started
 - Fork the the repository for CSC120-A6, and clone it to your local machine.
 - Enable Java tests using the `jUnit` testing framework.
 - Re-familiarize yourself with [A2: Object-ification](https://github.com/CSC120-instructors/CSC120-A2) to remember how the `Computer` and `ResaleShop` classes should function. 

## Step 2: Writing Unit Tests
Write your `jUnit` tests inside `ShopTest.java`, using **assertions** to validate expected outputs. Remember, there are bugs in the provided solution and your job is to use unit testing to identify them. 

## Step 3: Identify Bugs
In `bugLog.md` list the 10 bugs you identified. For each, briefly explain the bug and identify which unit test(s) in `ShopTest.java` reveal the bug. For example: 

Bug #1
Brief description: The refurbish method does not update price. 
Failed unit test: testRefurbishPrice() 

## What to Submit
As before, all the files necessary for this assignment are contained within this repository. When you submit, please remember to include:

- all files necessary to compile your program
- `bugLog.md` containing your bug documentation 
- `reflection.md` containing your reflections and notes
- `rubric.md` where you document which elements of the assignment you have attempted and/or completed
