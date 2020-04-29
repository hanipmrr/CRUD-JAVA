import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditProses extends JFrame {
    JLabel lTitle, lNama, lNIM, lAlamat, lNoTelp, lNote;
    JTextField fNama, fNIM, fAlamat, fNoTelp;
    JButton bSave, bBack;
    Statement statement;

    public EditProses() {

        setTitle("EDIT DATA");
        lTitle = new JLabel("Edit Berdasarkan NIM");
        lTitle.setFont(new Font("Regular", Font.PLAIN, 20));
        lTitle.setForeground(new Color(158, 158, 230));
        lNama = new JLabel("Nama ");
        lNama.setFont(new Font("Regular", Font.PLAIN, 18));
        lNama.setForeground(new Color(158, 158, 230));
        fNama = new JTextField();
        fNama.setFont(new Font("Regular", Font.PLAIN, 16));
        fNama.setForeground(new Color(245, 249, 250));
        fNama.setBackground(new Color(158, 158, 230));
        lNIM = new JLabel("NIM ");
        lNIM.setFont(new Font("Regular", Font.PLAIN, 18));
        lNIM.setForeground(new Color(158, 158, 230));
        fNIM = new JTextField();
        fNIM.setFont(new Font("Regular", Font.PLAIN, 16));
        fNIM.setForeground(new Color(245, 249, 250));
        fNIM.setBackground(new Color(158, 158, 230));
        lAlamat = new JLabel("Alamat ");
        lAlamat.setFont(new Font("Regular", Font.PLAIN, 18));
        lAlamat.setForeground(new Color(158, 158, 230));
        fAlamat = new JTextField();
        fAlamat.setFont(new Font("Regular", Font.PLAIN, 16));
        fAlamat.setForeground(new Color(245, 249, 250));
        fAlamat.setBackground(new Color(158, 158, 230));
        lNoTelp = new JLabel("No Telp ");
        lNoTelp.setFont(new Font("Regular", Font.PLAIN, 18));
        lNoTelp.setForeground(new Color(158, 158, 230));
        fNoTelp= new JTextField();
        fNoTelp.setFont(new Font("Regular", Font.PLAIN, 16));
        fNoTelp.setForeground(new Color(245, 249, 250));
        fNoTelp.setBackground(new Color(158, 158, 230));
        lNote=new JLabel ("*Masukkan NIM yang akan diedit");
        lNote.setFont(new Font("Regular", Font.PLAIN, 9));
        lNote.setForeground(new Color(158, 158, 230));
        bSave = new JButton("Simpan");
        bSave.setFont(new Font("Regular",Font.PLAIN, 14));
        bSave.setBackground(new Color(158, 158, 230));
        bBack = new JButton("Kembali");
        bBack.setFont(new Font("Regular",Font.PLAIN, 14));
        bBack.setBackground(new Color(158, 158, 230));
        
        
        
        getContentPane().setBackground(new Color(255, 255, 0));

        setLayout(null);
        add(lTitle);
        add(lNama);
        add(fNama);
        add(lNIM);
        add(fNIM);
        add(lAlamat);
        add(fAlamat);
        add(lNoTelp);
        add(fNoTelp);
        add(lNote);
        add(bSave);
        add(bBack);

        lTitle.setBounds(120, 20, 250, 30);
        lNama.setBounds(30, 70, 120, 30);
        fNama.setBounds(110, 73,270,25);
        lNIM.setBounds(30, 110, 120, 30);
        fNIM.setBounds(110, 113, 270, 25);
        lAlamat.setBounds(30, 150, 120, 30);
        fAlamat.setBounds(110, 153, 270, 25);
        lNoTelp.setBounds(30, 190, 120, 30);
        fNoTelp.setBounds(110, 193, 270, 25);
        lNote.setBounds(30, 210, 270, 25);
        bSave.setBounds(120, 245, 90, 30);
        bBack.setBounds(220, 245, 90,30);

        setSize(440, 350);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        bSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                btnUpdateactionListener();
            }

            private void btnUpdateactionListener() {
                Koneksi connec = new Koneksi();
                try {
                    statement = connec.getConnection().createStatement();
                    statement.executeUpdate("UPDATE tb_mahasiswa SET  nama='" +
                            fNama.getText() + "'," + "alamat='" + fAlamat.getText() + "'," + "no_telp='" + fNoTelp.getText() + "'WHERE nim='" + fNIM.getText() + "'");

                    JOptionPane.showMessageDialog(null, "Data berhasil di Update!", "Hasil", JOptionPane.INFORMATION_MESSAGE);
                    statement.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Data gagal diupdate!", "Hasil", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        bBack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                try {
                    new Edit();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(EditProses.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(EditProses.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}