/*
 * Copyright (C) 2020-21 Application Library Engineering Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hmos.compat.utils;

import ohos.agp.components.AttrSet;
import ohos.agp.components.element.Element;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

/**
 * Utils for Attributes.
 *
 * @author a00237416.
 * @since 2021-24-06.
 */
public class AttrUtils {
    private static final HiLogLabel HI_LOG_LABEL =new HiLogLabel(0,0,"MultistateView");
    private static final String TAG = "context";

    private AttrUtils() {
        throw new IllegalStateException("Utils class");
    }

    /**
     * GetIntFromAttr.
     *
     * @param attrs attrset.
     * @param name name.
     * @param defaultValue defvalue.
     * @return value.
     */
    public static int getIntFromAttr(AttrSet attrs, String name, int defaultValue) {
        int value = defaultValue;
        try {
            if (attrs.getAttr(name).isPresent() && attrs.getAttr(name).get() != null) {
                value = attrs.getAttr(name).get().getIntegerValue();
            }
        } catch (Exception e) {
            HiLog.error(HI_LOG_LABEL, TAG,e);
        }
        return value;
    }

    /**
     * getFloatFromAttr.
     *
     * @param attrs attrs.
     * @param name name.
     * @param defaultValue defValue.
     * @return value.
     */
    public static float getFloatFromAttr(AttrSet attrs, String name, float defaultValue) {
        float value = defaultValue;
        try {
            if (attrs.getAttr(name).isPresent() && attrs.getAttr(name).get() != null) {
                value = attrs.getAttr(name).get().getFloatValue();
            }
        } catch (Exception e) {
            HiLog.error(HI_LOG_LABEL, TAG,e);
        }
        return value;
    }

    /**
     * getBooleanFromAttr.
     *
     * @param attrs attrs.
     * @param name name.
     * @param defaultValue defValue.
     * @return value.
     */
    public static boolean getBooleanFromAttr(AttrSet attrs, String name, boolean defaultValue) {
        boolean value = defaultValue;
        try {
            if (attrs.getAttr(name).isPresent() && attrs.getAttr(name).get() != null) {
                value = attrs.getAttr(name).get().getBoolValue();
            }
        } catch (Exception e) {
            HiLog.error(HI_LOG_LABEL, TAG,e);
        }
        return value;
    }

    /**
     * getLongFromAttr.
     *
     * @param attrs attrs.
     * @param name name.
     * @param defaultValue defValue.
     * @return value.
     */
    public static long getLongFromAttr(AttrSet attrs, String name, long defaultValue) {
        long value = defaultValue;
        try {
            if (attrs.getAttr(name).isPresent() && attrs.getAttr(name).get() != null) {
                value = attrs.getAttr(name).get().getLongValue();
            }
        } catch (Exception e) {
            HiLog.error(HI_LOG_LABEL, TAG,e);
        }
        return value;
    }

    /**
     * getColorFromAttr.
     *
     * @param attrs attrs.
     * @param name name.
     * @param defaultValue defValue.
     * @return value.
     */
    public static int getColorFromAttr(AttrSet attrs, String name, int defaultValue) {
        int value = defaultValue;
        try {
            if (attrs.getAttr(name).isPresent() && attrs.getAttr(name).get() != null) {
                value = attrs.getAttr(name).get().getColorValue().getValue();
            }
        } catch (Exception e) {
            HiLog.error(HI_LOG_LABEL, TAG,e);
        }
        return value;
    }

    /**
     * getDimensionFromAttr.
     *
     * @param attrs attrs.
     * @param name name.
     * @param defaultValue defValue.
     * @return value.
     */
    public static int getDimensionFromAttr(AttrSet attrs, String name, int defaultValue) {
        int value = defaultValue;
        try {
            if (attrs.getAttr(name).isPresent() && attrs.getAttr(name).get() != null) {
                value = attrs.getAttr(name).get().getDimensionValue();
            }
        } catch (Exception e) {
            HiLog.error(HI_LOG_LABEL, TAG,e);
        }
        return value;
    }

    /**
     * getDimensionalFromAttr.
     *
     * @param attrs attrs.
     * @param name name.
     * @param defaultValue defValue.
     * @return value.
     */
    public static int getDimensionFromAttr(AttrSet attrs, String name, float defaultValue) {
        float value = defaultValue;
        try {
            if (attrs.getAttr(name).isPresent() && attrs.getAttr(name).get() != null) {
                value = attrs.getAttr(name).get().getDimensionValue();
            }
        } catch (Exception e) {
            HiLog.error(HI_LOG_LABEL, TAG,e);
        }
        return (int) value;
    }

    /**
     * getStringFromAttr.
     *
     * @param attrs attrs.
     * @param name name.
     * @param defaultValue defValue.
     * @return value.
     */
    public static String getStringFromAttr(AttrSet attrs, String name, String defaultValue) {
        String value = defaultValue;
        try {
            if (attrs.getAttr(name).isPresent() && attrs.getAttr(name).get() != null) {
                value = attrs.getAttr(name).get().getStringValue();
            }
        } catch (Exception e) {
            HiLog.error(HI_LOG_LABEL, TAG,e);
        }
        return value;
    }

    /**
     * getStringAttr.
     *
     * @param attrs attrset.
     * @param name name.
     * @return value.
     */
    public static String getStringFromAttr(AttrSet attrs, String name) {
        String value = "";
        try {
            if (attrs.getAttr(name).isPresent() && attrs.getAttr(name).get() != null) {
                value = attrs.getAttr(name).get().getStringValue();
            }
        } catch (Exception e) {
            HiLog.error(HI_LOG_LABEL, TAG,e);
        }
        return value;
    }

    /**
     * getElementAttr.
     *
     * @param attrs attrset.
     * @param name name.
     * @return value.
     */
    public static Element getElementFromAttr(AttrSet attrs, String name) {
        Element value = null;
        try {
            if (attrs.getAttr(name).isPresent() && attrs.getAttr(name).get() != null) {
                value = attrs.getAttr(name).get().getElement();
            }
        } catch (Exception e) {
            HiLog.error(HI_LOG_LABEL, TAG,e);
        }
        return value;
    }
}
