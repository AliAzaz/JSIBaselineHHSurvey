package aku.jsi.edu.jsibaselinehhsurvey.data.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import aku.jsi.edu.jsibaselinehhsurvey.core.CONSTANTS;
import aku.jsi.edu.jsibaselinehhsurvey.data.entities.ChildHealthForms;
import aku.jsi.edu.jsibaselinehhsurvey.data.entities.Clusters;
import aku.jsi.edu.jsibaselinehhsurvey.data.entities.FamilyMembersForms;
import aku.jsi.edu.jsibaselinehhsurvey.data.entities.Forms;
import aku.jsi.edu.jsibaselinehhsurvey.data.entities.MWDeathForms;
import aku.jsi.edu.jsibaselinehhsurvey.data.entities.MWForms;
import aku.jsi.edu.jsibaselinehhsurvey.data.entities.Users;

@Dao
public interface FormsDAO {

    /*Form*/
    @Insert
    Long insertForm(Forms forms);

    @Update
    int updateForm(Forms forms);

    /*Family Members*/
    @Insert
    Long insertFamilyMembers(FamilyMembersForms fm_forms);

    @Update
    int updateFamilyMembers(FamilyMembersForms fm_forms);

    /*Child Health*/
    @Insert
    Long insertChildHealth(ChildHealthForms ch_forms);

    @Update
    int updateChildHealth(ChildHealthForms ch_forms);

    /*Married Women's*/
    @Insert
    Long insertMW(MWForms mw_forms);

    @Update
    int updateMW(MWForms mw_forms);

    /*Married Women's Death*/
    @Insert
    Long insertMWDeath(MWDeathForms mw_death_forms);

    @Update
    int updateMWDeath(MWDeathForms mw_death_forms);

    @Insert
    Long insertUsers(Users users);

    @Insert
    Long insertClusters(Clusters clusters);

    @Query("DELETE from " + CONSTANTS.TABLE_USERS)
    int deleteUsers();

    @Query("DELETE from " + CONSTANTS.TABLE_CLUSTERS)
    int deleteClusters();

    /*Update methods after upload on server*/

    /**
     * Updating only sync and syncDate
     * By order id
     */
    @Query("UPDATE Forms SET synced = '1' , synced_date= :synced_date WHERE id =:id")
    int updateSyncedForms(String synced_date, int id);


}
