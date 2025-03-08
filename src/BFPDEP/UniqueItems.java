package BFPDEP;
import java.util.*;
public class UniqueItems {
	public static Integer[] uniqueItem(String[] data) {
		String[] a;
		HashSet<Integer>unique=new HashSet<Integer>();
		for(int i=0;i<data.length;i++) {
			a=data[i].split(",");
			for(int j=0;j<a.length;j++) {
				int n=Integer.parseInt(a[j]);
				unique.add(n);
			}
		}
	return (unique.toArray(new Integer[0]));
	}

}
