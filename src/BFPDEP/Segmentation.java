package BFPDEP;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
public class Segmentation {
	public static Map<String,ArrayList<String>> partition(Integer[] IC,String[] data,Integer halfMax) {
		int i;
		ArrayList<String> discard=new ArrayList<String>();
		ArrayList<String> actual=new ArrayList<String>();
		for(i=0;i<IC.length;i++) {
			
			if(IC[i]>=halfMax) {
				discard.add(data[i]);
			}
			else {
				actual.add(data[i]);
			}
		}
		
try {
	File file=new File("Database/discard.csv");
		FileWriter ds=new FileWriter(file,true);
		new FileWriter(file,false).close();
		for(i=0;i<discard.size();i++) {
			ds.write(discard.get(i)+"\n");
		}
		ds.close();
}
catch(IOException e){
	System.out.println("Error");
	e.printStackTrace();
}
Map<String,ArrayList<String>> result =new HashMap<>();
result.put("discard",discard);
result.put("actual",actual);
return result;
	}
}
