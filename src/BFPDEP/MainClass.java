package BFPDEP;
import java.util.*;
public class MainClass {
    public static String filePath="Database/sample.csv";
    public static String uFilePath="Database/updated.csv";
	public static void main(String[] args) {
		ArrayList<String> data=FileRead.readFile(filePath);	
		ArrayList<Integer> uniqueList=UniqueItems.uniqueItem(data);
		System.out.println("unique="+uniqueList);
		System.out.println("Original="+data);
		ArrayList<Integer> individualCount=IC.individualCount(filePath);
		Map<String,ArrayList<String>> result=Segmentation.partition(individualCount, data);
		ArrayList<String>updated=result.get("updated");
		ArrayList<String>actual=result.get("actual");
		ArrayList<String>discard=result.get("discard");
		System.out.println("updated="+updated);
//		ArrayList<Integer> uindividualCount=IC.individualCount(uFilePath);
		HashMap<Integer,ArrayList<Integer>> actualBvr=BVR.bitVector(uniqueList, actual);
		HashMap<Integer,ArrayList<Integer>> discardBvr=BVR.bitVector(uniqueList, discard);
		System.out.println("Actual BVR");
		System.out.println(actualBvr);
		System.out.println("Discard BVR");
		for(int key:discardBvr.keySet()) {
			ArrayList<Integer> bvr=discardBvr.get(key);
			for(int j=0;j<bvr.size();j++) {
				bvr.set(j,bvr.get(j)==0 ? 1 : 0);
			}
		}
		System.out.println(discardBvr);
		ArrayList<Integer> c=NoOfOnes.count(actualBvr, uniqueList, updated);
		System.out.println(c);
		ArrayList<Integer> c1=NoOfOnes.count(discardBvr, uniqueList, updated);
		System.out.println(c1);
		ArrayList<ArrayList<Integer>> k=FrequentItemset.frequentItemSet(uniqueList, c, c1, actualBvr, discardBvr);
		System.out.println(k);
	}
}

