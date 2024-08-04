class Hindex {
    public int hIndex(int[] citations) {
        if (citations.length == 0 || citations == null) {
            return 0;
        }
        int total = 0;
        int n = citations.length;
        int[] temp = new int[n + 1];

        for (int c : citations) {

            if (c >= n) {

                temp[n]++;

            } else {
                temp[c]++;
            }
        }
        for (int i = n; i >= 0; i--) {
            total += temp[i];

            if (total >= i) {

                return i;
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        Hindex s = new Hindex();
        int[] citations = { 3, 0, 6, 1, 5 };
        int ans = s.hIndex(citations);
        System.out.println(ans);
    }
}