/*
面试题50_2：字符流中第一个只出现一次的字符
*/
public class Solution50_2 {
    int[] occurence = new int[256];
    int index = 0;
    public Solution(){
        for(int i = 0; i < 256; i++){
            occurence[i] = -1;
        }
    }
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(occurence[ch] == -1){
            occurence[ch] = index;
        }
        else{  // 表明这个字符在前面的字符流中已经出现过了
            occurence[ch] = -2;
        }
        index++;
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        int firstIndex = Integer.MAX_VALUE;
        char ch = '#';
        for(int i = 0; i < 256; i++){
            if(occurence[i] >= 0 && occurence[i] < firstIndex){
                firstIndex = occurence[i];
                ch = (char)i;
            }
        }
        return ch;
    }
}