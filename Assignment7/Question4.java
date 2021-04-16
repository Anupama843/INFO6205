package Assignment7;
/*
Valid Anagram
 */
public class Question4 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int [] alphabet = new int [26];
        for(int i = 0; i < s.length(); i++){
            alphabet[s.charAt(i) - 'a']++;
            alphabet[t.charAt(i) - 'a']--;
        }

        for(int result : alphabet){
            if (result != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Question4 a = new Question4();
        System.out.println(a.isAnagram("anagram", "nagaram"));
        System.out.println(a.isAnagram("rat", "car"));
    }
}
