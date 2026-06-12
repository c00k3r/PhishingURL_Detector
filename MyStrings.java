public class MyStrings {
    private String name;
    private int age;
    public MyStrings(String name, int age){
        this.name = name;
        this.age = age;
        }
        public String toString() {
            return "MyStrings{name =" +name+ " age= " +age+ " }";

        }
        public static void main(String[] args) {
            MyStrings s1 = new MyStrings("Moksh", 18);
            System.out.println(s1);
        }
    }

