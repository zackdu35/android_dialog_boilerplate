package com.projet_times_up.zac.dialog_boilerplate.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.projet_times_up.zac.dialog_boilerplate.Activity.Util.DialogTool;
import com.projet_times_up.zac.dialog_boilerplate.R;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button oneButtonDialog, simpleDialog, yesNoDialog,
            threeButtonDialog, fourButtonDialog, customDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oneButtonDialog = (Button) findViewById(R.id.simple_dialog);
        simpleDialog = (Button) findViewById(R.id.one_button_dialog);
        yesNoDialog = (Button) findViewById(R.id.yes_no_button_dialog);
        threeButtonDialog = (Button) findViewById(R.id.three_button_dialog);
        fourButtonDialog = (Button) findViewById(R.id.four_button_dialog);
        customDialog = (Button) findViewById(R.id.custom_dialog);

        simpleDialog.setOnClickListener(this);
        oneButtonDialog.setOnClickListener(this);
        yesNoDialog.setOnClickListener(this);
        threeButtonDialog.setOnClickListener(this);
        fourButtonDialog.setOnClickListener(this);
        customDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.simple_dialog:
                DialogTool.simpleDialog(MainActivity.this, getString(R.string.title), getString(R.string.message));
                break;
            case R.id.one_button_dialog:
                DialogTool.oneButtonDialog(MainActivity.this, getString(R.string.title), getString(R.string.message), getString(R.string.submit));
                break;
            case R.id.yes_no_button_dialog:
                DialogTool.yesNoDialog(MainActivity.this, getString(R.string.title), getString(R.string.message), getString(R.string.positive), getString(R.string.negative));
                break;
            case R.id.three_button_dialog:
                DialogTool.threeButtonDialog(MainActivity.this, getString(R.string.title), getString(R.string.message), getString(R.string.positive), getString(R.string.submit), getString(R.string.negative));
                break;
            case R.id.four_button_dialog:
                DialogTool.customFourButtonDialog(MainActivity.this, getString(R.string.title), getString(R.string.message),
                        getString(R.string.firstButton), getString(R.string.secondButton), getString(R.string.thirdButton), getString(R.string.fourthButton));
                break;
            case R.id.custom_dialog:
                DialogTool.customDialog(MainActivity.this, getString(R.string.message), R.layout.custom_dialog);
                break;
        }
    }
}
