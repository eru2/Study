package z.practice.set.ex1;

import java.util.Comparator;

public class SortedLottery  implements Comparator<Lottery>{
	
	public int compare(Lottery o1, Lottery o2) {
		if(o1.getName().compareTo(o2.getName()) == 0) {
			return o1.getPhone().compareTo(o2.getPhone());
		}
		//제목비교한 결과 반환 -> 오름차순
		return o1.getName().compareTo(o2.getName());
	}
	}
	
