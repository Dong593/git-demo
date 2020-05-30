package com.lwd.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataUtils {


    //查询工具类
    public static <T> List<T> executeDQL(Class<T> cls,String sql, Object ...params) throws Exception{
        //获取链接
        Connection conn = DbUtils.getConnection();
        //获取预处理对象
        PreparedStatement ps = conn.prepareStatement(sql);
        //设置参数
        setParams(ps,params);

        ResultSetMetaData md = ps.getMetaData();

        //执行查询，获取结果集
        ResultSet rs = ps.executeQuery();
        //将查询的数据，封装到List里面来；
        List<T> list = new ArrayList<T>();

        T obj;

        while(rs.next()) {
            //根据我们的字节码，实例化一个对象；用来保存我们的一条记录行信息
            obj = cls.newInstance();
            //循环我们所有的列的信息，并且给这个属性赋值；
            for (int i = 1; i <= md.getColumnCount(); i++) {
                String name = md.getColumnLabel(i);
                try {
                    //给我们object里面的name属性，赋值了；
                    Field field = cls.getDeclaredField(name);
                    field.setAccessible(true);

                    Object value = rs.getObject(name);
                    if (value == null) { // 不能一刀切;

                        int type = md.getColumnType(i); // 这个方法会返回我们当前列的类型;

                        if(cheakType(type)) {
                            value = 0;
                            //continue;
                        }
                    }
                    field.set(obj, value);

                } catch (NoSuchFieldException e) {
                    System.out.println("没找到这个字段："+name);
                }

            }
            list.add(obj);
        }
        return list;
    }

    private static boolean cheakType(int type) {
        return Types.INTEGER == type || Types.FLOAT == type || Types.DECIMAL == type || Types.DOUBLE == type
                || Types.REAL == type;
    }

    //DML方法
    public static boolean executeDML(String sql, Object...params) {

        Connection conn = DbUtils.getConnection();
        int result = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            setParams(ps,params);

            result = ps.executeUpdate();

            DbUtils.close(null,ps,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result>0;

    }

    //设置参数
    private static void setParams(PreparedStatement ps, Object[] params) {
        if(params!= null) {
            for (int i = 0; i < params.length; i++) {
                try {
                    ps.setObject(i+1, params[i]);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
