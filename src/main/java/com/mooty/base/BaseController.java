/**
 * Copyright (c) www.bugull.com
 */
package com.mooty.base;

import org.springframework.web.bind.annotation.InitBinder;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project mooty-factory
 * @package com.mooty.base
 * @date 2017/2/28/028
 */
public class BaseController {

    @InitBinder
    public void initBinder(){
        System.out.println("InitBinder!!!!");
    }

}
