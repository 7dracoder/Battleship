# BattleShip

Battleship (also called Battleships or Sea Battle) is a two-player strategy game whose history traces back to the First World War. It started off as a pencil and paper game, until Milton Bradley coined the rules and published the game. Fun fact: it was one of the first games to be produced as a computer game in 1979! In this project, recreated this timeless classic in 5 stages.

Stage-1: 
In this stage, arranged ships on the game field. Before start, let's discuss the conventions of the game:
On a 10x10 field, the first row should contain numbers from 1 to 10 indicating the column, and the first column should contain letters from A to J indicating the row.
The symbol ~ denotes the fog of war: the unknown area on the opponent's field and the yet untouched area on your field.
The symbol O denotes a cell with your ship, X denotes that the ship was hit, and M signifies a miss.
You have 5 ships: Aircraft Carrier is 5 cells, Battleship is 4 cells, Submarine is 3 cells, Cruiser is also 3 cells, and Destroyer is 2 cells. Start placing your ships with the largest one.
To place a ship, enter two coordinates: the beginning and the end of the ship.
If an error occurs in the input coordinates, your program should report it. The message should contain the word Error.

Stege-2:
Took a shot at a prepared game field. Need to indicate the coordinates of the target, and the program should then display a message about a hit or a miss. If the shell misses the target and falls in the water, this cell should be marked with an M, and a successful strike is marked by an X. After this shot, the game should be stopped.
If the player managed to hit a ship, the game should display a message You hit a ship!; otherwise, the message is You missed!

Stage-3:
In this stage, needed to implement the "fog of war" feature in the game. First, place all the ships on the game field, and then hide them with the symbol ~. Take a shot like in the previous stage, and after your attempt, the program should print a message along with two versions of the field: one covered with the fog of war and the other one uncovered.

Stage-4:
To complete this step, I should add a check that all the ships were successfully sunk. The game is supposed to go on until all ships go down. The program should print an extra message You sank a ship! when all the cells of a particular ship have been hit.

Stage-5:
To complete this stage and the entire project, added a PvP component to your game. Now the player will see not only the opponent's screen but their own as well. Place the opponent's screen at the top and your field at the bottom.

Good Luck!
