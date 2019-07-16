package poi;

import java.util.Scanner;

public class Tax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int taxAfter;
        int tax;
        double money = 0.0D;
         while (true) {
             System.out.println("查询国人个人所得税请输入1,查询外籍个人所得税请输入2,退出请输入3");
             String s = sc.next();
             if (s.equals("3")) {
                 System.out.println("程序已经退出!");
                 return;
             }
            System.out.println("请输入工资:");
            tax= sc.nextInt();
                if (s.equals("1")) {
                    if (tax > 3500) {
                        taxAfter = tax - 3500;
                    }else {
                        taxAfter = 0;
                    }
                } else {
                    if (tax > 4800) {
                        taxAfter = tax - 4800;
                    }else {
                        taxAfter = 0;
                    }
                }
                if (taxAfter <= 1500) {
                    money = taxAfter * 0.03;
                } else if (taxAfter <= 4500) {
                    money = taxAfter * 0.10;
                } else if (taxAfter <= 9000) {
                    money = taxAfter * 0.20;
                } else if (taxAfter <= 35000) {
                    money = taxAfter * 0.25;
                } else if (taxAfter <= 55000) {
                } else if (taxAfter <= 80000) {
                    money = taxAfter * 0.35;
                } else {
                    money = taxAfter * 0.45;
                }
                System.out.println("所需要缴纳的税费为: " + money+"元");
        }
    }
}
