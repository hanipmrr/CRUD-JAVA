import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete extends JFrame {
    Statement statement;
    ResultSet resultSet;
    String[][] datas = new String[500][4];
    String[] kolom = {"NIM", "NAMA", "ALAMAT", "NO TELP"};
    JLabel lTitle;
    JButton bDelete, bBack;
    JTable tTable;
    JScrollPane scrollPane;

    public Delete() throws SQLException, ClassNotFoundException {
        lTitle = new JLabel ("Seluruh Data Mahasiswa");
        lTitle.setFont(new Font("Regular", Font.BOLD, 18));
        lTitle.setForeground(new Color(158, 158, 230));
        bDelete = new JButton ("Delete");
        bDelete.setFont(new Font("Regular", Font.PLAIN, 14));
        bDelete.setBackground(new Color(158, 158, 230));
        bBack = new JButton ("Kembali");
        bBack.setFont(new Font("Regular", Font.PLAIN, 14));
        bBack.setBackground(new Color(158, 158, 230));
        tTable = new JTable(datas, kolom);
        tTable.setBackground(new Color(158, 158, 230));
        scrollPane = new JScrollPane(tTable);
        scrollPane.setBackground(new Color(158, 158, 230));

        getContentPane().setBackground(new Color(255, 255, 0));

        setTitle("Hapus Data Mahasiswa");
        Koneksi connec = new Koneksi();
        statement = connec.getConnection().createStatement();
        String sql = "SELECT * FROM tb_mahasiswa";
        resultSet = statement.executeQuery(sql);
        int row = 0;
        while (resultSet.next()){
            datas[row][0] = resultSet.getString("nim");
            datas[row][1] = resultSet.getString("nama");
            datas[row][2] = resultSet.getString("alamat");
            datas[row][3] = resultSet.getString("no_telp");
            row++;
        }
        setLayout(null);
        add(lTitle);
        add(bDelete);
        add(bBack);
        add(scrollPane);

        lTitle.setBounds(160, 30, 300, 30);
        scrollPane.setBounds(70, 70, 400, 400);
        bDelete.setBounds(170, 490, 90, 25);
        bBack.setBounds(280, 490, 90, 25);

        setSize(550,650);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Main();
            }
        });

        bDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteProses hapus = new DeleteProses();
                hapus.ProcessDelete();
                setVisible(false);
            }
        });
    }
}
