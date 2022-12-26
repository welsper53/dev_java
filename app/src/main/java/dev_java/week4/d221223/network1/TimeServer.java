
package dev_java.week4.d221223.network1;

import java.io.IOException;
import java.io.ObjectInputStream;   // 듣기
import java.io.ObjectOutput;        // 말하기
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

// 서버를 기동하고 클라이언트가 접속해 오기를 기다린다 
// -> 기다리면 스레드
public class TimeServer extends Thread {
    // [선언부]
    // 객체 직렬화 가능하고 듣기와 쓰기가 가능한 I/O관련 클래스 선언
    // {소켓이 있어야만 객체 생성 가능함}
    // oos : 말하기
    // ois : 듣기
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    Socket client = null;
    
    // [생성자]
    TimeServer() {}
    // 아래 생성자가 필요한 이유는 서버소켓에 접속해온 클라이언트소켓을
    // run메소드에서 사용해야 하니까 전역변수로 치환해야한다
    TimeServer(Socket client) {
        this.client = client;
    }
    
    // run메소드 재정의 - 스레드에서 해야 할 일을 처리함
    // 반드시 선언부 일치해야함 -> 부모가 가진 메소드와
    // Timeserver is a Thread 관계가 성립하니까 상속처리가능
    // 스레드 구현 메소드에서 서버소켓에 접속해온 client소켓을 가지고
    // 말하기와 듣기에 필요한 oos와 ois객체를 생성함
    // I/O도 지연과 데드락 상태에 빠질 수 있으므로 반드시 예외처리 할 것
    @Override
    public void run() {
        try {
            oos = new ObjectOutputStream(client.getOutputStream());
            ois = new ObjectInputStream(client.getInputStream());
            while(true) {
                oos.writeObject(getTimeMessage());  // 12:05:45
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    // TODO: handle exception
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    } // end of run()
    
    
    // [메인메소드]
    public static void main(String[] args) {
        // 서버소켓 생성 시 파라미터로 포트번호 필요함
        int port = 3000;
        
        // 동시에 여러사람이 접속 시도함
        ServerSocket server = null;
        // 여기에 들어오는 소켓은 서버소켓에 접속해온 클라이언트 소켓(주소번지)임
        Socket client = null;
        
        try {
            server = new ServerSocket(port);
        } catch (IOException ie) {
            System.out.println("Can't bind port : " + port);
            // 에러메시지를 라인번호와 함께 출력 -> 힌트문
            // 디버깅에 사용
            ie.printStackTrace();
            try {
                server.close();
            } catch (Exception e) {
                // 서버 강제 종료시킨다
                System.exit(0);
            }
        } // end of try..catch
        System.out.println("TimeServer started successfully...");

        while(true) {
            try {
                // 클라이언트가 접속해 오기를 기다리다가 접속(new Socket("192.168.10.72",3000)) 
                // 들어오면 아래 메소드가 클라이언트 소켓 정보를 취득한다
                client = server.accept();
                // 클라이언트의 네트웤 정보
                System.out.println(client.getInetAddress());
                System.out.println("New Client connected...");
                // 스레드 개입이 필요함 - 1초 동안 sleep(1000) 호출하고 현재 시,분,초 정보를 출력
                // 스레드 동작시킴 - 스레드의 추상메소드 run을 호출해야 한다
                // 주의 : run을 직접 호출하는게 아니라 start() 호출하면 JVM이 순서를 따져서 실행 - 콜백
                TimeServer ts = new TimeServer(client); // client-> 왜냐하면 run에서 사용하고 싶으니까...
                ts.start(); // run() 호출된다
                System.out.println("New TiemServer Thread started...");
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    } 


    public String getTimeMessage() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        
        return (hour < 10 ? "0" + hour : "" + hour) + ":" +
        (min < 10 ? "0" + min : "" + min) + ":" +
        (sec < 10 ? "0" + sec : "" + sec);
    }
    // return "12:05:45";
}
