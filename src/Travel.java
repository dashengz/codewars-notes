public class Travel {
    /**
     * String format and manipulation
     */
    public static String travel(String r, String zipcode) {
        StringBuilder addrs = new StringBuilder(zipcode + ":");
        StringBuilder nums = new StringBuilder("/");
        for (String a : r.split(",")) {
            String thisZip = a.substring(a.length() - 8);
            String num = a.split(" ")[0];
            String address = a.substring(num.length() + 1, a.length() - 9);
            if (zipcode.equals(thisZip)) {
                addrs.append(address).append(',');
                nums.append(num).append(',');
            }
        }
        return !(addrs.toString() + nums.toString()).contains(":/")
                ? addrs.substring(0, addrs.length() - 1) + nums.substring(0, nums.length() - 1)
                : addrs.toString() + nums.toString();
    }

//    private static boolean isValidZipcode(String zipcode) {
//        return zipcode.matches("^[A-Z]{2}\\s{1}\\d{5}");
//    }

    public static void main(String[] args) {
        String ad = "123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432,"
                + "54 Holy Grail Street Niagara Town ZP 32908,3200 Main Rd. Bern AE 56210,1 Gordon St. Atlanta RE 13000,"
                + "10 Pussy Cat Rd. Chicago EX 34342,10 Gordon St. Atlanta RE 13000,58 Gordon Road Atlanta RE 13000,"
                + "22 Tokyo Av. Tedmondville SW 43098,674 Paris bd. Abbeville AA 45521,10 Surta Alley Goodtown GG 30654,"
                + "45 Holy Grail Al. Niagara Town ZP 32908,320 Main Al. Bern AE 56210,14 Gordon Park Atlanta RE 13000,"
                + "100 Pussy Cat Rd. Chicago EX 34342,2 Gordon St. Atlanta RE 13000,5 Gordon Road Atlanta RE 13000,"
                + "2200 Tokyo Av. Tedmondville SW 43098,67 Paris St. Abbeville AA 45521,11 Surta Avenue Goodtown GG 30654,"
                + "45 Holy Grail Al. Niagara Town ZP 32918,320 Main Al. Bern AE 56215,14 Gordon Park Atlanta RE 13200,"
                + "100 Pussy Cat Rd. Chicago EX 34345,2 Gordon St. Atlanta RE 13222,5 Gordon Road Atlanta RE 13001,"
                + "2200 Tokyo Av. Tedmondville SW 43198,67 Paris St. Abbeville AA 45522,11 Surta Avenue Goodville GG 30655,"
                + "2222 Tokyo Av. Tedmondville SW 43198,670 Paris St. Abbeville AA 45522,114 Surta Avenue Goodville GG 30655,"
                + "2 Holy Grail Street Niagara Town ZP 32908,3 Main Rd. Bern AE 56210,77 Gordon St. Atlanta RE 13000";

        System.out.println(travel(ad, "AA 45522")); // "AA 45522:Paris St. Abbeville,Paris St. Abbeville/67,670");
        System.out.println(travel(ad, "EX 34342")); // "EX 34342:Pussy Cat Rd. Chicago,Pussy Cat Rd. Chicago/10,100");
        System.out.println(travel(ad, "EX 34345")); // "EX 34345:Pussy Cat Rd. Chicago/100");
        System.out.println(travel(ad, "AA 45521")); // "AA 45521:Paris bd. Abbeville,Paris St. Abbeville/674,67");
        System.out.println(travel(ad, "AE 56215")); // "AE 56215:Main Al. Bern/320");
    }
}