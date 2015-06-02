package contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class O4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		boolean negativeEven = false;
		
		int numCards = s.nextInt();
		ArrayList<Integer> cards = new ArrayList<Integer>();
		for(int i = 0; i < numCards; i++){
			int x = s.nextInt();
			if(x != 0)
			cards.add(x);
			if(x < 0)
				negativeEven = !negativeEven;
		}
		
		if(negativeEven && (cards.size() != 1) || (cards.get(0) == -3)){
			int minIndex = 0;
			for(Integer i : cards){
				
				if(i<0 && i > cards.get(minIndex)){
					minIndex = cards.indexOf(i);
				}
			}
			cards.remove(minIndex);
		}
		
		int sum = 1;
		
		for(Integer i : cards){
			sum *= i;
		}
		if(cards.isEmpty()){
			System.out.println("0");
		}else
		System.out.println(sum);
		
	}

}
