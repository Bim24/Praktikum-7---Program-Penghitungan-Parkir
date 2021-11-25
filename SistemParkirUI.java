
/**
 *
 * @author LENOVO
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemParkirUI {
    SistemParkir sistemParkir;

    public SistemParkirUI() {
        sistemParkir = new SistemParkir();
        JFrame frameWindow = new JFrame("Sistem Parkir");
        JPanel panelKendaraanMasuk = new JPanel();
        formKendaraanMasuk(panelKendaraanMasuk);
        frameWindow.add(panelKendaraanMasuk);
        frameWindow.setVisible(true);
        
        JPanel panelKendaraanKeluar = new JPanel ();
        formKendaraanKeluar(panelKendaraanKeluar);
        frameWindow.add(panelKendaraanKeluar);
        frameWindow.setVisible(true);
        
    }

    public void formKendaraanMasuk(JPanel panel) {
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        // text field tipe kendaraan
        JTextField fieldTipe = new JTextField(5);
        // text field plat nomor
        JTextField platNomor = new JTextField(12);
        // tombol submit
        JButton submit = new JButton("Submit");
        // label cetak karcis
        JLabel labelKarcis = new JLabel();

        panel.add(new Label("Tipe:"));
        panel.add(fieldTipe);
        panel.add(new Label("Plat:"));
        panel.add(platNomor);
        panel.add(submit);
        panel.add(labelKarcis);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Karcis karcis = sistemParkir.cekIn(Kendaraan.Tipe.valueOf(fieldTipe.getText().toUpperCase()),
                        platNomor.getText());
                labelKarcis.setText("Dibuat karcis " + karcis.kode);
            }
        });
    }

    /*public void formKendaraanKeluar(JPanel panelExit) {
//        panelExit.setLayout(null);
//        panelExit.setBounds(100,100,100,100);
//        panelExit.setLayout(new FlowLayout(FlowLayout.LEFT));
        // text field kode karcis
        JTextField kodeKarcis = new JTextField(6);
        kodeKarcis.setBounds(10,100,100,100);
        // tombol submit
        JButton submitExit = new JButton("Submit Kode");
        // label biaya parkir
        
        panelExit.add(new Label("Kode Karcis:"));
        panelExit.add(kodeKarcis);
        panelExit.add(submitExit);
    }*/
}

