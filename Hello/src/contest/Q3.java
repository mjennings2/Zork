package contest;

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		String[] wandh = s.nextLine().split(" ");
		String[] input = new String[Integer.parseInt(wandh[1])];
		int numBerrys = 0;
		
		for(int i = 0; i < Integer.parseInt(wandh[1]); i++){
			input[i] = s.nextLine();
		}
		for(int i = 0; i < Integer.parseInt(wandh[1]); i++){
			for(int j = 0; j < Integer.parseInt(wandh[0]); j++){
				if(input[i].substring(j,j+1).equals(" ") || input[i].substring(j,j+1).equals("#")){
					System.out.print(input[i].substring(j,j+1));
				}else{
					if(input[i].substring(j,j+1).equals("o")){
						System.out.print(" ");
						numBerrys++;
					}else{
						System.out.print(" ");
					}
				}
				
			}
			System.out.println();
			
		}
		for(int i = 0; i < numBerrys; i++)
			System.out.print("o");
		
		
		
	}

}
