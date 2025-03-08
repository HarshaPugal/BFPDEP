package BFPDEP;
import java.util.*;
public class UniqueItems {
	public static ArrayList<Integer> uniqueItem(ArrayList<String> data) {
		String[] a;
		HashSet<Integer>unique=new HashSet<Integer>();
		for(int i=0;i<data.size();i++) {
			a=data.get(i).split(",");
			for(int j=0;j<a.length;j++) {
				int n=Integer.parseInt(a[j]);
				unique.add(n);
			}
		}
		ArrayList<Integer> uniqueList=new ArrayList<Integer>(unique);
		Collections.sort(uniqueList);
		return uniqueList;
	}

}
