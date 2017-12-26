import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

class Boat extends JLabel implements Runnable{
    private int frmW,frmH,x,y,r1,r;
    private ImageIcon[] imgIcon = {new ImageIcon("boat1.jpg"),new ImageIcon("boat2.jpg")};
    private Random rand = new Random();
    private Timer t1;

    public Boat(MainFrame frm,int frmH,int frmW){
        this.frmH = frmH;
        this.frmW = frmW;
        x = rand.nextInt(frmW-100);
        y = rand.nextInt(frmH-100);
        this.setIcon(imgIcon[r1 = rand.nextInt(3)]);
        this.setBounds(x,y,this.getIcon().getIconWidth(),this.getIcon().getIconHeight());
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frm.setSelectedBoat(Boat.this);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                Boat.this.setIcon(imgIcon[r1]);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                Boat.this.setIcon(imgIcon[r1]);
            }
            @Override
            public void mouseEntered(MouseEvent e) {   }
            @Override
            public void mouseExited(MouseEvent e) {     }
        });
    }
    public void movingShip(int x1,int y1){
        System.out.println(">>>>"+ x1 +","+y1);

    }
}
