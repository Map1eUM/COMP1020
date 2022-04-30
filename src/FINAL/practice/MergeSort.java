package FINAL.practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static processing.core.PApplet.print;
import static processing.core.PApplet.println;

public class MergeSort {
    static final int size = (int) 1e5 + 5;
    int length;
    int[] data = new int[size]; // this is not a good practice. better in constructor.

    public int[] MergeSort() {
        return this.data = MergeSortRec(0, length-1);
    }

    public MergeSort(String path) throws FileNotFoundException {
        //you need filereader!
        Scanner r = new Scanner(new FileReader(path));
        length = 0;
        while (r.hasNext()) {
            if (r.hasNextInt()) {
                this.data[length++] = r.nextInt();
            }
            else {
                //here! why you didn't find it?
                r.next();
            }
        }
    }
    public String toString() {
        String S = "";
        for (int i = 0; i < length; ++i) {
            S += this.data[i]+" ";
        }
        return S;
    }

    public int[] MergeSortRec(int l, int r) {
        if (l == r) {
            int[] x = new int[1];
            x[0] = data[l];
            return x;
        }
        int mid = l + r >> 1;
        int[] arr1 = MergeSortRec(l, mid);
        int[] arr2 = MergeSortRec(mid + 1, r);
        int[] ans = new int[arr1.length + arr2.length];
        int p1 = 0, p2 = 0, p3 = 0;
        while (p1 < arr1.length && p2 < arr2.length) {
            if (arr1[p1] < arr2[p2]) ans[p3++] = arr1[p1++];
            else ans[p3++] = arr2[p2++];
        }
        while (p1 < arr1.length) ans[p3++] = arr1[p1++];
        while (p2 < arr2.length) ans[p3++] = arr2[p2++];
        return ans;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        MergeSort dt = new MergeSort("C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\FINAL\\practice\\data");
//        System.out.println(dt);
//        println(dt.MergeSort());
    }
}
