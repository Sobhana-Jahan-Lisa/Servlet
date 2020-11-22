import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;


public class Welcome extends HttpServlet {
String n;
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		 n=req.getParameter("name");
                 n="Sobhana";
		out.print("HELLO "+n+"!!");
                  out.print("<BR>Welcome to our Webpage<BR>");
                HttpSession session = req.getSession(false);
    res.setContentType("text/html");
    res.setHeader("pragma", "no-cache");
    out.println("<HTML>"); 
        out.println("<HEAD>"); 
        out.println("<TITLE>Available items to buy</TITLE>"); 
        out.println("</HEAD>"); 
        out.println("<BODY>");
        
        out.println("<H1>Available Items to buy</H1>");
        
        out.println("<BR><FORM METHOD=POST>"); 
        out.println("<BR>Amazon Kindle"); 
        out.println("<BR>Apple iPod"); 
        out.println("<BR>Airbud"); 
        out.println("<BR>Amazon "); 
        out.println("<BR>Apple smartwatch"); 
        out.println("<BR>Apple AirPod");
     
        out.println("<BR>Samsung Galaxy A01"); 
        out.println("<BR>One Plus 8"); 
        out.println("<BR>Samsung Galaxy S20"); 
        out.println("<BR>Samsung Galaxy A0S "); 
        out.println("<BR>Samsung Galaxy A21"); 
        out.println("<BR>Asus Rog gaming phone");

        out.println("<BR>");
        //out.println("<BR><INPUT TYPE=SUBMIT VALUE=\"Add to Cart\">"); 
        out.println("</FORM>"); 
        
        out.println("</BODY>"); 
        out.println("</HTML>"); 
        
       
			
        /*@Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(true);
        String[] formValues = request.getParameterValues("book");
        int length = 0;
        try{
            length = formValues.length;
            ArrayList<String> books = new ArrayList<String>();
        
        
            for(int i=0;i<length;i++){
                books.add(formValues[i]);
            }


            session.putValue("formData", books);

            Cookie[] cookies = request.getCookies();

            if(request.getCookies() == null || cookies.length == 1){
                response.sendRedirect("logIn");
            } else{
                response.sendRedirect("Addtocart");
            }
        }
        catch(NullPointerException n){
            response.sendRedirect(" ");
        }
        */
        


    
   
    out.print("<HTML><HEAD><TITLE>Online Shop</TITLE>"+
	      "</HEAD><BODY><FORM METHOD=POST ACTION=");
  
    out.print(res.encodeRedirectURL(req.getRequestURI()));
    out.print("><INPUT TYPE=SUBMIT STYLE=BACKGROUND-COLOR:CYAN NAME=AmazonKindle VALUE="+
	      "\"Add Amazon Kindle into the shopping cart\">"+"<BR>"+
	      "<INPUT TYPE=SUBMIT STYLE=BACKGROUND-COLOR:CYAN NAME=AppleiPod VALUE="+
	      "\"Add Apple iPod into the shopping cart\">"+"<BR>"+
	      "<INPUT TYPE=SUBMIT STYLE=BACKGROUND-COLOR:CYAN NAME=see VALUE="+
	      "\"See the shopping cart contents\">"+"<BR>"+
	      "<INPUT TYPE=SUBMIT STYLE=BACKGROUND-COLOR:CYAN NAME=buy VALUE="+
	      "\"Buy the shopping cart contents\">"+"<BR>"+
              "<INPUT TYPE=SUBMIT STYLE=BACKGROUND-COLOR:CYAN NAME=empty VALUE="+
	      "\"Reset\">"+"<BR>"+
	      "</FORM></BODY></HTML>");
    out.close();
	}
        protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
  {
    String msg;
    res.setContentType("text/html");
    res.setHeader("pragma", "no-cache");
    PrintWriter out = res.getWriter();
out.print("HELLO "+"Sobhana"+"!!");
    HttpSession session = req.getSession(true);
    if(session.isNew())
    {
      session.setAttribute("AmazonKindle", new int[] { 0 });
      session.setAttribute("AppleiPod", new int[] { 0 });
    }

    int[] Amazon_Kindle = (int[])session.getAttribute("AmazonKindle");
    int[] Apple_iPod = (int[])session.getAttribute("AppleiPod");

    if(req.getParameter("AmazonKindle") != null)
    {
     Amazon_Kindle[0]++;
      msg = "<H3> Amazon Kindle is added into cart. You now have "+Amazon_Kindle[0]+".</H3>";
    }
    else if(req.getParameter("AppleiPod") != null)
    {
      Apple_iPod[0]++;
      msg = " <H3>Apple iPod is added into cart. You now have "+ Apple_iPod[0]+".</H3>";
    }
    else if(req.getParameter("buy") != null)
    {
     
      /*msg="<H3>Your order for </H3><BR>";
      if(Amazon_Kindle[0]>=1)
      {msg=Amazon_Kindle[0]+" Amazon Kindle";
      }
      if(Apple_iPod[0]>=1)
      {msg=Apple_iPod[0]+" Apple iPod";
      }
      else
      {
          msg="is accepted";
      }*/
      session.invalidate();
      msg = "<H3>Your order for "+Amazon_Kindle[0]+" Amazon Kindle and "+ Apple_iPod[0]+
	" Apple_iPod has been accepted.You have Successfully bought them. Your shopping cart is empty now.</H3>";
    }
     else if(req.getParameter("empty") != null)
    {
      session.invalidate();
      msg = "<H3>Your shopping cart is empty now.</H3>";
    }
    
    else 
    {
      msg = "<H3>You have<BR> "+Amazon_Kindle[0]+" Amazon Kindle,<BR> "+ Apple_iPod[0]+
	" Apple_iPod <BR>in your shopping cart.</H3>";
    }

    
    
		
    out.print("<HTML><HEAD><TITLE>Shopping Cart</TITLE></HEAD><BODY>");
    out.print(msg);
    out.print("<HR><A HREF=\"");
    out.print(res.encodeRedirectURL(req.getRequestURI()));
        n="Sobhana";
    out.print("\"<BUTTON STYLE=BACKGROUND-COLOR:CYAN;>Back to Product List.</A></BUTTON></BODY></HTML>");
    out.close();
  }

    @Override
  public String getServletInfo()
  {
    return "welcome";
  }

}
