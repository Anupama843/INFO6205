package Assignment7;
/*
 Longest Common Prefix
 */
public class Question5 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            while (strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        Question5 a = new Question5();
        String[] strs = {"flower","flow", "flight" };
        String[] strs1 = {"dog","racecar","car" };

        System.out.println(a.longestCommonPrefix(strs1));
    }
}
