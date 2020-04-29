import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Menu extends JFrame {
    JLabel lTittle;
    JButton bCreate, bRead, bUpdate, bDelete, bExit;

    public void displayMenu(){
        setTitle("DATA MAHASISWA");
        lTittle = new JLabel("DATA MAHASISWA");
        lTittle.setFont(new Font("Regular", Font.BOLD, 18));
        lTittle.setForeground(new Color(255,0,0));
        bCreate = new JButton("Input ");
        bCreate.setFont(new Font("Regular",Font.PLAIN, 16));
        bCreate.setBackground(new Color(255, 0, 0));
        bRead = new JButton("Tampil ");
        bRead.setFont(new Font("Regular",Font.PLAIN, 16));
        bRead.setBackground(new Color(255, 0, 0));
        bUpdate = new JButton("Edit ");
        bUpdate.setFont(new Font("Regular",Font.PLAIN, 16));
        bUpdate.setBackground(new Color(255, 0, 0));
        bDelete = new JButton("Hapus ");
        bDelete.setFont(new Font("Regular",Font.PLAIN, 16));
        bDelete.setBackground(new Color(255, 0, 0));
        bExit = new JButton("Exit ");
        bExit.setFont(new Font("Regular",Font.PLAIN, 16));
        bExit.setBackground(new Color(255, 0, 0));

        getContentPane().setBackground(new Color(255, 255, 0));

        setLayout(null);
        add(lTittle);
        add(bCreate);
        add(bRead);
        add(bUpdate);
        add(bDelete);
        add(bExit);

        lTittle.setBounds(40,30,180,30);
        bCreate.setBounds(10, 80, 220, 30);
        bRead.setBounds(10, 120, 220, 30);
        bUpdate.setBounds(10, 160, 220, 30);
        bDelete.setBounds(10, 200, 220, 30);
        bExit.setBounds(10, 240, 220, 30);

        setSize(280, 350);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        bCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Create();
            }
        });
        bRead.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Read();
            }
        });
        bDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Delete();
                }catch (ClassNotFoundException classError){
                    classError.printStackTrace();
                }catch (SQLException sqlError){
                    sqlError.printStackTrace();
                }
            }
        });
        bUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Edit();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        });

        bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
