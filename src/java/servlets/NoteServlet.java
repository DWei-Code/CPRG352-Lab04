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
        while(br.readLine() != null){
            contents = contents + br.readLine();
        }

        Note note = new Note(title, contents);
        request.setAttribute("note", note);
        
        
        }catch(IOException e){
            System.err.println("File cannot be read");
        }
        
        //this will display the view note JSP as a view
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
}
