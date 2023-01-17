
public class AddTwoMatrics {
	public static void main(String args[]){  
		int mt1[][]={{1,2,3},{4,5,6},{7,8,9}};    
		int mt2[][]={{9,8,7},{6,5,4},{3,2,1}};    
		     
		int mt3[][]=new int[3][3];  
  
		for(int i=0;i<3;i++){    
			for(int j=0;j<3;j++){    
				mt3[i][j] = mt1[i][j] + mt2[i][j];
				System.out.print(mt3[i][j]+" ");    
		}    
		System.out.println();    
		}    
	}
}
