package aku.jsi.edu.jsibaselinehhsurvey.RMOperations;

import android.content.Context;
import android.os.AsyncTask;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import aku.jsi.edu.jsibaselinehhsurvey.data.AppDatabase;

/**
 * Created by openm on 19-Jul-18.
 */

public class CrudOperations extends AsyncTask<String, Void, Long> {

    private AppDatabase db;
    private Object objForms;
    private Context mContext;
    private String className, DAOClassRef, DAOClassFncRef;

    public CrudOperations(Context mContext, String className, String DAOClassRef, String DAOClassFncRef, Object objForms) {
        this.mContext = mContext;
        this.className = className;
        this.DAOClassRef = DAOClassRef;
        this.DAOClassFncRef = DAOClassFncRef;
        this.objForms = objForms;
    }

    @Override
    protected Long doInBackground(String... fnNames) {
        db = AppDatabase.getDatabase(mContext);

        Long longID = new Long(0);

        try {

            Method[] fn = db.getClass().getDeclaredMethods();
            for (Method method : fn) {
                if (method.getName().equals(DAOClassRef)) {

                    Class<?> fnClass = Class.forName(className);

                    for (Method method2 : fnClass.getDeclaredMethods()) {
                        if (method2.getName().equals(DAOClassFncRef)) {

                            longID = Long.valueOf(String.valueOf(fnClass.getMethod(method2.getName(), objForms.getClass())
                                    .invoke(db.getClass().getMethod(DAOClassRef).invoke(db), objForms)));

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