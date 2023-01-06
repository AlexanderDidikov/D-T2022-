public class Main {
    public static void main(String[] args) throws InterruptedException {
        PersonTest tester = new PersonTest();
        tester.LoginPage();
        tester.MainPage();
        tester.PersonPage();
        if (tester.checkRow()) {
            tester.removeRow();
        }
    }
}
