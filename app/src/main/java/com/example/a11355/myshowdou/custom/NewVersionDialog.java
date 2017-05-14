package com.example.a11355.myshowdou.custom;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.example.a11355.myshowdou.Base.BaseDialog;
import com.example.a11355.myshowdou.R;
import com.example.a11355.myshowdou.Utils.ToastUtil;
import com.example.a11355.myshowdou.Utils.Util;


/**
 * 发现新版本 对话框
 */
public class NewVersionDialog extends BaseDialog implements View.OnClickListener, DialogInterface.OnKeyListener,
        View.OnLongClickListener {

    private int clickCount = 0;//标题点击数量
    private boolean isExit = false;//退出标识
    private Handler handler = new Handler();

    public static NewVersionDialog newInstance(String title, String content, String cancel, String confirm) {
        NewVersionDialog confirmDialog = new NewVersionDialog();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("content", content);
        bundle.putString("cancel", cancel);
        bundle.putString("confirm", confirm);
        confirmDialog.setArguments(bundle);
        return confirmDialog;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_new_version, null);
        AlertDialog alertDialog = new AlertDialog.Builder(getActivity())
                .setView(view)
                .create();
        TextView tvTitle = (TextView) view.findViewById(R.id.tv_versionTitle);
        TextView tvContent = (TextView) view.findViewById(R.id.tv_versionContent);
        TextView btnCancel = (TextView) view.findViewById(R.id.btn_versionCancel);
        TextView btnConfirm = (TextView) view.findViewById(R.id.btn_versionUpdate);
        //点击对话框外不可取消
        alertDialog.setCanceledOnTouchOutside(false);
        tvTitle.setText(getArguments().getString("title"));
        tvContent.setText(getArguments().getString("content"));
        //特定字符情况下隐藏取消按钮
        String cancelText = getArguments().getString("cancel");
        if ("force".equals(cancelText) || "gone".equals(cancelText)) {
            if ("force".equals(cancelText)) {
                alertDialog.setOnKeyListener(this);
            }
            btnCancel.setVisibility(View.GONE);
        } else {
            btnCancel.setText(getArguments().getString("cancel"));
        }
        btnConfirm.setText(getArguments().getString("confirm"));
        tvTitle.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        btnConfirm.setOnClickListener(this);
        btnConfirm.setOnLongClickListener(this);
        return alertDialog;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_versionUpdate:
                onItemClickListener.onItemClick(v);
            case R.id.btn_versionCancel:
                dismiss();
                break;
            case R.id.tv_versionTitle:
                clickCount++;
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (clickCount == 3) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override
    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
            if (isExit) {
                System.exit(0);
            } else {
                ToastUtil.initToast(getActivity(), "再按一次退出" + Util.getAppName(getActivity()));
                isExit = true;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isExit = false;
                    }
                }, 5000);//5秒内再按后退键真正退出
            }
            return true;
        } else {
            return false;
        }
    }
}
