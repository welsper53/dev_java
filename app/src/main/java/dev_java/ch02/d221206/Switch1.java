package dev_java.ch02.d221206;

public class Switch1 {
    public static void main(String[] args) {
        String bread = "도우넛";
        switch (bread) {
            case "소보로": {
                int protocol = 100;
                System.out.println("소보로 빵입니다." + protocol);
                break;
            }
            case "도우넛": {
                int protocol = 200;
                System.out.printf("%s 빵입니다. %d %n", bread, protocol);
                break;
            }
            default:
            System.out.println("원하는 빠이 없습니다.");    
            break;
        }
    }
}
