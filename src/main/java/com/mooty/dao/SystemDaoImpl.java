/**
 * Copyright (c) www.bugull.com
 */
package com.mooty.dao;

import com.mooty.base.BaseDao;
import com.mooty.pojo.System;
import org.springframework.stereotype.Repository;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project mooty-factory
 * @package com.mooty.dao
 * @date 2017/2/28/028
 */
@Repository
public class SystemDaoImpl extends BaseDao implements SystemDao {

    public System getSystem(){
        return this.queryForBean("select * from system where id = 1",System.class);
    }
}
