import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private Map<Integer, Node> map = new HashMap<>();
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int m = in.nextInt();
	int[][] edge = new int[m][3];
	int total_wt =0;
	for(int i=0;i<m;i++) {
		int c1 = in.nextInt();
		int c2 = in.nextInt();
		int wt = in.nextInt();
		edge[i][0] = c1;
		edge[i][1] = c2;
		edge[i][2] = wt;
	}
	Solution ka = new Solution();
	ka.sort(edge);
	for(int i=1;i<=n;i++) {
		ka.makeSet(i);
	}
	for(int i=0;i<m;i++) {
		if(ka.union(edge[i][0],edge[i][1])) {
			total_wt += edge[i][2];
		}
	}
	System.out.println(total_wt);
	
	}
	public void sort(int[][] arr) {
		int n = arr.length;
		for(int i=0;i<n-1;i++) {
			int imin = i;
			for(int j=i+1;j<n;j++) {
				if(arr[j][2]<arr[imin][2]) {
					imin = j;
				}
			}
			int temp = arr[i][0];
			   arr[i][0] = arr[imin][0];
			   arr[imin][0] = temp;
			int temp1 = arr[i][2];
			   arr[i][2] = arr[imin][2];
			   arr[imin][2] = temp1;
			   
			   int temp2 = arr[i][1];
			   arr[i][1] = arr[imin][1];
			   arr[imin][1] = temp2;
		}
	}
	private void makeSet(int data) {
		Node node = new Node();
		node.data = data;
		node.parent = node;
		node.rank = 0;
		map.put(data, node);
	}
	private boolean union(int data1, int data2) {
		Node node1 = map.get(data1);
		Node node2 = map.get(data2);
		Node parent1 = findSet(node1);
		Node parent2 = findSet(node2);
		if(parent1.data == parent2.data) {
			return false;
		}
		if(parent1.rank >= parent2.rank) {
			parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
			parent2.parent = parent1;
		}else {
			parent1.parent = parent2;
		}
		return true;
	}
	private Node findSet(Node node) {
		Node parent = node.parent;
		if(parent == node) {
			return parent;
		}
		node.parent = findSet(node.parent);
		return node.parent;
	}
	class Node {
		int data;
		Node parent;
		int rank;
	}
	

}
