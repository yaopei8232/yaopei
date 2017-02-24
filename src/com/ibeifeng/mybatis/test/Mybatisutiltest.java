package com.ibeifeng.mybatis.test;

import com.ibeifeng.mybatis.model.Blog;
import com.ibeifeng.mybatis.model.User;
import com.ibeifeng.mybatis.util.Mybatisutil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */
public class Mybatisutiltest {
    @Test
    public void testadd(){
        SqlSession session = Mybatisutil.getSession();
        User user = new User("赵丽颖","886");
        session.insert(User.class.getName()+".add",user);
        session.commit();
        Mybatisutil.close(session);
    }
    @Test
    public void testAdd() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session =factory.openSession();
        User user =new User("姚明","10993");

        session.insert("com.ibeifeng.mybatis.model.User.add",user);
        session.commit();
        session.close();
    }
    @Test
    public void updatetest(){
        SqlSession session = Mybatisutil.getSession();
        User user = new User("铃铛","224555");
        user.setId(5);
        session.update(User.class.getName()+".update",user);
        session.commit();
        Mybatisutil.close(session);
    }
    @Test
    public void delete(){
        SqlSession session = Mybatisutil.getSession();
        session.delete(User.class.getName()+".delete",1);
        session.commit();
        Mybatisutil.close(session);
    }
    @Test
    public void load(){
        SqlSession session =Mybatisutil.getSession();
       List<Blog> blog = session.selectList(Blog.class.getName()+".blogList");
       for(Blog b:blog){
           System.out.println(b);
       }
    }
    @Test
    public void list(){
        SqlSession session = Mybatisutil.getSession();
        List<User> list = session.selectList(User.class.getName()+".list");
        for(User u:list){
            System.out.println(u);
            System.out.println(u.getBlog().size());
        }
    }

}
