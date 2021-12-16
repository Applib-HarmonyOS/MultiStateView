package me.xdj.view;

import ohos.agp.components.AttrSet;
import ohos.agp.components.Component;
import ohos.app.Context;
import com.hmos.compat.utils.AttrUtils;

/**
 * Created by xdj on 16/2/3.
 * Multi-state view.
 */
public class SimpleMultiStateView extends MultiStateView implements Component.BindStateChangedListener {

    private static final int MIN_SHOW_TIME = 600;
    private static final int MIN_DELAY = 600;
    Integer resIdEmpty;
    Integer resIdLoading;
    Integer resIdFail;
    private int mTargetState = -1;
    private long mLoadingStartTime = -1;

    private final Runnable mLoadingHide = () -> {
        setViewState(mTargetState);
        mLoadingStartTime = -1;
        mTargetState = -1;
    };

    public SimpleMultiStateView(Context context) {
        this(context, null);
    }

    public SimpleMultiStateView(Context context, AttrSet attrs) {
        this(context, attrs, "");
    }

    /**
     * SimpleMultiStateView.
     *
     * @param context context.
     * @param attrs attr.
     * @param defStyleAttr defStyle.
     */
    public SimpleMultiStateView(Context context, AttrSet attrs, String defStyleAttr) {
        super(context, attrs, defStyleAttr);
        resIdEmpty = AttrUtils.utils(attrs);
        resIdLoading = AttrUtils.utils1(attrs);
        resIdFail = AttrUtils.utils2(attrs);

        if (resIdEmpty != -1) {
            addViewForStatus(MultiStateView.STATE_EMPTY, resIdEmpty);
        }
        if (resIdFail != -1) {
            addViewForStatus(MultiStateView.STATE_FAIL, resIdFail);
        }
        if (resIdLoading != -1) {
            addViewForStatus(MultiStateView.STATE_LOADING, resIdLoading);
        }
    }

    @Override
    public void setViewState(int state) {
        if (getViewState() == STATE_LOADING && state != STATE_LOADING) {
            long diff = System.currentTimeMillis() - mLoadingStartTime;
            if (diff < MIN_SHOW_TIME) {
                mTargetState = state;
                postDelayed(mLoadingHide, MIN_DELAY);
            } else {
                super.setViewState(state);
            }
            return;
        } else if (state == STATE_LOADING) {
            mLoadingStartTime = System.currentTimeMillis();
        }
        super.setViewState(state);
    }


    @Override
    public void onComponentBoundToWindow(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void onComponentUnboundFromWindow(Component component) {
        removeCallbacks(mLoadingHide);
    }
}
