package contest;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int numNums = Integer.parseInt(s.nextLine());
		
		String[] numbers = new String[numNums];
		
		for(int i = 0; i < numNums; i++){
			numbers[i] = s.nextLine();
			
		}
		for(int i = 0; i < numNums; i++){
			if(numbers[i].length() == 10 && (numbers[i].substring(0,3).equals("416") || numbers[i].substring(0,3).equals("647")) ){
				System.out.println("(" + numbers[i].substring(0,3) + ")-" + numbers[i].substring(3, 6) + "-" + numbers[i].substring(6));
			}else{
				System.out.println("not a phone number");
			}
			
		}
		
		
		
		
	}

}
