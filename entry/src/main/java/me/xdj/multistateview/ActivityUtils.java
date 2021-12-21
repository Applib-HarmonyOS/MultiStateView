package me.xdj.multistateview;

import ohos.aafwk.ability.fraction.Fraction;
import ohos.aafwk.ability.fraction.FractionManager;
import ohos.aafwk.ability.fraction.FractionScheduler;

/**
 * Created by xdj on 16/9/13.
 */

public class ActivityUtils {
    private ActivityUtils() {
        throw new IllegalStateException("Utils class");
    }

    /**
     * AddFragementMethod.
     *
     * @param fm FractionManager.
     * @param fraction Fraction.
     * @param contentId ContentId.
     */
    public static void addFractionToActivity(FractionManager fm, Fraction fraction, int contentId) {
        FractionScheduler ft = fm.startFractionScheduler();
        ft.add(contentId, fraction);
        ft.submit();
    }
}
