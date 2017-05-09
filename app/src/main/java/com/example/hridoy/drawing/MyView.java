package com.example.hridoy.drawing;

/**
 * Created by Hridoy on 09-May-17.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

    MyShape myShape;
    float ratioRadius;
    int numberOfPoint = 3; //default

    public MyView(Context context) {
        super(context);
        initMyView();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initMyView();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initMyView();
    }

    public void initMyView(){
        myShape = new MyShape();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int w = getWidth();
        int h = getHeight();

        if((w==0) || (h==0)){
            return;
        }

        float x = (float)w/2.0f;
        float y = (float)h/2.0f;
        float radius;
        if(w > h){
            radius = h * ratioRadius;
        }else{
            radius = w * ratioRadius;
        }

        myShape.setPolygon(x, y, radius, numberOfPoint);
        canvas.drawPath(myShape.getPath(), myShape.getPaint());
    }

    public void setShapeRadiusRatio(float ratio){
        ratioRadius = ratio;
    }

    public void setNumberOfPoint(int pt){
        numberOfPoint = pt;
    }

}