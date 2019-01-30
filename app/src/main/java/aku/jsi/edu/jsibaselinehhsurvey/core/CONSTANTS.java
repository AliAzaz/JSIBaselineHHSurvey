package aku.jsi.edu.jsibaselinehhsurvey.core;

public final class CONSTANTS {

    //Form Interface
    public static final String DATABASE_NAME = "jsi";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_FORMS = "forms";
    public static final String TABLE_CHILD_HEALTH = "child_health";
    public static final String TABLE_FAMILY_MEMBERS = "family_members";
    public static final String TABLE_MARRIED_WOMENS = "mw";
    public static final String TABLE_MARRIED_WOMENS_DEATH = "mw_death";
    public static final String TABLE_USERS = "users";
    public static final String TABLE_CLUSTERS = "clusters";


    public static final String _IP = "43.245.131.159"; // Test PHP server
    public static final Integer _PORT = 8080; // Port - with colon (:)
    public static final String _HOST_URL = "http://" + _IP + ":" + _PORT + "/src2/api/";
    public static final String _UPDATE_URL = "http://" + _IP + ":" + _PORT + "/leapsup/app/app-debug.apk";

    public static final String URL_USERS = "users.php";
    public static final String URL_CLUSTERS = "clusters.php";
    public static final String URL_DEVICES = "devices.php";
    public static final String URL_FORMS = "forms.php";

    public static final String _URI_END_FLAG = "complete";
    public static final String _URI_END_OBJECT = "fc_data";
    public static final String _URI_FC_OBJ = "fc_data";

}
