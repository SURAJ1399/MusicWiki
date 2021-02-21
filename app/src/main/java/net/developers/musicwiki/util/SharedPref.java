package net.developers.musicwiki.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {



            public Context context;


            public SharedPref(Context context)
            {
              this.context=context;
            }







        public  void setValue( String key, String pref_name,String value) {
            SharedPreferences sharedPref = context.getSharedPreferences(pref_name,Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString(key, value);
            editor.apply();
        }

        public String getValue(String key,String pref_name) {
            SharedPreferences sharedPref = context.getSharedPreferences(pref_name,Context.MODE_PRIVATE);

            return sharedPref.getString(key, null );
        }


    }

