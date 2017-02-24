package com.ibeifeng.mybatis.test;

import com.ibeifeng.mybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/2/22.
 */
public class Mybatistest {
    @Test
    public void testadd(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            SqlSession session =factory.openSession();
            User user =new User("z虚岁","10993");

            session.insert("com.ibeifeng.mybatis.model.User.add",user);
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
