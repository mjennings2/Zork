package contest;

import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		double trunkA = s.nextDouble();
		double trunkB = s.nextDouble();
		double trunkC = s.nextDouble();
		double trunkD = s.nextDouble();
		double trunkE = s.nextDouble();
		double trunkF = s.nextDouble();
		
		if(trunkA<=trunkD && trunkB <= trunkE && trunkC <= trunkF){
			System.out.println("Y");
		}else if(trunkA<=trunkE && trunkB <= trunkF && trunkC <= trunkD){
			System.out.println("Y");
		}else if(trunkA<=trunkF && trunkB <= trunkD && trunkC <= trunkE){
			System.out.println("Y");
		}else if(trunkA<=trunkF && trunkB <= trunkE && trunkC <= trunkD){
			System.out.println("Y");
		}else if(trunkA<=trunkE && trunkB <= trunkD && trunkC <= trunkF){
			System.out.println("Y");
		}else if(trunkA<=trunkD && trunkB <= trunkF && trunkC <= trunkE){
			System.out.println("Y");
		}else{
			System.out.println("N");
		}
		
		
		
	
	}

}
