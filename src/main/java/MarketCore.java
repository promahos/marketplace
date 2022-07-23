import java.util.List;

public class MarketCore {

    private final MarketStorage storage = new MarketStorage();

    public void initSetUp() {
        addUser("One", "First", 20);
        addUser("Two", "Second", 20);
        addUser("Three", "Third", 20);

        addProduct("First", 50);
        addProduct("Second", 5);
        addProduct("Third", 5);
    }

    public void displayListOfProductBuyers(int productId) {
        List<User> userList = storage.getListOfProductBuyers(productId);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    public void displayListOfUserProducts(int userId) {
        List<Product> productList = storage.getListOfUserProducts(userId);
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public void buyProduct(int userId, int productId) {
        Product product = storage.getProductById(productId);
        User user = storage.getUserById(userId);

        double productPrice = product.getPrice();
        double moneyAmount = user.getMoneyAmount();

        if (moneyAmount < productPrice) {
            throw new MarketOperationException("Not enough money for purchase");
        } else {
            user.spendMoney(productPrice);

            Purchase purchase = new Purchase(userId, productId);
            storage.addPurchase(purchase);
        }
    }

    public void displayListOfAllUsers() {
        List<User> userList = storage.getListOfAllUsers();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    public void displayListOfAllProducts() {
        List<Product> productList = storage.getListOfAllProducts();
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public void addProduct(String name, double price) {
        Product product = new Product(name, price);
        storage.addProduct(product);
    }

    public void addUser(String firstName, String lastName, double moneyAmount) {
        User user = new User(firstName, lastName, moneyAmount);
        storage.addUser(user);
    }

    public void deleteProduct(int id) {
        storage.deleteProduct(id);
        storage.deletePurchasesByProduct(id);
    }

    public void deleteUser(int id) {
        storage.deleteUser(id);
        storage.deletePurchasesByUser(id);
    }
}
