package aku.jsi.edu.jsibaselinehhsurvey.data.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import aku.jsi.edu.jsibaselinehhsurvey.data.AppDatabase;
import aku.jsi.edu.jsibaselinehhsurvey.data.entities.Clusters;
import aku.jsi.edu.jsibaselinehhsurvey.data.entities.Forms;
import aku.jsi.edu.jsibaselinehhsurvey.data.entities.Users;

@Dao
public interface FormsDAO {

    /*Form*/

    @Insert
    Long insertForm(Forms forms);

    @Update
    int updateForm(Forms forms);

    /*Others Sync*/
    @Insert
    Long insertUsers(Users users);

    @Insert
    Long insertClusters(Clusters clusters);

    @Query("DELETE from " + AppDatabase.Sub_DBConnection.TABLE_USERS)
    int deleteUsers();

    @Query("DELETE from " + AppDatabase.Sub_DBConnection.TABLE_CLUSTERS)
    int deleteClusters();


    /*Update methods after upload on server*/

    /**
     * Updating only sync and syncDate
     * By order id
     */
    @Query("UPDATE Forms SET synced = '1' , synced_date= :synced_date WHERE id =:id")
    int updateSyncedForms(String synced_date, int id);


}
