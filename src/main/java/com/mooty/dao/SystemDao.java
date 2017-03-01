package com.mooty.dao;

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
public interface SystemDao {
    System getSystem();
}
