import org.omg.CORBA.INTERNAL;

import java.util.*;

public class Question127 {
    public static void main(String[] args){

    }


    // https://leetcode-cn.com/problems/word-ladder/description/
    //思路：先对所有单词建图，若两个单词可以经过一步互相转换，则这两个单词之间有一条路径,然后求最短路径
    // 由于节点间长度都为1，因此可以使用广度优先遍历求最短路径
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue=new ArrayDeque<>();
        HashMap<String,Integer> stepMap=new HashMap<>();    //用于快速查询字典中是否包含某个单词
        HashSet<String> dictSet=new HashSet<>(wordList);    //保存到当前节点的距离
        queue.offer(beginWord);
        stepMap.put(beginWord,1);
        while (!queue.isEmpty()){
            String word=queue.poll();
            int step=stepMap.get(word);
            for(int i=0;i<word.length();i++){
                for(char j='a';j<'z';j++){
                    if(word.charAt(i)==j){
                        continue;
                    }
                    String tmpWord=word.substring(0,i)+String.valueOf(j)+word.substring(i+1);
                    if(!dictSet.contains(tmpWord)){
                        continue;
                    }
                    dictSet.remove(tmpWord);
                    queue.offer(tmpWord);
                    stepMap.put(tmpWord,step+1);
                    if(tmpWord.equals(endWord)){
                        return step+1;
                    }
                }
            }
        }
        return 0;
    }


}
