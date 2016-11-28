/**
 * Class implementing common video conference number manipulation features.
 */

public class VCNumberUtils {

    public static boolean isEmpty(String value) {
        return value==null || value.length()==0;
    }

    /**
     * Method to return lower case
     * String if its not null
     * @param text
     * @return
     */
    public static String toLowerCaseIfNotNull(String text) {
        if (text != null)
            text = text.toLowerCase();
        return text;
    }

    public static String getFormattedPhoneString(String phoneStr) {
        String retStr = phoneStr;

      			if(phoneStr != null) {
                if(phoneStr.contains("@")) {
                    phoneStr = phoneStr.substring(0, phoneStr.length() - phoneStr.indexOf("@"));
                }

                String lastFour = phoneStr.length() > 4 ? phoneStr.substring(phoneStr.length() - 4) : "";
                String midThree = phoneStr.length() > 7 ? phoneStr.substring(phoneStr.length() - 7, phoneStr.length() - 4): "";
                String areaCode = phoneStr.substring(phoneStr.length() - 10, phoneStr.length() - 7);

                String countryCode = phoneStr.length() > 10 ? phoneStr.substring(0, phoneStr.length() - 10) : "+1"; //need to investigate default int'l prefixes here

                retStr = countryCode + " (" + areaCode + ") " + midThree + "-" + lastFour;
            }

            // have StringIndexOutOfBoundsException here.
            //scenarios : SfB SpeedDial call,  Participants entry : name: lucy.liu  address: lucy.liu@polycom.com.  So phoneStr = lucy.liu
    
        return retStr;
    }
}
