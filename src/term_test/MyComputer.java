package term_test;

public class MyComputer {
    private int numProcessors;
    private String brandName;
    private int[] memorySlots;
    public static final int NUM_MEM_SLOTS = 4;

    public MyComputer(int nproc, String brand) {
        numProcessors = nproc;
        brandName = brand;
        memorySlots = new int[NUM_MEM_SLOTS];
    }

    public void setMemSlot(int slotNum, int amountOfMemory) {
        if (slotNum < NUM_MEM_SLOTS)
            memorySlots[slotNum] = amountOfMemory;
    }

    public MyComputer clone() {
        MyComputer newOb = new MyComputer(this.numProcessors, this.brandName);
        for (int i = 0; i < NUM_MEM_SLOTS; ++i) newOb.memorySlots[i] = this.memorySlots[i];
        return newOb;
    }

    public static void main(String[] args) {
        MyComputer x = new MyComputer(20, "24");
        MyComputer y = x.clone();
        System.out.println(y.brandName);
    }
}