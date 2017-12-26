import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private Container cp;
    private ImagePanel jpn = new ImagePanel();
    private JPanel toolPane = new JPanel(new GridLayout(1,2,5,5));
    private JButton jbtnAddBoat = new JButton("Add Boat");
    private JButton jbtnExit = new JButton("Exit");
    private Image mouseCursor = new ImageIcon("pin1.png").getImage();
    private Boat selectedBoat;
    private boolean selectedBoatFlag = false;
    private int imgW, imgH;
    private ArrayList <Boat> boatList = new ArrayList<Boat>();
    private ArrayList <Thread> boatList = new ArrayList<Thread>();
    final Point hotSpot = new Point(0,0);
    final String name = "My Cursor";

    public MainFrame(){
        imgW = jpn.getImgWidth();
        imgH = jpn.getImgHeight();
        this.setBounds(350,100,imgW,imgH+30);
        this.setResizable(false);
        jpn.setLayout(null);
        toolPane.add(jbtnAddBoat);
        toolPane.add(jbtnExit);
        jbtnAddBoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boatList.add(new Boat(MainFrame.this,imgH,imgW));
                jpn.add(boatList.get(boatList.size()-1));
                threadList.add(new Thread(new Thread(boatList.size()-1)));
                threadList.get(threadList.size()-1).start();
            }
        });
        jbtnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}


class ImagePanel extends JPanel{
    private BufferedImage image;
    private int imgW,imgH;
    public ImagePanel(){
        try{
            image = ImageIO.read(new File("596332.jpg"));
            imgW = image.getWidth();
            imgH = image.getHeight();
        }catch (IOException ex){
                javax.swing.JOptionPane.showMessageDialog(this,"IOException"+ex.toString());
        }
    }
    @Override
    protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(image,0,0,null);
    }
    public int getImgWidth(){
        return imgW;
    }
    public int getImgHeight(){
        return imgH;
    }
    public void setSelectedBoat(Boat boat1){
        selectedBoat = boat1;
        selectedBoatFlag = true;
    }
}
