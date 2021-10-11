package com.gl.dsalab.problem1.main;
import java.util.*;
public class BalancedBracket {
	
	//function to check if the string has balanced bracket
	public static boolean checkBalancedBracket(String s) {
		
		Stack<Character> balStack = new Stack<Character>();
		
		if(s.length()%2!=0) {
			
			return false;
		}
		
		else {
			
			for(int i=0;i<s.length();i++) {
				
				char ch = s.charAt(i);				
				if(ch=='(' || ch=='[' || ch=='{') {
					
					balStack.push(ch);
					continue;
				}
				
				if(balStack.isEmpty()) {
					return false;
				}
				char c;
				
				switch(ch) {
				
				case '}':
					c=balStack.pop();
					if(c=='[' || c=='(')
						return false;
					break;
				case ']' :
					c =balStack.pop();
					if(c=='{' || c=='(' )
						return false;
					break;
				case ')' :
					c=balStack.pop();
					if(c=='{' || c=='[')
						return false;
					break;
				}				
			}
			
			return balStack.isEmpty();
		}		
		
	}
	//Driver Code

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String to be checked");
		String str = sc.next();
		boolean res = checkBalancedBracket(str);
		if(res) {
			System.out.println("The entered String has Balanced Brackets");
		}
		else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
		
		sc.close();

	}

}
