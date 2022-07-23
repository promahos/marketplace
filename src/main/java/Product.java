import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Product {
    private final int id;
    private String name;
    private double price;
    private static int productCounter;

    public Product() {
        productCounter++;
        this.id = productCounter;
    }

    public Product(String name, double price) {
        this();
        this.name = name;
        this.price = price;
    }
}
