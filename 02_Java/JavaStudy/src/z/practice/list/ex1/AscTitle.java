package z.practice.list.ex1;

import java.util.Comparator;

public class AscTitle implements Comparator<Music>{
	
	public int compare(Music o1, Music o2) {
		//Title의 오름차순으로 정렬하는 기준을 마련한다.
		
		//compareTo ->  나 자신과 비교해서 크면 1반환 작으면 -1 동일하면 0
		
		
		//o1의 제목이 o2의 제목보다 사전적으로 크면 1
		//o1의 제목이 o2의 제목보다 사전적으로 작으면 -1
		//o1의 제목이 o2의 제목보다 사전적으로  같으면 0
//		o1.getTitle().compareTo(o2.getTitle()); //제목이 같으면 0
		
		if(o1.getTitle().compareTo(o2.getTitle()) == 0) {
			return o1.getSinger().compareTo(o2.getSinger());
		}
		//제목비교한 결과 반환 -> 오름차순
		return o1.getTitle().compareTo(o2.getTitle());
	}
	

}
