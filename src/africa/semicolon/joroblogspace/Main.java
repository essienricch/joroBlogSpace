package africa.semicolon.joroblogspace;

import africa.semicolon.joroblogspace.controllers.PostController;
import africa.semicolon.joroblogspace.dtos.requests.CreatePostRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.util.Scanner;


@SpringBootApplication
public class Main {

   private static Scanner keyboardInput = new Scanner(System.in);

    private static PostController postController = new PostController();


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        //displayMainMenu();
    }

    private  static void displayMainMenu(){
        String mainMenu = """
                Press 1. To create post
                Press 2. To view post
                Press 3. To exit
                """;
        String userInput = input(mainMenu);

        switch (Integer.parseInt(String.valueOf(userInput.charAt(0)))){
            case 1 -> createPost();
            case 2 -> viewPost();
            case 3 -> existFromApp();
        }
    }
    private static void createPost(){
        String title = input("Enter Post Title");
        String body = input("Enter Post Body");
        CreatePostRequest createPostRequest =  new CreatePostRequest();
        createPostRequest.setTitle(title);
        createPostRequest.setBody(body);
         print(postController.createPost(createPostRequest));
         displayMainMenu();

    }
    private static void viewPost(){
        String userInput = input("Enter Post ID");
        print(postController.viewPost(Integer.parseInt(String.valueOf(userInput))).toString());
        displayMainMenu();
    }

    private static void existFromApp(){
        print("Thank you for using this app.");
        System.exit(0);
    }

    private static String input(String prompt){
       // print(prompt);
        return JOptionPane.showInputDialog(prompt);
                //keyboardInput.nextLine();
    }

    private static void print(String prompt){
        JOptionPane.showMessageDialog(null, prompt);
        //System.out.println(prompt);
    }
}
