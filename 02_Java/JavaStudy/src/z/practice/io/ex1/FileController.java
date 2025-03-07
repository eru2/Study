package z.practice.io.ex1;

public class FileController {
	
	private FileDAO fd = new FileDAO();
	
	public boolean checkName(String file) {
		boolean re = fd.checkName(file);
		return re;
	}
	
	public void fileSave(String file, StringBuilder sb) {
		String str = sb.toString();
		fd.fileSave(file,str);
	}
	
	public StringBuilder fileOpen(String file) {
		StringBuilder edit = fd.fileOpen(file);
		return edit;
	}
	
	public void fileEdit(String file, StringBuilder sb) {
		String strEdit = sb.toString();
		fd.fileEdit(file, strEdit);
	}

}
