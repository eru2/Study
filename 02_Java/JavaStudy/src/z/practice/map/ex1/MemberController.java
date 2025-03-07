package z.practice.map.ex1;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class MemberController {
    private HashMap<String, Member> map = new HashMap<>();

    public boolean joinMembership(String id, Member m) {
    	if(map.get(id)==null) {
    		map.put(id, m);
    		return true;
    	}
//        if (!map.containsKey(id)) {
//            map.put(id, m);
//            return true;
//        }
        return false;
    }

    public String logIn(String id, String password) {
//    	Member member = map.get(id);
    	
        if (map.containsKey(id)) {
            Member member = map.get(id);
            if (member.getPassword().equals(password)) {
                return member.getName();
            }
        }
        return null;
    }

    public boolean changePassword(String id, String oldPw, String newPw) {
        Member member = map.get(id);
        if(member != null && member.getPassword().equals(oldPw)) {
        	return true;
        }
//        if (map.containsKey(id)) {
//            Member member = map.get(id);
//            if (member.getPassword().equals(oldPw)) {
//                member.setPassword(newPw);
//                return true;
//            }
//        }
        return false;
    }

    public void changeName(String id, String newName) {
        if (map.containsKey(id)) {
            Member member = map.get(id);
            member.setName(newName);
        }
    }

    public TreeMap sameName(String name) {
    	TreeMap result = new TreeMap((o1,o2) -> ((String)o1).compareTo((String)o2));
    	
    	
    	Set keys = map.keySet();
    	for(Object id : keys) {
    		Member member = (Member)map.get(id);
    		if(member.getName().equals(name)) {
    			result.put(id, member.getName());
    		}
    	}
    	return result;
    }
}

