package BFPDEP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FrequentItemset {
    public static ArrayList<ArrayList<Integer>> frequentItemSet(
        ArrayList<Integer> uniqueList, 
        ArrayList<Integer> c, 
        ArrayList<Integer> c1, 
        HashMap<Integer,ArrayList<Integer>> actualBvr, 
        HashMap<Integer,ArrayList<Integer>> discardBvr) {

        ArrayList<ArrayList<Integer>> frequent = new ArrayList<>();
        ArrayList<Integer> oneItemSet = new ArrayList<>();
        System.out.print("Enter the minimum support: ");
        Scanner sc=new Scanner(System.in);
        int minimum_support=sc.nextInt();
        sc.close();
        for (int i=0;i<c.size();i++) {
            int k=c.get(i)+c1.get(i);
            if (k>=minimum_support) {
                oneItemSet.add(uniqueList.get(i));
            }
        }
        generateFrequentItemsets(oneItemSet,new ArrayList<>(),0,frequent,actualBvr,discardBvr);
        return frequent;
    }
    private static void generateFrequentItemsets(
        ArrayList<Integer> oneItemSet, 
        ArrayList<Integer> currentSubset, 
        int start, 
        ArrayList<ArrayList<Integer>> frequent, 
        HashMap<Integer,ArrayList<Integer>> actualBvr, 
        HashMap<Integer,ArrayList<Integer>> discardBvr) {

        if (!currentSubset.isEmpty()) { 
            ArrayList<Integer> actual_subset = bitOperation(currentSubset, actualBvr);
            ArrayList<Integer> discard_subset = bitOperation(currentSubset, discardBvr);

            int a_ct=0;
            for (int value : actual_subset) {
                if (value==1) {
                    a_ct++;
                }
            }

            int d_ct=0;
            for (int value : discard_subset) {
                if (value==1) {
                    d_ct++;
                }
            }
            if (a_ct+d_ct>=3 && currentSubset.size()>1) {
                frequent.add(new ArrayList<>(currentSubset));
            }
        }
        for (int i=start;i<oneItemSet.size();i++) {
            currentSubset.add(oneItemSet.get(i));
            generateFrequentItemsets(oneItemSet,currentSubset,i + 1,frequent,actualBvr,discardBvr);
            currentSubset.remove(currentSubset.size()-1); 
    
        }
    }

	public static ArrayList<Integer> bitOperation(ArrayList<Integer> temp,HashMap<Integer,ArrayList<Integer>> bvr) {
		ArrayList<ArrayList<Integer>> temp_bit=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> sub_res=new ArrayList<Integer>();
		for(int i=0;i<temp.size();i++) {
			temp_bit.add(bvr.get(temp.get(i)));
		}
		int k=0,b,size;
		size=temp_bit.get(0).size();
		while(k!=size) {
			b=1;
		for(int j=0;j<temp_bit.size();j++) {
	
			b=b & temp_bit.get(j).get(k);
		}
		sub_res.add(b);
		k++;
		}
		return sub_res;
		
	}
}
