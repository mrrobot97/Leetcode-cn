public class Question789 {

    public static void main(String[] args){

    }

    //只要有ghost到target的距离小于等于pacman到target的距离，则必定可以拦截(ghost总可以在target附近拦截,要么是target处，要么是target相邻的位置
    //https://leetcode-cn.com/problems/escape-the-ghosts/description/
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int dis=Math.abs(target[0])+Math.abs(target[1]);
        for(int[] g:ghosts){
            if(Math.abs(g[0]-target[0])+Math.abs(g[1]-target[1])<=dis){
                return false;
            }
        }
        return true;
    }
}
