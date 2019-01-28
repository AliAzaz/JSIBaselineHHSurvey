package aku.jsi.edu.jsibaselinehhsurvey.RMOperations;

import android.os.AsyncTask;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import aku.jsi.edu.jsibaselinehhsurvey.data.AppDatabase;

/**
 * Created by openm on 19-Jul-18.
 */

public class CrudOperations extends AsyncTask<String, Void, Long> {

    AppDatabase db;
    Object forms;

    public CrudOperations(AppDatabase db, Object forms) {
        this.db = db;
        this.forms = forms;
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

                            longID = Long.valueOf(String.valueOf(fnClass.getMethod(method2.getName(), forms.getClass())
                                    .invoke(db.getClass().getMethod(fnNames[1]).invoke(db), forms)));

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