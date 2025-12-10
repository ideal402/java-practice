public class ArrayInitalize {

    public static void main(String[] args){
        ArrayInitalize array = new ArrayInitalize();
        array.otherInit();
        System.out.println(array.getMonth(3));
    }
    
    public void otherInit(){
        int [] lottoNumbers = {1, 2, 3, 4, 5, 6};

        //int [] lottoNumbers;
        //lottoNumbers = {1, 2, 3, 4, 5, 6}; // complie error

        System.out.println(lottoNumbers[0]);

    }

    public String getMonth(int monthInt){
        String [] month = {"jan","feb","mar","apr","may"};

        return month[monthInt];
    }
}
