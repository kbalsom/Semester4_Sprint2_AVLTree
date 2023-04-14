package keyin.org;

import java.util.Arrays;
import java.util.Scanner;
import org.json.simple.JSONObject;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AVL avl = new AVL();

        System.out.println("Enter a series of numbers separated by spaces:");
        String input = scanner.nextLine();

        String[] numbers = input.split(" ");
        for (String number : numbers) {
            avl.insert(Integer.parseInt(number));
        }

        JSONObject json = avl.toJson(avl.getRoot());
        System.out.println(json.toJSONString());


    }}



