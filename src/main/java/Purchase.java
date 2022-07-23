import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Purchase {
    private int userId;
    private int productId;
}
