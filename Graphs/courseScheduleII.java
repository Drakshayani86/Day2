class Solution {
    //inorder to detect a cycle 
    public boolean isCyclic = false;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<numCourses;i++){
            topologicalSort(adj, st, i, visited, recStack);
        }
        //if cycle is detected then no course can be taken
        if(isCyclic)
            return new int[]{};
        //initialize res with size of stack
        int res[] = new int[st.size()];
        int k = 0;
        //pop elements from stack and add into result
        while(!st.isEmpty()){
            res[k++]=st.pop();
        }
        return res;
    }
     public void topologicalSort(ArrayList<ArrayList<Integer>> graph, Stack<Integer> st, int curr,boolean[] visited,boolean[] recStack){
        //if node in recStack then cycle is detected
        if(recStack[curr])
            isCyclic = true;
        //skip visited nodes
        if(visited[curr])
            return;
        //mark current node as true
        visited[curr] = true;
        recStack[curr] = true;
        for(int x:graph.get(curr)){
            topologicalSort(graph,st,x,visited,recStack);
        }
        //mark current node as false as cycle is not detected
        recStack[curr] = false;
        //push curr node into stack
        st.push(curr);
    }
}