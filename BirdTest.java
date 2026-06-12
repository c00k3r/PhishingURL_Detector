 interface Flyable {
    void Fly();
}
abstract class Bird implements Flyable{
    String name;
    Bird(String name){
        this.name = name;
    }
    void eat(){
        System.out.println(name + " is eating");
    }
}
class Eagle extends Bird{
    Eagle(String name){
        super(name);
    }
    @Override
    public void Fly(){
        System.out.println(name + " roars high in the sky with powerful wings!! ");
    }
}
    public class BirdTest{
        public static void main(String[] args) {
            Eagle eagle = new Eagle("Soul Stealer");
            eagle.Fly();
            eagle.eat();
        }
    }

