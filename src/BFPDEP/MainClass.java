package BFPDEP;

public class MainClass {

	public static void main(String[] args) {
		int j;
		String filePath="Database/sample.csv";
		String[] data=FileRead.readFile(filePath);
		for(j=0;j<data.length;j++) {
			System.out.println(data[j]);
		}
	}

}
