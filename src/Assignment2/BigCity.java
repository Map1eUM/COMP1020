package Assignment2;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static processing.core.PApplet.print;
import static processing.core.PApplet.println;

public class BigCity {
    private int rows, columns;
    private int boxNum, cheeseNum, xPos, yPos;
    private int[][] cheesePositions;
    private char[][] grid;
    private int getCheeseNum, moveMade;
    private boolean isFree;
    private char[][][] rev = new char[5][][]; //no need to initialise in constructor since we know size is constant.
    private int step = 0;
    //for processMove usage...
    private int newX, newY;

    private void processMove(char dir) {
        saveGrid();
        if (this.grid[newX][newY] == '.') this.moveMade++;
        else if (this.grid[newX][newY] == 'b') {
            this.moveMade++;
            if (isBoxCheese(newX, newY))
                this.getCheeseNum++;
            else endTerror();
        }
        this.grid[this.xPos][this.yPos] = '.';
        this.grid[newX][newY] = 's';
        this.xPos = newX;
        this.yPos = newY;
    }

    public void move(char dir) {
        //if game ended, return
        if (!this.isFree) return;
        //reminder that X is first dimension
        if (dir == 'w') {
            newX = this.xPos - 1;
            newY = this.yPos;
        } else if (dir == 's') {
            newX = this.xPos + 1;
            newY = this.yPos;
        } else if (dir == 'a') {
            newX = this.xPos;
            newY = this.yPos - 1;
        } else if (dir == 'd') {
            newX = this.xPos;
            newY = this.yPos + 1;
        } else return;
        if (newX < 0 || newX >= this.rows || newY < 0 || newY >= this.columns)
            throw new IndexOutOfBoundsException("This move takes Suzie out of the grid.");
        //before move, save status!
        processMove(dir);
    }

    public char[][] deepCopy(char[][] input) {
        char[][] ans = new char[this.rows][this.columns];
        for (int i = 0; i < this.rows; ++i) {
            for (int j = 0; j < this.columns; ++j) {
                ans[i][j] = input[i][j];
            }
        }
        return ans;
    }

    private void saveGrid() {
        if (step == 0) {
            step++;
            this.rev[0] = deepCopy(this.grid);
            return;
        }
        for (int i = step - 1; i >= 0; --i) {
            if (i + 1 == 5) continue;
            this.rev[i + 1] = deepCopy(this.rev[i]);
        }
        this.rev[0] = deepCopy(this.grid);
        if (step < 5) step++;
    }

    public void undo() {
        if (this.step == 0) return;
        this.grid = deepCopy(this.rev[0]);
        cheeseUpdate();
        if (this.step == 1) this.step = 0;
        else {
            for (int i = 0; i < step - 1; ++i)
                this.rev[i] = deepCopy(this.rev[i + 1]);
            this.step--;
        }
        //get the former position of s
        for (int i = 0; i < this.rows; ++i) {
            for (int j = 0; j < this.columns; ++j) {
                if (this.grid[i][j] == 's') {
                    this.xPos = i;
                    this.yPos = j;
                    return;
                }
            }
        }
    }

    public BigCity(int rows, int cols, int numBoxes, int numCheese, int[][] cheesePositions) {
        this.rows = rows;
        this.columns = cols;
        this.boxNum = numBoxes;
        this.cheeseNum = numCheese;
        this.cheesePositions = cheesePositions;
        this.grid = new char[this.rows][this.columns];
        this.getCheeseNum = 0;
        this.moveMade = 0;
        this.isFree = true;
        this.xPos = this.yPos = 0;
        fillGrid();
    }

    private void endTerror() {
        //game ended
        this.isFree = false;
    }

    public boolean isRoamingCity() {
        return this.isFree;
    }

    private void cheeseUpdate() {

        int ans = this.cheeseNum;
        for (int i = 0; i < this.cheeseNum; ++i) {
            if (this.grid[this.cheesePositions[i][0]][this.cheesePositions[i][1]] == 'b') {
                --ans;
                println(this.cheesePositions[i][0]);
                println(this.cheesePositions[i][1]);
            }
        }
        this.getCheeseNum = ans;
    }

    private boolean isBoxCheese(int row, int col) {
        for (int i = 0; i < this.cheeseNum; ++i) {
            if (row == this.cheesePositions[i][0] && col == this.cheesePositions[i][1])
                return true;
        }
        return false;
    }

    private boolean isValid(int x, int y) {
//        for (int i = 0; i < this.cheeseNum; ++i) {
//            if (x == this.cheesePositions[i][0] && y == this.cheesePositions[i][1]) return false;
//        }
        if (x == 0 && y == 0) return false;
        if (this.grid[x][y] == 'b') return false;
        return true;
    }

    char[] extractRow(int rowNum) throws DataDoesNotExistException {
        if (rowNum >= this.rows || rowNum < 0)
            throw new DataDoesNotExistException("BigCity grid does not have a row index of " + rowNum);
        return this.grid[rowNum];
    }

    char[] extractColumn(int colNum) throws DataDoesNotExistException {
        if (colNum >= this.columns || colNum < 0)
            throw new DataDoesNotExistException("BigCity grid does not have a column index of " + colNum);
        char[] ans = new char[this.rows];
        for (int i = 0; i < this.rows; ++i)
            ans[i] = this.grid[i][colNum];
        return ans;
    }

    public String toString() {
        for (int i = 0; i < this.rows; ++i) {
            for (int j = 0; j < this.columns; ++j)
                System.out.print(this.grid[i][j] + " ");
            System.out.println();
        }
        String S = "";
        //--------------------------------Phase 7 test part of toString require---------------------------------
        if (!isFree && (this.cheeseNum - this.getCheeseNum) > 0)
            S += "Suzie's reign of terror came to an end abruptly after just " + this.moveMade + " move. She was captured with " + this.getCheeseNum + " cheese crumbs on her person";
        else if (!isFree && this.cheeseNum == this.getCheeseNum)
            S += "Suzie outsmarted the exterminators, making " + this.moveMade + " moves and collecting all " + this.getCheeseNum + " cheese crumbs. She sniffed out the " + (this.boxNum - this.cheeseNum) + " traps.";
        return S;

        //----------------------------------------------------------------------------------------------
    }

    private void fillGrid() {
        for (int i = 0; i < this.rows; ++i) {
            for (int j = 0; j < this.columns; ++j) {
                this.grid[i][j] = '.';
            }
        }
        this.grid[0][0] = 's';
        int boxFillNum = this.boxNum - this.cheeseNum; //this is only for phrase 1
        for (int i = 0; i < this.cheeseNum; ++i)
            this.grid[this.cheesePositions[i][0]][this.cheesePositions[i][1]] = 'b';
        while (boxFillNum > 0) {
            int x = (int) (Math.random() * this.rows);
            int y = (int) (Math.random() * this.columns);
//            print(this.rows + " " + this.columns);
            if (isValid(x, y)) {
                this.grid[x][y] = 'b';
                boxFillNum--;
            }
        }
    }

    //------------------------------CONSTUCTOR BY FILE-----------------------------------------------------
    public BigCity(String filename) throws IOException {
        this.xPos = this.yPos = 0;
        this.getCheeseNum = 0;
        this.moveMade = 0;
        this.isFree = true;
        try {
            Scanner mapFile = new Scanner(new BufferedReader(new FileReader(filename)));
            //--------------------------------- get city grid size---------------------------------------
            this.rows = Integer.parseInt(String.valueOf(mapFile.next()));
            this.columns = Integer.parseInt(String.valueOf(mapFile.next()));
            if (this.rows == 0 && this.columns == 0) throw new IOException("No grid to read");
            mapFile.nextLine();
            //-------------------------------------------------------------------------------------------
            char[][] charMap = new char[this.rows][this.columns];
            for (int i = 0; i < this.rows; ++i) {
                String curLine = mapFile.nextLine();
                //At first we judge if there's even grid to read
                if (i == 0 && curLine.charAt(0) != 's') throw new IOException("No grid to read");
                //current line constructed Scanner.
                Scanner curScanner = new Scanner(curLine);
                int realColumn = 0;
                try {
                    for (int j = 0; j < this.columns; ++j) {
                        charMap[i][j] = curScanner.next().charAt(0);
                        realColumn = j + 1;
                    }
                } catch (NoSuchElementException e) {
                    throw new IOException("Inaccurate number of columns of cheese in the file. Saw " + realColumn + " expected " + this.columns);
                }
            }
            this.grid = charMap;
            this.boxNum = mapFile.nextInt();
            this.cheeseNum = mapFile.nextInt();
            if (this.boxNum == 0) throw new IOException("No boxes on grid");
            this.cheesePositions = new int[this.cheeseNum][2];
            int eNum = 0;
            try {
                for (int i = 0; i < this.cheeseNum; ++i) {
                    this.cheesePositions[i][0] = Integer.parseInt(String.valueOf(mapFile.next()));
                    this.cheesePositions[i][1] = Integer.parseInt(String.valueOf(mapFile.next()));
                    eNum = i;
                }
            } catch (NoSuchElementException e) {
                throw new IOException("Inaccurate number of rows of cheese positions in the file. Saw " + eNum + " expected " + this.cheeseNum);
            }
        } catch (FileNotFoundException e) {
            throw new IOException("The file " + filename + " was not found");
        } catch (NumberFormatException e) {
            throw new IOException("No dimension to read");
        }
    }
}
