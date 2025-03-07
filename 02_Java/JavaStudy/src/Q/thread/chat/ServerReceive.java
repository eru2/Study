package Q.thread.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerReceive extends Thread {
	
	private Socket socket;
	
	

	public ServerReceive(Socket socket) {
		super();
		this.socket = socket;
	}



	@Override
	public void run() {
		
		try(BufferedReader br= new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
			
			//새로운 메시지가 도착하면 받아서 출력하는 동작을 무한반복한다.
			while(true) {
				String message = br.readLine();
				System.out.println("\n클라이언트로부터 받은 내용 : " + message);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.run();
	}

	
	
}
