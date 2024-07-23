package trie;

public class CountOfStringPrefixMatch {

   static class TreeNode {
        TreeNode[] node;
        int pc;
        TreeNode(){
            this.node = new TreeNode[26];
        }
    }

    public static void main(String[] args) {
        String str[] = {"abc","abcd","acb","abd"};
        TreeNode node = new TreeNode();
        CountOfStringPrefixMatch cs = new CountOfStringPrefixMatch();
        cs.addString(node,str);
        System.out.println(cs.getCount(node, "ab"));
        System.out.println(cs.getCount(node, "abc"));
        System.out.println(cs.getCount(node, "abd"));
        System.out.println(cs.getCount(node, "kd"));


    }

    void addString(TreeNode root, String[] strs){
        for(String str: strs){
            TreeNode tmp = root;
            for(int i =0; i< str.length(); i++){
                int index = str.charAt(i)-'a';
                if(tmp.node[index] == null){
                    tmp.node[index] = new TreeNode();
                }

                tmp = tmp.node[index];
                tmp.pc++;
            }
        }
    }

    int getCount(TreeNode root, String prefix){
        for(int i=0; i<prefix.length(); i++){
            if(root.node[prefix.charAt(i)-'a'] == null)
                return 0;
            root = root.node[prefix.charAt(i)-'a'];
        }
        return root.pc;

    }
}
