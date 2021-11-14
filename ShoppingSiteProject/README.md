Project Group Number: g2m
Project Title: Shop via g2m
Project Description: A shopping application for customers
Project Current Status: Complete
Members: 
Zeynep Hanife Akgül 22003356, 
Gökberk Altıparmak 21901798, 
Osman Baktır 22002553, 
Berkan Karakuş 22002033

A jar file sqlite-jdbc-3.7.2  was downloaded and used as an additional library to be able to connect to a database.

In VSCode, alexcvzz.vscode-sqlite v0.12.0 was downloaded and used as an additional extension to connect to a database

To be able to connect to the database, the location of the datab.db present inside the project file should be added 
to commented parts as “//Write location of the database file datab.db to be connected” in the class RegisterationFrame 
constructor and in the class DBConnection constructor.

To work the project, RegisterFrame class should be runned.

Contributions:
Gökberk Altıparmak: Bank registration and user registration classes. User class. Item class and its four subclasses 
which are Book , TechnologicalDevices, Vehicles and Clothes classes. Creating the login page , user register page and 
their frame. Also Frame of main page and User profile and Checkout panels of it with necessary action listeners. 
In addition, at the beginning, the first detailed design of our project did not match with the project that we wanted to implement. 
Therefore, ı take the lead there and start creating model classes first and then create all the work in my mind and 
distribute the necessary works to my teammates.

Zeynep Hanife Akgül: Database connection class with methods connecting and getting data from databases. 
Displaying all properties of items, like images, prices, names in MainFrame class. Connecting user registration 
class to database, getting values from user registration and creating new users and saving them to the database. Controlling logins, 
checking if a user exists or if the password matches. Implementation of search engine, adding it to mainframe, making it available to search 
inside certain categories, and displaying searched items using GUI. Gathering all code work that my groupmates did and making changes 
accordingly to make the whole code work.

Berkan Karakuş: Implemented UserRegistration class with their methods and properties. 
Also worked together with Gökberk while writing the methods of checking the conditions for user registration such as checking 
passwords in RegisterFrame class. Also wrote the CompareItem panel in MainFrame class for comparing the properties of 2 chosen items from 
the main page. Also implemented the actionListener methods of the compare buttons of items in the main page to open the CompareItem panel.

Osman Baktır: Implemented the GUI of the product page panel and wrote the necessary actionListener methods for adding the products 
in the item list of users. Contributed to the general design MainFrame and connected the ProductPage panel to the MainFrame with 
necessary action listener methods. In addition, implemented the GUI of the Bank Register in the RegisterFrame class for the payment of the products.
Implemented GUI of the bank registeration panel. 
