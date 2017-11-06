package com.example.controller;

import com.example.utils.QRCodeUtils;
import com.google.zxing.BarcodeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 二维码生成
 * Created by 11019 on 17.11.6.
 */
@CrossOrigin    //跨域
@RestController
public class QRCodeController {

    @RequestMapping(value = "/getqr")
    public void createQR(String content,HttpServletResponse response){
        //跨域
//        response.setHeader("Access-Control-Allow-Origin", "*");
        ServletOutputStream outputStream = null;
        try {
            response.setContentType("image/png");
            outputStream = response.getOutputStream();
            QRCodeUtils qrCodeUtils = new QRCodeUtils();
            BufferedImage image = qrCodeUtils.encode(content, "png", BarcodeFormat.QR_CODE, 200, 200, null);
            ImageIO.write(image, "png", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
