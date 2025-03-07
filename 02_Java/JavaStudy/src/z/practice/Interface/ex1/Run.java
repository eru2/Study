package z.practice.Interface.ex1;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PhoneController pc = new PhoneController();
		
		String[] results = pc.method();
		
		for(String res : results) {
			System.out.println(res);
			System.out.println();
		}
		
	}

}
