/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatocelulartempo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author vinipachecov
 */
public class MatrixImagePanel extends JPanel {
    
    
    private BufferedImage img;
    
    public MatrixImagePanel(int height, int width){
        
        initJpanel(width, height);
    }
    
    public void initJpanel(int width, int height){
        this.setSize(width, height);
        this.setVisible(true);        
    }

public void load(String path) throws IOException {
       img = ImageIO.read(new File(path));
       this.repaint();
}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (img != null) {
        g.drawImage(img, 0, 0, null);
    }
    
    }    

//    public void setLocation(){
//        this.        
//    }
}
