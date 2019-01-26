package aku.jsi.edu.jsibaselinehhsurvey.core;

public interface CONSTANTS {

    String _IP = "43.245.131.159"; // Test PHP server
    Integer _PORT = 8080; // Port - with colon (:)
    String _HOST_URL = "http://" + _IP + ":" + _PORT + "/src2/api/";
    String _UPDATE_URL = "http://" + _IP + ":" + _PORT + "/leapsup/app/app-debug.apk";

    String URL_USERS = "users.php";
    String URL_CLUSTERS = "clusters.php";
    String URL_DEVICES = "devices.php";
    String URL_FORMS = "forms.php";

    String URI_END_FLAG = "complete";
    String URI_END_OBJECT = "fc_data";

}
