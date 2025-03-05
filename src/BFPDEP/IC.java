package BFPDEP;

import java.util.Arrays;

public class IC {
public static void individualCount() {
	MainClass mc=new MainClass();
	int i,ic,halfMax,j,k=0;
	String[] data=FileRead.readFile(mc.filePath);
	Integer[] unique=UniqueItems.uniqueItem(data);
	Arrays.sort(unique);
	halfMax=Math.round((unique.length)/2);
	String[] a;
	Integer[] IC=new Integer[data.length];
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
	for(int l=0;l<IC.length;l++) {
	System.out.print(IC[l]+" ");
	}
}}

