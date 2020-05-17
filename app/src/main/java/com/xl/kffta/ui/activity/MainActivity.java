package com.xl.kffta.ui.activity;

import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.xl.kffta.R;
import com.xl.kffta.base.BaseActivity;

import org.jetbrains.annotations.NotNull;

/**
 * @author created by zhanghaochen
 * @date 2020-05-15 16:08
 * 描述：主界面-任务大厅
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void initViews() {
        findViewById(R.id.title_left).setVisibility(View.GONE);
        ((TextView) findViewById(R.id.title_name)).setText("任务大厅");
    }

    @Override
    protected void initListener() {
        findViewById(R.id.main_take_order).setOnClickListener(this);
        findViewById(R.id.main_execute_order).setOnClickListener(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void handleMessage(@NotNull Message message) {

    }

    @NotNull
    @Override
    public String getLoggerTag() {
        return "MainActivity";
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.main_take_order) {

        } else if (id == R.id.main_execute_order) {

        }
    }
}
