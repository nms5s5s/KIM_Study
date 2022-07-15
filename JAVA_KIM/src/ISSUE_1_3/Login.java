package ISSUE_1_3;

import java.util.Scanner;

public class Login {
    String ID = "";
    int Password = 0;
    Scanner sc;

    public Login() {
        this.sc = new Scanner(System.in);
    }

    public void login() {
        System.out.println("WELCOME");
        System.out.println("아이디를 입력해주세요");
        System.out.println("ID : ");
        this.ID = this.sc.nextLine();
        if (this.ID.equals("admin")) {
            this.password();
        } else {
            System.out.println("아이디를 다시 확인해주세요");
            System.out.println("-----------------");
            this.login();
        }

    }

    public void password() {
        System.out.println("패스워드를 입력해주세요");
        System.out.println("Password : ");
        this.Password = this.sc.nextInt();
        if (this.Password == 123456) {
            System.out.println("로그인을 성공하였습니다");
        } else {
            System.out.println("패스워드가 틀렸습니다. 다시 입력하세요.");
            System.out.println("------------------");
            this.password();
        }

    }
}

