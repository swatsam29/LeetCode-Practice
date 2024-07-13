package Google;

public class RangeModule {
    private final TreeNode Root;
    private static final int MAX_RANGE = 1000000000;  
    public RangeModule() {
        Root = new TreeNode(0, MAX_RANGE, false);
    }
    
    public void addRange(int left, int right) {
        Root.update(left, right - 1, true);
    }
    
    public boolean queryRange(int left, int right) {
        return Root.query(left, right - 1);
    }
    
    public void removeRange(int left, int right) {
        Root.update(left, right - 1, false);
    }
    
    private static class TreeNode {
        int start, mid, end;
        boolean val; 
        TreeNode left, right;
        
        private TreeNode(int s, int e, boolean v) {
            start = s;
            mid = (s + e) >>> 1;
            end = e;
            val = v;
        }
        
        private boolean query(int s, int e) {
            if (s > e) 
                return true;
            if (s == start && e == end) 
                return val;
            if (left == null || right == null)
                return val;
            if (e <= mid) {
                return left.query(s, e);
            } else if (s > mid) {
                return right.query(s, e);
            } else {
                return left.query(s, mid) && right.query(mid + 1, e);
            }
        }
        
        private boolean update(int s, int e, boolean v) {
            if (s > e) 
                return val;
            if (s == start && e == end) {
                val = v;
                left = null;
                right = null;
                return val;
            }
            if (left == null) {
                left = new TreeNode(start, mid, val);
                right = new TreeNode(mid + 1, end, val);
            }
            boolean l = left.update(Math.max(s, start), Math.min(e, mid), v);
            boolean r = right.update(Math.max(s, mid + 1), Math.min(e, end), v);
            val = l && r;
            return val;
        }
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left, right);
 * boolean param_2 = obj.queryRange(left, right);
 * obj.removeRange(left, right);
 */

