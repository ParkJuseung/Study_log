package com.test.java.model;


import java.sql.*;
import java.util.ArrayList;

//서블릿 x
//데이터를 전문적으로 컨트롤하는 애들
public class TodoDAO {
    DBUtil util = new DBUtil();


    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private DBUtil util;
    private ResultSet rs;

    public TodoDAO(){
        try {
            this.conn = util.open();
            this.stat = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<TodoDTO> list(){
        //할일 목록 요청
        try {
            String sql = "select * from tblTodo order by seq desc";
            rs = stat.executeQuery(sql);

            ArrayList<TodoDTO> list = new ArrayList<>();

            while(rs.next()){

                //레코드 1줄 -> TodoDTO();
                TodoDTO dto = new TodoDTO();

                dto.setSeq(rs.getString("seq"));
                dto.setTodo(rs.getString("todo"));
                dto.setState(rs.getString("state"));
                dto.setRegdate(rs.getString("regdate"));

                list.add(dto);
            }

            rs.close();

            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
            return null;
        }
    }

}
