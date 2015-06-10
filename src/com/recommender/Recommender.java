package com.recommender;

import java.io.*;
import java.util.Scanner;

public class Recommender {
	
	public static void main(String[] args) {
		int row=707,col=8571;
		Similarity s = new Similarity();
		int user=0;
		Scanner in = new Scanner(System.in);
		double[][] r= new double [row][col];
		int i=0,size=0;
		BufferedReader br=null;
		String line ;
		try {
			i=1;
			br = new BufferedReader(new FileReader("I:/Data Recommender/ml-latest-small/user_vs_movies.csv"));
			while((line=br.readLine())!=null)
			{	
				String[] b =line.split(",");
				size=b.length;
				for(int k=1;k<=size;k++)
				{
					r[i][k]= Double.valueOf(b[k-1]).doubleValue();
				
				}
				i++;
				
			}
			System.out.println("Enter the user");
			user=in.nextInt();
			System.out.println("Similar user of "+ user+" is :"+s.similar(user, r, row, col));
			

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("Done!!!!!");
		}
		
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		
	}
}
