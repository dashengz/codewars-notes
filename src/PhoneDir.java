public class PhoneDir {
    /**
     * Organize a messy phone directory
     *
     * @param strng the messy phone dir
     * @param num   the number that we want to find
     * @return the organized string output of the information about the person with the number
     */
    public static String phone(String strng, String num) {
        String found = null;
        int count = 0;
        for (String entry : strng.split("\n"))
            if (entry.contains("+" + num)) {
                found = entry;
                count++;
            }

        // error cases
        if (count == 0) return "Error => Not found: " + num;
        if (count > 1) return "Error => Too many people: " + num;

        // process found entry
        String name = found.split("<|>")[1];
        String address = found
                .replace(name, "").replace(num, "") // only address left
                .replaceAll("[^A-Za-z0-9\\. -]", " ") // filter all unnecessary chars
                .trim().replaceAll(" +", " "); // reduce extra spaces

        return "Phone => " + num + ", Name => " + name + ", Address => " + address;
    }

    public static void main(String[] args) {
        String dr = "/+1-541-754-3010 156 Alphand_St. <J Steeve>\n 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010\n"
                + "+1-541-984-3012 <P Reed> /PO Box 530; Pollocksville, NC-28573\n :+1-321-512-2222 <Paul Dive> Sequoia Alley PQ-67209\n"
                + "+1-741-984-3090 <Peter Reedgrave> _Chicago\n :+1-921-333-2222 <Anna Stevens> Haramburu_Street AA-67209\n"
                + "+1-111-544-8973 <Peter Pan> LA\n +1-921-512-2222 <Wilfrid Stevens> Wild Street AA-67209\n"
                + "<Peter Gone> LA ?+1-121-544-8974 \n <R Steell> Quora Street AB-47209 +1-481-512-2222\n"
                + "<Arthur Clarke> San Antonio $+1-121-504-8974 TT-45120\n <Ray Chandler> Teliman Pk. !+1-681-512-2222! AB-47209,\n"
                + "<Sophia Loren> +1-421-674-8974 Bern TP-46017\n <Peter O'Brien> High Street +1-908-512-2222; CC-47209\n"
                + "<Anastasia> +48-421-674-8974 Via Quirinal Roma\n <P Salinger> Main Street, +1-098-512-2222, Denver\n"
                + "<C Powel> *+19-421-674-8974 Chateau des Fosses Strasbourg F-68000\n <Bernard Deltheil> +1-498-512-2222; Mount Av.  Eldorado\n"
                + "+1-099-500-8000 <Peter Crush> Labrador Bd.\n +1-931-512-4855 <William Saurin> Bison Street CQ-23071\n"
                + "<P Salinge> Main Street, +1-098-512-2222, Denve\n" + "<P Salinge> Main Street, +1-098-512-2222, Denve\n";

        System.out.println(phone(dr, "48-421-674-8974")); // "Phone => 48-421-674-8974, Name => Anastasia, Address => Via Quirinal Roma");
        System.out.println(phone(dr, "1-921-512-2222")); // "Phone => 1-921-512-2222, Name => Wilfrid Stevens, Address => Wild Street AA-67209");
        System.out.println(phone(dr, "1-908-512-2222")); // "Phone => 1-908-512-2222, Name => Peter O'Brien, Address => High Street CC-47209");
        System.out.println(phone(dr, "1-541-754-3010")); // "Phone => 1-541-754-3010, Name => J Steeve, Address => 156 Alphand St.");
        System.out.println(phone(dr, "1-121-504-8974")); // "Phone => 1-121-504-8974, Name => Arthur Clarke, Address => San Antonio TT-45120");
        System.out.println(phone(dr, "1-498-512-2222")); // "Phone => 1-498-512-2222, Name => Bernard Deltheil, Address => Mount Av. Eldorado");
        System.out.println(phone(dr, "1-098-512-2222")); // "Error => Too many people: 1-098-512-2222");
        System.out.println(phone(dr, "5-555-555-5555")); // "Error => Not found: 5-555-555-5555");
    }
}
