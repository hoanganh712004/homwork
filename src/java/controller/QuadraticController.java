/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class QuadraticController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = "";

        try {
            String a_raw = request.getParameter("a").trim();
            String b_raw = request.getParameter("b").trim();
            String c_raw = request.getParameter("c").trim();

            if (a_raw.isBlank() || b_raw.isBlank() || c_raw.isBlank()) {
                message = "Nhập hết không được bỏ trống !!!";
                request.setAttribute("message", message);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                int a = Integer.parseInt(a_raw);
                int b = Integer.parseInt(b_raw);
                int c = Integer.parseInt(c_raw);
                double delta, x1, x2;
                if (a == 0) {
                    if (b == 0) {
                        if (c == 0) {
                            message = "Phương trình có vô số nghiệm";
                            request.setAttribute("message", message);
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                        } else {
                            message = "Phương trình vô nghiệm";
                            request.setAttribute("message", message);
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                        }
                    } else {
                        x1 = -(double) c / b;
                        int gcd = gcd(c, b);

                        if (c > 0 && b > 0) {
                            c = -c;
                        } else if (c < 0 && b < 0) {
                            c = Math.abs(c);
                        } else if ((c < 0 && b > 0)) {
                            c = Math.abs(c);
                            b = Math.abs(b);
                        } else {
                            c = Math.abs(c);
                            b = Math.abs(b);
                        }

                        c /= gcd;
                        b /= gcd;

                        String result = "Phương trình có nghiệm duy nhất: x = " + String.format("%.2f", x1)
                                + " OR " + c + "/" + b;
                        message = result;
                        request.setAttribute("message", message);
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                } else {
                    delta = b * b - 4 * a * c;

                    if (delta > 0) {
                        x1 = (-b + Math.sqrt(delta)) / (2 * a);
                        x2 = (-b - Math.sqrt(delta)) / (2 * a);
                        String result = "Phương trình có nghiệm riêng biệt:"
                                + "x1 = " + String.format("%.2f", x1)
                                + ", x2 = " + String.format("%.2f", x2);
                        message = result;
                        request.setAttribute("message", message);
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    } else if (delta == 0) {
                        x1 = -b / (2 * a);
                        String result = "Phương trình có nghiệm kép: x1 = x2 = "
                                + String.format("%.2f", x1);
                        message = result;
                        request.setAttribute("message", message);
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    } else {
                        message = "Phương trình vô nghiệm";
                        request.setAttribute("message", message);
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                }
            }

        } catch (NumberFormatException e) {
            message = "Nhập khác số à, nhập lại đi em !!!";
            request.setAttribute("message", message);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet QuadraticController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet QuadraticController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
