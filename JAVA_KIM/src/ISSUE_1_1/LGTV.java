package ISSUE_1_1;

public class LGTV {
    public LGTV() {
    }

    public static void main(String[] args) {
        smartTV();
    }

    public static void smartTV() {
        Searchable.changeselect();
        System.out.println("-------------------");
        SmartTelevision TV = new SmartTelevision();
        TV.channelchange(45);
    }
}

