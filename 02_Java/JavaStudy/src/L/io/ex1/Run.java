package L.io.ex1;

import java.io.File;
import java.io.IOException;

public class Run {
	
	/*
	 * 간단하게 파일생성 해보기
	 * 
	 * java..io.File클래스를 이용하면 된다.
	 */

	public static void main(String[] args) {
		// 1. 경로지정 없이 파일 생성
		File f1 = new File("test.txt"); // 파일 객체를 하나 만든 상태(실제파일 x 코드로 존재하는 파일 객체)
		
		// 2. 존재하는 폴더에 파일 생성
		File f2 = new File("D:\\test.txt");
		
		// 3. 존재하지 않는 경로에 파일 생성
		File f3 = new File("D:\\tmp\\test.txt");
		
		try {
			f1.createNewFile(); //createNewFile메서ㄹ드가 실행될 때 실제 파일이 만들어 진다.
			f2.createNewFile();
//			f3.createNewFile(); // 존재하지 않는 경로로 생성시 예외 발생 -> IOException
			
			//폴더를 먼저 만들고 파일이 만들어지게 하면 f3.creatNewFile 사용가능
			File tmpFolder = new File("D:\\tmp");
			tmpFolder.mkdir(); //폴더 만들어 주는 함수 -> .mkdir();
			
			f3.createNewFile();
			
			File f4 = new File("ttt.txt");
			
			//파일의 존재유무를 코드로 확인할 수 있음
			System.out.println(f4.exists()); // 파일의 존재유무 확인 코드 .exists() -> false 파일 존재 x  |  true 파일 존재 o
			System.out.println(f1.exists());
			
			//파일인지 아닌지 확인 가능할 수 있는 메서드 -> 파일이면 true | 파일이 아니면 false
			System.out.println("isFile : " + f1.isFile()); 
			System.out.println("isFile : " +  tmpFolder.isFile());
			
			//--------------------------------------------------------------
			File folder = new File("parent");
			folder.mkdir();
			
			File file = new File("parent\\person.txt");
			file.createNewFile();
			
			System.out.println("파일명 : " + file.getName());
			System.out.println("파일 경로 : " + file.getAbsolutePath());
			System.out.println("파일 용량 : " + file.length());
			System.out.println("파일 상위 폴더 : " + file.getParent());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
