/**
 * Copyright (c) www.bugull.com
 */
package com.mooty.service;

import com.mooty.dao.SystemDao;
import com.mooty.pojo.System;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project mooty-factory
 * @package com.mooty
 * @date 2017/2/28/028
 */
@Service
public class SystemServiceImpl implements SystemService {

    @Autowired(required = false)
    private SystemDao systemDao;

    public System getSystem() {
        return systemDao.getSystem();
    }
}
