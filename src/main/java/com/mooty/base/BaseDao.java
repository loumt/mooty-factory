/**
 * Copyright (c) www.bugull.com
 */
package com.mooty.base;

import com.mooty.exception.DaoException;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Map;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project mooty-factory
 * @package com.mooty.dao
 * @date 2017/2/28/028
 */
public class BaseDao {

    protected Logger logger = Logger.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    protected NamedParameterJdbcTemplate npjt;


    /**
     * 执行select语句，获取一个记录
     *
     * @param sql          要执行的语句
     * @param requiredType 返回对象类型
     * @param args         参数
     * @return 单个数据对象
     * @throws DaoException
     */
    protected <T> T queryForObject(String sql, Class<T> requiredType,
                                   Object... args) throws DaoException {
        try {
            return this.jdbcTemplate.queryForObject(sql, requiredType, args);
        } catch (DataAccessException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    /**
     * 执行select语句，获取一个记录,并转换为传入类型Bean
     *
     * @param sql          要执行的语句
     * @param requiredType 返回对象类型
     * @return Bean数据对象
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    protected <T> T queryForBean(String sql, Class<T> requiredType)
            throws DaoException {
        try {
            Map m = this.jdbcTemplate.queryForMap(sql);
            Class<?> cls = Class.forName(requiredType.getName());// 取得Class对象
            Object obj = cls.newInstance();
            T t = (T) obj;
            BeanUtils.copyProperties(t, m);
            return t;
        } catch (EmptyResultDataAccessException ede) {
            logger.debug(ede.getMessage());
            return null;
        } catch (Exception e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

}
