import java.util.Scanner;
public class GameOfThrones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your favourite GOT character and i will give you his/hers best quote");
        String Character = sc.nextLine();

        switch(Character){
            case "Arya Stark" : System.out.println("A girl is Arya Stark of Winterfell, and I'm going home.");
            break;
            case "Jon Snow" : System.out.println("When enough people make false promises, words stop meaning anything. Then there are no more answers, only better and better lies");
            break;
            case "Tyrion Lannister" : System.out.println("A mind needs books as a sword needs a whetstone, if it is to keep its edge");
            break;
            case "Cersei Lannister" : System.out.println("When you play the game of thrones, you win or you die. There is no middle ground.");
            break;
            case "Daenerys Targaryen" : System.out.println("I am not going to stop the wheel. I am going to break the wheel");
            break;
            case "Ned Stark" : System.out.println("The man who passes the sentence should swing the sword.");
            break;
            case "Brienne of Tarth" : System.out.println("Nothing's more hateful than failing to protect the one you love");
            break;
            case "Petyr Baelish" : System.out.println("Chaos isn't a pit. Chaos is a ladder");
            break;
            case "The Hound" : System.out.println("F*ck the king");
            break;
            case "Tywin Lannister" : System.out.println(" Any man who must say 'I am the king' is no true king.    A lion does not concern himself with the opinion of sheep. ");
            break;
            case "Maester Aemon" : System.out.println("What is honour compared to a woman's love?.   Kill the boy , jon snow, kill the boy and let the MAN be born ");
            break;
            case "Jorah Mormont" : System.out.println("The common people pray for rain, healthy children, and a summer that never ends");
            break;
            case "Lord Varys" : System.out.println("Power resides where men believe it resides. Its a trick. A shadow on the wall. And a very small man can cast a very large shadow");
            break;
            case "Sansa Stark" : System.out.println(" When the snows fall and the white winds blow, the lone wolf dies, but the pack survives ");
            break;
            case "Robb Stark" : System.out.println("Tell Lord Tywin winter is coming for him. Twenty thousand northerners marching south to find out if he really does sh*t gold\r\n" + //
                                "");
            break;
            case "Jamie Lannister" : System.out.println(" The things I do for love ");
            break;
            default : System.out.println("Invalid Character");
            sc.close();
        }
    }
}
