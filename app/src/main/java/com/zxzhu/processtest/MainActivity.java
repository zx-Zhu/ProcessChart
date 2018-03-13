package com.zxzhu.processtest;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zxzhu.processchart.ProcessChart;

public class MainActivity extends AppCompatActivity {

    private ProcessChart processChart1, processChart2, processChart3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setProcessImg1();
        setProcessImg2();
        setProcessImg3();
        Looper.loop();
    }

    private void initViews(){
        processChart1 = (ProcessChart) findViewById(R.id.p1);
        processChart2 = (ProcessChart)findViewById(R.id.p2);
        processChart3 = (ProcessChart)findViewById(R.id.p3);
    }
    private void setProcessImg1(){
        processChart1.setColor(Color.parseColor("#FFFF8C56"));
        processChart1.setProcess(3,2);
        processChart1.setTitle(1,"title1");
        processChart1.setTitle(2,"title2");
        processChart1.setTitle(3,"title3");
        processChart1.setClick(1, new ProcessChart.Click() {
            @Override
            public void click() {
                Toast.makeText(MainActivity.this, "点击第1项", Toast.LENGTH_SHORT).show();
            }
        });
        processChart1.setClick(2, new ProcessChart.Click() {
            @Override
            public void click() {
                Toast.makeText(MainActivity.this, "点击第2项", Toast.LENGTH_SHORT).show();
            }
        });
        processChart1.setClick(3, new ProcessChart.Click() {
            @Override
            public void click() {
                Toast.makeText(MainActivity.this, "点击第3项", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setProcessImg2(){
        processChart2.setColor(Color.parseColor("#FFFF8C56"));
        processChart2.setProcess(5,4);
        processChart2.setTitle(1,"title1");
        processChart2.setTitle(2,"title2");
        processChart2.setTitle(3,"title3");
        processChart2.setTitle(4,"title4");
        processChart2.setTitle(5,"title5");
        processChart2.setTitle(6,"title6");
    }

    private void setProcessImg3(){
        processChart3.setColor(Color.parseColor("#809bff"));
        processChart3.setProcess(4,2);
        processChart3.setTitle(1,"标题1");
        processChart3.setTitle(2,"标题2");
        processChart3.setTitle(3,"标题3");
        processChart3.setTitle(4,"标题4");

    }
}
