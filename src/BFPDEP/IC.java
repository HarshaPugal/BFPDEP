package BFPDEP;
import java.util.Map;
import java.util.Arrays;
import java.util.ArrayList;
public class IC {
	public static Integer[] individualCount(String filePath) {
		int i,ic,halfMax,j,k=0;
		String[] data=FileRead.readFile(filePath);
		Integer[] unique=UniqueItems.uniqueItem(data);
		Arrays.sort(unique);
		halfMax=Math.round((unique.length)/2);
		String[] a;
		Integer[] IC=new Integer[data.length];
		System.out.println(unique.length);
		System.out.println(halfMax);
		for(i=0;i<data.length;i++) {
			a=data[i].split(",");
			ic=0;
			for(j=0;j<a.length;j++) {
				ic++;
			}
			IC[k]=ic;
			k++;
		}
	
	
	Map<String,ArrayList<String>> result=Segmentation.partition(IC,data,halfMax);
	ArrayList<String> discard=result.get("discard");
	ArrayList<String> actual=result.get("actual");
	System.out.println("discard="+discard);
	System.out.println("actual="+actual);
		return IC;
	}
}

