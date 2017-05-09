package com.example.hridoy.drawing;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {

    SeekBar radiusBar;
    MyView myView;

    SeekBar ptBar;
    TextView textPt;
    final static int MIN_PT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radiusBar = (SeekBar) findViewById(R.id.radiusbar);
        myView = (MyView) findViewById(R.id.myview);
        float defaultRatio = (float) (radiusBar.getProgress())
                / (float) (radiusBar.getMax());
        myView.setShapeRadiusRatio(defaultRatio);

        radiusBar.setOnSeekBarChangeListener(radiusBarOnSeekBarChangeListener);

        textPt = (TextView)findViewById(R.id.pttext);
        ptBar = (SeekBar)findViewById(R.id.ptbar);
        ptBar.setOnSeekBarChangeListener(ptBarOnSeekBarChangeListener);

    };

    OnSeekBarChangeListener radiusBarOnSeekBarChangeListener =
            new OnSeekBarChangeListener() {

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    float ratio = (float) (radiusBar.getProgress())
                            / (float) (radiusBar.getMax());
                    myView.setShapeRadiusRatio(ratio);
                    myView.invalidate();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {}

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {}

            };

    OnSeekBarChangeListener ptBarOnSeekBarChangeListener =
            new OnSeekBarChangeListener() {

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    int pt = progress + MIN_PT;
                    textPt.setText("number of point in polygon: " + String.valueOf(pt));
                    myView.setNumberOfPoint(pt);
                    myView.invalidate();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {}

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {}

            };
}
