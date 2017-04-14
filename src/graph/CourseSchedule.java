package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import linkedlist.ListNode;


public class CourseSchedule {
	 public boolean canFinish(int numCourses, int[][] prerequisites) {
		 int[] indegree = new int[numCourses];
		 Queue<Integer> queue = new ArrayDeque<>();
		 List<List<Integer>> adjList = new ArrayList<>();
		 // init
		 for(int i = 0;i<numCourses;i++) adjList.add(new ArrayList<>());
		 for(int i = 0;i<prerequisites.length;i++){
			 int from = prerequisites[i][1];
			 int to = prerequisites[i][0];
			 indegree[to]++;
			 adjList.get(from).add(to);
		 }
		 
		 for(int i=0;i<numCourses;i++){
			 if(indegree[i]==0)queue.add(i);
		 }
		 
		 int inqueue = 0;
		 while(!queue.isEmpty()){
			 int from = queue.poll();
			 inqueue++;
			 for(int to:adjList.get(from)){
				 indegree[to]--;
				 if(indegree[to]==0)queue.add(to);
			 }
		 }
		 
		 if(inqueue<numCourses)return false;
		 else return true;
	        
	 }
	 
	 public int[] findOrder(int numCourses, int[][] prerequisites) {
		 int[] path = new int[numCourses];
		 int[] indegree = new int[numCourses];
		 Queue<Integer> queue = new ArrayDeque<>();
		 List<List<Integer>> adjList = new ArrayList(numCourses);
		 for(int i = 0;i<numCourses;i++)adjList.add(new ArrayList<>());
		 
		 for(int i = 0;i<prerequisites.length;i++){
			 int prev = prerequisites[i][1];
			 int cur = prerequisites[i][0];
			 indegree[cur]++;
			 adjList.get(prev).add(cur);
		 }
		 
		 for(int i = 0;i<numCourses;i++){
			 if(indegree[i]==0)queue.add(i);
		 }
		 if(queue.isEmpty())return new int[0];
		 
		 int next = 0;
//		 boolean[] isVisit = new boolean[numCourses];
		 while(!queue.isEmpty()){
			 int from = queue.poll();
//			 if(isVisit[from]==true){
//				 continue;
//			 }
			 path[next++] = from;
//			 isVisit[from] = true;
			 for(int to: adjList.get(from)){
				 indegree[to]--;
				 if(indegree[to]==0)queue.add(to);
			 }
//			 for(int i = 0;i<numCourses;i++){
//				 if(indegree[i]==0)queue.add(i);
//			 }
			 
		 }
		 if(next<numCourses)return new int[0];
		 else return path;
	 }
	 
	 public static void main(String[] args) {
//		int[][] pre = new int[4][2];
//		pre[0] = new int[]{1,0};
//		pre[1] = new int[]{2,0};
//		pre[2] = new int[]{3,1};
//		pre[3] = new int[]{3,2};
		 
//		int[][] pre = new int[3][2];
//		pre[0] = new int[]{0,1};
//		pre[1] = new int[]{1,0};
//		pre[2] = new int[]{1,2};
		 int[][] pre = new int[1][2];
		 pre[0] = new int[]{0,1};
		
		CourseSchedule sol = new CourseSchedule();
//		int[] order = sol.findOrder(3, pre);
//		System.out.println(Arrays.toString(order));
		
		boolean can = sol.canFinish(2, pre);
		System.out.println(can);
		
	}

}
