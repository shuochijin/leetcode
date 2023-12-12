package contest.weekly.no316;

public class No6214 {
	
	public static void main(String[] args) {
		String a = "12:00";
		String b = "01:00";
		System.out.println(a.compareTo(b));
		System.out.println("12:00".compareTo("12:00"));
		System.out.println("02:00".compareTo("12:00"));
		No6214 n = new No6214();
		System.out.println(n.haveConflict(new String[] {"01:15","02:00"}, new String[] {"02:00","03:00"}));
		System.out.println(n.haveConflict(new String[] {"01:00","02:00"}, new String[] {"01:20","03:00"}));
		System.out.println(n.haveConflict(new String[] {"10:00","11:00"}, new String[] {"14:00","15:00"}));
	}

	public boolean haveConflict(String[] event1, String[] event2) {
		boolean result = true;
		if(event1[0].compareTo(event2[1]) > 0
				|| event1[1].compareTo(event2[0]) < 0){
			result = false;
		}
		return result;
    }
	
}
