public class Person{
    private String name;
    private int age;

public Person(String name, int age){
    this.name=name;
    this.age=age;
}

@Override
public boolean equals(Object obj){
    if(this==obj){
        return true;
    }
    if(obj==null || getClass() != obj.getClass()){
        return false;
    }
    Person other = (Person) obj;
    return age == other.age && name.equals(other.name);
}

@Override
public int hashCode(){
    return name.hashCode() + Integer.hashCode(age);
}


    public static void main(String[] args) {
        Person p1 = new Person("Moksh", 18);
        Person p2 = new Person("Moksh", 18);
        Person p3 = new Person("Diya", 18);
        System.out.println("p1 equals p2 : " + p1.equals(p2));
        System.out.println("p1 equals p3 : " + p1.equals(p3));
    }
}
