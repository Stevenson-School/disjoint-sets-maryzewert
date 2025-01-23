public class QuickFind implements DisjointSets {
    private int[] id;

    public QuickFind(int N){
        id = new int[N];
        for(int i =0;i<N;i++){
            id[i] = i;
        }
    }

    public void connect(int q, int p){
        int qid = id[q];
        int pid = id[p];
        for(int i =0;i<id.length;i++){
            if(id[i] == qid){
                id[i] = pid;
            }
        }
    }

    public boolean isConnected(int q, int p){
        return (id[q] == id[p]);
    }
}
