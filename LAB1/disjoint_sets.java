public class disjoint_sets {
   int[] parent;
   int n;
   disjoint_sets(int n){
       parent = new int[n];
       this.n=n;
       make_parent_itself();
   }

   private void make_parent_itself() {
      for (int i = 0; i < n; i++) {
         parent[i] = i;
      }
   }


   int find(int x){
      if(parent[x] != x){
         parent[x]=find(parent[x]);
      }
      return parent[x];
   }

   void union(int x, int y){
      int xParent = find(x);
      int yParent = find(y);

      if(xParent == yParent){
         return;
      }
      parent[xParent] = yParent;
   }
}
