<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Simple Interest Result</title>
    </head>

    <body>
        <h2>Simple Interest Result</h2>

        <% // Get the form data String principalStr=request.getParameter("principal");
         String timeStr=request.getParameter("time"); 
         String rateStr=request.getParameter("rate");
            data types double principal=0.0;
             double time=0.0;
              double rate=0.0; 
              try {
            principal=Double.parseDouble(principalStr);
             time=Double.parseDouble(timeStr);
            rate=Double.parseDouble(rateStr);
             double interest=(principal * time * rate) /100; 
             out.println("<p>Principal: " + principal + "</p>");
            out.println("<p>Time: " + time + " years</p>");
            out.println("<p>Rate of Interest: " + rate + "%</p>");
            out.println("<p>Simple Interest: " + interest + "</p>");
            } catch (NumberFormatException e) {
            out.println("<p>Invalid input values! Please enter valid numbers.</p>");
            }
            %>

            <br><br>
            <a href="simple_interest_form.html">Go Back to the Form</a>
    </body>

    </html>