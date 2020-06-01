package com.xl.kffta.ui.activity;

import android.content.Intent;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.xl.kffta.R;
import com.xl.kffta.base.BaseActivity;
import com.xl.kffta.model.QueryTaskCountBean;
import com.xl.kffta.net.ResponseObjectCallback;
import com.xl.kffta.net.taskmanager.TaskNetManager;
import com.xl.kffta.ui.activity.executejointtask.ExecuteJointTaskListActivity;
import com.xl.kffta.ui.activity.executetask.ExecuteListActivity;
import com.xl.kffta.ui.activity.lawcase.LawcaseListActivity;
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

    private static final int HANDLER_REFRESH_COUNT = 0x801;

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
        findViewById(R.id.main_layout_5).setOnClickListener(this);
        findViewById(R.id.main_layout_6).setOnClickListener(this);
        findViewById(R.id.main_layout_7).setOnClickListener(this);
        findViewById(R.id.main_layout_8).setOnClickListener(this);
        findViewById(R.id.main_layout_9).setOnClickListener(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void handleMessage(@NotNull Message message) {
        switch (message.what) {
            case HANDLER_REFRESH_COUNT:
                if (message.obj instanceof QueryTaskCountBean) {
                    QueryTaskCountBean bean = (QueryTaskCountBean) message.obj;

                    ((TextView) findViewById(R.id.main_count_1)).setText(String.valueOf(bean.getPendingClaimedEnforcementTaskCount()));
                    ((TextView) findViewById(R.id.main_count_2)).setText(String.valueOf(bean.getPendingExcutedEnforcementTaskCount()));
                    ((TextView) findViewById(R.id.main_count_3)).setText(String.valueOf(bean.getPendingClaimedProjectTaskCount()));
                    ((TextView) findViewById(R.id.main_count_4)).setText(String.valueOf(bean.getPendingExcutedProjectTaskCount()));
                    ((TextView) findViewById(R.id.main_count_5)).setText(String.valueOf(bean.getExcutedEnforcementTaskCount()));
                    ((TextView) findViewById(R.id.main_count_6)).setText(String.valueOf(bean.getExcutedProjectTaskCount()));
                }

                mHandler.removeMessages(HANDLER_REFRESH_COUNT);
                break;
            default:
                break;
        }
    }

    @NotNull
    @Override
    public String getLoggerTag() {
        return "MainActivity";
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = new Intent();
        if (id == R.id.main_layout_1) {
            startActivity(new Intent(MainActivity.this, TakeOrderActivity.class));
        } else if (id == R.id.main_layout_2) {
            // 待执行的
            intent.setClass(MainActivity.this, ExecuteListActivity.class);
            intent.putExtra(ExecuteListActivity.EXE_TASK_TYPE, ExecuteListActivity.EXE_TASK_PENDING);
            startActivity(intent);
        } else if (id == R.id.main_layout_3) {
            startActivity(new Intent(MainActivity.this, JointTaskListActivity.class));
        } else if (id == R.id.main_layout_4) {
            intent.setClass(MainActivity.this, ExecuteJointTaskListActivity.class);
            intent.putExtra(ExecuteJointTaskListActivity.JOINT_EXE_TASK_STATE, ExecuteJointTaskListActivity.JOINT_EXE_TASK_PENDING);
            startActivity(new Intent(intent));
        } else if (id == R.id.main_layout_5) {
            intent.setClass(MainActivity.this, ExecuteListActivity.class);
            intent.putExtra(ExecuteListActivity.EXE_TASK_TYPE, ExecuteListActivity.EXE_TASK_OVER);
            startActivity(intent);
        } else if (id == R.id.main_layout_6) {
            intent.setClass(MainActivity.this, ExecuteJointTaskListActivity.class);
            intent.putExtra(ExecuteJointTaskListActivity.JOINT_EXE_TASK_STATE, ExecuteJointTaskListActivity.JOINT_EXE_TASK_OVER);
            startActivity(new Intent(intent));
        } else if (id == R.id.main_layout_7) {
            startActivity(new Intent(MainActivity.this, LawcaseListActivity.class));
        } else if (id == R.id.main_layout_9) {

        } else if (id == R.id.main_layout_8) {

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        sendRequest();
    }

    /**
     * 请求主页几个列表的数量
     */
    private void sendRequest() {
        TaskNetManager.INSTANCE.getMainCount(new ResponseObjectCallback() {
            @Override
            public void onError(@NotNull String msg) {
                Log.e("zhc", "请求数量失败：" + msg);
            }

            @Override
            public void onSuccess(@NotNull Object obj) {
                mHandler.obtainMessage(HANDLER_REFRESH_COUNT, obj).sendToTarget();
            }
        });
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
