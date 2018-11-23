import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DB_Login_Window {

    private JFrame frame;
    private JTextField usrnmField;
    private JPasswordField pswrdField;


    public DB_Login_Window() {

        initialize();

    }

    private void initialize() {

        frame = new JFrame("Login");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        usrnmField = new JTextField();
        usrnmField.setBounds(156, 56, 203, 26);
        frame.getContentPane().add(usrnmField);
        usrnmField.setColumns(10);

        pswrdField = new JPasswordField();
        pswrdField.setBounds(156, 107, 203, 26);
        frame.getContentPane().add(pswrdField);

        JLabel usrLabel = new JLabel("Username:");
        usrLabel.setBounds(57, 61, 87, 16);
        frame.getContentPane().add(usrLabel);

        JLabel pswrdLbl = new JLabel("Password:");
        pswrdLbl.setBounds(63, 112, 70, 16);
        frame.getContentPane().add(pswrdLbl);

        JButton connectBtn = new JButton("Connect");
        connectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DB_Statements stmts = new DB_Statements();
                try{
                    String username = usrnmField.getText();
                    String password = new String(pswrdField.getPassword());

                    if(stmts.checkLogin(username, password)) {
                        JOptionPane.showMessageDialog(null, "Username found.\nAccess granted.");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "User not found.\nAccess denied!");
                    }

                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        connectBtn.setBounds(148, 172, 117, 29);
        frame.getContentPane().add(connectBtn);

        frame.setVisible(true);

    }

}











