package aku.jsi.edu.jsibaselinehhsurvey.get.db;

import android.os.AsyncTask;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

import aku.jsi.edu.jsibaselinehhsurvey.data.AppDatabase;

/**
 * Created by openm on 19-Jul-18.
 */

public class GetAllDBData extends AsyncTask<Object, Void, Collection<?>> {

    AppDatabase db;
    String DAOclsName, DAOAbsClsFnc, DAOFnc;

    public GetAllDBData(AppDatabase db, String DAOclsName, String DAOAbsClsFnc, String DAOFnc) {
        this.db = db;
        this.DAOclsName = DAOclsName;
        this.DAOAbsClsFnc = DAOAbsClsFnc;
        this.DAOFnc = DAOFnc;
    }

    @Override
    protected Collection<?> doInBackground(Object... fnNames) {

        Collection<?> curData = new ArrayList<>();

        try {

            Method[] fn = db.getClass().getDeclaredMethods();
            for (Method method : fn) {
                if (method.getName().equals(DAOAbsClsFnc)) {

                    Class<?> fnClass = Class.forName(DAOclsName);

                    for (Method method2 : fnClass.getDeclaredMethods()) {
                        if (method2.getName().equals(DAOFnc)) {

                            Class<?> params[] = new Class[fnNames.length];
                            for (int i = 0; i < fnNames.length; i++) {
                                if (fnNames[i] instanceof Integer) {
                                    params[i] = Integer.TYPE;
                                } else if (fnNames[i] instanceof String) {
                                    params[i] = String.class;
                                }
                            }

                            curData = (Collection<?>) fnClass.getDeclaredMethod(method2.getName(), params)
                                    .invoke(db.getClass().getMethod(DAOAbsClsFnc).invoke(db), fnNames);


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

        return curData;
    }
}
