class Solution {
    public int minLength(String s) {
        int size=s.length();
        while(size>0){
            if(s.contains("AB")){
                s=s.replace("AB","");
                int rep=(size-s.length())/2;
                size-=2*rep;
            }
            else if(s.contains("CD")){
                s=s.replace("CD","");
                int rept=(size-s.length())/2;
                size-=2*rept;
            }
            else{
                break;
            }
        }
        return size;
    }
    // public String str(String adi){
    //     s.replace("AB","");
    //     s.replace("CD","");
    //     return adi;
    // }
}