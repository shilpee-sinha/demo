import java.util.Scanner;
import java.util.Scanner;
import java.io.*;
import java.io.FileNotFoundException;
class CreateMatrix {

   static final int N = 4; 
      
    
    static void getCofactor(int mat[][],  
             int temp[][], int p, int q, int n) 
    { 
        int i = 0, j = 0; 
      
        
        for (int row = 0; row < n; row++) 
        { 
            for (int col = 0; col < n; col++) 
            { 
                
                if (row != p && col != q) 
                { 
                    temp[i][j++] = mat[row][col]; 
      
                    if (j == n - 1) 
                    { 
                        j = 0; 
                        i++; 
                    } 
                } 
            } 
        } 
    } 
      
    
    static int determinantOfMatrix(int mat[][], int n) 
    { 
        int D = 0; // Initialize result 
        if (n == 1) 
            return mat[0][0]; 
          
       
        int temp[][] = new int[N][N];  
          
       
        int sign = 1;  
      
      
        for (int f = 0; f < n; f++) 
        { 
            
            getCofactor(mat, temp, 0, f, n); 
            D += sign * mat[0][f]  
               * determinantOfMatrix(temp, n - 1); 
      
           
            sign = -sign; 
        } 
      
        return D; 
    } 
      

public static void main(String args[])throws FileNotFoundException{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the dimension of matrix");
	int N=sc.nextInt();
 
      	int[][] arr = new int[20][20];
	File f=new File("C:\\shilpee\\matrix1.txt");
	 Scanner scn=null;
	scn = new Scanner(f);

	 String line = scn.nextLine(); 
	 String[] numbers = line.split(" "); 

 	for(int i = 0; i < N; i++)
    	 for(int j = 0; j < N; j++)
         arr[i][j] = Integer.parseInt(numbers[j]); 

	System.out.println("\nThe Matrix is :");
		for(int i=0; i < N; i++) {
			for(int j=0; j < N; j++) {
				System.out.print("\t" + arr[i][j]);
			}
			System.out.println();
		}

int D= determinantOfMatrix(arr,N);
 System.out.print("Determinant " +  "of the matrix is : ");
System.out.println(D); 

	}
}