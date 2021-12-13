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

package com.hmos.compat.util;

import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

/**
 * Log utils.
 *
 * @since 2020-03-01.
 */
public class Log {

    private static final String TAG_LOG = "HMOSCompat";

    private static final int DOMAIN_ID = 0xD000F00;

    private static final HiLogLabel LABEL_LOG = new HiLogLabel(3, DOMAIN_ID, Log.TAG_LOG);

    private static final String LOG_FORMAT = "%{public}s: %{public}s";

    private Log() {
    }

    /**
     * Print debug log.
     *
     * @param tag log tag.
     * @param msg log message.
     */
    public static int debug(String tag, String msg) {
        return HiLog.debug(LABEL_LOG, LOG_FORMAT, tag, msg);
    }

    /**
     * Print info log.
     *
     * @param tag log tag.
     * @param msg log message.
     */
    public static int info(String tag, String msg) {
        return HiLog.info(LABEL_LOG, LOG_FORMAT, tag, msg);
    }

    /**
     * Print warn log.
     *
     * @param tag log tag.
     * @param msg log message.
     */
    public static int warn(String tag, String msg) {
        return HiLog.warn(LABEL_LOG, LOG_FORMAT, tag, msg);
    }

    /**
     * Print error log.
     *
     * @param tag log tag.
     * @param msg log message.
     */
    public static void error(String tag, String msg) {
        HiLog.error(LABEL_LOG, LOG_FORMAT, tag, msg);
    }

    public static int error(String tag, String msg, Throwable tr) {
        return HiLog.error(LABEL_LOG, LOG_FORMAT, tag, msg, tr);
    }

    public static int warn(String tag, String msg, Throwable tr) {
        return HiLog.warn(LABEL_LOG, LOG_FORMAT, tag, msg, tr);
    }

    public static int warn(String tag, Throwable tr) {
        return HiLog.warn(LABEL_LOG, LOG_FORMAT, tag, tr);
    }

    public static int debug(String tag, String msg, Throwable th) {
        return HiLog.debug(LABEL_LOG, LOG_FORMAT, tag, msg, th);
    }


    public static String getStackTraceString(Throwable tr) {
        return HiLog.getStackTrace(tr);
    }

    public static boolean isLoggable(String tag, int level) {
        return HiLog.isLoggable(DOMAIN_ID, tag, level);
    }

    public static void verbose(String tag, String msg) {
        HiLog.warn(LABEL_LOG, LOG_FORMAT, tag, msg);
    }
}
