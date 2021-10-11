package com.gl.dsalab.problem2.driver;

import java.util.ArrayList;

public class LongestPath {
	
	//Node class
	static class Node{
		Node leftNode;
		Node rightNode;
		int nodeData;
	};
	
	// function to create a new node
	static Node newNode(int nodeData) {
		Node temp = new Node();
		
		temp.nodeData = nodeData;
		temp.leftNode = null;
		temp.rightNode = null;
		
		return temp;
	}
	
	//function to find the longest path in a tree
	public static ArrayList<Integer> findLongestPath(Node root){
		
		if(root ==null) {
			ArrayList<Integer> res = new ArrayList<>();
			return res;
		}
		
		ArrayList<Integer> right = findLongestPath(root.rightNode);
		
		ArrayList<Integer> left = findLongestPath(root.leftNode);
		
		if(right.size() < left.size())
		{
			left.add(root.nodeData);
		}
		else
		{
			right.add(root.nodeData);
		}
		
		return(left.size()>right.size()? left: right);
	}
	
	//Driver Code
	public static void main(String[] args) {
		Node root = newNode(100);
		root.leftNode = newNode(20);
		root.rightNode = newNode(130);
		root.leftNode.leftNode = newNode(10);
		root.leftNode.rightNode = newNode(50);
		root.rightNode.leftNode =newNode(110);
		root.rightNode.rightNode = newNode(140);
		root.leftNode.leftNode.leftNode = newNode(5);
		
		ArrayList<Integer> res = findLongestPath(root);
		int n = res.size();
		
		System.out.print(res.get(n-1));
		for(int i=n-2;i>=0;i--) {
			System.out.print(" -> " +res.get(i));
		}

	}

}
