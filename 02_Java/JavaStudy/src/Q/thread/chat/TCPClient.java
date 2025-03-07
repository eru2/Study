package Q.thread.chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	public static void main(String[] args) {
	

		try {
			// 소프트웨어가 실행중인 본인의 ip는
			// 127.0.0.1 or localhost라는 대명사로 작성 가능
			Socket socket = new Socket("localhost", 3000);
			
			ClientReceive cr = new ClientReceive(socket);
			cr.start(); //계속해서 값을 받아와서 출력하는 동작을 쓰레드로 실행
			
			ClientSend cs = new ClientSend(socket);
			cs.start();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
