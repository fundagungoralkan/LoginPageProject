package LoginPageProject;

import java.util.Scanner;

public class LoginPage  extends UserService{
    public static void main(String[] args) {
        LoginPage lg=new LoginPage();
        lg.start();


    }

    public void start(){
        Scanner input=new Scanner(System.in);
        int choice;
        do{
            showMenu();
            choice=input.nextInt();

            switch (choice){
                case 1:
                    signUp();
                    break;
                case 2:
                    logIn();
                    break;
                    case 0:
                        System.out.println("have a good day");
                    break;
                default:
                    System.out.println("You entered the wrong value, please try again.");
            }
        }
        while(choice!=0);




    }


    public static void showMenu(){
        System.out.println("TECHPROEDUCATION");
        System.out.println("1-Sign Up");
        System.out.println("2-Log in");
        System.out.println("0-Out");
        System.out.println("Your choice : ");

    }






}
