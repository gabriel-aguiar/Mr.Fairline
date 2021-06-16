package controler;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import dao.Login_Dao;
import entity.Login;

public class Email_Controler {

	private Login_Dao loginDao; // teste lll
	private Login Login;
	private ArrayList<Login> listuser;
	
	public void EnviarEmail(String email) {
		
		try {
			
		Login = new Login();
		loginDao = new Login_Dao();
		listuser = new ArrayList<Login>();
		Login.setEmail(email);
		
	    Properties props = new Properties();
	    /** Parâmetros de conexão com servidor Gmail */
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class",
	    "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "465");

	    Session session = Session.getDefaultInstance(props,
	      new javax.mail.Authenticator() {
	           protected PasswordAuthentication getPasswordAuthentication()
	           {
	                 return new PasswordAuthentication("mrfairline3@gmail.com",
	                 "@facul123");
	           }
	      });

	    /** Ativa Debug para sessão */
	    session.setDebug(true);

	    try {

	      Message message = new MimeMessage(session);
	      message.setFrom(new InternetAddress("mrfairline3@gmail.com"));
	      //Remetente

	      try {
	    	  
				loginDao = new Login_Dao();
				listuser = loginDao.selectDisparaEmail(Login.getEmail()); 
					
			} catch (Exception e) {
				System.out.println(e);
			}
	      
	      Address[] toUser = InternetAddress //Destinatário(s)
	                 .parse(listuser.get(0).getEmail());
	                 
	                 /*Address[] toUser = InternetAddress //Destinatário(s)
	    	                 .parse("gabrielpaguiar@gmail.com");*/          

	      message.setRecipients(Message.RecipientType.TO, toUser);
	      message.setSubject("Recuperação de Senha");//Assunto
	      //message.setText("Caro SR. " + listuser.get(0).getNome() + " sua senha antiga é: " + listuser.get(0).getSenha());
	      //message.setText("teste");
	      message.setText("Caro SR. " + listuser.get(0).getNome() + " seu link de recuperação de senha é: " + "http://localhost:8080/mr_fairline/recuperacao.jsp");
	      /**Método para enviar a mensagem criada*/
	      Transport.send(message);

	      System.out.println("Feito!!!");

	     } catch (MessagingException e) {
	        throw new RuntimeException(e);
	    }
		} catch (Exception e) {
			// TODO: handle exception
		}
	  }

}
