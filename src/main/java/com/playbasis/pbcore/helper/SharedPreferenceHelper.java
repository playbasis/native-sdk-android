package com.playbasis.pbcore.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 */
public class SharedPreferenceHelper {

    /**
     * Get the Shared preferencs editors.
     *
     * @param context activity context
     * @return a new instance of the SharedPreferences.Editor interface, allowing you to modify the values in this SharedPreferences object.
     */
    public static SharedPreferences.Editor getEditor(Context context) {
        SharedPreferences settings = getSharedPref(context);
        return settings.edit();
    }

    /**
     * Get the shared preference
     *
     * @param context activity context
     * @return The single SharedPreferences instance that can be used to retrieve and modify the preference values.
     */
    public static SharedPreferences getSharedPref(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }


    /**
     * Write a String on the desired preference file.
     *
     * @param context activity context
     * @param key     The name of the preference to modify.
     * @param value   The new value for the preference
     */
    public static void setPreference(Context context, String key, String value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * Write a String on the desired preference file.
     *
     * @param context activity context
     * @param key     The name of the preference to modify.
     * @param value   The new value for the preference
     */
    public static void setPreferenceSync(Context context, String key, String value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * Read a String from the desired preference file.
     *
     * @param context      activity context
     * @param key          The name of the preference to modify.
     * @param defaultValue The default value for the preference if the preference is null or doesn't exist
     * @return Returns the preference value if it exists, or defValue.
     */
    public static String getPreferenceString(Context context, String key, String defaultValue) {
        SharedPreferences sharedPreferences = getSharedPref(context);
        return sharedPreferences.getString(key, defaultValue);
    }

    /**
     * Write a Int on the desired preference file.
     *
     * @param context activity context
     * @param key     The name of the preference to modify.
     * @param value   The new value for the preference
     */
    public static void setPreference(Context context, String key, int value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putInt(key, value);
        editor.apply();
    }

    /**
     * Read a Int from the desired preference file.
     *
     * @param context      activity context
     * @param key          The name of the preference to modify.
     * @param defaultValue The default value for the preference if the preference is null or doesn't exist
     * @return Returns the preference value if it exists, or defValue.
     */
    public static int getPreferenceInt(Context context, String key, int defaultValue) {
        SharedPreferences sharedPreferences = getSharedPref(context);
        return sharedPreferences.getInt(key, defaultValue);
    }

    /**
     * Write a Boolean on the desired preference file.
     *
     * @param context activity context
     * @param key     The name of the preference to modify.
     * @param value   The new value for the preference
     */
    public static void setPreference(Context context, String key, boolean value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putBoolean(key, value);
        editor.apply();
    }

    /**
     * Read a Boolean from the desired preference file.
     *
     * @param context activity context
     * @param key     The name of the preference to modify.
     * @return Returns the preference value if it exists, or defValue.
     */
    public static boolean getPreferenceBoolean(Context context, String key, boolean defaultValue) {
        SharedPreferences sharedPreferences = getSharedPref(context);
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    /**
     * Write a long on the desired preference file.
     *
     * @param context activity context
     * @param key     The name of the preference to modify.
     * @param value   The new value for the preference
     */
    public static void setPreference(Context context, String key, long value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putLong(key, value);
        editor.apply();
    }

    /**
     * Read a long from the desired preference file.
     *
     * @param context      activity context
     * @param key          The name of the preference to modify.
     * @param defaultValue default value
     * @return Returns the preference value if it exists, or defValue.
     */
    public static long getPreferenceLong(Context context, String key, long defaultValue) {
        SharedPreferences sharedPreferences = getSharedPref(context);
        return sharedPreferences.getLong(key, defaultValue);
    }

    public static void unsetPreference(Context context, String key) {
      SharedPreferences.Editor editor = getEditor(context);
      editor.remove(key);
      editor.apply();
    }

}
