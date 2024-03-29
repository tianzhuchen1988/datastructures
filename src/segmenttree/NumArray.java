package segmenttree;

class NumArray {

    private interface Merger<E> {
        E merge(E a, E b);
    }

    private class SegmentTree<E> {
        private E[] data;
        private E[] tree;
        private Merger<E> merger;

        public SegmentTree(E[] arr, Merger<E> merger){
            this.merger = merger;
            data = (E[])new Object[arr.length];
            for(int i = 0; i < arr.length; i++){
                data[i] = arr[i];
            }
            tree = (E[])new Object[4 * arr.length];
            buildSegmentTree(0, 0, data.length - 1);
        }

        private void buildSegmentTree(int treeIndex, int l, int r) {
            if(l == r){
                tree[treeIndex] = data[l];
                return;
            }

            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);
            int mid = l + (r - l) / 2;
            buildSegmentTree(leftTreeIndex, l, mid);
            buildSegmentTree(rightTreeIndex, mid + 1, r);

            tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
        }

        public E get(int index){
            if(index < 0 || index >= data.length){
                throw new IllegalArgumentException("index is illegal.");
            }
            return data[index];
        }

        private int leftChild(int index){
            return index * 2 + 1;
        }

        private int rightChild(int index){
            return index * 2 + 2;
        }

        public E query(int queryL, int queryR){
            if(queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR){
                throw new IllegalArgumentException("queryL or queryR is illegal.");
            }
            return query(0, 0, data.length - 1, queryL, queryR);
        }

        private E query(int treeIndex, int l, int r, int queryL, int queryR) {
            if(queryL == l && queryR == r){
                return tree[treeIndex];
            }
            int leftIndex = leftChild(treeIndex);
            int rightIndex = rightChild(treeIndex);
            int mid = l + (r - l) / 2;
            if(queryL >= mid + 1){
                return query(rightIndex, mid + 1, r, queryL, queryR);
            }else if(queryR <= mid){
                return query(leftIndex, l, mid, queryL, queryR);
            }

            E leftResult = query(leftIndex, l, mid, queryL, mid);
            E rightResult = query(rightIndex, mid + 1, r, mid + 1, queryR);
            return merger.merge(leftResult, rightResult);
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            res.append('[');
            for(int i = 0; i < tree.length; i++){
                if(tree[i] != null){
                    res.append(tree[i]);
                }else{
                    res.append("null");
                }
                if(i != tree.length - 1){
                    res.append(", ");
                }
            }
            res.append(']');
            return res.toString();
        }

    }

    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        if(nums.length != 0){
            Integer[] numArray = new Integer[nums.length];
            for(int i = 0; i < nums.length; i++){
                numArray[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(numArray, (a, b) -> a + b);
        }
    }

    public int sumRange(int i, int j) {
        if(segmentTree != null){
            return segmentTree.query(i, j);
        }
        return 0;
    }
}

