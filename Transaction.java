import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int fromAcc;
    private int toAcc;
    private double amount;
    private Date date;

    // Getters and Setters
}
