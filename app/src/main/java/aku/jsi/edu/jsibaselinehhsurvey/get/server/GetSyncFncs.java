package aku.jsi.edu.jsibaselinehhsurvey.get.server;

import org.json.JSONArray;
import org.json.JSONObject;

import aku.jsi.edu.jsibaselinehhsurvey.RMOperations.CrudOperations;
import aku.jsi.edu.jsibaselinehhsurvey.RMOperations.SyncOperations;
import aku.jsi.edu.jsibaselinehhsurvey.data.AppDatabase;
import aku.jsi.edu.jsibaselinehhsurvey.data.DAO.FormsDAO;
import aku.jsi.edu.jsibaselinehhsurvey.data.entities.Clusters;
import aku.jsi.edu.jsibaselinehhsurvey.data.entities.Users;


public abstract class GetSyncFncs {

    public static void syncUsers(AppDatabase db, JSONArray userlist) {

        new SyncOperations(db).execute(FormsDAO.class.getName(), "formsDao", "deleteUsers");

        try {
            JSONArray jsonArray = userlist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);
                String userName = jsonObjectUser.getString("username");
                String password = jsonObjectUser.getString("password");

                Users users = new Users(userName, password);
                new CrudOperations(db, users).execute(FormsDAO.class.getName(), "formsDao", "insertUsers").get();
            }
            db.close();

        } catch (Exception e) {
        }
    }

    public static void syncClusters(AppDatabase db, JSONArray clusterList) {

        new SyncOperations(db).execute(FormsDAO.class.getName(), "formsDao", "deleteClusters");

        try {
            JSONArray jsonArray = clusterList;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);

                Clusters clusters = new Clusters();
                clusters.Sync(jsonObjectUser);

                new CrudOperations(db, clusters).execute(FormsDAO.class.getName(), "formsDao", "insertClusters").get();
            }
            db.close();

        } catch (Exception e) {
        }
    }

}
