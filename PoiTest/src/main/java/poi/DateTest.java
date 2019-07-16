package poi;

import java.util.Scanner;

public class DateTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("如果查询请输入1,如果退出请输入2");
            String date = sc.nextLine();
            if (date.equals("2")) {
                System.out.println("程序已经退出!");
                return;
            }
            System.out.println("请输入日期格式:(例 2019-01-01):");
            date = sc.nextLine();

            // 闰年标志
            boolean isLeapYear = false;
            //判断输入的日期长度
            if (date.length() == 10) {
                //截取年份的长度
                String year = date.substring(0, 4);
                for (int i = 0; i < year.length(); i++) {
                    //判断年份是否合法
                    if (year.charAt(i) < '0' || year.charAt(i) > '9') {
                        System.out.println("输入的日期不合法!");
                        return;
                    }
                }
                //截取年份后的"-"
                String flagstaff1 = date.substring(4, 5);
                //截取月份的长度
                String month = date.substring(5, 7);
                //截取月份后面的"-"
                String flagstaff2 = date.substring(7, 8);
                //判断年份后以及月份后是否是"-"
                if (!flagstaff2.equals("-") && !flagstaff1.equals("-")) {
                    System.out.println("输入的日期不合法!");
                    return;
                }
                //截取日期的长度
                String day = date.substring(8, 10);
                //判断月份及日期是否合法
                for (int i = 0; i < day.length(); i++) {
                    if ((day.charAt(i) < '0' || day.charAt(i) > '9') && (month.charAt(i) < '0' || month.charAt(i) > '9')) {
                        System.out.println("输入的日期不合法!");
                        return;
                    }
                }
                int vYear = Integer.parseInt(year);

                // 判断是否为闰年
                if (vYear % 4 == 0 && vYear % 100 != 0 || vYear % 400 == 0) {
                    isLeapYear = true;
                }
                // 判断月份
                // 1.判断月份
                if (month.startsWith("0")) {
                    String units4Month = month.substring(1, 2);
                    int vUnits4Month = Integer.parseInt(units4Month);
                    //获取天数
                    int vDays4February = Integer.parseInt(day);
                    //如果月份是00
                    if (vUnits4Month == 0) {
                        System.out.println("输入的日期不合法!");
                        return;
                        //如果月份是2
                    } else if (vUnits4Month == 2) {
                        //如果是闰年
                        if (isLeapYear) {
                            if (vDays4February > 29) {
                                System.out.println("输入的日期不存在!");
                                return;
                            }
                        } else {
                            if (vDays4February > 28) {
                                System.out.println("输入的日期不存在!");
                                return;
                            }
                        }
                    } else if (vUnits4Month == 1 || vUnits4Month == 3 || vUnits4Month == 5 || vUnits4Month == 7 || vUnits4Month == 8 || vUnits4Month == 10 || vUnits4Month == 12) {
                        if (vDays4February > 31) {
                            System.out.println("输入的日期不存在!");
                            return;
                        }
                    } else if (vUnits4Month == 4 || vUnits4Month == 6 || vUnits4Month == 9 || vUnits4Month == 11) {
                        if (vDays4February > 30) {
                            System.out.println("输入的日期不存在!");
                            return;
                        }
                    }
                } else {
                    // 2.判断非0打头的月份是否合法
                    int vMonth = Integer.parseInt(month);
                    if (vMonth != 10 && vMonth != 11 && vMonth != 12) {
                        System.out.println("输入的日期不合法!");
                        return;
                    }
                }
                // 判断日期
                // 1.判断日期
                if (day.startsWith("0")) {
                    String units4Day = day.substring(1, 2);
                    int vUnits4Day = Integer.parseInt(units4Day);
                    //判断日期是否是00
                    if (vUnits4Day == 0) {
                        System.out.println("输入的日期不合法!");
                        return;
                    }
                } else {
                    // 2.判断非0打头的日期是否合法
                    int vDay = Integer.parseInt(day);
                    if (vDay < 10 || vDay > 31) {
                        System.out.println("输入的日期不合法!");
                        return;
                    }
                }
                System.out.println("您输入的日期是: " + date);

                int dayAfter = Integer.parseInt(day);
                int yearAfter = Integer.parseInt(year);
                int vUnits4Month = Integer.parseInt(month);
                //判断月份为大月
                if (vUnits4Month == 12) {
                    if (dayAfter >= 31) {
                        dayAfter = 1;
                        vUnits4Month = 1;
                        yearAfter = yearAfter + 1;
                    }
                    // 判断是否为闰年
                    if (yearAfter % 4 == 0 && yearAfter % 100 != 0 || yearAfter % 400 == 0) {
                        isLeapYear = true;
                    }
                    //判断月份为2月
                } else if (vUnits4Month == 1 || vUnits4Month == 3 || vUnits4Month == 5 || vUnits4Month == 7 || vUnits4Month == 8 || vUnits4Month == 10) {
                    if (dayAfter >= 31) {
                        dayAfter = 1;
                        vUnits4Month = vUnits4Month + 1;
                    } else {
                        dayAfter = dayAfter + 1;
                    }
                    //判断月份为12月
                } else if (vUnits4Month == 2) {
                    // 获取2月的天数
                    //如果是闰年
                    if (isLeapYear) {
                        if (dayAfter >= 29) {
                            dayAfter = 1;
                            vUnits4Month = 3;
                        } else {
                            dayAfter = dayAfter + 1;
                        }
                    } else {
                        if (dayAfter >= 28) {
                            dayAfter = 1;
                            vUnits4Month = 3;
                        } else {
                            dayAfter = dayAfter + 1;
                        }
                    }
                    //判断月份是否是小月
                } else if (vUnits4Month == 4 || vUnits4Month == 6 || vUnits4Month == 9 || vUnits4Month == 11) {
                    if (dayAfter >= 30) {
                        dayAfter = 1;
                        vUnits4Month = vUnits4Month + 1;
                    } else {
                        dayAfter = dayAfter + 1;
                    }
                }
                String m;
                String d;
                //输出下一天的日期
                if (vUnits4Month < 10) {
                    m = "0" + vUnits4Month;
                } else {
                    m = "" + vUnits4Month;
                }
                if (dayAfter < 10) {
                    d = "0" + dayAfter;
                } else {
                    d = "" + dayAfter;
                }
                System.out.println("您输入的日期的下一天是: " + yearAfter + "-" + m + "-" + d);
            } else {
                System.out.println("输入的日期不合法!");
                return;
            }
        }
    }
}