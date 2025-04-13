@Service
public class BankingService {
    @Autowired
    private SessionFactory sf;

    @Transactional
    public void transfer(int from, int to, double amount) {
        Session session = sf.getCurrentSession();

        Account a1 = session.get(Account.class, from);
        Account a2 = session.get(Account.class, to);

        if (a1.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }

        a1.setBalance(a1.getBalance() - amount);
        a2.setBalance(a2.getBalance() + amount);

        Transaction txn = new Transaction();
        txn.setFromAcc(from);
        txn.setToAcc(to);
        txn.setAmount(amount);
        txn.setDate(new Date());

        session.save(txn);
    }
}
