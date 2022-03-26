package Assignment2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BigCity {
    private int rows, columns;

    private int boxNum, cheeseNum, xPos, yPos;

    private int[][] cheesePositions;
    private char[][] grid;
    private boolean mark[][];

    private int getCheeseNum, moveMade;
    private boolean isFree;

    private char[][][] rev = new char[5][][]; //no need to initialise in constructor since we know size is constant.
    private int step = 0;
    //for processMove usage...
    private int newX, newY;

    //-----------------phase 7----------------------------------------
    private void saveGrid() {
        if (step == 0) {
            step++;
            this.rev[0] = this.grid;
            return;
        }
        //this is actually a stack...
        for (int i = step - 1; i >= 0; --i) {
            if (i + 1 >= 5) continue;
            this.rev[i + 1] = this.rev[i];
        }
        this.rev[0] = this.grid;
        step++;
    }

    public void undo() {
        if (this.step == 0) return;
        this.grid = this.rev[0];
        if (step == 1) step = 0;
        else {
            for (int i = 0; i < step - 1; ++i)
                this.rev[i] = this.rev[i + 1];
            step--;
        }
    }

    public BigCity(int rows, int cols, int numBoxes, int numCheese, int[][] cheesePositions) {
        this.rows = rows;
        this.columns = cols;
        this.boxNum = numBoxes;
        this.cheeseNum = numCheese;
        this.cheesePositions = cheesePositions;
        this.grid = new char[this.rows][this.columns];
        this.mark = new boolean[this.rows][this.columns];
        this.getCheeseNum = 0;
        this.moveMade = 0;
        this.isFree = true;
        this.xPos = this.yPos = 0;
        fillGrid();
    }

    //--------------------------phrase 3-----------------------------------------
    private void processMove(char dir) {
        saveGrid();

        if (this.grid[newX][newY] == '.') this.moveMade++;
        else if (this.grid[newX][newY] == 'b') {
            this.moveMade++;
            if (isBoxCheese(newX,newY))
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
//--------------------------phrase 3-----------------------------------------

    //-------------------------------------------phrase 4--------------------------------
    private void endTerror() {
        //game ended
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
    char[] extractRow(int rowNum) throws DataDoesNotExistException {
        if (rowNum >= this.rows || rowNum < 0)
            throw new DataDoesNotExistException("BigCity grid does not have a row index of" + rowNum);
//        } catch (DataDoesNotExistException e) {
//            e.printStackTrace();
//        }
        return this.grid[rowNum];
    }

    char[] extractColumn(int colNum) throws DataDoesNotExistException {
        if (colNum >= this.columns || colNum < 0)
            throw new DataDoesNotExistException("BigCity grid does not have a column index of " + colNum);
//        } catch (DataDoesNotExistException e) {
//            e.printStackTrace();
//        }
        char[] ans = new char[this.rows];
        for (int i = 0; i < this.rows; ++i)
            ans[i] = this.grid[i][colNum];
        return ans;
    }

    //---------------------------------------------------------------------
    public String toString() {

        //-------------Test Phase 3 print--------------------------
        for (int i = 0; i < this.rows; ++i) {
            for (int j = 0; j < this.columns; ++j)
                System.out.print(this.grid[i][j]+" ");
            System.out.println();
        }
        //-----------------------------------------------------------


        //--------------------------------Phase 1 and 7 part of toString require---------------------------------
        String S = String.format("s at (%d,%d),\nb at ", this.xPos, this.yPos);

        for (int i = 0; i < this.cheeseNum; ++i)
            S += String.format("(%d,%d)", this.cheesePositions[i][0], this.cheesePositions[i][1]) + (i == this.cheeseNum - 1 ? "\n" : ", ");
        S += "and " + (this.boxNum - this.cheeseNum) + " random b's\n";
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
    public BigCity (String filename) throws IOException {
        this.xPos = this.yPos = 0;
        this.getCheeseNum = 0;
        this.moveMade = 0;
        this.isFree = true;
        int ct=0;
        try {
            Scanner mapFile = new Scanner(new BufferedReader(new FileReader(filename)));
//            String test1 = mapFile.nextLine();
//            if (test1.charAt(0) == 's') throw new IOException("No dimension to read");
            //-------------------------------------------------------------------------------
            int[] readInt = new int[2];
            readInt[0] = mapFile.nextInt();
            readInt[1] = mapFile.nextInt();
            this.rows = readInt[0];
            this.columns = readInt[1];
//            System.out.println(readInt[0]);
//            System.out.println(readInt[1]);
            System.out.print(mapFile.nextLine()); //get away with \n
            char[][] charMap = new char[readInt[0]][readInt[1]];
            for (int i = 0; i < this.rows; ++i) {
                String newLine = mapFile.nextLine();
                ct++;
//                System.out.println(newLine.length());
                if (newLine.length() / 2 + 1 != this.columns)
                    throw new IOException("Inaccurate number of columns of cheese in the file. Saw " + (newLine.length() / 2 + 1) + " expected " + this.columns);
                for (int j = 0; j < newLine.length(); j += 2)
                    charMap[i][j / 2] = newLine.charAt(j);
            }


            this.grid = charMap;
            this.boxNum = mapFile.nextInt();
            this.cheeseNum = mapFile.nextInt();
            this.cheesePositions = new int[this.cheeseNum][2];
            try {
                for (int i = 0; i < this.cheeseNum; ++i) {
                    //remember to add exception if there are less than cheeseNum lines.
                    this.cheesePositions[i][0] = mapFile.nextInt();
                    this.cheesePositions[i][1] = mapFile.nextInt();
                    //the right data already marked all cheese cheesePositions in map!
//                this.grid[this.cheesePositions[i][0]][this.cheesePositions[i][1]] = 'b';
                }
            } catch (NoSuchElementException e) {
                System.out.println("No grid to read");
            }
        } catch (FileNotFoundException e) {
//                e.printStackTrace();
            System.out.println("The file " + filename + " was not found");
        } catch (InputMismatchException e) {
//            throw new IOException(" java.io.IOException: No dimension to read");
            if(this.rows!= ct) {
                System.out.println("Inaccurate number of rows of cheese positions in the file. Saw 0 expected 1");
            }
            System.out.println("No dimension to read");
        }
    }
//------------------------------------------------------------------------------------------------------

}
