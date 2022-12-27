package dev_java.week5.d221227;

public class ServerTest {
    public static void main(String[] args) {
        // 아래 중 생성자 안에 
        // 인스턴스화를 하면 생성자(디폴트)도 호출된다
        BananaServer bs = new BananaServer();
        // BananaServer bs = new BananaServer("테스트");
        KiwiServer ks = new KiwiServer();
    }
}
