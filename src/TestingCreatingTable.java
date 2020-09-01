

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.nagappa.dao.HibernateUtil;

@WebServlet("/TestingCreatingTable")
public class TestingCreatingTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestingCreatingTable() {
        super();
        try {
			Configuration configuration  = new Configuration().configure();
			configuration.addAnnotatedClass(com.nagappa.model.Standard.class);
			configuration.addAnnotatedClass(com.nagappa.model.Student.class);
			configuration.addAnnotatedClass(com.nagappa.model.Subject.class);
			configuration.addAnnotatedClass(com.nagappa.model.Teacher.class);
			
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			
			SessionFactory factory = configuration.buildSessionFactory(builder.build());
			
			Session session = factory.openSession();
			Transaction txn = session.beginTransaction();
			
			txn.commit();
			session.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			PrintWriter out = response.getWriter();
			out.println("<html><body><h1>something executed</h1></body></html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
