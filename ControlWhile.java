public class ControlWhile {
    public static void main(String[] args){
        ControlWhile control = new ControlWhile();
        control.whileLoop1();
    }
    public void whileLoop1(){
        ControlSwitch control = new ControlSwitch();

        int loop = 0;

        while(loop < 4){
            loop++;
            if(loop == 2) continue;
            control.switchStatement(loop);
            if(loop == 3) break;
        }
    }
}
