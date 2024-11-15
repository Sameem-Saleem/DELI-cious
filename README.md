# DELI-cious
This application can help track all receipts and orders for a deli, with a simple terminal interface including multiple menus to streamline user-experience.

Note that information entered must follow the guidelines expressed in the documentation and this `README.md`, otherwise, errors may occur.



## Table Of Content
- [Home Screen](#home-screen)
    - [New Order](#new-order)
    - [Exit](#exit)
- [Order Screen](#order-screen)
    - [Add Sandwich](#add-sandwich)
    - [Add Drink](#add-drink)
    - [Add Chips](#add-chips)
    - [Checkout](#checkout)
    - [Cancel Order](#cancel-order)
- [Add Sandwich](#add-sandwich)
    - [Bread](#bread)
    - [Size](#size)
    - [Toppings](#toppings)
- [Interesting Code](#interesting-code)
    - [Restricting input](#restricting-input)



## Installation
You can pull this repository locally to access the program. Make sure to use a Java IDE to run the program, or manually compile with Javac and run with Java. Steps are below:
1. `git clone https://github.com/Sameem-Saleem/DELI-cious.git`
2. `javac src/main/java/com/pluralsight/Main`
3. `java src/main/java/com/pluralsight/Main`

Suggested software:
- [Java JDK](https://www.oracle.com/th/java/technologies/downloads)
- [JetBrains IntelliJ](https://www.jetbrains.com/idea/download/)


If you have **previous receipts** you want to import, you must **add them manually** into the **receipts** folder, with the file named as the following:
`yyyyMMdd-hhmmss.txt`

Notes:
- The **time** *must be* in `HH:MM:SS` 24 hour format



## Home Screen
It provides the options to start a new order or exit the program.

The user must enter the digit correlating to the menu item, and press enter.



### New Order
This option takes the user into the Order Screen, where they will be able to add items into an order and output it into a newly created receipt file.



### Exit
This option closes the program.



## Order Screen
It provides the options to add a sandwich to an order, add chips to an order, add a drink to the order, checkout, or cancel the order. The user may add as many items as they please before checking out.

The user must enter the digit correlating to the menu item, and press enter.



### Add Sandwich
First, this option prompts the user whether they want a Signature Sandwich, or to create a custom sandwich.

The signature sandwich option allows the user to select one of the following signature sandwiches, and then adds it into the order predefined.

The custom sandwich option prompts the user to select a type of bread, a size for the sandwich, and toppings, all of which are from predefined sets.

This information is then appended in to the order, where it will be shown on the next iteration of the Order Screen.



### Add Drink
This option prompts the user with a brand of drink and a cup size.

This information is then appended in to the order, where it will be shown on the next iteration of the Order Screen.



### Add Chips
This option prompts the user with a brand of chips.

This information is then appended in to the order, where it will be shown on the next iteration of the Order Screen.



### Checkout
This option creates a new file with the name in the format of yyyyMMdd-hhmmss.txt in the /receipts folder, writing to it the current order's receipt, which is the price followed by the item for every individual item currently in the order.

**Note that additions may not be written to the file if this option is not reached** or a misinput causes a crash in the program.


### Exit
This option saves changes to the file and closes the program.

**Note that additions may not be written to the file if this option is not reached** or a misinput causes a crash in the program.



## Interesting Code
The following code segment I encountered while programming this application was interesting to me.



### Restricting Input
I found that by restricting input to only integers - and having them correlate to a specific item in my program, I was much less prone to errors, since the user was selecting as opposed to inputting.