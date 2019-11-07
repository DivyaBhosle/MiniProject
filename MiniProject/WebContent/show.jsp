<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Jsp Sample</title>
    <%@page import="java.sql.*"%>
</head>
<body>
    <%
    try
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection(
            "jdbc:oracle:thin:@192.168.100.144:1521:xe","hr","hr");
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from chiefminister");
    %><table border=1 align=center style="text-align:center">
      <thead>
          <tr>
             <th>CID</th>
             <th>CNAME</th>
             <th>QUALIFICATION</th>
             <th>STATE</th>
              <th>END_STATE</th>
               <th>PARTY</th>
          </tr>
      </thead>
      <tbody>
        <%while(rs.next())
        {
            %>
            <tr>
                <td><%=rs.getString("cid") %></td>
                <td><%=rs.getString("cname") %></td>
                <td><%=rs.getString("qualification") %></td>
                <td><%=rs.getString("state") %></td>
                <td><%=rs.getString("end_date") %></td>
                <td><%=rs.getString("party") %></td>
            </tr>
            <%}%>
           </tbody>
        </table><br>
    <%}
    catch(Exception e){
        out.print(e.getMessage());%><br><%
    }
   
    %>
</body>
</html>