package com.ronhe.demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.jbarcode.JBarcode;
import org.jbarcode.JBarcodeFactory;
import org.jbarcode.encode.Code128Encoder;
import org.jbarcode.encode.InvalidAtributeException;
import org.jbarcode.paint.TextPainter;
import org.jbarcode.util.ImageUtil;

/**
* auther: rjc
* email:rjc@ronhe.com.cn
* version: 1.0.0
* desc: 测试条形码
*/
public class LineCodeTest {
	
	  //设置条形码高度    
    private static final int BARCODE_HEIGHT = 40;    
    //设置条形码默认分辨率    
    private static final int BARCODE_DPI = ImageUtil.DEFAULT_DPI;    
    //设置条形码字体样式    
    private static final String FONT_FAMILY = "console";    
    //设置条形码字体大小    
    private static final int FONT_SIZE = 15;    
    //设置条形码文本    
    public static String TEXT = "";    
    //创建jbarcode    
    private static JBarcode jbc = null;  
	
    /*  
     * 参考设置样式：  
     *barcode.setEncoder(Code128Encoder.getInstance()); //设置编码 
     *barcode.setPainter(WidthCodedPainter.getInstance());// 设置Painter 
     *barcode.setTextPainter(BaseLineTextPainter.getInstance()); //设置TextPainter 
     *barcode.setBarHeight(17); //设置高度 
     *barcode.setWideRatio(Double.valueOf(30).doubleValue());// 设置宽度比率 
     *barcode.setXDimension(Double.valueOf(2).doubleValue()); // 设置尺寸，大小 密集程度 
     *barcode.setShowText(true); //是否显示文本 
     *barcode.setCheckDigit(true); //是否检查数字 
     *barcode.setShowCheckDigit(false); //是否显示检查数字 
     */    
    
    static JBarcode getJBarCode() throws InvalidAtributeException{
    	if(jbc == null){
    		//创建对象
    		jbc = JBarcodeFactory.getInstance().createCode128();
    		jbc.setEncoder(Code128Encoder.getInstance());
    		jbc.setTextPainter(CustomTextPainter.getInstance());
    		//设置高度
    		jbc.setBarHeight(BARCODE_HEIGHT);
    		 // 设置尺寸，大小 密集程度 
    		jbc.setXDimension(Double.valueOf(0.8).doubleValue());
    		jbc.setShowText(true);//显示文本
    	}
    	return jbc;
    }
    /**  
     * @descript:生成条形码文件  
     * @param message  条形码内容  
     * @param file   生成文件  
     * @throws FileNotFoundException 
     */ 
    private static void createBarCode(String message, String path, String text) throws Exception{
    	FileOutputStream fos = new FileOutputStream(path);
    	createBarCode(message, fos, text);
    	fos.close();
    }
    
    /**
     * 
     * @param message 条形码内容
     * @param os
     * @param text 条形码文本
     */
    private static void createBarCode(String message, OutputStream os, String text){
    	TEXT = text;
    	try {
    		BufferedImage image = getJBarCode().createBarcode(message);
			ImageUtil.encodeAndWrite(image, ImageUtil.PNG, os, BARCODE_DPI, BARCODE_DPI);
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
	public static void main(String[] args) {
		 List<String> list=new ArrayList<String>();    
//         list.add("12345678");    
//         list.add("23456789");    
//         list.add("34567890");    
         list.add("45678901");    
         if(list!=null && list.size()>0){    
             for(String message:list){    
            	 try {
					LineCodeTest.createBarCode(message, message + ".png", "rjc");
				} catch (Exception e) {
					e.printStackTrace();
				}
             }    
         }       
		
	}

	/**  
     * 静态内部类  
     * 自定义的 TextPainter， 允许定义字体，大小，文本等  
     * 参考底层实现：BaseLineTextPainter.getInstance()  
     */    
    protected static class CustomTextPainter implements TextPainter {    
       private static CustomTextPainter instance =new CustomTextPainter();    
       public static CustomTextPainter getInstance() {    
            return instance;    
       }    
       public void paintText(BufferedImage barCodeImage, String text, int width) {    
            //绘图    
            Graphics g2d = barCodeImage.getGraphics();    
            //创建字体    
            Font font = new Font(FONT_FAMILY, Font.PLAIN, FONT_SIZE * width);    
            g2d.setFont(font);    
            FontMetrics fm = g2d.getFontMetrics();    
            int height = fm.getHeight();    
            int center = (barCodeImage.getWidth() - fm.stringWidth(text)) / 2;    
            g2d.setColor(Color.WHITE);    
            g2d.fillRect(0, 0, barCodeImage.getWidth(), barCodeImage.getHeight() * 1 / 20);    
            g2d.fillRect(0, barCodeImage.getHeight() - (height * 9 / 10), barCodeImage.getWidth(), (height * 9 / 10));    
            g2d.setColor(Color.BLACK);    
            //绘制文本    
            g2d.drawString(TEXT, 1, 145);    
            //绘制条形码    
            g2d.drawString(text, center, barCodeImage.getHeight() - (height / 10) - 2);    
        }    
    }    
    
	

}
