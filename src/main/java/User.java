import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class User {
    private final int id;
    private String firstName;
    private String lastName;
    private double moneyAmount;
    private static int userCounter;

    public User() {
        userCounter++;
        this.id = userCounter;
    }

    public User(String firstName, String lastName, double moneyAmount) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.moneyAmount = moneyAmount;
    }

    public void spendMoney(double price) {
        moneyAmount -= price;
    }
}
