package dev_java.week5.d221230.exam;

import java.net.InetAddress;
import java.net.Socket;

public class NetworkClient {
	public void client() {
		int port = 3000;
		String serverIP = null;
		try {
			// serverIP = InetAddress.getLocalHost().getHostAddress();
			serverIP = "192.168.10.72";
			Socket socket = new Socket(serverIP, port);
			System.out.println("NetworkClient socket : " + socket);
		} catch (Exception e) {
			System.out.println("NetworkClient client : " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		NetworkClient nc = new NetworkClient();
		nc.client();
	}

}

/*
 * TCP 소켓을 사용하여 클라이언트에서 서버로 연결처리하는 네트워크 프로그램을 구동하였으나 
서버와 연결이 되지 않았다. 문제점이 있는 코드를 찾아 [원인](30점)에 파악된 문제점을 기술하고,
해결 방안을 구상하여 [조치내용](30점)에 해결방법을 작성하여 보고서를 완성하시오. (총 60점)


- 서버 IP : 192.168.20.34, 포트번호 : 3000
 */

 /*
클라이언트용 프로그래밍 코드 내
serverIP 변수의 초기화를 [serverIP = InetAddress.getLocalHost().getHostAddress()']로 초기화 되어있다.

따라서 try-catch문 내 [Socket socket = new Socket(serverIP, port);] 코드를 실행 시
클라이언트 자신의 localhost IP로 접속 시도하게 되어 서버와 통신할 수 없는 증상이 발생한다.

------
serverIP 변수를 접속 시도할 서버의 IP로 초기화한다.

  */