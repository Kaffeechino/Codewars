package de.gfn;

public class RgbToHex {
    /**
     * Converts decimal RGB values to hexadecimal RGB values.
     *
     * @param r,g,b RGB decimal values.
     * @return  String containing hexadecimal RGB values, e.g. "FFAA0B".
     */

    public static String rgb(int r, int g, int b) {
        int[] args = new int[]{r,g,b};
        String result = new String();
        for (int element:args) {
            element = element < 0 ? 0 : element;
            element = element > 255 ? 255 : element;
            String hexString = Integer.toHexString(element);
            if (hexString.length() == 1) hexString = "0" + hexString;
            result += hexString;
        }

        return result.toUpperCase();
    }
}
