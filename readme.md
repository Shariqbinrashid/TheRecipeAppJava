# Terminal based recipe app on JAVA 
I have a project of implementing Strategy pattern so  codded this small app which have a search strategy patern.

An application that handles recipes. In essence this is a digital cooking book with recipes that you can add, delete and view via the terminal. All recipes are to be stored on file and read when the program starts (as well as saved when the program is closed). As it is digital, you should be able to do some additional things as compared to a normal book, for instance change the number of portions or list based on ingredient or max price

Search Strategy patern:

-Search available recipes based on  recipe name, or the max price

Feel free to add more search types, e.g. ingredient name etc.

# Class diagram 
![class diagram](./img/finalCD.JPG)

# Functionality Implemented
User can do following operations:
- view all recipies
- add recipie
- delete recipie
- search recipie
- view all avaialable ingredients
- view particular ingredient details
- to add ingredient
- to delete ingredient
- to Look at a particular recipe with specific portion

Files read as program starts and update as it terminates.

# To run

To run on your pc change path of files (recipes.txt and ingredients.txt) at line 18,40, 91,93,121,123 on Main.java file.

# Some screenshots
![menu](./img/menu.JPG)

![view all recipes](./img/viewall.JPG)

![view all ingredients](./img/viewalling.JPG)

![adding recipe ](./img/addingrec.JPG)

![after adding recipe ](./img/afteraddingrec.JPG)

![searching recipe ](./img/searching.JPG)

![searching particular recipe ](./img/particularRec.JPG)

![after closing program text file ](./img/afterclosing.JPG)
