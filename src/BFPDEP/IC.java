package BFPDEP;
import java.util.ArrayList;
public class IC {
	public static ArrayList<Integer> individualCount(String filePath) {
		int i,ic,j,total=0;
		ArrayList<String> data=FileRead.readFile(filePath);
		String[] a;
		ArrayList<Integer> IC=new ArrayList<Integer>();
		for(i=0;i<data.size();i++) {
			a=data.get(i).split(",");
			ic=0;
			for(j=0;j<a.length;j++) {
				ic++;
			}
			total=total+ic;
			IC.add(ic);
		}
		System.out.println(total);
		return IC;
	}
}

