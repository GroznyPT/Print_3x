/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imprime_3x;

import java.awt.*;
import java.awt.print.*;

/**
 *
 * @author Luis ALves
 */



public class Printnow {

    public static boolean printCard(final  String bill){

        final PrinterJob job = PrinterJob.getPrinterJob();

        Printable contentToprint = new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

                Graphics2D g2d = (Graphics2D) graphics;
                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

                g2d.setFont(new Font("Monospaced",Font.BOLD,11));

                String[] text = bill.split(";");
                int y = 15;

                //one String for each line

                for (int i = 0; i < text.length; i++){
                    graphics.drawString(text[i], 5, y);
                    y = y + 15;
                }
                if (pageIndex > 0){
                    return NO_SUCH_PAGE; }

                return PAGE_EXISTS;
            }
        };
        PageFormat pageFormat = new PageFormat();
        pageFormat.setOrientation(PageFormat.PORTRAIT);
        Paper paperr = pageFormat.getPaper();

        paperr.setImageableArea(0,0,paperr.getWidth(), paperr.getHeight()-2);
        pageFormat.setPaper(paperr);
        job.setPrintable(contentToprint,pageFormat);

        try{
            job.print();
        }catch (PrinterException e){
            System.out.println(e.getMessage());
        }
        return true;
    }
}
