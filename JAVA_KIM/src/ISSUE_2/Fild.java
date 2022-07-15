package ISSUE_2;

public class Fild {
    public static void main(String[] args) {
        quiz_2();
    }
    public static void quiz_2() {

        Driver DRIVER = new Driver();
        basic BASIC = new basic();
        middle MIDDLE = new middle();
        master MASTER = new master();


        DRIVER.driver(BASIC);
        DRIVER.driver(MIDDLE);
        DRIVER.driver(MASTER);

        System.out.println("__________");
        DRIVER.run();


    }
}
