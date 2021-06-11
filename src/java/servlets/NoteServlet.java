package servlets;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import models.Note;

/**
 *
 * @author DWEI
 */
public class NoteServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        //try catch to read the note.txt file and use its contents to create a note object
        //use the note object to show contents on jsp
        try{
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String title = br.readLine();
        String contents = br.readLine();
        String line;
        while( (line=br.readLine()) != null){
            contents = contents +line + br.readLine();
        }
        
        Note note = new Note(title, contents);
        request.setAttribute("note", note);
        
        br.close();
        }catch(IOException e){
            System.err.println("File cannot be read");
        }
         String edit = request.getParameter("edit");
        
        if(edit != null){
        getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request,response);
        return;
        }
        
        //this will display the view note JSP as a view
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        request.setAttribute("edit", null);
        
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        Note note = new Note(title, contents);
        request.setAttribute("note", note);
        
        try{
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        pw.println(title);
        pw.print(contents);
        pw.close();
        }catch(IOException e){
            System.err.println("File cannot be read");
        }
        

        //this will display the view note JSP as a view
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
       
    }

    
}
