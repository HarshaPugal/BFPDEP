package BFPDEP;

import java.util.ArrayList;
import java.util.HashMap;

public class NoOfOnes {
	public static ArrayList<Integer> count(HashMap<Integer,ArrayList<Integer>> bvr,ArrayList<Integer> uniqueList,ArrayList<String> updated) {
		int count;
		ArrayList<Integer> countList=new ArrayList<Integer>();
		for(int key:bvr.keySet()) {
			ArrayList<Integer> bvr2=bvr.get(key);
			count=0;
			for(int j=0;j<bvr2.size();j++) {
				if(bvr2.get(j)==1) {
					count++;
				}
			}
			countList.add(count);
		}
		return countList;
		
	}
}
