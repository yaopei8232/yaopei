package com.ibeifeng.mybatis.util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/2/22.
 */
public class Mybatisutil {
    private static SqlSessionFactory factory = null;
    static {
        //1.创建MyBatis配置文件输入流
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取SqlSession
     * @return
     */
    public static SqlSession getSession(){
        return factory.openSession();
    }

    public static void close(SqlSession session){
        if(session != null){
            session.close();
        }
    }
}
