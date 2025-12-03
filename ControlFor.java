public class ControlFor {
    public static void main(String[] args){
        ControlFor control = new ControlFor();
        control.forloop(10);
    }

    public void forloop(int until){
        int sum = 0;

        for(int i=1; i<=until; i++){
            sum += i;
            System.out.println(sum);
        }
    }
}
