package BFPDEP;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
public class FileRead {

public static String[] readFile(String filePath) {
File db=new File(filePath);
int count=0,i,j;
String[] arr;
try {
Scanner sc= new Scanner(db);
while(sc.hasNextLine()) {
	count++;
	sc.nextLine();
}
sc.close();
sc= new Scanner(db);
i=0;
arr=new String[count];
while(sc.hasNextLine()) {
	arr[i]=sc.nextLine();
	i++;
}
sc.close();
return arr;
}
catch(FileNotFoundException e){
	System.out.println("File Not Found");
	e.printStackTrace();
	return new String[0];
}
}
}

