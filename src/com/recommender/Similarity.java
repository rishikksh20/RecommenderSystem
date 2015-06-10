package com.recommender;

public class Similarity {
	
	public int similar(int usr,double[][]mat,int row,int col)
	{	int user = 0,count=0,g=0,gmin=0;
		double rmse=0,min=100000,tsum=0;
		double sum=0,mean=0;
		int i=0,j=0,k=0;
		double[] rating=new double[8571];
		double[] err=new double[707];
		
		for(i=1;i<=706;i++)
		{   count=0;
			k=0;
			g=0;
			if(i==usr)
				continue;
				for(j=1;j<=8570;)
				{	
					if(mat[usr][j]==0 || mat[i][j]==0)
						{
							count++;
							rating[j]=0;
							j++;
							continue;
						}
					
						rating[j]=mat[usr][j]-mat[i][j];
						
						j++;
				
				}
				g=8570-count;
				sum=0.0;
				System.out.print(" User: "+i);
				System.out.print(" g: "+g);
				if(g > 0)
				{	
					System.out.print(" Inside g: "+g);
					for( k=1;k<=8570;k++)
				 	{ 					
						sum = sum +rating[k]*rating[k];
				 	}
				 	System.out.print(" Sum: "+sum);
				 	mean=sum/g;
				 	System.out.print(" Mean: "+mean);
				 	rmse= Math.sqrt(mean);
				 	err[i]= rmse;
				 	System.out.print(" RMSE: "+rmse+"\n");
				 	if(g>10)
				 	{
				 		if(rmse<min)
				 		{	
				
				 			user=i;
				 			min=rmse;
				 			gmin=g;
				 			tsum=sum;
				 			System.out.println(user +" Total both rated: "+gmin+" Sum: "+sum+" g= "+g+" User error "+err[user]);
				
				 	}
				 	}
				
				}
			
				
	}
		for(i=1;i<=706;i++)
			System.out.println("User"+i+": "+err[i]);
		
		System.out.println("Total sum rated: "+tsum);
		System.out.println("Minimum Roor Mean Square is "+min);
		
		return user;		
	}
	
	
}
