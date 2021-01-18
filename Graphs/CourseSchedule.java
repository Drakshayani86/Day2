/*The implementation is similar to cycle detection in a directed graph. If a cycle is detected then 
it is not possible to take a course*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(numCourses);
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }
        //keeps track of visited nodes
        boolean visited[] = new boolean[numCourses];
        boolean recStack[] = new boolean[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for(int i=0;i<numCourses;i++){
            if(dfs(i, adj, visited, recStack))
                return false;
        }
        return true;
    }
    public boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] recStack){
        //mark current node as true
        visited[v] = true;
        recStack[v] = true;
        for(int i:adj.get(v)){
            //if node is unvisited 
            if(!visited[i] && dfs(i, adj, visited, recStack))
                return true;
            // if node is present in recStack
            else if(recStack[i])
                return true;
        }
        //mark v as false inorder to backtrack
        recStack[v] = false;
        return false;
    }
}