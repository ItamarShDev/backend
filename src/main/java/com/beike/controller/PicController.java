package com.beike.controller;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by huahui.yang on 4/19/15.
 */

@Controller
@RequestMapping("/pic")
public class PicController {
    private static Logger logger = Logger.getLogger(PicController.class);
    private static String ACCESS_KEY = "2M7GJDQg1q-9t3ainZtuZ_IcZIT258vhI_IiwQzY";
    private static String SECRET_KEY = "EtwCu1HBm-0o1HzQ3QvTB8ObLRNLk-CZ1KQkAUzw";
    private static String bucketName = "picbeike";
//    private Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
//    private BucketManager bucketManager = new BucketManager(auth);


    @RequestMapping(value = "/upload")
    public void methodPicUpload(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "picurl", required = false) String picurl) {
        String jsonResult = "";

        logger.info("picurl: " + picurl);

        UploadManager uploadManager = new UploadManager();
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String token = auth.uploadToken(bucketName);

        Response r = null;
        try {
            r = uploadManager.put("hello world".getBytes(), "yourkey", token);

        } catch (QiniuException e) {
            e.printStackTrace();
        }

        logger.info("response:" + r);

        jsonResult = "{result:true, message:upload success}";

        try {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print(jsonResult);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

    }

}
