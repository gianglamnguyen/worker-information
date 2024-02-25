
import Controller.Controller;
import view.Menu;

public class Main {

    public static void main(String[] args) {
        Menu mainMenu = new Controller(null);
        new Controller(mainMenu).run();
    }
}