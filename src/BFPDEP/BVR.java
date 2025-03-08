package BFPDEP;
import java.util.ArrayList;
import java.util.Map;
public class BVR {
	public static ArrayList<ArrayList<Integer>> bitVector(ArrayList<Integer> uniqueList,ArrayList<String> updated){
		int i,j,k=0;
		String[] a;
		ArrayList<ArrayList<Integer>> bvr=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> inbvr;
		ArrayList<Integer> temp;
		for(k=0;k<uniqueList.size();k++) {
			inbvr=new ArrayList<Integer>();
			for(i=0;i<updated.size();i++) {
				temp=new ArrayList<Integer>();
			    a=updated.get(i).split(",");
				for(j=0;j<a.length;j++) {
					temp.add(Integer.parseInt(a[j]));
				}
				if(temp.contains(uniqueList.get(k))) {
					inbvr.add(1);
				}
				else {
					inbvr.add(0);
				}

			}
			bvr.add(inbvr);
		}
		return bvr;
	}
}
