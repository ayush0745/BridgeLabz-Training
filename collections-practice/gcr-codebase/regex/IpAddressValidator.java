public class IpAddressValidator {

    public static boolean isValidIPv4(String ip) {
        String regex = "\\b(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])" +
                       "(\\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])){3}\\b";
        return ip.matches(regex);
    }

    public static void main(String[] args) {

        String[] ips = {
            "192.168.1.1",
            "255.255.255.255",
            "256.100.50.0",
            "192.168.1"
        };

        for (String ip : ips) {
            System.out.println(ip + " → " +
                (isValidIPv4(ip) ? "Valid" : "Invalid"));
        }
    }
}
