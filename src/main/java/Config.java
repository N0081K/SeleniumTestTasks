/**
 * this is just class that contains our testing data
 * some people said me that it breaks Encapsulation rule of OOP
 * but majority of tester said me that it doesn't matter, cos it is not send to production and it is better for reading
 * than using getters and easier for us than maintaining it in all test files and easier to reuse them
 */

public class Config {

    public static String googleURL = "https://www.google.cz";
    public static String searchQueryTmobile = "t-mobile";
    public static String formPage = "https://www.t-mobile.cz/podpora/kontaktujte-nas";

    /**
     * some test Credentials for form that you can find https://www.t-mobile.cz/podpora/kontaktujte-nas
     */
    public static class CredentialsTMobile{
        public static class Valid{
            public static String subject = "Test help";
            public static String text = "This is test text. Do not reply. Thanks.";
            public static String phoneNumber = "723456789";
            public static String mail = "adress@example.com";
            public static String file = System.getProperty("user.dir") + "/testFile.txt";
        }
        public static class Invalid{
            public static String empty = "";
            public static class phoneNumber{
                public static String invalidCharacters= "+7345678";
                public static String letters = "abc";
            }
            public static class mail{
                public static String noAtSign = "adressexample.com";
                public static String noDotSign = "adress@examplecom";
            }
            public static String file = System.getProperty("user.dir") + "/.idea/misc.xml";
        }
    }

    /**
     * Error strings from T-Mobile website form https://www.t-mobile.cz/podpora/kontaktujte-nas
     */
    public static class LabelsTMobile{
        public static String emptyBox = "Tento údaj je povinný.";
        public static String badPhoneFormat = "Prosím, zadejte pouze čísla";
        public static String badMailFormat = "Prosím, zadejte platný e-mail.";
        public static String badFileFormat = "Jsou podporovány pouze soubory ve formátu (.BMP, .JPG, .JPEG, .GIF, .PNG, .WAV, .AMR, .MP3, .AAC, .MP4, .3GP, .PDF, .TXT, .DOC, .DOCX, .ODT, .XLS, .XLSX).";
        public static String successSend = "Váš e-mail byl úspěšně odeslán. S odpovědí se Vám ozveme telefonicky nebo e-mailem co nejdříve.";
    }

}
