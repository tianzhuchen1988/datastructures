package unionfind;

public class UnionFind5 implements UF{

    private int[] parent;
    private int[] rank;

    public UnionFind5(int size){
        parent = new int[size];
        rank = new int[size];
        for(int i = 0; i < size; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    private int find(int p){
        if(p < 0 || p >= parent.length){
            throw new IllegalArgumentException("p is out of bound.");
        }
        while(p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if(pId == qId){
            return;
        }
        if(rank[pId] < rank[qId]){
            parent[pId] = qId;
        }else if(rank[pId] > rank[qId]){
            parent[qId] = pId;
        }else{
            parent[pId] = qId;
            rank[qId]++;
        }

    }
}
