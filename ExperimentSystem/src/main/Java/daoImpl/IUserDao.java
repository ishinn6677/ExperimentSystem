package daoImpl;

import entity.User;

import java.util.List;

/**
 * @author ：
 * @date ：Created in 2019/11/7 17:07
 * @description ： dao
 */
public interface IUserDao {

    /**
     * @author      ：
     * @description ：查询所有
     * @date        ：Created in 2019/11/7
     */
    List<User> findAll();
}
