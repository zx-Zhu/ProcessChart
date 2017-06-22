package com.zxzhu.processtest.Common;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.pavlospt.CircleView;
import com.zxzhu.processtest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxzhu on 2017/6/18.
 */


public class ProcessImg extends LinearLayout {
    public interface Click {
        void click();
    }
    private String TAG = "ProcessImg";
    private CircleView circleView1, circleView2, circleView3, circleView4, circleView5, circleView6;
    private TextView textView1, textView2, textView3, textView4, textView5, textView6;
    //view代表流程连接线
    private View view1l, view1r, view2l, view2r, view3l, view3r, view4l, view4r, view5l, view5r, view6l, view6r;
    private LinearLayout process1, process2, process3, process4, process5, process6;
    private List<LinearLayout> layouts = new ArrayList<>();//用于控制流程个数的列表
    private List<View> views = new ArrayList<>();
    private List<TextView> texts = new ArrayList<>();
    private List<CircleView> circleViews = new ArrayList<>();
    private Context context;
    private int color = Color.parseColor("#E0E0E0");
    private int total = 0, process = 0;

    public ProcessImg(Context context) {
        super(context);
        this.context = context;
        initViews();
    }

    public ProcessImg(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        initViews();
    }

    private void initViews() {
        LayoutInflater.from(context).inflate(R.layout.process_img, this);
        circleView1 = (CircleView) findViewById(R.id.circle1);
        circleView2 = (CircleView) findViewById(R.id.circle2);
        circleView3 = (CircleView) findViewById(R.id.circle3);
        circleView4 = (CircleView) findViewById(R.id.circle4);
        circleView5 = (CircleView) findViewById(R.id.circle5);
        circleView6 = (CircleView) findViewById(R.id.circle6);
        process1 = (LinearLayout) findViewById(R.id.process1);
        process2 = (LinearLayout) findViewById(R.id.process2);
        process3 = (LinearLayout) findViewById(R.id.process3);
        process4 = (LinearLayout) findViewById(R.id.process4);
        process5 = (LinearLayout) findViewById(R.id.process5);
        process6 = (LinearLayout) findViewById(R.id.process6);
        textView1 = (TextView) findViewById(R.id.text1);
        textView2 = (TextView) findViewById(R.id.text2);
        textView3 = (TextView) findViewById(R.id.text3);
        textView4 = (TextView) findViewById(R.id.text4);
        textView5 = (TextView) findViewById(R.id.text5);
        textView6 = (TextView) findViewById(R.id.text6);
        view1l = findViewById(R.id.view1l);
        view1r = findViewById(R.id.view1r);
        view2l = findViewById(R.id.view2l);
        view2r = findViewById(R.id.view2r);
        view3l = findViewById(R.id.view3l);
        view3r = findViewById(R.id.view3r);
        view4l = findViewById(R.id.view4l);
        view4r = findViewById(R.id.view4r);
        view5l = findViewById(R.id.view5l);
        view5r = findViewById(R.id.view5r);
        view6l = findViewById(R.id.view6l);
        view6r = findViewById(R.id.view6r);
        circleViews.add(circleView1);
        circleViews.add(circleView2);
        circleViews.add(circleView3);
        circleViews.add(circleView4);
        circleViews.add(circleView5);
        circleViews.add(circleView6);
        layouts.add(process1);
        layouts.add(process2);
        layouts.add(process3);
        layouts.add(process4);
        layouts.add(process5);
        layouts.add(process6);
        texts.add(textView1);
        texts.add(textView2);
        texts.add(textView3);
        texts.add(textView4);
        texts.add(textView5);
        texts.add(textView6);
        views.add(view1l);
        views.add(view1r);
        views.add(view2l);
        views.add(view2r);
        views.add(view3l);
        views.add(view3r);
        views.add(view4l);
        views.add(view4r);
        views.add(view5l);
        views.add(view5r);
        views.add(view6l);
        views.add(view6r);
    }

    /**
     * 设置已完成流程颜色
     *
     * @param color
     */
    public void setColor(int color) {
        this.color = color;
        setProcess(total, process);
    }

    /**
     * 设置进度
     *
     * @param total   总共流程个数(不超过6)
     * @param process 当前进度
     */
    public void setProcess(int total, int process) {
        this.total = total;
        this.process = process;
        //使流程总数的view显示出来
        for (int i = 0; i < total; i++) {
            layouts.get(i).setVisibility(VISIBLE);
        }
        //  设置已完成进度的颜色
        for (int i = 0; i < circleViews.size(); i++) {
            if (i < process) {
                circleViews.get(i).setFillColor(color);
                circleViews.get(i).setBackgroundColor(color);
                circleViews.get(i).setStrokeColor(color);
                texts.get(i).setTextColor(color);

            } else {
                //未完成设置为灰色
                circleViews.get(i).setFillColor(Color.parseColor("#CCCCCC"));
                circleViews.get(i).setBackgroundColor(Color.parseColor("#CCCCCC"));
                texts.get(i).setTextColor(Color.parseColor("#CCCCCC"));
                circleViews.get(i).setStrokeColor(color);
                circleViews.get(i).setStrokeColor(Color.parseColor("#CCCCCC"));
            }
        }
        //设置流程连接线的颜色
        for (int i = 0; i < views.size(); i++) {
            if (i < process * 2) {
                views.get(i).setBackgroundColor(color);
            } else {
                views.get(i).setBackgroundColor(Color.parseColor("#CCCCCC"));
            }
        }
        views.get(0).setBackgroundColor(Color.parseColor("#00000000"));
        if (total != 0) {
            views.get(2 * total - 1).setBackgroundColor(Color.parseColor("#00000000"));
        }
    }

    /**
     * 设置各进度标题
     *
     * @param position
     * @param text
     */
    public void setTitle(int position, String text) {
        texts.get(position - 1).setText(text);
    }

    /**
     * 设置个流程的点击事件
     *
     * @param i
     * @param click 点击回调
     */
    public void setClick(int i, final Click click) {
        layouts.get(i - 1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                click.click();
            }
        });
    }
}