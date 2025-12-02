public class ControlIf {
    public void ifStatment(){
        if(true);
        if(true) System.out.println("true");
        if(true)
            System.out.println("true 2");
        if(false) System.err.println("false");
    }
    public void ifElseStatment(){
        int intVal = 10;

        if(intVal > 5) System.out.println("bigger than 5");
        else System.out.println("smaller or equal than 5");

        if(intVal <= 5)
            System.out.println("smaller or equal than 5");
        else
            System.out.println("bigger than 5");
    }
    public void ifAndOr(){
        int age = 25;
        boolean isMarried = true;

        if(age > 25 && isMarried){
            System.out.println("age over 25 and Married");
        }
        if(age > 25 || isMarried){
            System.out.println("age over 25 or Married");
        }
    }
    public void controlIfAndOr(){
        int age = 25;
        boolean isMarried = true;
        double height = 180;

        if(age > 25 || isMarried && height >= 180){
            // == if((age > 25 || isMarried) && height >= 180)
            System.out.println("t");
        }
    }
    public void elseIf(int p){
        if(p >= 90){
            System.out.println("A");
        }
        else if(p >= 80){
            System.out.println("B");
        }
        else if(p >= 70){
            System.out.println("C");
        }
        else{
            System.out.println("D");
        }
    }

    public void elseIf2(int p){
        String result = p > 90 ? "A" : p > 80 ? "B" : p > 70 ? "C" : "D"; 

        System.out.println(result);
    }

    public static void main(String[] args){
        ControlIf control = new ControlIf();
        control.ifStatment();
        control.ifElseStatment();
    }
}
