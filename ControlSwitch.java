public class ControlSwitch {
    public void switchStatement(int num){
        switch (num) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            default:
                System.out.println("exception");
                break;
        }
    }
    
    public static void main(String[] args){
        ControlSwitch control = new ControlSwitch();

        control.switchStatement(1);
        control.switchStatement(2);
        control.switchStatement(3);
        control.switchStatement(0);
    }
}
