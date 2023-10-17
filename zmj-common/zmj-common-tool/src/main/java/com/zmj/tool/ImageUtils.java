package com.zmj.tool;

/**
 * @author ZMJ
 * @Package com.zmj.tool
 * @describe 获取图片路径工具类
 * @date 2023/10/17 14:41
 */
public class ImageUtils {

    /**
     * 获取图片域名
     */
    public static String getImageDomain(Long id) {

        String imageDomain = "//zmj/img1.com/pic/";
        try {
            int index = (int) (id % 5);
            switch (index) {
                case 0:
                    imageDomain = "//zmj/img1.com/pic/";
                    break;
                case 1:
                    imageDomain = "//zmj/img2.com/pic/";
                    break;
                case 2:
                    imageDomain = "//zmj/img3.com/pic/";
                    break;
                case 3:
                    imageDomain = "//zmj/img4.com/pic/";
                    break;
                case 4:
                    imageDomain = "//image_zmj/img1.com/pic/";
                    break;
                default:
                    imageDomain = "//image_zmj/img3.com/pic/";
                    break;
            }
            imageDomain = "https:" + imageDomain;
        } catch (Exception e) {
            return imageDomain;
        }
        return imageDomain;
    }


}