public class OperatorCasting {
    public static void main(String[] args){
        OperatorCasting operator = new OperatorCasting();
        operator.casting();
    }

    public void casting(){
        byte byteVal = 127;
        short shortVal = byteVal;

        shortVal++;
        System.out.println(shortVal);
        byteVal = (byte)shortVal;
        System.out.println(byteVal);
    }
}
