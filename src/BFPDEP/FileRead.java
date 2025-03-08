package BFPDEP;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
public class FileRead {

public static ArrayList<String> readFile(String filePath) {
File db=new File(filePath);
ArrayList<String> arr=new ArrayList<String>();
try {
Scanner sc= new Scanner(db);
while(sc.hasNextLine()) {
	arr.add(sc.nextLine());
}
sc.close();
return arr;
}
catch(FileNotFoundException e){
	System.out.println("File Not Found");
	e.printStackTrace();
	return new ArrayList<String>();
}
}
}

