package com.neu.learn;
// Leetcode Problem # 205
public class Isomorphic {
	public static boolean isIsomorphic(String sString, String tString) {
        char[] s = sString.toCharArray();
        char[] t = tString.toCharArray();

        int length = s.length;
        if (length != t.length) return false;

        char[] sm = new char[256];
        char[] tm = new char[256];

        for(int i = 0; i < length; i++){
            char sc = s[i];
            char tc = t[i];
            if (sm[sc] == 0 && tm[tc] == 0){
                sm[sc] = tc;
                tm[tc] = sc;
            } else {
                if (sm[sc] != tc || tm[tc] != sc){
                    return false;
                }
            }
        }
        return true;
    }
	
	/* //BIT SHIFTING METHOD
    if(s ==null || t == null || s.length() != t.length()){
        return false;
    }
    int[] a = new int[256]; //For extended ASCII
    int[] b = new int[256];
    
    for(int i = 0; i < s.length(); i++){
        char c1 = s.charAt(i);
        char c2 = t.charAt(i);
        
        if(a[c1] != b[c2]){
            return false;
        }
        //Since all the int array is pointing to 0, we change it
        a[c1] = i + 1;
        b[c2] = i + 1;
    }
    return true;
}   */

	public static void main(String[] args) {
		String s1 = "egg";
		String s2 = "add";
		System.out.println(isIsomorphic(s1, s2));
	}

}
