package BFPDEP;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.File;
import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
public class Segmentation {
	public static Map<String,ArrayList<String>> partition(ArrayList<Integer> IC,ArrayList<String> data) {
		int i,j,g,halfMax;
		String[] a;
		ArrayList<Integer> uniqueList=UniqueItems.uniqueItem(data);
		halfMax=Math.round((float)(uniqueList.size())/2);
		ArrayList<Integer> temp;
		ArrayList<String> discard=new ArrayList<String>();
		ArrayList<String> actual=new ArrayList<String>();
		ArrayList<String> updated=new ArrayList<String>();
		for(i=0;i<IC.size();i++) {
			if(IC.get(i)>=halfMax) {
				discard.add(data.get(i));
			}
			else {
				actual.add(data.get(i));
			}
		}
		for(i=0;i<discard.size();i++) {
			a=discard.get(i).split(",");
			temp=new ArrayList<Integer>(uniqueList);
			for(j=0;j<a.length;j++) {
				if(uniqueList.contains(Integer.parseInt(a[j]))) {
					temp.remove(Integer.valueOf(Integer.parseInt(a[j])));
				}
			}
			discard.set(i, String.join(",", temp.stream().map(String::valueOf).toArray(String[]::new)));
		}
		g=0;
		for(i=0;i<IC.size();i++) {	
			if(IC.get(i)>=halfMax) {
				updated.add(discard.get(g));
				g++;
			}
			else {
				updated.add(data.get(i));
			}
		}
		
		try {
			File file=new File("Database/updated.csv");
				try (FileWriter ds = new FileWriter(file,true)) {
					new FileWriter(file,false).close();
					for(i=0;i<updated.size();i++) {
						ds.write(updated.get(i)+"\n");
					}
					ds.close();
				}
		}
		catch(IOException e){
			System.out.println("Error");
			e.printStackTrace();
		}
		Map<String,ArrayList<String>> result=new HashMap<>();
		result.put("updated", updated);
		result.put("discard",discard);
		result.put("actual",actual);
		return result;
	}
}
