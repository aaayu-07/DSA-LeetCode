class Solution {
    public boolean checkString(String s) {
        int m=0;
        for(char ch: s.toCharArray()){
            if(m==0 && ch=='b'){
                m=1;
            }
            if(m==1 && ch=='a')
                return false;
        }
        return true;
    }
}