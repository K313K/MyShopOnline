
public class ReversePattern {             
	            
	public static void main(String[] args)   
	{  
	int i, j, k = 10;  
	 
	for (i = 4; i >= 1; i--)   
	{  
		int x = 0;
	for (j = k; j>=1 ; j--)   
	{  
	  
	System.out.print(j+  " "); 
	x =x+1;
	k=j;
	if (i==x) {
		k= k-1;
		break;
	}
	}  
	
	System.out.println();  
	}  
	}  
	}  