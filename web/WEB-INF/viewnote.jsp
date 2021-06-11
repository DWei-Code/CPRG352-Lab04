<%-- 
    Document   : viewnote
    Created on : Jun 2, 2021, 12:30:40 PM
    Author     : DWEI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>view note page</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <form method="post" action="submit">
        <h2>View Note</h2>
        
        <p><b>Title:</b> ${note.title}</p>
        <p><b>Contents:</b> <br> ${note.contents}</p>
        
        <a href="note?edit" >Edit</a>
        </form>
    </body>
</html>
