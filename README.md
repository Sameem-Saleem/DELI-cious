# DELI-cious
This application can help track all receipts and orders for a deli, with a simple terminal interface including multiple menus to streamline user-experience, and export options that are viewable and printable.

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

Class Hierarchy:
![Hierarchy](https://media.discordapp.net/attachments/219982898550276096/1308188946467000510/image.png?ex=673d0965&is=673bb7e5&hm=6cebb19e29b2665fb56533ed51d71d577ac18ce763f34fae14fbcb1409a19ccd&=&format=webp&quality=lossless&width=2160&height=1080)


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

The following is related to custom sandwiches:

#### Bread
The user may choose between White, Wheat, Rye, and Wrap
#### Size
The user may choose between 4", 8", and 12"
- The sandwich costs 5.50, 7.00, and 8.50 respectively based on size
#### Toppings
The user may choose between lettuce, peppers, onions, tomatoes, jalapenos, cucumbers, mayo, mustard, ketchup, ranch, thousand islands, vinaigrette, pickles, guacamole, mushrooms, au jus, and sauce.
The user may choose meats of steak, ham, chicken, salami, bacon, and roast beef - they can add extra meat at the end of the selection process
- These cost 1.00 * inches/4, plus 0.50 * inches/4 for extra meat
The user may choose cheeses of american, provolone, cheddar, and swiss - they can add extra cheese at the end of the selection process
- These cost 0.75 * inches/4, plus 0.30 * inches/4 for extra cheese

### Add Drink
This option prompts the user with a brand of drink and a cup size.
- The drink costs 2.00, 2.50, and 3.00 if it's Small, Medium, or Large, respectively.
This information is then appended in to the order, where it will be shown on the next iteration of the Order Screen.



### Add Chips
This option prompts the user with a brand of chips.
- Adding chips costs a flat 1.50
This information is then appended in to the order, where it will be shown on the next iteration of the Order Screen.



### Checkout
This option creates a new HTML file with the name in the format of yyyyMMdd-hhmmss.html in the /receipts folder, writing to it the current order's receipt, which is the price followed by the item for every individual item currently in the order.

The following is what the receipt document looks like: 
![receipt](https://media.discordapp.net/attachments/219982898550276096/1308355249236611092/image.png?ex=673da447&is=673c52c7&hm=582a2ca7d630e4082266953dbcf20640ea5b0e42757003ca24028114939e6bf1&=&format=webp&quality=lossless&width=694&height=1184)
**Note that additions may not be written to the file if this option is not reached** or a misinput causes a crash in the program.


### Cancel Order
This option saves changes to the file and closes the program.

**Note that additions may not be written to the file if this option is not reached** or a misinput causes a crash in the program.



## Interesting Code
The following code segment I encountered while programming this application was interesting to me.



### Restricting Input
I found that by restricting input to only integers - and having them correlate to a specific item in my program, I was much less prone to errors, since the user was selecting as opposed to inputting.
![Interesting](https://media.discordapp.net/attachments/219982898550276096/1308355894911959040/image.png?ex=673da4e1&is=673c5361&hm=6e8b0007c6fecf9093f199cd4824433ec730474999ead390b2a8276267832952&=&format=webp&quality=lossless&width=1964&height=1186)
