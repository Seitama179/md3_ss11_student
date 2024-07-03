package com.example.ss11_student.controller;

import com.example.ss11_student.model.Student;
import com.example.ss11_student.services.IStudentService;
import com.example.ss11_student.services.impl.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentController", value = "/student")
public class StudentController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static IStudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                req.getRequestDispatcher("/student/create.jsp").forward(req, resp);
                break;
            case "edit":
                editShowForm(req, resp);
                break;
            default:
                List<Student> students = studentService.findAll();
                req.setAttribute("students", students);
                req.getRequestDispatcher("/student/list.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createStudent(req, resp);
                break;
            case "delete":
                deleteStudent(req, resp);
                break;
            case "search":
                String search = req.getParameter("search");
                List<Student> students = studentService.findByName(search);
                req.setAttribute("students", students);
                req.getRequestDispatcher("/student/list.jsp").forward(req, resp);
                break;
            case "edit":
                updateStudent(req, resp);
                break;
            default:
                resp.sendRedirect(req.getContextPath() + "/student");
                break;
        }
    }

    private static void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id = null;
        if(req.getParameter("id") != null) {
            try {
                id = Long.parseLong(req.getParameter("id"));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        if(id != null) {
            Boolean isDelete = studentService.deleteById(id);
            if(!isDelete) {
                req.setAttribute("message", "Xóa không thành công.");
            }
        } else {
            req.setAttribute("message", "ID không hợp lệ.");
        }
        resp.sendRedirect(req.getContextPath() + "/student");
    }

    private static void createStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        Float point = null;
        if(req.getParameter("points") != null) {
            try {
                point = Float.parseFloat(req.getParameter("point"));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        if (name != null && address != null && point != null) {
            Student student = new Student(name, address, point);
            studentService.save(student);
            System.out.println("save student");
        } else {
            req.setAttribute("error", "Please enter all the details");
        }
        resp.sendRedirect("/student");

    }

    private void editShowForm(HttpServletRequest req, HttpServletResponse resp) {
        Long id = Long.parseLong(req.getParameter("id"));
        Student student = studentService.findById(id);
        RequestDispatcher dispatcher;
        req.setAttribute("customer", student);
        dispatcher = req.getRequestDispatcher("student/edit.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void updateStudent(HttpServletRequest req, HttpServletResponse resp) {
        Long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        Float point = Float.parseFloat(req.getParameter("point"));
        Student student = studentService.findById(id);
        if (student != null) {
            student.setName(name);
            student.setAddress(address);
            student.setPoint(point);
            studentService.update(id, student);
            req.setAttribute("student", student);
            req.setAttribute("message", "Cập nhật thành công");
            RequestDispatcher dispatcher = req.getRequestDispatcher("student/edit.jsp");
            try {
                dispatcher.forward(req, resp);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else {
            req.setAttribute("message", "Sinh viên không tồn tại");
        }
    }
}
