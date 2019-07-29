package unionfind;

public class UnionFind3 implements UF{

    private int[] parent;
    private int[] sz;

    public UnionFind3(int size){
        parent = new int[size];
        sz = new int[size];
        for(int i = 0; i < size; i++){
            parent[i] = i;
            sz[i] = 1;
        }
    }

    private int find(int p){
        if(p < 0 || p >= parent.length){
            throw new IllegalArgumentException("p is out of bound.");
        }
        while(p != parent[p]){
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
        if(sz[pId] < sz[qId]){
            parent[pId] = qId;
            sz[qId] += sz[pId];
        }else{
            parent[qId] = pId;
            sz[pId] += sz[qId];
        }

    }
}
