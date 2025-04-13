public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        BankingService service = ctx.getBean(BankingService.class);

        try {
            service.transfer(1001, 1002, 500);
            System.out.println("Transfer Successful");
        } catch (Exception e) {
            System.out.println("Transfer Failed: " + e.getMessage());
        }

        ctx.close();
    }
}
