import java.util.Scanner;

public class MarketMenu {

    private final MarketCore marketCore;
    private final Scanner input = new Scanner(System.in);

    public MarketMenu(MarketCore marketCore) {
        this.marketCore = marketCore;
    }

    public void showMenu() {
        int choice;
        do {
            showMenuOptions();
            choice = input.nextInt();
            input.nextLine();

            int productId, userId;
            String productName, firstName, lastName;
            double price, moneyAmount;

            try {
                switch (choice) {
                    case 1:
                        marketCore.displayListOfAllUsers();
                        break;
                    case 2:
                        marketCore.displayListOfAllProducts();
                        break;
                    case 3:
                        productId = getProductId();
                        userId = getUserId();
                        marketCore.buyProduct(userId, productId);
                        System.out.println("Successful purchase, congratulations!");
                        break;
                    case 4:
                        userId = getUserId();
                        marketCore.displayListOfUserProducts(userId);
                        break;
                    case 5:
                        productId = getProductId();
                        marketCore.displayListOfProductBuyers(productId);
                        break;
                    case 6:
                        firstName = getFirstName();
                        lastName = getLastName();
                        moneyAmount = getMoneyAmount();
                        marketCore.addUser(firstName, lastName, moneyAmount);
                        break;
                    case 7:
                        productName = getProductName();
                        price = getPrice();
                        marketCore.addProduct(productName, price);
                        break;
                    case 8:
                        userId = getUserId();
                        marketCore.deleteUser(userId);
                        break;
                    case 9:
                        productId = getProductId();
                        marketCore.deleteProduct(productId);
                        break;
                    case 0:
                        System.out.println("Exiting Program...");
                        break;
                    default:
                        System.out.println(choice + " is not a valid Menu Option! Please Select Another.");
                }
            } catch (Exception e) {
                System.out.println("\nOops, an error occurred:\n");
                System.out.println(e.getMessage());
                System.out.println("\nPlease, try again");
            }
        } while (choice != 0 /*Exit loop*/);
    }

    private void showMenuOptions() {
        System.out.println("\nMarketplace menu: ");
        System.out.println("\t1. Display list of all users");
        System.out.println("\t2. Display list of all products");
        System.out.println("\t3. Buy product");
        System.out.println("\t4. Display list of user products by user id");
        System.out.println("\t5. Display list of users that bought product by product id");
        System.out.println("\t6. Add user");
        System.out.println("\t7. Add product");
        System.out.println("\t8. Delete user");
        System.out.println("\t9. Delete product");
        System.out.println("\t0. Exit");
        System.out.println("Enter menu number: \n");
    }

    private int getProductId() {
        System.out.println("Enter product Id:");
        return input.nextInt();
    }

    private int getUserId() {
        System.out.println("Enter user Id:");
        return input.nextInt();
    }

    private String getProductName() {
        System.out.println("Enter product name:");
        return input.next();
    }

    private String getFirstName() {
        System.out.println("Enter first name:");
        return input.nextLine();
    }

    private String getLastName() {
        System.out.println("Enter last name:");
        return input.nextLine();
    }

    private double getPrice() {
        System.out.println("Enter product price:");
        return input.nextDouble();
    }

    private double getMoneyAmount() {
        System.out.println("Enter money amount:");
        return input.nextDouble();
    }
}
