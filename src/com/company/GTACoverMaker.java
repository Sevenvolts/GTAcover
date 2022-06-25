package com.company;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import javafx.scene.shape.TriangleMesh;
import sun.awt.image.ImageWatched;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.File;
import java.io.IOException;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB_PRE;

public class GTACoverMaker {
    public GTACoverMaker(BufferedImage linksboven, BufferedImage centraalBoven, BufferedImage rechtsboven, BufferedImage links, BufferedImage groteMidden, BufferedImage kleineMidden, BufferedImage linksonder, BufferedImage centraalOnder, BufferedImage rechtsonder, String logo, String naam) {
        Linksboven = linksboven;
        CentraalBoven = centraalBoven;
        Rechtsboven = rechtsboven;
        Links = links;
        GroteMidden = groteMidden;
        KleineMidden = kleineMidden;
        Linksonder = linksonder;
        CentraalOnder = centraalOnder;
        Rechtsonder = rechtsonder;
        this.naam=naam;
        this.logo=logo;
        this.transformaties();
    }

    BufferedImage Linksboven;
    BufferedImage CentraalBoven;
    BufferedImage Rechtsboven;
    BufferedImage Links;
    BufferedImage GroteMidden;
    BufferedImage KleineMidden;
    BufferedImage Linksonder;
    BufferedImage CentraalOnder;
    BufferedImage Rechtsonder;
    String naam;
    String logo;

    public BufferedImage afbeelding() throws IOException, FontFormatException {
        BufferedImage img = new BufferedImage(833,960,TYPE_INT_ARGB_PRE);
        Graphics2D g = img.createGraphics();
        g.setBackground(Color.WHITE);
        g.drawImage(Linksboven,null,15,15);
        g.drawImage(CentraalBoven,null,295,15);
        g.drawImage(Rechtsboven,null,572,15);
        g.drawImage(Links,null,15,240);
        g.drawImage(GroteMidden,null,227,202);
        g.drawImage(KleineMidden,null,242,532);
        g.drawImage(CentraalOnder,null,250,727);
        g.drawImage(Linksonder,null,15,580);
        g.drawImage(Rechtsonder,null,504,679);
        g.drawImage((ImageIO.read(new File("GTAcover.png"))),null,0,0);

        BufferedImage b = ImageIO.read(new File(logo+".png"));
        b=herschaal(300,300,b);
        g.drawImage(b,null,300,300);
        g.setColor(Color.MAGENTA);
        Font f = Font.createFont(Font.TRUETYPE_FONT, new File("rage italic.ttf")).deriveFont(90f);
        g.setFont(f);
        if (naam.length()<10) {
            g.drawString(naam, 300, 600);
        } else {
            g.drawString(naam, 180, 600);
        }
        return img;
    }

    private void transformaties() {
        this.linksbovenTransformatie();
        this.centraalBovenTransformatie();
        this.rechtsbovenTransformatie();
        this.linksTransformatie();
        this.groteMiddenTransformatie();
        this.kleineMiddenTransformatie();
        this.linksonderTransformatie();
        this.centraalOnderTransformatie();
        this.rechtsonderTransformatie();
    }

    private BufferedImage generiekeDeelTransformatie(BufferedImage afbeelding, int breedte, int hoogte) {
        afbeelding = snijNaarJuisteVerhoudingen(afbeelding,breedte,hoogte);
        afbeelding.getGraphics().drawImage(afbeelding.getScaledInstance(breedte,hoogte,0), 0, 0 , null);
        return afbeelding.getSubimage(0,0,breedte,hoogte);
    }

    private void linksbovenTransformatie() {
        //Linksboven=Linksboven.getSubimage(0,0,281,255);
        Linksboven=generiekeDeelTransformatie(Linksboven,281,255);
        Graphics2D g = Linksboven.createGraphics();
        int[] x = {0,220,0};
        int[] y = {218,262,262};
        g.setColor(Color.WHITE);
        g.fill(new Polygon(x,y,3));
        Linksboven=maakWitTransparant(Linksboven);
    }

    private void centraalBovenTransformatie() {
        CentraalBoven=generiekeDeelTransformatie(CentraalBoven,283,252);
         //CentraalBoven=CentraalBoven.getSubimage(0,0,283,252);
        Graphics2D g = CentraalBoven.createGraphics();
        g.setColor(Color.WHITE);

        int[] x1 = {269,283,283};
        int[] y1 = {0,63,0};
        g.fill(new Polygon(x1,y1,3));
        int[] x2 = {283,84,283};
        int[] y2 = {220,252,252};
        g.fill(new Polygon(x2,y2,3));

        CentraalBoven=maakWitTransparant(CentraalBoven);
    }

    private void rechtsbovenTransformatie() {
        //Rechtsboven=Rechtsboven.getSubimage(0,0,248,208);
        Rechtsboven=generiekeDeelTransformatie(Rechtsboven,248,208);
        Graphics2D g = Rechtsboven.createGraphics();
        g.setColor(Color.WHITE);

        int[] x1 = {0,11,0};
        int[] y1 = {139,208,208};
        g.fill(new Polygon(x1,y1,3));
        int[] x2 = {248,98,248};
        int[] y2 = {177,208,208};
        g.fill(new Polygon(x2,y2,3));

        Rechtsboven=maakWitTransparant(Rechtsboven);
    }

    private void linksTransformatie() {
        //Links = Links.getSubimage(0,0,215,366);
        Links=generiekeDeelTransformatie(Links,215,366);
        Graphics2D g = Links.createGraphics();
        g.setColor(Color.WHITE);
        int[] x1 = {215,80,215};
        int[] y1 = {0,0,25};
        g.fill(new Polygon(x1,y1,3));
        Links = maakWitTransparant(Links);
    }

    private void groteMiddenTransformatie() {
        //GroteMidden = GroteMidden.getSubimage(0,0,594,497);
        GroteMidden=generiekeDeelTransformatie(GroteMidden,594,497);
        Graphics2D g = GroteMidden.createGraphics();
        g.setColor(Color.WHITE);
        int[] x1 = {0,0,70,70};
        int[] y1 = {0,67,65,0};
        g.fill(new Polygon(x1,y1,4));
        int[] x2 = {70,70,557};
        int[] y2 = {65,0,0};
        g.fill(new Polygon(x2,y2,3));

        GroteMidden=maakWitTransparant(GroteMidden);
    }

    private void rechtsonderTransformatie() {
        //Rechtsonder = Rechtsonder.getSubimage(0,0,317,267);
        Rechtsonder=generiekeDeelTransformatie(Rechtsonder,317,267);
        Graphics2D g = Rechtsonder.createGraphics();
        g.setColor(Color.WHITE);
        int[] x1 = {255,0,0};
        int[] y1 = {0,45,0};
        g.fill(new Polygon(x1,y1,3));
        Rechtsonder=maakWitTransparant(Rechtsonder);
    }

    private void kleineMiddenTransformatie() {
        //KleineMidden = KleineMidden.getSubimage(0,0,374,226);
        KleineMidden=generiekeDeelTransformatie(KleineMidden,374,226);
        Graphics2D g = KleineMidden.createGraphics();
        g.setColor(Color.WHITE);
        int[] x1 = {340,0,0};
        int[] y1 = {0,50,0};
        g.fill(new Polygon(x1,y1,3));
        KleineMidden=maakWitTransparant(KleineMidden);
    }

    private void centraalOnderTransformatie() {
        //CentraalOnder = CentraalOnder.getSubimage(0,0,250,218);
        CentraalOnder=generiekeDeelTransformatie(CentraalOnder,250,218);
        Graphics2D g = CentraalOnder.createGraphics();
        g.setColor(Color.WHITE);
        int[] x1 = {189,0,0};
        int[] y1 = {0,29,0};
        g.fill(new Polygon(x1,y1,3));
        CentraalOnder=maakWitTransparant(CentraalOnder);
    }

    private void linksonderTransformatie() {
        Linksonder=generiekeDeelTransformatie(Linksonder,240,370);
        Graphics2D g = Linksonder.createGraphics();
        g.setColor(Color.WHITE);
        int[] x1 = {162,0,0};
        int[] y1 = {0,32,0};
        g.fill(new Polygon(x1,y1,3));
        int[] x2 = {222,240,240};
        int[] y2 = {0,190,0};
        g.fill(new Polygon(x2,y2,3));
        Linksonder=maakWitTransparant(Linksonder);
    }


    private static BufferedImage maakWitTransparant(BufferedImage bi){
        int[] pixels = bi.getRGB(0, 0, bi.getWidth(), bi.getHeight(), null, 0, bi.getWidth());

        for(int i=0;i<pixels.length;i++){
            int color = pixels[i];
            int a = (color>>24)&255;
            int r = (color>>16)&255;
            int g = (color>>8)&255;
            int b = (color)&255;

            if(r == 255 && g == 255 && b == 255){
                a = 0;
            }

            pixels[i] = (a<<24) | (r<<16) | (g<<8) | (b);
        }

        BufferedImage biOut = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_ARGB);
        biOut.setRGB(0, 0, bi.getWidth(), bi.getHeight(), pixels, 0, bi.getWidth());
        return biOut;
    }

    private static BufferedImage herschaal(int targetWidth, int targetHeight,
                                       BufferedImage src) {
        double scaleW = (double) targetWidth / (double) src.getWidth() ;
        double scaleH = (double) targetHeight / (double) src.getHeight() ;

        double scale = scaleW < scaleH ? scaleW : scaleH;

        BufferedImage result = new BufferedImage((int) (src.getWidth() * scale),
                (int) (src.getHeight() * scale), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = result.createGraphics();
        g2d.drawImage(src, 0, 0, result.getWidth(), result.getHeight(), null);
        g2d.dispose();

        return result;}


    private Font getFont() {
        return new Font("Arial Black",Font.BOLD,100);
    }

    private static BufferedImage snijNaarJuisteVerhoudingen(BufferedImage image, int normalratiowidth, int normalratioheight) {
        int originalwidth=0;
        int originalheight=0;
        try {
            originalwidth=image.getWidth();
            originalheight=image.getHeight();
        } catch (NullPointerException A) {
            System.out.println(image);
        }
        int w=1;
        int h=1;
        if (originalwidth*normalratioheight<originalheight*normalratiowidth) {
            w = originalwidth;
            h = originalwidth*normalratioheight/normalratiowidth;
        } else if (originalwidth*normalratioheight>originalheight*normalratiowidth) {
            w = originalheight*normalratiowidth/normalratioheight;
            h = originalheight;
        }
        try {
            return image.getSubimage(0,0,w,h);
        } catch (RasterFormatException E) {
            System.out.println(w+" "+originalwidth);
            System.out.println(h+" "+originalheight);
            return null;
        }
    }

}
