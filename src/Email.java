import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Email {
    public Scanner scanner = new Scanner(System.in);

    private String firstName;
    private String lastName;
    private String department;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alternativeEmail;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        System.out.println("New Employee: " + this.firstName + " " + this.lastName);

        this.department = this.setDepartment();
        this.password = this.generatePassword(10);
        this.email = this.generateEmail();
    }

    private String generateEmail(){
        return this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department.toLowerCase() + ".com";
    }

    private String setDepartment(){
        System.out.println("Department codes \n1 Sales \n2 Development \n3 Accounting \n");
        boolean flag = false;
        do {
            System.out.println("Enter Department code");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounting";
                default:
                    System.out.println("Invalid choice, please choose correct one !");
            }
        } while(!flag);
        return null;
    }

    private String generatePassword(int length){
        Random rand = new Random();
        String capitalCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallCharacters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*()_-?";
        String values = capitalCharacters + smallCharacters + numbers + symbols;
        String password = "";
        for(int i = 0 ; i < length; i++){
            password = password + values.charAt(rand.nextInt(values.length()));
        }
        return password;
    }

    public void changePassword(){
        boolean flag = false;
        do {
            System.out.println("Do you want change password ? (Y/N)");
            char choice = scanner.next().charAt(0);
            if(choice == 'Y' || choice == 'y'){
                flag = true;
                System.out.println("Enter current password: ");
                String temporary = scanner.next();
                if(temporary.equals(this.password)){
                    System.out.println("Enter a new password");
                    this.password = scanner.next();
                    System.out.println("Password changed successfully");
                } else {
                    System.out.println("Invalid password, try again");
                }
            } else if(choice == 'N' || choice == 'n'){
                flag = true;
                System.out.println("exiting");
            } else {
                System.out.println("Enter valid option");
            }
        } while (!flag);
    }

    public void setMailCapacity(){
        System.out.println("Current capacity = " + this.mailCapacity + "mb");
        System.out.println("Enter new mailbox capacity: ");
        this.mailCapacity = scanner.nextInt();
        System.out.println("Mailbox capacity is successfully changed");
    }

    public void setAlternativeEmail(){
        System.out.println("Enter new alternative email: ");
        this.alternativeEmail = scanner.next();
        System.out.println("Alternative email is set");
    }

    public void getInfo(){
        System.out.println("New: " + this.firstName + " " + this.lastName);
        System.out.println("Department: " + this.department);
        System.out.println("Email: " + this.email);
        System.out.println("Password: " + this.password);
        System.out.println("Mail capacity: " + this.mailCapacity + "mb");
        System.out.println("Alternative Email: " + this.alternativeEmail);
    }

    public void storeData(){
        try {
            FileWriter in = new FileWriter("C:\\Users\\beis2\\Desktop\\info.txt");
            in.write("First name: " + this.firstName);
            in.append("\nLast name: " + this.lastName);
            in.append("\nEmail: " + this.email);
            in.append("\nPassword: " + this.password);
            in.append("\nAlternative Email: " + this.alternativeEmail);
            in.close();
            System.out.println("Data stored successfully");
        } catch (Exception e){
            System.out.println("Data not stored");
            System.out.println(e);
        }
    }

    public void readData(){
        try {
            FileReader out = new FileReader("C:\\Users\\beis2\\Desktop\\info.txt");
            int i;
            while ((i = out.read()) != -1){
                System.out.println((char) i);
            }
            System.out.println();
            out.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

}
