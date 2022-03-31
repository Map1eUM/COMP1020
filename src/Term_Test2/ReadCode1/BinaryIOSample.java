package Term_Test2.ReadCode1; /**
 * Illustrate reading and writing binary (non-text) files
 */

import java.io.*;

public class BinaryIOSample {

    public static void main(String[] args) throws IOException {

        //First create such a file. I'll name it ".txt" but it really isn't.
        DataOutputStream out = new DataOutputStream(
                new FileOutputStream("rawData.txt"));
        for (int i = 1; i <= 10; i++)
            out.writeInt(i * 111111111); //Make the numbers fairly big
        out.writeUTF("The End"); //Put a String at the end, just for fun.
        out.close();

        //Go take a look at this file with a text editor!

        //Now we'll read it back in.
        DataInputStream in = new DataInputStream(
                new FileInputStream("rawData.txt"));
        System.out.println("Reading back the file:");
        for (int i = 1; i <= 10; i++)
            System.out.println(in.readInt());
        System.out.println(in.readUTF());
        in.close();

    }//main

}//BinaryIOSample
