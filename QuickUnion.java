import java.util.Arrays;

public class QuickUnion implements DisjointSets{
    private int parent[];

    public QuickUnion(int N){
        parent = new int[N];
        Arrays.fill(parent,-1);
    }

    //this is weighted
    public void connect(int p, int q){
        if(find(p)==find(q)) return;
        // means p has greater connections
        if(parent[find(p)]<parent[find(q)]){
            parent[find(q)] = find(p);
            parent[find(p)]--;
        }
       else if(parent[find(q)]<parent[find(p)]){
           parent[find(p)] = find(q);
            parent[find(q)]--;
        }
       else if(p>q){
            parent[find(p)] = find(q);
            parent[find(q)]--;
        }
       else{
            parent[find(q)] = find(p);
            parent[find(p)]--;
        }
    }
// use path compression
    public boolean isConnected(int p, int q){
       return (find(p) == find(q));
    }

// finding number of root
    private int find(int p){
        int root = p;
        while (parent[root] >= 0) {
            root = parent[root];
        }
        while(p!=root){
            int temp = parent[p];
            parent[p] = root;
            p = temp;
        }
        return root;
//        if(parent[p]<0) return p;
//        return parent[p] = find(parent[p]);
    }

//while(parent[p]>=0){
//        p = parent[p];
//    }
//        return p;

    public static void main(String[] args) {
        QuickUnion qu = new QuickUnion(12);
        qu.connect(0,1);
        qu.connect(1,2);
        qu.connect(2,3);
        qu.connect(4,5);
     //   qu.connect(5,6);
        qu.connect(5,3);
        qu.connect(6,7);
        qu.connect(8,9);
        qu.connect(9,10);
        qu.connect(10,11);
       // qu.connect(3,4);
       // qu.isConnected(3,4);
        qu.connect(7,8);
        //qu.connect(5,0);
        qu.connect(3,11);
        qu.connect(0,10);
    }
}
