public class Car {
    int speed;
    int distance;
    String color;
    public Car(){
        speed = 0;
        distance = 0;
        color = "red";
    }
    public void speedUp(){
        speed += 5;
        distance += speed;
    }
    public void breakDown(){
        speed -= 10;
    }
    public int getCurrentSpeed(){
        return speed;
    }
}
