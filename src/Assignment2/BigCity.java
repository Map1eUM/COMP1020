package Assignment2;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class BigCity {
    int M, N;

    int boxNum, cheeseNum;

    int[][] positions;
    char[][] grid;

    void BigCity(int rows, int cols, int numBoxes, int numCheese, int[][] cheesePositions) {
        this.M = rows;
        this.N = cols;
        this.boxNum = numBoxes;
        this.cheeseNum = numCheese;
        this.positions = cheesePositions;
        fillGrid();
    }

    void BigCity(String filename) {
        try {
            FileReader mapFile = new FileReader(filename);
            if(5<10) {
                throw new Exception("Oh NO");
            }
            //write all reading functionality code here

        } catch (FileNotFoundException e) {
            System.out.println("File specified was not found");
        } catch (Exception e){
            //identify all the possible systematic exceptions

        }
    }

        private boolean isValid(int x, int y) {
        for (int i = 0; i < this.cheeseNum; ++i) {
            if (x == this.positions[i][0] && y == this.positions[i][1]) return false;
        }
        return true;
    }

    public String toString() {
        String S = "This city is " + this.M + "x" + this.N + "size and contain cheese at these positions:";
        for (int i = 0; i < this.cheeseNum; ++i)
            S += String.format("(%d,%d)", this.positions[i][0], this.positions[i][1]);
        return S;

    }

    private void fillGrid() {
        grid = new char[this.M][this.N];
        this.grid[0][0] = 's';
        int fil = this.boxNum - this.cheeseNum;
        for (int i = 0; i < this.cheeseNum; ++i) this.grid[this.positions[i][0]][this.positions[i][1]] = 'b';
        while (fil > 0) {
            int x = (int) (Math.random() % this.M);
            int y = (int) (Math.random() % this.N);
            if (isValid(x, y)) {
                this.grid[x][y] = 'b';
                fil--;
            }
        }
        for (int i = 0; i < this.M; ++i) {
            for (int j = 0; j < this.N; ++j) {
                if (this.grid[i][j] != 'b') this.grid[i][j] = '.';
            }
        }

    }
}
