import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {

        Ship[] ships = {new Ship("Destroyer", 2),
                new Ship("Cruiser", 3),
                new Ship("Submarine", 3),
                new Ship("Battleship", 4),
                new Ship("Aircraft Carrier", 5)};
        Battlefield myBattlefield = new Battlefield(ships);

        GamePlay.PlacementOfShips(myBattlefield);
        //GameStart g = new GameStart();
        //GameStart1 g = new GameStart1();
        GameStart2 g = new GameStart2();

    }
}

class GameStart2 extends GamePlay{
    char[][] Bf = new char[12][12];

    public void printBattlefield(){
        System.out.println("\n  1 2 3 4 5 6 7 8 9 10");
        for (int i = 1; i < Bf.length - 1; i++) {
            System.out.print((char) ('@' + i) + " ");
            for (int j = 1; j < Bf.length - 1; j++) {
                System.out.print(j == Bf.length - 2 ? Bf[i][j] + "\n" : Bf[i][j] + " ");
            }
        }
    }

    public boolean checkforO() {
        for (int i = 1; i < Battlefield.BATTLEFIELD.length - 1; i++) {
            for (int j = 1; j < Battlefield.BATTLEFIELD.length - 1; j++) {
                if(Battlefield.BATTLEFIELD[i][j] == 'O'){
                    return false;
                }
            }
        }
        return true;
    }
    public GameStart2() {
        System.out.println("\nThe game starts!");
        for (int i = 1; i < Bf.length - 1; i++) {
            for (int j = 1; j < Bf.length - 1; j++) {
                Bf[i][j] = '~';
            }
        }
        printBattlefield();
        System.out.println("\nTake a shot!\n");
        while(true) {
            String[] str = scanner.nextLine().toUpperCase(Locale.ROOT).split(" ");
            if (GameRules.checkInGameCoordinates(str)) {
                int row = str[0].charAt(0) - '@';
                int column = Integer.parseInt(str[0].substring(1));
                //Bf[row][column] = 'X';

                if (Battlefield.BATTLEFIELD[row][column] == 'O' || Battlefield.BATTLEFIELD[row][column] == 'X') {
                    Battlefield.BATTLEFIELD[row][column] = 'X';
                    Bf[row][column] = 'X';
                    printBattlefield();
                    System.out.println("\nYou hit a ship! Try again:");
                    //Battlefield.printBattlefield();
                } else {
                    Battlefield.BATTLEFIELD[row][column] = 'M';
                    Bf[row][column] = 'M';
                    printBattlefield();
                    System.out.println("\nYou missed. Try again:");
                    //Battlefield.printBattlefield();
                }
                if(checkforO()){
                    Battlefield.printBattlefield();
                    System.out.println("\nYou sank the last ship. You won. Congratulations!");
                    break;
                }
            }
        }
    }
}
class GameStart1 extends GamePlay{
    char[][] Bf = new char[12][12];

    public void printBattlefield(){
        System.out.println("\n  1 2 3 4 5 6 7 8 9 10");
        for (int i = 1; i < Bf.length - 1; i++) {
            System.out.print((char) ('@' + i) + " ");
            for (int j = 1; j < Bf.length - 1; j++) {
                System.out.print(j == Bf.length - 2 ? Bf[i][j] + "\n" : Bf[i][j] + " ");
            }
        }
    }
    public GameStart1() {
        System.out.println("\nThe game starts!");
        for (int i = 1; i < Bf.length - 1; i++) {
            for (int j = 1; j < Bf.length - 1; j++) {
                Bf[i][j] = '~';
            }
        }
        printBattlefield();
        System.out.println("\nTake a shot!\n");
        while(true) {
            String[] str = scanner.nextLine().toUpperCase(Locale.ROOT).split(" ");
            if (GameRules.checkInGameCoordinates(str)) {
                int row = str[0].charAt(0) - '@';
                int column = Integer.parseInt(str[0].substring(1));
                Bf[row][column] = 'X';
                printBattlefield();
                if (Battlefield.BATTLEFIELD[row][column] == 'O') {
                    Battlefield.BATTLEFIELD[row][column] = 'X';
                    System.out.println("\nYou hit a ship!");
                    Battlefield.printBattlefield();
                } else {
                    Battlefield.BATTLEFIELD[row][column] = 'M';
                    System.out.println("\nYou missed!");
                    Battlefield.printBattlefield();

                }
                break;
            }
        }
    }
}
class GameStart extends GamePlay{
    public GameStart() {
        System.out.println("\nThe game starts!");
        Battlefield.printBattlefield(); // F3F7A1D1J10J8B9D9I2J2
        System.out.println("\nTake a shot!\n");
        while(true) {
            String[] str = scanner.nextLine().toUpperCase(Locale.ROOT).split(" ");
            if (GameRules.checkInGameCoordinates(str)) {
                int row = str[0].charAt(0) - '@';
                int column = Integer.parseInt(str[0].substring(1));
                if (Battlefield.BATTLEFIELD[row][column] == 'O') {
                    Battlefield.BATTLEFIELD[row][column] = 'X';
                    Battlefield.printBattlefield();
                    System.out.println("\nYou hit a ship!");
                } else {
                    Battlefield.BATTLEFIELD[row][column] = 'M';
                    Battlefield.printBattlefield();
                    System.out.println("\nYou missed!");
                }
                break;
            }
        }
    }
}

class GamePlay extends GameRules {
    static Scanner scanner = new Scanner(System.in);

    public static void PlacementOfShips(Battlefield myBattlefield) {
        myBattlefield.createBattlefield();
        myBattlefield.printBattlefield();

        while (myBattlefield.getUnplacedShips() != 0) {

            System.out.printf("\nEnter the coordinates of the %s (%d cells):\n\n",
                    myBattlefield.getShip().getNAME(), myBattlefield.getShip().getSIZE());

            while (true) {
                try {
                    myBattlefield.getShip().setDeckCoordinates(scanner.nextLine().toUpperCase(Locale.ROOT).split(" "));

                    CheckShipPlacementRules(myBattlefield);

                    myBattlefield.placeShipOnBattlefield();
                    myBattlefield.printBattlefield();
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage().contains("Error") ? "\n" + e.getMessage()
                            : "\n" + new Exception(String.format("Error! %s. Try again:" + "\n",
                            e.getLocalizedMessage())).getMessage());
                }
            }
        }
    }
}

class Battlefield {
    public static final char[][] BATTLEFIELD = new char[12][12];
    private final Ship[] SHIPS;
    private int unplacedShips;

    public Battlefield(Ship[] ships) {
        SHIPS = ships.clone();
        this.unplacedShips = ships.length;
    }

    public char[][] getBATTLEFIELD() {
        return BATTLEFIELD;
    }

    public Ship getShip() {
        return this.SHIPS[this.unplacedShips - 1];
    }

    public int getUnplacedShips() {
        return this.unplacedShips;
    }

    public void createBattlefield() {
        for (int i = 1; i < BATTLEFIELD.length - 1; i++) {
            for (int j = 1; j < BATTLEFIELD.length - 1; j++) {
                BATTLEFIELD[i][j] = '~';
            }
        }
    }

    public static void printBattlefield() {
        System.out.println("\n  1 2 3 4 5 6 7 8 9 10");
        for (int i = 1; i < BATTLEFIELD.length - 1; i++) {
            System.out.print((char) ('@' + i) + " ");
            for (int j = 1; j < BATTLEFIELD.length - 1; j++) {
                System.out.print(j == BATTLEFIELD.length - 2 ? BATTLEFIELD[i][j] + "\n" : BATTLEFIELD[i][j] + " ");
            }
        }
    }

    public void placeShipOnBattlefield() {
        for (int i = 0; i < getShip().getDeckCoordinates()[0].length; i++) {
            BATTLEFIELD[getShip().getDeckCoordinates()[0][i]][getShip().getDeckCoordinates()[1][i]] = 'O';
        }
        this.unplacedShips--;
    }
}

class Ship {
    private final String NAME;
    private final int SIZE;
    private int[][] deckCoordinates;

    public Ship(String name, int size) {
        NAME = name;
        SIZE = size;
    }

    public String getNAME() {
        return NAME;
    }

    public int getSIZE() {
        return SIZE;
    }

    public void setDeckCoordinates(String[] coordinates) {

        int[] row = {coordinates[0].charAt(0) - '@', coordinates[1].charAt(0) - '@'};
        int[] col = {Integer.parseInt(coordinates[0].substring(1)), Integer.parseInt(coordinates[1].substring(1))};

        this.deckCoordinates = new int[2][Math.abs((row[0] + col[0]) - (row[1] + col[1])) + 1];

        for (int i = 0; i < this.deckCoordinates[0].length; i++) {
            this.deckCoordinates[0][i] = row[0] == row[1] ? Math.min(row[0], row[1]) : Math.min(row[0], row[1]) + i;
            this.deckCoordinates[1][i] = row[0] == row[1] ? Math.min(col[0], col[1]) + i : Math.min(col[0], col[1]);
        }
    }

    public int[][] getDeckCoordinates() {
        return this.deckCoordinates;
    }
}

class GameRules {
    public static boolean checkInGameCoordinates(String[] str) {
        int row = str[0].charAt(0) - '@';
        int column = Integer.parseInt(str[0].substring(1));
        if (row>10 || column>10 || row<0 || column<0) {
            System.out.println("Error! You entered the wrong coordinates! Try again:");
            return false;
        }
        return true;
    }
    public static void CheckShipPlacementRules(Battlefield myBattlefield) throws Exception {
        int[][] d = myBattlefield.getShip().getDeckCoordinates();
        if (d[0][0] != d[0][d[0].length - 1] && d[1][0] != d[1][d[0].length - 1]
                || d[0][d[0].length - 1] > 10 || d[1][d[0].length - 1] > 10) {
            throw new Exception("Error! Wrong ship location! Try again:\n");
        } else if (myBattlefield.getShip().getSIZE() != d[0].length) {
            throw new Exception(String.format("Error! Wrong length of the %s! Try again:\n", myBattlefield.getShip().getNAME()));
        } else {
            for (int i = 0; i < d[0].length; i++) {
                for (int j = d[0][i] - 1; j <= d[0][i] + 1; j++) {
                    for (int l = d[1][i] - 1; l <= d[1][i] + 1; l++) {
                        if (myBattlefield.getBATTLEFIELD()[j][l] == 'O') {
                            throw new Exception("Error! You placed it too close to another one. Try again:\n");
                        }
                    }
                }
            }
        }
    }
}