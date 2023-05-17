package LoginPageProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService implements INecessary {

    List<String> emails = new ArrayList<>();
    List<String> passwords = new ArrayList<>();
    List<String> usernames = new ArrayList<>();
    List<User> users = new ArrayList<>();

    @Override
    public void signUp() {
        Scanner input = new Scanner(System.in);
        // 1- Name-Surname
        System.out.println("please Name-Surname : ");
        String name = input.nextLine();

        // 2- Username
        String userName;
        boolean existUserName;

        do {
            System.out.println("Enter username : ");
            userName = input.next();
            existUserName = usernames.contains(userName);
            if (existUserName) { // true
                System.out.println(" this username exists.please enter different username");
            }
        }
        while (existUserName);
       usernames.add(userName);


        // 3- E-mail
        String email;
        boolean existEmail;
        boolean isValid;
        do {
            System.out.println("Please enter  your e-mail");
            email = input.next();
            existEmail = emails.contains(email);
            isValid = isValidEmail(email);
            if (existEmail) { // true
                System.out.println(" this e-mail exists.please enter different e-mail");
            }
        }
            while(existEmail || !isValid);
            emails.add(email);


            // 4- Password
        String password;
        boolean isValidPass;
        do{
            System.out.println("please enter your password");
            System.out.println("WARNING : your password must contain at least 6 character ");
            password=input.next();
            isValidPass=isValidPass(password);
        }while(!isValidPass);
        passwords.add(password);

        // kullanici -object olustur
        User user = new User(name, userName, email, password);
        users.add(user);
        System.out.println("Congratulations! Registration completed successfully.You can login");

    }

    public  boolean isValidPass(String password) {
        boolean isValid;
        if(password.length()>=6){
            isValid=true;
        }
        else{
            isValid=false;
            System.out.println("Incorrect password");

        }
        return isValid;
    }

    public boolean isValidEmail(String email) {
        boolean isValid=email.contains("@");
        if(isValid==false){  // eger e-mail @ isareti icermiyorsa
            System.out.println("This e-mail is invalid.please enter  different e-mail");
        }
        return  isValid;
    }

    @Override
    public void logIn() {
        Scanner scan= new Scanner(System.in);
        String userName;
        boolean existUserName;
        String email;
        boolean existEmail;

    do{
        System.out.println("please enter username- email and password");
        userName=scan.next();
        existUserName=users.contains(userName);
        if(!existUserName ){
            System.out.println("unused username and e-mail .you are not registered");
        }
    }while(!existUserName );

    boolean isValid;
    do{
        System.out.println("enter your password");
        String userPass=scan.next();
        int idxUser=emails.indexOf(userName);
        isValid=passwords.get(idxUser).equals(userPass);

        if(!isValid){
            System.out.println("you entered the wrong password ,please try again");
        }
    }
    while(!isValid);
        System.out.println("welcome");

    }
}
