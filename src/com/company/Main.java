package com.company;

import javax.imageio.ImageIO;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB_PRE;

public class Main {

    public static void main(String[] args) throws IOException, FontFormatException {
        // Open a JPEG file, load into a BufferedImage.
        BufferedImage Oost1 = ImageIO.read(new File("Huidig//1.png")); //281 bij 255, linksboven
        BufferedImage Oost2 = ImageIO.read(new File("Huidig//2.png")); //283 bij 252, centraal boven
        BufferedImage Oost3 = ImageIO.read(new File("Huidig//3.png")); //248 bij 208, rechtsboven
        BufferedImage Oost4 = ImageIO.read(new File("Huidig//4.png")); //215 bij 366, links
        BufferedImage Oost5 = ImageIO.read(new File("Huidig//5.png")); //594 bij 497, groot midden
        BufferedImage Oost6 = ImageIO.read(new File("Huidig//6.png")); //217 bij 267, rechtsonder
        BufferedImage Oost7 = ImageIO.read(new File("Huidig//7.png")); //374 bij 226, klein midden
        BufferedImage Oost8 = ImageIO.read(new File("Huidig//8.png")); //250 bij 218, centraal onder
        BufferedImage Oost9 = ImageIO.read(new File("Huidig//9.png")); //240 bij 370, linksonder
        GTACoverMaker A = new GTACoverMaker(Oost1,Oost2,Oost3,Oost4,Oost5,Oost7,Oost9,Oost8,Oost6,"logo","Ninof");

        // retrieve image
        File outputfile = new File("D.png");
        BufferedImage b = new BufferedImage(833,960,TYPE_INT_ARGB_PRE);
        Graphics2D g = b.createGraphics();
        g.setBackground(Color.WHITE);
        g.drawImage(A.afbeelding(),null,0,0);
        ImageIO.write(b, "png", outputfile);



    }
}


/*BufferedImage Oost1 = ImageIO.read(new File("Oost1.png"));
        BufferedImage T = new BufferedImage(200,200,TYPE_INT_ARGB_PRE);
        Graphics2D G = T.createGraphics();
        G.drawImage(Oost1,0,0,null);
        File outputfile = new File("image2.png");
        ImageIO.write(T, "png", outputfile);*/