public class ArrayLength {
    public static void main(String[] args){
        ArrayLength array = new ArrayLength();
        array.printArrayLength();
    }

    public void printArrayLength(){
        int [] oneDim = new int[3];
        int[][] twoDim = new int[2][3];
        System.out.println(oneDim.length);
        System.out.println(twoDim.length);
    }
}
