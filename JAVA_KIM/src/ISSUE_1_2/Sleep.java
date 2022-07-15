package ISSUE_1_2;

import java.util.concurrent.TimeUnit;

public class Sleep {
    public Sleep() {
    }

    public static void main(String[] args) {
        change();
    }

    public static void change() {
        RemoteControl.select();
        Kim KIM_J = new Kim();
        Park PARK_J = new Park();
        Lee LEE_J = new Lee();

        try {
            for(int i = 1; i < 34; ++i) {
                if (i % 3 == 0) {
                    TimeUnit.SECONDS.sleep(1L);
                    LEE_J.Change_channlenumber(2);
                    if (i % 5 == 0) {
                        TimeUnit.SECONDS.sleep(1L);
                        PARK_J.Change_channlenumber(1);
                    }
                } else if (i % 5 == 0) {
                    TimeUnit.SECONDS.sleep(1L);
                    PARK_J.Change_channlenumber(1);
                } else if (i % 11 == 0) {
                    TimeUnit.SECONDS.sleep(1L);
                    KIM_J.Change_channlenumber(3);
                } else {
                    TimeUnit.SECONDS.sleep(1L);
                    System.out.println("광고중......");
                }
            }
        } catch (Exception var4) {
            System.out.println(var4);
        }

    }
}
