public static String balancedSums(List<Integer> arr) {

    int total = 0;

    for (int num : arr) {
        total += num;
    }

    int left = 0;

    for (int i = 0; i < arr.size(); i++) {

        int right = total - left - arr.get(i);

        if (left == right) {
            return "YES";
        }

        left += arr.get(i);
    }

    return "NO";
}