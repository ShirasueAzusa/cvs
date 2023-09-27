package cn.cvs.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private static final SqlSessionFactory factory;

    static {    //通过静态代码块，唯一一次创建SqlSessionFactory实例
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            throw new RuntimeException("初始化失败", e);
        }
    }

    //创建并返回SqlSession实例
    public static SqlSession createSqlSession() {
        return factory.openSession(false);  //关闭自动提交开始事务
    }

    //关闭SqlSession
    public static void closeSqlSession(SqlSession sqlSession) {
        if (sqlSession != null)
            sqlSession.close();
    }
}
