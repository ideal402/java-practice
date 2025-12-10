public class ArrayNewFor {
    public static void main(String[] args){
        ArrayNewFor array = new ArrayNewFor();
        array.newFor();
    }

    public void newFor(){
        int[] temp = {1,2,3,5,6,7};
        
        for(int x: temp){
            System.out.println(x);
        }
    }
}
