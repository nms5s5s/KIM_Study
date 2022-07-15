package ISSUE_1_1;

public class SmartTelevision implements Searchable {
    private int channel;

    public SmartTelevision() {
    }

    public void channelchange(int number) {
        if (number <= 10) {
            number = 10;
        } else if (number <= 20) {
            number = 20;
        } else if (number <= 25) {
            number = 25;
        } else if (number <= 120) {
            number = 120;
        }

        System.out.println("" + number + "채널이 교체 됩니다");
    }
}
