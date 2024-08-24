import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> ret = s.groupAnagrams(input);
        System.out.println(ret);
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        List<String> temp = new ArrayList<>();
       char[][] copy = new char[strs.length][101];
       for(int i =0; i< strs.length;i++){
        copy[i]=strs[i].toCharArray();
        Arrays.sort(copy[i]);
       }
       for(int i=0; i<strs.length;i++){
            if(copy[i]==null)continue;
            temp = new ArrayList<>();
            temp.add(strs[i]);
            for(int j=i+1;j<strs.length;j++){
                if(Arrays.equals(copy[i], copy[j])){
                    temp.add(strs[j]);
                    copy[j]=null;
                }
            }
            copy[i]=null;
            if(temp.size()!=0) ret.add(temp);
       }
        return ret;
    }
}