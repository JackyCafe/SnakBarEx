package com.linyanheng.snakbarex;

import android.graphics.Color;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab;
    Snackbar snackbar;
    View snackView;
    ToggleButton toggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        toggleButton = (ToggleButton) findViewById(R.id.toggle);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (snackbar == null) {
                        createSnackView(buttonView);
                }
                if(isChecked)
                {
                    snackbar.show();
                }else {
                    snackbar.dismiss();

                }

                snackbar.addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() {
                    @Override
                    public void onDismissed(Snackbar transientBottomBar, int event) {
                        super.onDismissed(transientBottomBar, event);
                        toggleButton.toggle();
                        snackbar = null;
                    }

                    @Override
                    public void onShown(Snackbar transientBottomBar) {
                        super.onShown(transientBottomBar);
                    }
                });


            }
        });



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createSnackView(v);
            }


           });
    }


        private void createSnackView(View  v) {


            snackbar = Snackbar.make(v, "這是一封簡訊", Snackbar.LENGTH_SHORT)
                        .setAction("來自於妹子", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                toggleButton.toggle();
                            }
                        });

            snackbar.setDuration(3000);
            snackView = snackbar.getView();
            if(snackView != null)
            {
                snackView.setBackgroundColor(Color.parseColor("#000fff"));
                TextView tv = snackView.findViewById(R.id.snackbar_text);
                tv.setTextColor(Color.YELLOW);
                tv.setTextSize(16);
                Button snackbutton = snackView.findViewById(R.id.snackbar_action);
                snackbutton.setTextColor(Color.YELLOW);
                tv.setTextSize(16);

            }
            snackbar.show();
        }




}
