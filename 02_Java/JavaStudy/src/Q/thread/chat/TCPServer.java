package Q.thread.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		
		int port = 3000;
		
		try {
			ServerSocket server = new ServerSocket(3000);
			
			System.out.println("클라이언트 요청을 기다리고 있습니다.");
			Socket socket = server.accept(); // 요청이 올때까지 server.accept()에서 기다림
			System.out.println(socket.getInetAddress().getHostAddress() + "가 연결 요청함..."); //보낸사람의 ip 
			
			ServerReceive sr = new ServerReceive(socket);
			sr.start();
			
			ServerSend ss = new ServerSend(socket);
			ss.start();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
