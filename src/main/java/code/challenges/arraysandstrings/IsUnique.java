package code.challenges.arraysandstrings;

/*
    Implement an algorithm to determine if a string has all unique characters.

    Follow up: What if you cannot use addional data structures?
*/

/*
    Potential Solutions:
        - Iterate through each char, store values in set, and if set contains, not unique

    Assumptions:
        - All chars a-z
        - Can be Empty
*/

import java.util.Optional;
import java.util.*;

public class IsUnique {

    public static void allUniqueCharacters(){
        Optional<String> str = Optional.ofNullable("ojwnfksadsdfasd");
        System.out.println("IsUnique:\t"+isUnique(str));
    }

    public static boolean isUnique(Optional<String> str){
        Set<Character> charSet = new HashSet<>();

        if(str.isPresent()){
            for(char c : str.get().toCharArray()){
                if(charSet.contains(c)){
                    return false;
                } else{
                    charSet.add(c);
                }
            }
        }
        return true;
    }  
    
    public static boolean isUniqueNoDS(Optional<String> str){
        if(str.isPresent()) {
            char[] chars = str.get().toCharArray();
            Arrays.sort(chars);

            for(int i = 0; i < chars.length - 2; i++){
                if(chars[i] == chars[i+1]){
                    return false;
                }
            }
            
        }
        return true;
    }

}