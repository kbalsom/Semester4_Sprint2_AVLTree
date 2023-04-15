package keyin.org;

import java.util.Arrays;
import java.util.Scanner;
import org.json.simple.JSONObject;



public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AVL avl = new AVL();
        BST bst = new BST();

        System.out.println("Enter a series of numbers separated by spaces:");
        String input = scanner.nextLine();

        String[] numbers = input.split(" ");
        for (String number : numbers) {
            avl.insert(Integer.parseInt(number));
        }

        String[] bnumbers = input.split(" ");
        for (String number : bnumbers) {
            bst.insert(Integer.parseInt(number));
        }

        System.out.println(Arrays.toString(bnumbers));

        String json = avl.getJSONRepresentation();
        System.out.println(json);

        String bstjson = bst.getJSONRepresentation();
        System.out.println(bstjson);

//
//        JSONObject avljson = avl.toJson(avl.getRoot());
//
//        System.out.println(avl.getRoot());
////        System.out.println(avljson.toJSONString());
//
////        JSONObject bstjson = bst.toJson(avl.getRoot());
////        System.out.println(bstjson.toJSONString());

    }}





