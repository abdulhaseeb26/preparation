package practise;

public class StringReplace {

    public String defangIPaddr(String address) {
        StringBuilder output = new StringBuilder();
        for(char c : address.toCharArray()) {
            if (c == '.') {
                output.append("[.]");
            } else {
                output.append(c);
            }
        }
        return output.toString();
    }
}
