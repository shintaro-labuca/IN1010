public class ArrayFyll {
    public static void main (String[] args) {
        int[] tall = new int[8];
        tall[0] = 0;
        tall[1] = 1;
        for (int i = 2; i < 8; i++) {
            tall[i] = tall[i-2] + tall[i-1]; 
        }

        for (int t : tall) {
            System.out.println(t);
        }
    }
}

// tall[0] = 0; 
// tall[1] = 1;
// tall[2] = 1;
// tall[3] = 2;
// tall[4] = 3;
// tall[5] = 5;
// tall[6] = 8;
// tall[7] = 13;
