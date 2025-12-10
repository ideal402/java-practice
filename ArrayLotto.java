public class ArrayLotto {

    public static void main(String[] args){
        ArrayLotto array = new ArrayLotto();
        array.init();

    }

    public void init(){
        int [] lottoNumbers = new int[7];

        for(int i=0; i<7; i++){
            double randonNum = Math.random();
            int ranNum = (int)(randonNum*60);
    
            lottoNumbers[i] = ranNum;
        }
    }
}

