package keyin.org;
import java.util.Scanner;


//Creates the Main Class:
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AVL avl = new AVL();
        BST bst = new BST();

        System.out.println("Enter a series of numbers separated by spaces:");
        String input = scanner.nextLine();


        String[] numbers = input.split(" ");
        for (String number : numbers) {
            int n = Integer.parseInt(number);
            avl.insert(n);
            bst.insert(n);
        }

        String avljson = avl.getJSONRepresentation();
        System.out.println("AVL TREE: " + avljson);

        String bstjson = bst.getJSONRepresentation();
        System.out.println("BST TREE: " + bstjson);

        JSONWriter jsonWriter = new JSONWriter("src/main/java/keyin/org/avlfile.json", "src/main/java/keyin/org/bstfile.json");
        jsonWriter.writeAVL(avljson);
        jsonWriter.writeBST(bstjson);

    }}





