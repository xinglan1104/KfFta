package com.xl.kffta.ui.activity;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.xl.kffta.R;
import com.xl.kffta.base.BaseActivity;
import com.xl.kffta.ui.activity.executejointtask.ExecuteJointTaskListActivity;
import com.xl.kffta.ui.activity.executetask.ExecuteListActivity;
import com.xl.kffta.ui.activity.receivejointtask.JointTaskListActivity;
import com.xl.kffta.ui.activity.receivetask.TakeOrderActivity;
import com.xl.kffta.util.DialogUtil;

import org.jetbrains.annotations.NotNull;

/**
 * @author created by zhanghaochen
 * @date 2020-05-15 16:08
 * 描述：主界面-任务大厅
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {
    private boolean mForceQuit = false;

    @Override
    protected void initViews() {
        findViewById(R.id.title_left).setVisibility(View.GONE);
        ((TextView) findViewById(R.id.title_name)).setText("智慧执法");
    }

    @Override
    protected void initListener() {
        findViewById(R.id.main_layout_1).setOnClickListener(this);
        findViewById(R.id.main_layout_2).setOnClickListener(this);
        findViewById(R.id.main_layout_3).setOnClickListener(this);
        findViewById(R.id.main_layout_4).setOnClickListener(this);
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
        if (id == R.id.main_layout_1) {
            startActivity(new Intent(MainActivity.this, TakeOrderActivity.class));
        } else if (id == R.id.main_layout_2) {
            startActivity(new Intent(MainActivity.this, ExecuteListActivity.class));
        } else if (id == R.id.main_layout_3) {
            startActivity(new Intent(MainActivity.this, JointTaskListActivity.class));
        } else if (id == R.id.main_layout_4) {
            startActivity(new Intent(MainActivity.this, ExecuteJointTaskListActivity.class));
        }
    }

    @Override
    public void onBackPressed() {
        DialogUtil.INSTANCE.showCommonDialog(this, "确定要退出应用吗", new DialogUtil.OnDialogOkClick() {
            @Override
            public void onDialogOkClick() {
                mForceQuit = true;
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mForceQuit) {
            System.exit(0);
        }
    }
}
