class Solution {
    public String smallestSubsequence(String s, int k, char letter, int r) {
        char[] arr = s.toCharArray(), ans = new char[k];
        int c = letter - 'a';
        int[] pointers = new int[26];
        List<Integer>[] indices = getIndices(arr);
        for(int i=0, n=arr.length; i<k-r; ++i) {
            int rth = (r == 0 ? n : indices[c].get(indices[c].size() - r)), x = Math.min(rth, n - (k-i));
            for(int j=0; j<26; ++j) if(pointers[j] < indices[j].size()) {
                int first = indices[j].get(pointers[j]);
                if(x >= first) {
                    ans[i] = arr[first];
                    if(j == c && r > 0)
                        --r;
                    for(j=0; j<26; ++j)
                        while(pointers[j] < indices[j].size() && indices[j].get(pointers[j]) <= first)
                            ++pointers[j];
                    break;
                }
            }
        }
        for(int i=k-r; i<k; ++i)
            ans[i] = letter;
        return String.valueOf(ans);
    }
    
    private List<Integer>[] getIndices(char[] arr) {
        List<Integer>[] indices = new List[26];
        for(int i=0; i<26; ++i)
            indices[i] = new ArrayList<>();
        for(int i=0; i<arr.length; ++i)
            indices[arr[i]-'a'].add(i);
        return indices;
    }
}