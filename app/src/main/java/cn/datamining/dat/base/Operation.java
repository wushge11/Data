package cn.datamining.dat.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.io.Serializable;

import cn.datamining.dat.MyApplication;

/**
 * 基本的操作共通抽取
 *
 * @author 曾繁添
 * @version 1.0
 */
public class Operation {

    /**
     * 激活Activity组件意图
     **/
    private Intent mIntent = new Intent();
    /*** 上下文 **/
    private Activity mContext = null;
    /*** 整个应用Applicaiton **/
    private MyApplication mApplication = null;
    /**
     * 日志输出标志
     **/
    private final static String TAG = Operation.class.getSimpleName();

    public Operation(Activity mContext) {
        this.mContext = mContext;
        mApplication = (MyApplication) this.mContext.getApplicationContext();
    }

    public void forwardAndFinish(Class activity, int animeType) {
        forwardActivity(activity, animeType);
        mContext.finish();
    }

    public void forwardAndFinish(Class activity) {
        forwardActivity(activity, IBaseConstant.NONE);
        mContext.finish();
    }

    public void forward(Class activity, int animeType) {
        forwardActivity(activity, animeType);
    }

    public void forward(Class activity) {
        forwardActivity(activity, IBaseConstant.NONE);
    }

    /**
     * 跳转Activity
     *
     * @param animaType 动画类型IBaseActivity.LEFT_RIGHT/TOP_BOTTOM/FADE_IN_OUT
     */
    private void forwardActivity(Class className, int animaType) {
        mIntent.setClass(mContext, className);
        mIntent.putExtra(IBaseActivity.ANIMATION_TYPE, animaType);
        mContext.startActivity(mIntent);

        int mAnimIn = 0;
        int mAnimOut = 0;
        switch (animaType) {
            case IBaseActivity.LEFT_RIGHT:
                mAnimIn = BaseView.gainResId(mApplication, BaseView.ANIM, "base_slide_right_in");
                mAnimOut = BaseView.gainResId(mApplication, BaseView.ANIM, "base_slide_left_out");
                mContext.overridePendingTransition(mAnimIn, mAnimOut);
                break;
            case IBaseActivity.TOP_BOTTOM:
                mAnimIn = BaseView.gainResId(mApplication, BaseView.ANIM, "base_push_bottom_in");
                mAnimOut = BaseView.gainResId(mApplication, BaseView.ANIM, "base_push_up_out");
                mContext.overridePendingTransition(mAnimIn, mAnimOut);
                break;
            case IBaseActivity.FADE_IN_OUT:
                mAnimIn = BaseView.gainResId(mApplication, BaseView.ANIM, "base_fade_in");
                mAnimOut = BaseView.gainResId(mApplication, BaseView.ANIM, "base_fade_out");
                mContext.overridePendingTransition(mAnimIn, mAnimOut);
                break;
            default:
                break;
        }
    }

    /**
     * 设置传递参数
     *
     * @param value 数据传输对象
     */
    public void addParameter(DTO value) {
        mIntent.putExtra(SysEnv.ACTIVITY_DTO_KEY, value);
    }

    /**
     * 设置传递参数
     *
     * @param key   参数key
     * @param value 数据传输对象
     */
    public void addParameter(String key, DTO value) {
        mIntent.putExtra(key, value);
    }

    /**
     * 设置传递参数
     *
     * @param key   参数key
     * @param value 数据传输对象
     */
    public void addParameter(String key, Bundle value) {
        mIntent.putExtra(key, value);
    }

    /**
     * 设置传递参数
     *
     * @param key   参数key
     * @param value 数据传输对象
     */
    public void addParameter(String key, Serializable value) {
        mIntent.putExtra(key, value);
    }

    /**
     * 设置传递参数
     *
     * @param key   参数key
     * @param value 数据传输对象
     */
    public void addParameter(String key, String value) {
        mIntent.putExtra(key, value);
    }

    /**
     * 获取跳转时设置的参数
     *
     * @param key
     * @return
     */
    public Object getParameter(String key) {
        Bundle extras = mContext.getIntent().getExtras();
        if (null == extras) return null;

        return mContext.getIntent().getExtras().get(key);
    }

    /**
     * 获取跳转参数集合
     *
     * @return
     */
    public DTO getParameters() {
        DTO parms = (DTO) mContext.getIntent().getExtras().getSerializable(SysEnv.ACTIVITY_DTO_KEY);
        return parms;
    }

    /**
     * 设置全局Application传递参数
     *
     * @param strKey 参数key
     * @param value  数据传输对象
     */
    public void addGloableAttribute(String strKey, Object value) {
        mApplication.assignData(strKey, value);
    }

    /**
     * 获取跳转时设置的参数
     *
     * @param strKey
     * @return
     */
    public Object getGloableAttribute(String strKey) {
        return mApplication.gainData(strKey);
    }


    /**
     * 获取资源文件id
     *
     * @param mContext 上下文
     * @param resType  资源类型（drawable/string/layout/style/dimen/color/array等）
     * @param resName  资源文件名称
     * @return
     */
    public int gainResId(Context mContext, String resType, String resName) {
        int result = -1;
        try {
            String packageName = mContext.getPackageName();
            result = mContext.getResources().getIdentifier(resName, resType, packageName);
        } catch (Exception e) {
            result = -1;
            Log.e(TAG, "获取资源文件失败，原因：" + e.getMessage());
        }

        return result;
    }
}
