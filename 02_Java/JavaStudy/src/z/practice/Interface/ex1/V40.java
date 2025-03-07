package z.practice.Interface.ex1;

public class V40 extends SmartPhone implements NotePen{

	public V40() {
		super();
		super.setMaker("LG");
	}
	@Override
	public String charge() {
		// TODO Auto-generated method stub
		return "고속충전, 고속 무선 충전";
	}

	@Override
	public String makeCall() {
		// TODO Auto-generated method stub
		return "번호를 누르고 통화버튼을 누름";
	}

	@Override
	public String takeCall() {
		// TODO Auto-generated method stub
		return "전화받기 버튼을 누름";
	}

	@Override
	public String picture() {
		// TODO Auto-generated method stub
		return "1200, 1600만 화소 트리플 카메라";
	}

	@Override
	public String touch() {
		// TODO Auto-generated method stub
		return "정전식";
	}

	@Override
	public boolean bluetoothPen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String printInformation() {
		String result = "";
		result +=("V40는" + this.getMaker() + "에서 만들어졌고 제원은 다음고 같다. \n");
		result += (this.makeCall() + "\n");
		result += (this.takeCall() + "\n");
		result += (this.picture() + "\n");
		result += (this.charge() + "\n");
		result += (this.touch() + "\n");
		result += ("블루투스 펜 탑재 여부 : " + this.bluetoothPen());
		return result;
	}

}
