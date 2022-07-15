package ISSUE_2;

import java.util.Scanner;

public class Driver{

    Scanner sc = new Scanner(System.in);

    public void driver (Human human) {
        if (human instanceof basic) {
            basic basic = (basic) human;
            basic.speed();
        } else if (human instanceof middle) {
            middle middle = (middle) human;
            middle.speed();
        } else if (human instanceof master) {
            master master = (master) human;
            master.speed();
        }
    }

        public void run (){
            String[] arr = {"천안", "천안 톨게이트","고속도록", "서울 톨게이트", "서울"};
            for ( int i = 0; i< arr.length; i++){
                if(arr[i] == "천안" || arr[i] == "서울"){
                    bigblock big = new basic();
                    System.out.println(arr[i]+"에 진입하였습니다");
                    big.speed();
                }
                else if(arr[i] == "천안 톨게이트"){
                    System.out.println("천안 톨게이트에 진입하였습니다");
                }
                else if(arr[i] == "고속도록"){
                    bigblock big = new master();
                    System.out.println(arr[i] +"에 진입하였습니다." +arr[i]+ "의 기준 속도로 주행합니다");
                    big.speed();
                }

            }
        }


    }

