package com.michael.easydialogdemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.michael.easydialog.EasyDialog;

public class SecondActivity extends ActionBarActivity {

    Button btnClickMe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnClickMe=(Button)findViewById(R.id.btnMiddleBottom);
        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog();
            }
        });
    }
    public void showCustomDialog(){
        View view = this.getLayoutInflater().inflate(R.layout.custom_dialog, null);

        TextView txtMe = (TextView)view.findViewById(R.id.txt1);

        txtMe.setText("Dynamically set text to textview ");

        txtMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondActivity.this,"Hi this ",Toast.LENGTH_SHORT).show();
            }
        });
        new EasyDialog(SecondActivity.this)
//                        .setLayoutResourceId(R.layout.layout_tip_content_horizontal)//layout resource id
                .setLayout(view)
                .setBackgroundColor(SecondActivity.this.getResources().getColor(R.color.background_color_green))
//                        .setLocation(new location[])//point in screen
                .setLocationByAttachedView(btnClickMe)
                .setGravity(EasyDialog.GRAVITY_BOTTOM)
                .setAnimationTranslationShow(EasyDialog.DIRECTION_X, 1000, -600, 100, -50, 50, 0)
                .setAnimationAlphaShow(1000, 0.3f, 1.0f)
                .setAnimationTranslationDismiss(EasyDialog.DIRECTION_X, 500, -50, 800)
                .setAnimationAlphaDismiss(500, 1.0f, 0.0f)
                .setTouchOutsideDismiss(false)
                .setMatchParent(false)
                .setMarginLeftAndRight(24, 24)
                .setSize(500,500)
                .setOutsideColor(SecondActivity.this.getResources().getColor(R.color.outside_color_trans))
                .show();
    }
}
