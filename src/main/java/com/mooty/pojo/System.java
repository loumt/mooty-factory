/**
 * Copyright (c) www.bugull.com
 */
package com.mooty.pojo;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project mooty-factory
 * @package com.mooty.pojo
 * @date 2017/2/28/028
 */
public class System {

    private Long id;

    private String name;

    private String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "System{" +
                "password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
