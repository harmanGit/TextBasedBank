package bankaccount;

import java.util.Scanner;

/**
 * This class is used to as user input and menu interface for the Access
 * Database Class. The Access class is a class connect to a database which
 * simulates a Bank. Connect to a mySql Server on BU campus.
 *
 * @author hsd77849
 */
public class BankAccount {

    public static void main(String[] args) {

        // Creating a Access class object
        Access bank = new Access();
        // Scanner for user input
        Scanner sn = new Scanner(System.in);
        System.out.println("Enter a number corresponding to the menu.");
        menu(); // user #1 menu
        int choice = sn.nextInt(); // user input
        sn.nextLine();// nextLine used becasue of nextInt messing up the format

        // while loop for going through the #1 menu
        while (choice != 4) {
            System.out.println("");

            // Choice one, Create a new user
            if (choice == 1) {
                // Boolean used to run a while loop till correct info is entered
                boolean form = true; // user entered fields check
                boolean amount = true; // user entered amount check
                while (form && amount) {
                    System.out.println("Enter USERNAME:");
                    String un = sn.nextLine();
                    System.out.println("Enter PASSWORD:");
                    String pd = sn.nextLine();
                    System.out.println("Enter FIRST NAME:");
                    String f = sn.nextLine();
                    System.out.println("Enter LAST NAME:");
                    String l = sn.nextLine();
                    System.out.println("Enter STREET ADDRESS:");
                    String a = sn.nextLine();
                    System.out.println("Enter CITY:");
                    String c = sn.nextLine();
                    System.out.println("Enter STATE:");
                    String s = sn.nextLine();
                    System.out.println("Enter ZIP:");
                    String z = sn.nextLine();
                    System.out.println("Enter ACCOUNT TYPE:");
                    System.out.println("Checking or Savings or Money Market");
                    String at = sn.nextLine();
                    if (at.equals("Checking") || at.equals("Savings")
                            || at.equals("Money Market")) {
                        System.out.println("Must Add a Minimum Amount of Money:");
                        System.out.println("*** Minimum $50.00 ***");
                        double amt = sn.nextDouble();
                        // nextLine used becasue of nextDouble messing up the format
                        sn.nextLine();

                        // Checking if the amount entered is more than 50 dollars
                        if (amt >= 50) {
                            // Stopping the while loop from running again if
                            // amount is more than 50
                            amount = false;
                            // If statement checking if all fields are filled in
                            if (un != null && pd != null && f != null && l != null
                                    && a != null && c != null && s != null
                                    && z != null && at != null) {

                                // Creating new member and account
                                bank.newAccount(un, pd, f, l, a, c, s, z, at, amt);
                                // Stopping the while loop from running again if
                                // all the fields are filled in
                                form = false;

                            } else {
                                System.out.println("NOT ALL FIELDS FILLED"
                                        + " OUT TRY AGAIN!");
                            }
                        } else {
                            System.out.println("Try Again, Amount "
                                    + "Entered Lower That Minimum!");
                        }
                    } else {
                        System.out.println("Incorrect Type Of Account");
                    }
                }

            }
            // choice 2, Login In
            if (choice == 2) {

                // Local Varibales to be used inside the if statement
                String user = " "; // username
                String password = " ";

                // Boolean to keep the while loop running until the password is
                // correct.
                boolean retryLogin = true;

                while (retryLogin) {
                    System.out.println("Enter USERNAME:");
                    user = sn.nextLine();
                    System.out.println("Enter PASSWORD:");
                    password = sn.nextLine();
                    // bank login method returns a boolean, true or false.
                    // true if the username and password wrong
                    // false if the username and password is right
                    retryLogin = bank.login(user, password);
                }
                System.out.println("----------------------------");

                // While loop for the second menu
                while (choice != 5) {
                    System.out.println("Enter a number corresponding "
                            + "to the menu.");
                    menuLoggedIn(); // user menu #2
                    choice = sn.nextInt(); // user input
                    sn.nextLine();

                    // Second menu choice 1, Check Balance
                    if (choice == 1) {
                        /* 
                         * Prints out the bank balance, by using the username
                         * and password entered in the "login" if statement 
                         * above.
                         */

                        System.out.println("BALANCE---------------------------"
                                + "--------------------------------");
                        bank.checkAccountBalance(user, password);
                    }

                    // Second menu choice 2, Transfer Money
                    if (choice == 2) {
                        // Asking users info about there money transfer
                        System.out.println("Enter Transfer Amount:");
                        double ta = sn.nextDouble();
                        // nextLine used becasue of nextDouble messing up 
                        // the format
                        sn.nextLine();
                        System.out.println("Checking or Savings or Money Market");
                        System.out.println("Enter Which Account to "
                                + "Transfer From:");
                        String from = sn.nextLine();
                        System.out.println("Enter Which Account to"
                                + " Transfer To:");
                        String to = sn.nextLine();
                        /*
                         * Enters user given info into "traferBetweenAccount"
                         * method. The username and password were again pulled
                         * in from the "login" if statement above.
                         */
                        bank.tranferBetweenAccount(user, password, ta,
                                from, to);
                    }

                    // Second menu choice 3, Check Transactions
                    if (choice == 3) {
                        // Asking users info about checking there transactions
                        System.out.println("Which Account Would You Like"
                                + " The Transaction From:");
                        String type = sn.nextLine();
                        System.out.println("Enter Date From Where You Want The"
                                + " Transaction List To Start From.");
                        System.out.println("Please Enter In A YYYY-MM-DD "
                                + "Format:");
                        String transFrom = sn.nextLine();
                        System.out.println("Enter Date From Where You Want The"
                                + " Transaction List To End From.");
                        System.out.println("Please Enter In A YYYY-MM-DD "
                                + "Format:");
                        String transTo = sn.nextLine();

                        /*
                         * Enters user given info into "transactionsCheck" 
                         * method. The username and password were again pulled
                         * in from the "login" if statement above.
                         */
                        bank.transactionsCheck(user, password, type,
                                transFrom, transTo);

                    }

                    // Second menu choice 4, Open A New Account
                    if (choice == 4) {

                        // Asking users info about there new account to be
                        // created.
                        System.out.println("Enter Type Of Account To Create:");
                        System.out.println("Checking or Savings or Money Market");
                        String at = sn.nextLine();
                        if (at.equals("Checking") || at.equals("Savings")
                                || at.equals("Money Market")) {

                            System.out.println("Must Add a Minimum Amount of Money:");
                            System.out.println("*** Minimum $50.00 ***");
                            double amt = sn.nextDouble();
                            // nextLine used becasue of nextDouble messing up 
                            // the format
                            sn.nextLine();

                            // Checking if the account the user entered is more than
                            // 50 dollars
                            if (amt >= 50) {
                                // If its more than 50 dollars then inserting it
                                // into "addAccount" method. Which will create a
                                // new account for the customer
                                bank.addAccount(user, password, at, amt);

                            } else {
                                System.out.println("Try Again, Amount Entered Lower"
                                        + " Than Minimum.");
                            }
                        } else {
                            System.out.println("Incorrect Type Of Account");
                        }
                    }

                    System.out.println(" ");

                }

            }

            // first menu choice 3, Admin Access
            if (choice == 3) {
                // Asks user for admin
                System.out.println("Enter Admin Key:");
                int adminKey = sn.nextInt();
                // nextLine used becasue of nextInt messing up the format
                sn.nextLine();
                // Entering the  user entered key into the "keyCheck" method.
                // Which will check if the key is correct of not
                bank.keycheck(adminKey);

            }

            // Displaying the menu after the while
            System.out.println("Enter a number corresponding to the menu.");
            menu();
            choice = sn.nextInt();
            // nextLine used becasue of nextInt messing up the format
            sn.nextLine();
        }

    }

    /**
     * Creates the first menu.
     */
    public static void menu() {
        System.out.println("1. Create New User");
        System.out.println("2. Login In");
        System.out.println("3. Admin");
        System.out.println("4. Exit");

    }

    /**
     * Creates the second table once user has logged in.
     */
    private static void menuLoggedIn() {
        System.out.println("1. Check Balance");
        System.out.println("2. Transfer Money");
        System.out.println("3. Check Transactions");
        System.out.println("4. Open A New Account");
        System.out.println("5. Log Out");

    }
}
