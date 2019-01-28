package aku.jsi.edu.jsibaselinehhsurvey.RMOperations;

import android.os.AsyncTask;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import aku.jsi.edu.jsibaselinehhsurvey.data.AppDatabase;

/**
 * Created by openm on 19-Jul-18.
 */

public class UpdateSyncedStatus extends AsyncTask<String, Void, Long> {

    AppDatabase db;
    int _id;
    String _date;

    public UpdateSyncedStatus(AppDatabase db, String _date, int _id) {
        this.db = db;
        this._id = _id;
        this._date = _date;
    }

    @Override
    protected Long doInBackground(String... fnNames) {

        Long longID = new Long(0);
        try {

            Method[] fn = db.getClass().getDeclaredMethods();
            for (Method method : fn) {
                if (method.getName().equals(fnNames[1])) {

                    Class<?> fnClass = Class.forName(fnNames[0]);

                    for (Method method2 : fnClass.getDeclaredMethods()) {
                        if (method2.getName().equals(fnNames[2])) {

                            longID = Long.valueOf(String.valueOf(fnClass.getMethod(method2.getName(), String.class, int.class)
                                    .invoke(db.getClass().getMethod(fnNames[1]).invoke(db), this._date, this._id)));

                            break;
                        }
                    }
                    break;
                }
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


        return longID;
    }
}
