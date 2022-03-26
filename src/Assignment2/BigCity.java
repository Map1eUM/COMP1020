package Assignment2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BigCity {
    private int rows, columns;

    private int boxNum, cheeseNum, xPos, yPos;

    private int[][] cheesePositions;
    private char[][] grid;

    private int getCheeseNum, moveMade;
    private boolean isFree;

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

    //--------------------------phrase 3-----------------------------------------
    public void processMove(char dir) {
        //if game ended, return
        if (!this.isFree) return;
        //reminder that X is first dimension
        int newX, newY;
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

        if (newX < 0 || newX >= this.rows || newY < 0 || newY >= this.columns) throw new IndexOutOfBoundsException();

        if (this.grid[newX][newY] == '.') this.moveMade++;
        else if (this.grid[newX][newY] == 'b') {
            if (isBoxCheese(newX, newY))
                this.getCheeseNum++;
            else endTerror();
        }

        this.grid[this.xPos][this.yPos] = '.';
        this.grid[newX][newY] = 's';
        this.xPos = newX;
        this.yPos = newY;
    }
//--------------------------phrase 3-----------------------------------------

    //-------------------------------------------phrase 4--------------------------------
    private void endTerror() {
        this.isFree = false;
    }

    public boolean isRoamingCity() {
        return this.isFree;
    }

    private boolean isBoxCheese(int row, int col) {
        for (int i = 0; i < this.cheeseNum; ++i) {
            if (row == this.cheesePositions[i][0] && col == this.cheesePositions[i][1])
                return true;
        }
        return false;
    }

    private boolean isValid(int x, int y) {
        for (int i = 0; i < this.cheeseNum; ++i) {
            if (x == this.cheesePositions[i][0] && y == this.cheesePositions[i][1]) return false;
        }
        return true;
    }

    //---------------------phase 5--------------------------------------
    char[] extractRow(int rowNum) {
        if (rowNum >= this.rows || rowNum < 0) try {
            throw new DataDoesNotExistException("BigCity grid does not have a row index of" + rowNum);
        } catch (DataDoesNotExistException e) {
            e.printStackTrace();
        }
        return this.grid[rowNum];
    }

    char[] extractColumn(int colNum) {
        if (colNum >= this.columns || colNum < 0) try {
            throw new DataDoesNotExistException("BigCity grid does not have a column index of " + colNum);
        } catch (DataDoesNotExistException e) {
            e.printStackTrace();
        }
        char[] ans = new char[this.rows];
        for (int i = 0; i < this.rows; ++i)
            ans[i] = this.grid[i][colNum];
        return ans;
    }

    //---------------------------------------------------------------------
    public String toString() {
        String S = "s at (0,0),\nb at ";

        for (int i = 0; i < this.cheeseNum; ++i)
            S += String.format("(%d,%d)", this.cheesePositions[i][0], this.cheesePositions[i][1]) + (i == this.cheeseNum - 1 ? "\n" : ", ");
        S += "and " + (this.boxNum - this.cheeseNum) + " random b's";
        if (!isFree && (this.cheeseNum - this.getCheeseNum) > 0)
            S += "Suzie's reign of terror came to an end abruptly after just " + this.moveMade + " move. She was captured with " + this.getCheeseNum + " cheese crumbs on her person";
        else if (!isFree && this.cheeseNum == this.getCheeseNum)
            S += "Suzie outsmarted the exterminators, making " + this.moveMade + " moves and collecting all " + this.getCheeseNum + " cheese crumbs. She sniffed out the " + (this.boxNum - this.cheeseNum) + " traps."
        return S;

    }

    private void fillGrid() {
        for (int i = 0; i < this.rows; ++i) {
            for (int j = 0; j < this.columns; ++j) {
                this.grid[i][j] = '.';
            }
        }
        this.grid[0][0] = 's';
        int fil = this.boxNum - this.cheeseNum; //this is only for phrase 1
        for (int i = 0; i < this.cheeseNum; ++i)
            this.grid[this.cheesePositions[i][0]][this.cheesePositions[i][1]] = 'b';
        while (fil > 0) {
            int x = (int) (Math.random() % this.rows);
            int y = (int) (Math.random() % this.columns);
            if (isValid(x, y)) {
                this.grid[x][y] = 'b';
                fil--;
            }
        }
    }

    //------------------------------CONSTUCTOR BY FILE-----------------------------------------------------
    public BigCity(String filename) {
        this.xPos = this.yPos = 0;
        this.getCheeseNum = 0;
        this.moveMade = 0;
        this.isFree = true;
        try {
            Scanner mapFile = new Scanner(new BufferedReader(new FileReader(filename)));
//            String test1 = mapFile.nextLine();
//            if (test1.charAt(0) == 's') throw new IOException("No dimension to read");


            int[] readInt = new int[2];
            readInt[0] = mapFile.nextInt();
            readInt[1] = mapFile.nextInt();
            char[][] charMap = new char[readInt[0]][readInt[1]];
            for (int i = 0; i < readInt[0]; ++i) {
                String newLine = mapFile.nextLine();
                if (newLine.length() != this.columns + 1) throw new IOException("Bad dimensions for the grid");
                for (int j = 0; j < readInt[1]; ++j)
                    charMap[i][j] = newLine.charAt(j);
            }


            this.grid = charMap;
            this.rows = readInt[0];
            this.columns = readInt[1];
            this.boxNum = mapFile.nextInt();
            this.cheeseNum = mapFile.nextInt();

            for (int i = 0; i < this.cheeseNum; ++i) {
                //remember to add exception if there are less than cheeseNum lines.
                this.cheesePositions[i][0] = mapFile.nextInt();
                this.cheesePositions[i][1] = mapFile.nextInt();
                //the right data already marked all cheese cheesePositions in map!
//                this.grid[this.cheesePositions[i][0]][this.cheesePositions[i][1]] = 'b';
            }
            //initialise the grid for final step
//            fillGrid();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InputMismatchException e) {
//            throw new IOException(" java.io.IOException: No dimension to read");
            System.out.println("java.io.IOException: No dimension to read\"");
        }
    }
//------------------------------------------------------------------------------------------------------

}
