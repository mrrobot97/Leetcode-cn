import java.util.*;

public class QUestion139 {

    public static void main(String[] args){
        List<String> str= Arrays.asList("cats","dog","sand","and","cat");
        System.out.println(wordBreak("catsandog",str));
    }


    //https://leetcode-cn.com/problems/word-break/description/

    //dfs
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n=wordDict.size();
        Set<String> set=new HashSet<>();
        set.addAll(wordDict);
        return dfs(s,set,new HashMap<>());
    }

    public static boolean dfs(String str,Set<String> set,HashMap<String,Boolean> map){
        if(set.contains(str)){
            return true;
        }else if(str.length()==1){
            return false;
        }
        if(map.get(str)!=null){     //key optimization point,without this check, time exceed limit
            return map.get(str);
        }
        for(String pre:set){
            if(!str.startsWith(pre)){
                continue;
            }
            String suffix=str.substring(pre.length());
            if(map.getOrDefault(suffix,false) || dfs(suffix,set,map)){
                map.put(suffix,true);
                return true;
            }else{
                map.put(suffix,false);
            }
        }
        map.put(str,false);
        return false;
    }







    //拆分法，不如dfs简洁
//    public static boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> set=new HashSet<>();
//        set.addAll(wordDict);
//        return trySplit(s,set,new HashMap<>());
//    }
//
//    public static boolean trySplit(String s,Set<String> set,HashMap<String,Boolean> map){
//        if(s.length()==1){
//            return set.contains(s);
//        }else if(set.contains(s)){
//            return true;
//        }
//        if(map.get(s)!=null){                       //key optimization point,without this check, time exceed limit
//            return map.get(s);
//        }
//        for (int i = s.length()-1; i >=1 ; i--) {
//            String prefix=s.substring(0,i);
//            if(!set.contains(prefix)){
//                continue;
//            }
//            String suffix=s.substring(i);
//            boolean succ=set.contains(suffix) || map.getOrDefault(suffix,false);
//            if(!succ){
//                succ=trySplit(suffix,set,map);
//                map.put(suffix,succ);
//            }
//            if(succ){
//                return true;
//            }
//        }
//        map.put(s,false);
//        return false;
//    }
}
