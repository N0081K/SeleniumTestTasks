import java.io.File;

public class Config {

    public static String googleURL = "https://www.google.cz";
    public static String searchQueryTmobile = "t-mobile";

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
    public static class ErrorLabelsTMobile{
        public static String emptyBox = "Tento údaj je povinný.";
        public static String badPhoneFormat = "Prosím, zadejte pouze čísla";
        public static String badMailFormat = "Prosím, zadejte platný e-mail.";
        public static String badFileFormat = "Jsou podporovány pouze soubory ve formátu (.BMP, .JPG, .JPEG, .GIF, .PNG, .WAV, .AMR, .MP3, .AAC, .MP4, .3GP, .PDF, .TXT, .DOC, .DOCX, .ODT, .XLS, .XLSX).";
    }

}
