import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        String firstName = scanner.next();
        System.out.println("Enter your last name: ");
        String lastName = scanner.next();

        Email firstEmail = new Email(firstName, lastName);
        int choice = -1;
        do {
            System.out.println("\n******\nEnter your choice\n[1] Show info\n[2] Change Password\n" +
                    "[3] Change mailbox capacity\n[4] Set Alternative email\n[5] Store Data\n [6] Read data");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    firstEmail.getInfo();
                    break;
                case 2:
                    firstEmail.changePassword();
                    break;
                case 3:
                    firstEmail.setMailCapacity();
                    break;
                case 4:
                    firstEmail.setAlternativeEmail();
                    break;
                case 5:
                    firstEmail.storeData();
                case 6:
                    firstEmail.readData();
                default:
                    System.out.println("Invalid choice, Enter valid value again");
            }
        } while(choice != 5);
    }
}
