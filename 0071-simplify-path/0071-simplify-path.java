class Solution {
    public String simplifyPath(String path) {

        Stack<String> st = new Stack<>();

        String[] parts = path.split("/");

        for (int i = 0; i < parts.length; i++) {

            if (!parts[i].equals("") && !parts[i].equals(".")) {

                if (parts[i].equals("..")) {

                    if (!st.isEmpty()) {
                        st.pop();
                    }

                } else {
                    st.push(parts[i]);
                }
            }
        }

        if (st.isEmpty()) {
            return "/";
        }

        StringBuilder result = new StringBuilder();

        for (String dir : st) {
            result.append("/").append(dir);
        }

        return result.toString();
    }
}