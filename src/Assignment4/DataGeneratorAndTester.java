package Assignment4;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import static processing.core.PApplet.max;
import static processing.core.PApplet.println;


public class DataGeneratorAndTester {
    static String result;
    static final int MAXLEN = 2000;
    static final int MAXOPS = 2000;

    public static String RandStr() {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random nxt = new Random(12410415L);
        int len = nxt.nextInt(40, 80);
        int targetStringLength = len;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        return generatedString;
    }

    public static void print(FileWriter out1, FileWriter out2, DoublyLinkedList mylst1, ArrayList<Number> myArr) throws IOException {
        int len = mylst1.size();
        out1.write(mylst1.toString());

        out2.write("<< ");
        for (Number x : myArr) {
            out2.write(String.valueOf(x) + " ");
        }
        out2.write(">>");
        out1.write("\n One print End\n");
        out2.write("\n One print End\n");
//        out1.close();
//        out2.close();
    }

    public static void print(FileWriter out1, FileWriter out2, Number x1, Number x2) throws IOException {

        out1.write("\n---------MAX:" + String.valueOf(x1.doubleValue()) + "------\n");
        out2.write("\n---------MAX:" + String.valueOf(x2.doubleValue()) + "------\n");
    }

    public static void Test() throws IOException {
        FileWriter fw = new FileWriter("C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\Assignment4\\testData.txt");
        Random rand = new Random();
        for (int i = 0; i < MAXLEN / 1; ++i) {
            int type = rand.nextInt(1, 3);
//            if(type==1) {
            int x = rand.nextInt(1000, 2000);
//            println(x);
            if (x <= 1200) {
                fw.write(RandStr());
                fw.write(' ');
            } else {
                fw.write(String.valueOf(x));
                fw.write(' ');
            }
//            }
            if (i % 100 == 0) fw.write('\n');
        }
        fw.close();

        //----------------------Test p2---------------------------
        String fn1 = "C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\Assignment4\\out1";
        String fn2 = "C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\Assignment4\\out2";
        DoublyLinkedList mylst1;
        mylst1 = DoublyLinkedList.createList("C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\Assignment4\\testData.txt");
        ArrayList<Number> myArr = myTest.setMyLst("C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\Assignment4\\testData.txt");
//       println(mylst1.size());
//       println(myArr.size());
        //test phase 2(actually trivial)-----------------------
        FileWriter out1 = new FileWriter(fn1);
        FileWriter out2 = new FileWriter(fn2);
        FileWriter resultWriter = new FileWriter("C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\Assignment4\\testingResult");
        int len = mylst1.size();
        print(out1, out2, mylst1, myArr);
//        compare(fn1, fn2);


//
//        //--------------------------------------------P1
//        //About add front and addEnd, size()


        for (int i = 1; i < MAXOPS / 1; ++i) {
            int x = rand.nextInt(1, len);
            Number getVal = myArr.get(x);
            int op = rand.nextInt(1, 2);
            if (op == 1) {
                myArr.add(getVal);
                mylst1.addEnd(getVal);
            } else if (op == 2) {
                myArr.add(0, getVal);
                mylst1.addFront(getVal);
            }
            if (i % 100 == 0)
                print(out1, out2, mylst1, myArr);
        }

        //??
//        out2.write("\n");
        //------------------P3 test---------------------------------------
        len = mylst1.size();
        if (len != myArr.size()) println("????????????AWAHAWUHAW");
        for (int i = 1; i < len; ++i) {
            int id = rand.nextInt(0, mylst1.size() - 1);
            mylst1.remove(id);
            myArr.remove(id);
            if (i % 100 == 0) print(out1, out2, mylst1, myArr);
//            int res = compare(fn1
//            if (i % 50 == 0) {
//                //Testing for the maximum number
////                println("COME HERE?");
//                print(out1, out2, mylst1.findMax().getData(), maxArr(myArr));
//                println(mylst1.findMax().getData(), maxArr(myArr));
//                result+="MAX TEST:\n";
////                compare(fn1, fn2);
//
//                myArr=sort(myArr);
//                mylst1.insertionSort();
//                result+="SORT TEST:\n";
//                print(out1,out2,mylst1,myArr);
////                compare(fn1, fn2);
//            }
        }
        compare(fn1, fn2);
        resultWriter.close();
        out1.close();
        out2.close();
        //-----------------P4 P5 is bit complicated-----------------------------------
        //it will be inside  above too!
    }

    public static void main(String[] ars) throws IOException {
        for (int i = 1; i <= 2; ++i) {
            Test();
            result += "One Full Test End\n";
        }
        FileWriter fw = new FileWriter("C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\Assignment4\\testingResult");
        fw.write(result);
        fw.close();

    }

    public static ArrayList<Number> sort(ArrayList<Number> arr) {

        ArrayList<Number> ans = new ArrayList<>();
        while (arr.size() > 0) {
            Number minVal = 99912412;
            for (Number x : arr) {
                if (x.doubleValue() < minVal.doubleValue()) {
                    minVal = x;
                }
            }
            ans.add(minVal);
            arr.remove(minVal);
        }
        return ans;
    }

    public static ArrayList<Number> sortArr(ArrayList<Number> arr) {
        ArrayList<Number> ar1 = new ArrayList<>();
        ArrayList<Number> ar2 = new ArrayList<>();
        ArrayList<Number> ar3 = new ArrayList<>();
        ArrayList<Number> ans = new ArrayList<>();
        for (Number x : arr) {
            if (x instanceof Integer) ar1.add(x);
            else if (x instanceof Long) ar2.add(x);
            else if (x instanceof Double) ar3.add(x);
            else {
                println("SERIOUS PROBLEM!");
            }
        }
        ar1 = sort(ar1);
        ar2 = sort(ar2);
        ar3 = sort(ar3);

        for (Number x : ar1)
            ans.add(x);
        for (Number x : ar2)
            ans.add(x);
        for (Number x : ar3)
            ans.add(x);

        return ans;
    }

    public static Number maxArr(ArrayList<Number> arr) {
        ArrayList<Number> ar1 = new ArrayList<>();
        ArrayList<Number> ar2 = new ArrayList<>();
        ArrayList<Number> ar3 = new ArrayList<>();
        for (Number x : arr) {
            if (x instanceof Integer) ar1.add(x);
            else if (x instanceof Long) ar2.add(x);
            else if (x instanceof Double) ar3.add(x);
            else {
                println("SERIOUS PROBLEM!");
            }
        }
        ar1 = sort(ar1);
        ar2 = sort(ar2);
        ar3 = sort(ar3);

        if (ar3.size() > 0) return ar3.get(ar3.size() - 1);
        if (ar2.size() > 0) return ar2.get(ar2.size() - 1);
        if (ar1.size() > 0) return ar1.get(ar1.size() - 1);
        return null;
    }


    public static int compare(String fn1, String fn2) throws FileNotFoundException, IOException {

        File f1 = new File(fn1);// OUTFILE
        File f2 = new File(fn2);// INPUT

        FileReader fR1 = new FileReader(f1);
        FileReader fR2 = new FileReader(f2);

        BufferedReader reader1 = new BufferedReader(fR1);
        BufferedReader reader2 = new BufferedReader(fR2);

        String line1 = null;
        String line2 = null;
        int flag = 1;
        while ((flag == 1) && ((line1 = reader1.readLine()) != null)
                && ((line2 = reader2.readLine()) != null)) {
            if (!line1.equalsIgnoreCase(line2))
                flag = 0;
        }
        reader1.close();
        reader2.close();
//        System.out.println("Flag " + flag);
        result += "Flag " + flag + "\n";
        return flag;
    }


}
