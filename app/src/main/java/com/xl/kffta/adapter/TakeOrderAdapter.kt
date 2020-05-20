package com.xl.kffta.adapter

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.xl.kffta.R
import com.xl.kffta.model.TakeOrderBean
import com.xl.kffta.model.TaskGetOrCancel
import com.xl.kffta.net.ResponseCallback
import com.xl.kffta.net.taskmanager.TaskNetManager
import com.xl.kffta.ui.activity.singletask.TaskInfoDetailActivity
import com.xl.kffta.util.ApplicationParams
import com.xl.kffta.util.DialogUtil
import com.xl.kffta.util.SysUtils
import com.xl.kffta.viewholder.TakeOderViewHolder
import org.jetbrains.anko.runOnUiThread

/**
 * @author zhanghaochen
 * date 2020-05-17
 * 描述：领取任务adapter
 */
class TakeOrderAdapter(var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val mDatas = ArrayList<TakeOrderBean.DataBean>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_takeorder, parent, false)

        return TakeOderViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mDatas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val takeOderViewHolder = holder as TakeOderViewHolder
        val dataBean = mDatas[position]
        dataBean?.let {
            takeOderViewHolder.setData(it)
            takeOderViewHolder.setHolderItemClickListener(object : TakeOderViewHolder.HolderItemClickListener {
                override fun onTakeClick() {
                    // 领取任务
                    DialogUtil.showCommonDialog(context, "确认领取任务", object : DialogUtil.OnDialogOkClick {
                        override fun onDialogOkClick() {
                            TaskNetManager.getOrCancelTask(it.id.toString(), true, object : ResponseCallback {
                                override fun onError(msg: String?) {
                                    context.runOnUiThread {
                                        Toast.makeText(context, msg
                                                ?: "领取出错", Toast.LENGTH_SHORT).show()
                                    }
                                }

                                override fun onSuccess(jsonString: String) {
                                    if (!TextUtils.isEmpty(jsonString)) {
                                        // 直接把Json转换成javaBean
                                        try {
                                            val taskGetOrCancel: TaskGetOrCancel? = Gson().fromJson(jsonString, TaskGetOrCancel::class.java)
                                            if (taskGetOrCancel == null) {
                                                context.runOnUiThread {
                                                    Toast.makeText(context, "解析错误", Toast.LENGTH_SHORT).show()
                                                }
                                            } else {
                                                // 获取ErrorCode,<0时错误
                                                if (taskGetOrCancel.errorCode < 0) {
                                                    context.runOnUiThread {
                                                        Toast.makeText(context, taskGetOrCancel.error
                                                                ?: "解析错误", Toast.LENGTH_SHORT).show()
                                                    }
                                                } else {
                                                    // success
                                                    context.runOnUiThread {
                                                        // 最好的办法就是改变数据源，刷新自己
                                                        Toast.makeText(context, "领取成功", Toast.LENGTH_SHORT).show()
                                                        it.ownerIDs.add(ApplicationParams.USER_ID)
                                                        notifyItemChanged(position)
                                                    }
                                                }
                                            }
                                        } catch (e: Exception) {
                                            context.runOnUiThread {
                                                Toast.makeText(context, e.message
                                                        ?: "解析错误", Toast.LENGTH_SHORT).show()
                                            }
                                        }
                                    } else {
                                        context.runOnUiThread {
                                            Toast.makeText(context, "请求返回为空", Toast.LENGTH_SHORT).show()
                                        }
                                    }
                                }
                            })
                        }
                    })
                }

                override fun onBackClick() {
                    // 退回任务
                    DialogUtil.showCommonDialog(context, "确认退回任务", object : DialogUtil.OnDialogOkClick {
                        override fun onDialogOkClick() {
                            TaskNetManager.getOrCancelTask(it.id.toString(), true, object : ResponseCallback {
                                override fun onError(msg: String?) {
                                    context.runOnUiThread {
                                        Toast.makeText(context, msg
                                                ?: "退回出错", Toast.LENGTH_SHORT).show()
                                    }
                                }

                                override fun onSuccess(jsonString: String) {
                                    if (!TextUtils.isEmpty(jsonString)) {
                                        // 直接把Json转换成javaBean
                                        try {
                                            val taskGetOrCancel: TaskGetOrCancel? = Gson().fromJson(jsonString, TaskGetOrCancel::class.java)
                                            if (taskGetOrCancel == null) {
                                                context.runOnUiThread {
                                                    Toast.makeText(context, "解析错误", Toast.LENGTH_SHORT).show()
                                                }
                                            } else {
                                                // 获取ErrorCode,<0时错误
                                                if (taskGetOrCancel.errorCode < 0) {
                                                    context.runOnUiThread {
                                                        Toast.makeText(context, taskGetOrCancel.error
                                                                ?: "解析错误", Toast.LENGTH_SHORT).show()
                                                    }
                                                } else {
                                                    // success
                                                    context.runOnUiThread {
                                                        // 此处不需要刷新自己，有可能列表的数据并没有变化
                                                        Toast.makeText(context, "退回成功", Toast.LENGTH_SHORT).show()
//                                                        holder.takeBtn.isEnabled = false
                                                    }
                                                }
                                            }
                                        } catch (e: Exception) {
                                            context.runOnUiThread {
                                                Toast.makeText(context, e.message
                                                        ?: "解析错误", Toast.LENGTH_SHORT).show()
                                            }
                                        }
                                    } else {
                                        context.runOnUiThread {
                                            Toast.makeText(context, "请求返回为空", Toast.LENGTH_SHORT).show()
                                        }
                                    }
                                }
                            })
                        }
                    })
                }

                override fun onInfoClick(getState: Int) {
                    val intent = Intent()
                    val activity = SysUtils.getActivity(context)
                    activity?.let { parentActivity ->
                        intent.setClass(parentActivity, TaskInfoDetailActivity::class.java)
                        intent.putExtra(TaskInfoDetailActivity.TASK_ID, it.id)
                        intent.putExtra(TaskInfoDetailActivity.TASK_GET_STATE, getState)
                        parentActivity.startActivity(intent)
                    }
                }

            })
        }
    }

    fun notifyDataChange(takeOrderBean: TakeOrderBean) {
        if (!takeOrderBean.data.isNullOrEmpty()) {
            mDatas.clear()
            mDatas.addAll(takeOrderBean.data)
            notifyDataSetChanged()
        }
    }
}