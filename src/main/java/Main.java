public class Main {
    public static void main(String[] args) {
        MarketCore marketCore = new MarketCore();
        marketCore.initSetUp();

        MarketMenu marketMenu = new MarketMenu(marketCore);
        marketMenu.showMenu();
    }
}
