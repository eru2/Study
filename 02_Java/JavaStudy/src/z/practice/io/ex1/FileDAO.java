package z.practice.io.ex1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDAO {
	
	public boolean checkName(String file) {
		File f = new File(file);
		return f.exists();
	}
	
	public void fileSave(String file, String s) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file));) {
			bw.write(s);
		} catch (IOException e) {

			e.printStackTrace();
		}		
	}
	
	public StringBuilder fileOpen(String file) {
		StringBuilder res= new StringBuilder();
		try(BufferedReader br = new BufferedReader(new FileReader(file));) {
			String str = null;
			while((str = br.readLine()) != null) {
				res.append(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}		
		return res;
	}
	
	public void fileEdit(String file, String s) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));) {
			bw.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		// 매개변수로 들어온 file을 파일 명으로 이용하여 파일을 찾고
		// String에 써서 저장하되 이어서 저장될 수 있도록 함		
	}

}
