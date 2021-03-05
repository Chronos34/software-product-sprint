package com.google.sps.servlets;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import com.google.gson.Gson;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

    private final Gson gson = new Gson();
    private final ArrayList<String> message = new ArrayList<String>(
        Arrays.asList("Welcome To Fortress Inquisitorius!",
        "It's a beautiful day!", "Have a Starsome Day!"));

  @Override
  public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
    response.setContentType("text/html;");
    response.getWriter().println(gson.toJson(message));
  }
}
