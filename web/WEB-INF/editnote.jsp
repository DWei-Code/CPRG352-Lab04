<%-- 
    Document   : editnote
    Created on : Jun 2, 2021, 12:30:55 PM
    Author     : DWEI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>note edit page</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <form method="post" action="submit">
        <h2>Edit Note</h2>
        
        <label>Title:</label>
        <input type="text" name="title" value="${note.title}">
        <br>
        <label>Contents:</label>
        <textarea name="contents" rows="6" cols="25">${note.contents}</textarea>
        
        <br>
        <input type="submit" value="Save">
        </form>
    </body>
</html>
