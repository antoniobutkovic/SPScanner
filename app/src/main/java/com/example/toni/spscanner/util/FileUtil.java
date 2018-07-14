package com.example.toni.spscanner.util;

import android.app.Activity;
import android.content.Intent;

import com.example.toni.spscanner.Constants;
import com.example.toni.spscanner.R;

public class FileUtil {

    public static void selectFile(Activity activity){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType(Constants.PICKFILE_INTENT_TYPE);
        intent = Intent.createChooser(intent, activity.getString(R.string.choose_file_title_text));
        activity.startActivityForResult(intent, Constants.PICKFILE_RESULT_CODE);
    }

}
