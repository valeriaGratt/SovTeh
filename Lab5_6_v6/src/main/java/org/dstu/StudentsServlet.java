package org.dstu;

import org.dstu.db.DbWorker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String[] name = req.getParameterValues("name");
        String[] second_name = req.getParameterValues("second_name");
        String[] last_name = req.getParameterValues("last_name");
        String[] subject = req.getParameterValues("subject");
        String[] result = req.getParameterValues("result");


        if (last_name[0].isEmpty()) {
            req.getRequestDispatcher("notfound.jsp").forward(req, resp);
        }
        if(DbWorker.getFromDbByLastName(last_name[0])){
            req.getRequestDispatcher("duplicate.jsp").forward(req, resp);
        }
        DbWorker.saveFromForm(name[0], second_name[0], last_name[0], subject[0], result[0]);
        req.getRequestDispatcher("ok.jsp").forward(req, resp);
    }
}
