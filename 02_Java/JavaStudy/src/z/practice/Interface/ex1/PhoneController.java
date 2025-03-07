package z.practice.Interface.ex1;

public class PhoneController {

	private String[] result = new String[2];
	
	public String[] method() {
		Phone[] phArr = new Phone[2];
		
		phArr[0] = new GalaxyNote9();
		phArr[1] = new V40();
		
		for(int i = 0; i < phArr.length; i++) {
			if(phArr[i] instanceof SmartPhone) {
				result[i] = ((SmartPhone)phArr[i]).printInformation(); //GalaxyNote9으로 하면 V40으로 다시 해줘야 하는데 SmartPhone으로 하면 한번에 가능
				//SmartPhone으로 해도 GalaxyNote9이랑 V40 가능 (오버라이딩 관계)
			}
		}
		
		return result;
	}
}
