class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        //queue to store nodes
        Queue<Node> q = new LinkedList<>();
        //holds nodes of the graph
        Map<Node, Node> h = new HashMap<>();
        q.add(node);
        h.put(node, new Node(node.val));
        while(!q.isEmpty()){
            Node curr = q.poll();
            //iterate through neighbors of current node
            for(Node neigh:curr.neighbors){
                //if node is unvisited add to queue
                if(!h.containsKey(neigh)){
                    h.put(neigh, new Node(neigh.val));
                    q.add(neigh);
                }
                h.get(curr).neighbors.add(h.get(neigh));
            }
        }
        return h.get(node);
    }
}
