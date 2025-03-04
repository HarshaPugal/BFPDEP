package BFPDEP;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
public class FileRead {

public static void main(String[] args) {
		// TODO Auto-generated method stub
File db=new File("chess.csv");
int count=0;
try {
Scanner sc= new Scanner(db);
while(sc.hasNextLine()) {
	count++;
	String data=sc.nextLine();
	System.out.println(data);
}
sc.close();
}
catch(FileNotFoundException e){
	System.out.println("File Not Found");
	e.printStackTrace();
}
System.out.println(count);
}

}
