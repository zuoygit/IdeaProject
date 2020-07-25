public class test {
    public static void main(String[] args) {
        String s="aaaaa";
        String ss=longestPalindrome(s);
        System.out.println(ss);
    }
    public static String longestPalindrome(String s) {
        String str="";
        for(int i=0;i<s.length();i++){
            str+="*"+s.charAt(i);
        }
        str+="*";
        String ss="";
        for(int i=1;i<str.length();i++){
            //ss+=str.charAt(i);
            int left=i-1;
            int right=i+1;
            String s0="";
            s0+=str.charAt(i);
            while(left>=0&&right<str.length()){
                if(str.charAt(left)==str.charAt(right)){
                    s0=str.charAt(left)+s0;
                    s0=s0+str.charAt(right);
                    left--;
                    right++;
                }
                else{
                    break;
                    
                }
            }
            ss=ss.length()>s0.length()?ss:s0;
        }
        String sss="";
        for(int i=0;i<ss.length();i++){
            if(ss.charAt(i)!='*'){
                sss+=ss.charAt(i);
            }
        }
        return sss;
    }
}
