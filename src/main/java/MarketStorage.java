import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MarketStorage {

    private final List<User> userList = new ArrayList<>();
    private final List<Product> productList = new ArrayList<>();
    private final List<Purchase> purchaseList = new ArrayList<>();

    public List<User> getListOfProductBuyers(int productId) {
        return purchaseList
                .stream()
                .filter(purchase -> purchase.getProductId() == productId)
                .map(Purchase::getUserId)
                .distinct()
                .map(this::getUserById)
                .collect(Collectors.toList());
    }

    public List<Product> getListOfUserProducts(int userId) {
        return purchaseList
                .stream()
                .filter(purchase -> purchase.getUserId() == userId)
                .map(Purchase::getProductId)
                .distinct()
                .map(this::getProductById)
                .collect(Collectors.toList());
    }

    public List<User> getListOfAllUsers() {
        return userList;
    }

    public List<Product> getListOfAllProducts() {
        return productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void addPurchase(Purchase purchase) {
        purchaseList.add(purchase);
    }

    public void deleteProduct(int id) {
        Product product = getProductById(id);
        productList.remove(product);
    }

    public void deleteUser(int id) {
        User user = getUserById(id);
        userList.remove(user);
    }

    public void deletePurchasesByUser(int id) {
        purchaseList.removeIf(purchase -> purchase.getUserId() == id);
    }

    public void deletePurchasesByProduct(int id) {
        purchaseList.removeIf(purchase -> purchase.getProductId() == id);
    }

    public User getUserById(int userId) {
        return userList.stream()
                .filter(u -> u.getId() == userId)
                .findAny()
                .orElseThrow(() -> new MarketOperationException("User with such id doesn't exist"));
    }

    public Product getProductById(int productId) {
        Product product = productList.stream()
                .filter(p -> p.getId() == productId)
                .findAny()
                .orElse(null);

        if (product == null) {
            throw new MarketOperationException("Product with such id doesn't exist");
        }

        return product;
    }
}
