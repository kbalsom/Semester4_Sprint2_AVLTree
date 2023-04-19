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

//        String[] numbers = input.split(" ");
//        for (String number : numbers) {
//            bst.insert(Integer.parseInt(number));
//        }

        String[] numbers = input.split(" ");
        for (String number : numbers) {
            int n = Integer.parseInt(number);
            avl.insert(n);
            bst.insert(n);
        }


        String json = avl.getJSONRepresentation();
        System.out.println("AVL TREE: " + json);

        String bstjson = bst.getJSONRepresentation();
        System.out.println("BST TREE: " + bstjson);

//
//        JSONObject avljson = avl.toJson(avl.getRoot());
//
//        System.out.println(avl.getRoot());
////        System.out.println(avljson.toJSONString());
//
////        JSONObject bstjson = bst.toJson(avl.getRoot());
////        System.out.println(bstjson.toJSONString());

    }}





