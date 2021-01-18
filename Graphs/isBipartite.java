class GfG
{
    boolean isBipartite(int G[][],int V){
        return isBipartiteGraph(G, 0, V);
    }
    boolean isBipartiteGraph(int G[][], int src, int V){
        int[] color = new int[V];
	//Initialize color of all nodes as -1
        Arrays.fill(color, -1);
        Queue<Integer> q = new LinkedList<>();
        //let color of source be 1
        color[src] = 1;
        //add source into queue
        q.add(src);
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i=0;i<V;i++){
                //check whether there exists a self loop
                if(G[i][i]==1)
                    return false;
                //check if color of adjacent nodes is equal 
                //if equal then return false
                else if(G[curr][i]==1 && color[curr] == color[i])
                    return false;
                //if color of adjacent nodes is not equal then add them into queue
                else if(G[curr][i]==1 && color[i] == -1){
                    color[i] = 1-color[curr];
                    q.add(i);
                }
            }
        }
        return true;
    }
}