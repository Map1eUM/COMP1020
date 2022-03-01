package Lab04;

/**
 * A class for rectangular arrays full of random
 * positive integers.
 */

public class RandomArray {

    //An instance variable to hold an array of integers
    //****YOUR CODE HERE****
    private int[][] array2D;

    public RandomArray(int rows, int cols, int range) {
        /* Construct a random array with the given number of
         * rows and columns, filled with random integers in
         * the range  0..range-1.
         * Use the expression (int)(range*Math.random())
         */
        //****YOUR CODE HERE****
        this.array2D = new int[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                array2D[i][j] = (int) (range * Math.random());
            }
        }

    }//constructor

    public int[] getRow(int r) {
        //Return a copy (clone) of row r of the array
        //****YOUR CODE HERE****
        int[] newArr = new int[this.array2D[r].length];
        System.arraycopy(this.array2D[r], 0, newArr, 0, this.array2D[r].length);
        return newArr; //DUMMY - REMOVE
    }//getRow method

    public int[] getCol(int c) {
        //Return an int[] array containing the numbers from column c.
        //****YOUR CODE HERE****
        int[] newArr = new int[this.array2D.length];
        for (int i = 0; i < this.array2D.length; ++i) {
            newArr[i] = this.array2D[i][c];
        }
        return newArr;
        //DUMMY - REMOVE
    }//getCol method

}//RandomArray class
