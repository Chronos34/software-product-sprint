package com.google.sps.servlets;
import com.google.sps.data.SentimentAnalyzer;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form and analyze it.
    final String textValue = request.getParameter("text-input");
    final SentimentAnalyzer statementAnalysis = 
    new SentimentAnalyzer(textValue);

    // Print the value so you can see it in the server logs.
    System.out.println("You submitted: " + textValue);
    System.out.println("You statement scored: " + statementAnalysis.getSentimentScore());

    response.getWriter().println(statementAnalysis.getSentimentScore());
  }
}