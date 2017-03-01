/**
 * Copyright (c) www.bugull.com
 */
package com.mooty.exception;

import org.apache.log4j.Logger;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project mooty-factory
 * @package com.mooty.exception
 * @date 2017/2/28/028
 */
public class DaoException extends RuntimeException{
    /**
     * 序列化ID
     */
    private static final long servialVersionUID = 1006823391281782460L;
    /**
     * 日志对象
     */
    protected final Logger logger = Logger.getLogger(getClass());

    /**
     * @param message 异常信息
     */
    public DaoException(String message) {
        super(message);
        logger.error(message);
    }

    /**
     * @param message   异常信息
     * @param throwable 异常对象
     */
    public DaoException(String message, Throwable throwable) {
        super(message);
        logger.error(message + " :Throwable[" + throwable.getMessage() + "]");
    }


}
