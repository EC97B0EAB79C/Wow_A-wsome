package com.example.pc.wow_awsome;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }

    class MyView extends View{
        float hsv[]={0,1,1};
        int backgroud;
        int width, height;
        boolean up=true;
        public MyView(Context context) {
            super(context);

            DisplayMetrics disp=getApplicationContext().getResources().getDisplayMetrics();

            width=disp.widthPixels;
            height=disp.heightPixels;

            mHandler.sendEmptyMessageDelayed(0,0);
        }

        public void onDraw(Canvas canvas){

            Paint paint=new Paint();
            paint.setColor(Color.HSVToColor(hsv));
            paint.setTextSize((int)((float)483/2560.0*width));
            canvas.drawARGB(backgroud,0,0,0);
            canvas.drawText("우와 대~단해",0,height/2,paint);

        }

        Handler mHandler = new Handler(){
            public void handleMessage(Message msg){
                hsv[0]++;
                hsv[0]=hsv[0]%360;
                if(up)backgroud+=10;
                else backgroud-=10;
                if(backgroud==240) up=false;
                if(backgroud==0) up=true;
                invalidate();
                mHandler.sendEmptyMessageDelayed(0,1);
            }
        };
    }
}
