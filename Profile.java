public class Profile {
    String name;
    int age;

    public void setName(String str){
        name = str;
    }
    public void setAge(int val){
        age = val;
    }
    public void printName(){
        System.out.println(name);
    }
    public void printAge(){
        System.out.println(age);
    }

    public void main(String[] args){
        Profile profile = new Profile();
        
        String name = "min";
        int age = 20;
        
        profile.setName(name);
        profile.setAge(age);

        profile.printName();
        profile.printAge();

    }

}
