package z.practice.set.ex1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class LotteryController {

	private HashSet lottery = new HashSet();
	private HashSet win = new HashSet();

	public boolean insertObject(Lottery l) {
		return lottery.add(l);
	}

	public boolean deleteObject(Lottery l) {
		if (win.equals(l)) {
			lottery.remove(l);
			win.remove(l);
			return true;
		} else {
			lottery.remove(l);
			return true;
		}
	}

	public HashSet winObject() {
		if (lottery.size() >= 4) {
			return null;
		}
		List<Lottery> loList = new ArrayList<>();
		loList.addAll(lottery);

		while (win.size() < 4) {
			int rand = (int) (Math.random() * loList.size());
			win.add(rand);
		}
		return win;
	}

	public TreeSet sortedWinObject() {
		TreeSet sortedWinSet = new TreeSet(new SortedLottery());
		sortedWinSet.addAll(win);
		return sortedWinSet;
	}

	public boolean searchWinner(Lottery l) {
		return win.contains(l);
	}
}
