package com.example.browncoffee.util;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;

import com.example.browncoffee.R;

public class DialogUtil {
    public static Dialog progressDialog(Context context) {
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_progress_bar);
//        Activity activity = (Activity) context;
//        activity.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return dialog;
    }
}
