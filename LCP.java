package mentorAssessment;
public class LCP {
    public static void main(String[] args) {
        String[] strs1 = {"technique", "technician", "technology", "technical"};
        String[] strs2 = {"techie delight", "tech", "techie", "technology", "technical"};

        System.out.println(findLCP(strs1)); // prints "techn"
        System.out.println(findLCP(strs2)); // prints "tech"
    }

    public static String findLCP(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
