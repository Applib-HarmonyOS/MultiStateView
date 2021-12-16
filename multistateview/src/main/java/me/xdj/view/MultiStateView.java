package me.xdj.view;

import ohos.agp.components.AttrSet;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.LayoutScatter;
import ohos.agp.components.StackLayout;
import ohos.app.Context;
import ohos.eventhandler.EventHandler;
import ohos.eventhandler.EventRunner;
import ohos.utils.PlainArray;
import ohos.utils.PlainIntArray;
import java.util.logging.Logger;

/**
 * Created by xdj on 16/2/3.
 * Multi-state view
 */
public class MultiStateView extends StackLayout {

    public static final int STATE_CONTENT = 10001;
    public static final int STATE_LOADING = 10002;
    public static final int STATE_EMPTY = 10003;
    public static final int STATE_FAIL = 10004;
    private PlainArray<Component> mStateViewArray = new PlainArray<>();
    private PlainIntArray mLayoutIdArray = new PlainIntArray();
    private Component mContentView;
    private int mCurrentState = STATE_CONTENT;
    private OnInflateListener mOnInflateListener;
    private EventHandler mHandler;

    /**
     * MultiStateView.
     *
     * @param context context.
     */
    public MultiStateView(Context context) {
        this(context, null);
        mHandler = new EventHandler(EventRunner.getMainEventRunner());
    }

    /**
     * MultiStateView.
     *
     * @param context context.
     * @param attrs attrs.
     */
    public MultiStateView(Context context, AttrSet attrs) {
        this(context, attrs, "");
        mHandler = new EventHandler(EventRunner.getMainEventRunner());
    }

    /**
     * MultiStateView.
     *
     * @param context context.
     * @param attrs attrset.
     * @param defStyleAttr defattr.
     */
    public MultiStateView(Context context, AttrSet attrs, String defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mHandler = new EventHandler(EventRunner.getMainEventRunner());
    }

    @Override
    public void addComponent(Component child) {
        validContentView(child);
        super.addComponent(child);
    }

    @Override
    public void addComponent(Component child, int index) {
        validContentView(child);
        super.addComponent(child, index);
    }

    @Override
    public void addComponent(Component child, int width, int height) {
        validContentView(child);
        super.addComponent(child, width, height);
    }

    @Override
    public void addComponent(Component child, ComponentContainer.LayoutConfig params) {
        validContentView(child);
        super.addComponent(child, params);
    }

    @Override
    public void addComponent(Component child, int index, ComponentContainer.LayoutConfig params) {
        validContentView(child);
        super.addComponent(child, index, params);
    }

    /**
     * Change view state.
     *
     * @param state State type.
     */
    public void setViewState(int state) {
        if (state != mCurrentState) {
            Component view = getView(state);
            getCurrentView().setVisibility(HIDE);
            mCurrentState = state;
            if (view != null) {
                view.setVisibility(VISIBLE);
            } else {
                int resLayoutId = mLayoutIdArray.get(state).get();
                view = LayoutScatter.getInstance(getContext()).parse(resLayoutId, this, false);
                mStateViewArray.put(state, view);
                addComponent(view);
                view.setVisibility(VISIBLE);

                if (mOnInflateListener != null) {
                    mOnInflateListener.onInflate(state, view);
                }
            }
        }
    }

    /**
     * get current status view.
     *
     * @return currentState.
     */
    public int getViewState() {
        return mCurrentState;
    }

    /**
     * Get the specified status View.
     *
     * @param state state.
     * @return Specified state View.
     */
    public Component getView(int state) {
        if (mStateViewArray.get(state).isPresent()) {
            return mStateViewArray.get(state).get();
        }
        return null;
    }

    /**
     * getCurrentView.
     *
     * @return currentStateView.
     */
    public Component getCurrentView() {
        Component view = getView(mCurrentState);
        if (view == null && mCurrentState == STATE_CONTENT) {
            Logger.getLogger("Content is null");
        } else if (view == null) {
            throw new NullPointerException("current state view is null =" + mCurrentState);
        }
        return getView(mCurrentState);
    }

    public void addViewForStatus(int status, int resLayoutId) {
        mLayoutIdArray.put(status, resLayoutId);
    }

    public void setOnInflateListener(OnInflateListener onInflateListener) {
        mOnInflateListener = onInflateListener;
    }

    private boolean isValidContentView(Component view) {
        return mContentView == null && mStateViewArray.indexOfValue(view) == -1;
    }

    /**
     * postDelayed.
     *
     * @param loadingHide loading.
     * @param minDelay mindelay.
     */
    public void postDelayed(Runnable loadingHide, int minDelay) {
        if (mHandler == null) {
            return;
        }
        mHandler.postTask(loadingHide, minDelay);
    }

    /**
     * removecallbacks.
     *
     * @param loadingHide mloading.
     */
    public void removeCallbacks(Runnable loadingHide) {
        if (mHandler == null) {
            return;
        }
        mHandler.removeTask(loadingHide);
    }

    /**
     * CheckContentView.
     *
     * @param view view.
     */
    private void validContentView(Component view) {
        if (isValidContentView(view)) {
            mContentView = view;
            mStateViewArray.put(STATE_CONTENT, view);
        } else if (mCurrentState != STATE_CONTENT) {
            mContentView.setVisibility(HIDE);
        }
    }

    /**
     * OnInflateListener.
     */
    public interface OnInflateListener {
        void onInflate(int state, Component view);
    }
}
