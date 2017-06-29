package com.projet_times_up.zac.dialog_boilerplate.Activity.Util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.projet_times_up.zac.dialog_boilerplate.R;

/**
 * Created by Zaccharie.BOUVY on 29/06/2017.
 */

public class DialogTool {


    public static void oneButtonDialog(Context context, String title, String message, String neutralButton){
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, neutralButton,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }


    public static void simpleDialog(Context context, String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.show();
    }

    public static void yesNoDialog(Context context, String title, String message, String positiveButton, String negativeButton){
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, positiveButton,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, negativeButton,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public static void threeButtonDialog(Context context, String title, String message, String positiveButton, String neutralButton, String negativeButton){
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, positiveButton,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, neutralButton,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, negativeButton,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }


    public static void customFourButtonDialog(Context context, String title, String message, String firstButton, String secondButton, String thirdButton, String fourthButton){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setItems(new CharSequence[]
                        {firstButton, secondButton, thirdButton, fourthButton},
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int position) {
                        switch (position) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                                dialog.dismiss();
                                break;
                        }
                    }
                });
        builder.create().show();
    }


    public static void customDialog(Activity activity, String message, int custom_layout){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(custom_layout);
        TextView text = (TextView) dialog.findViewById(R.id.text);
        text.setText(message);
        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}
