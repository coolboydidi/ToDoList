
import org.python.util.PythonInterpreter;
public class Main {
    public static void main(String[] args) {

        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("""
                import smtplib
                               
                def send_email(sender_email, receiver_email, subject, body, smtp_server, smtp_port, username, password):
                    message = ""
                               
                
                    with smtplib.SMTP(smtp_server, smtp_port) as server:
                        server.starttls()
                        server.login(username, password)
                        server.sendmail(sender_email, receiver_email, message)
                    print("Email sent successfully!")
                    
                  
                sender_email = "todolistemailclient@gmail.com"
                receiver_email = "didijack5606@gmail.com"
                subject = "Hello, World!"
                body = "This is the body of the email."
                smtp_server = "smtp.gmail.com"
                smtp_port = 465
                username = "todolistemailclient@gmail.com"
                password = "lvofeolfzrxwbvap"
                               
                # Send the email
                send_email(sender_email, receiver_email, subject, body, smtp_server, smtp_port, username, password)
                               
                            
                """);

    }
}