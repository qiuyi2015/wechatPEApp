package main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import menu.Button;
import menu.CommonButton;
import menu.ComplexButton;
import menu.Menu;
import pojo.AccessToken;
import util.WeixinUtil;

/**
 * 菜单管理器类
 */
public class MenuManager {
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);

    public static void main(String[] args) {
        // 第三方用户唯一凭证
        String appId = "wxd88fd8fadcb29a3c";
        // 第三方用户唯一凭证密钥
        String appSecret = "hitpeandyouth123";

        // 调用接口获取access_token
        AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);

        if (null != at) {
            // 调用接口创建菜单
            int result = WeixinUtil.createMenu(getMenu(), at.getToken());

            // 判断菜单创建结果
            if (0 == result)
                log.info("菜单创建成功！");
            else
                log.info("菜单创建失败，错误码：" + result);
        }
    }

    /**
     * 组装菜单数据
     *
     * @return
     */
    private static Menu getMenu() {
        CommonButton btn11 = new CommonButton();
        btn11.setName("运动指南");
        btn11.setType("click");
        btn11.setKey("11");

        CommonButton btn12 = new CommonButton();
        btn12.setName("失物招领");
        btn12.setType("click");
        btn12.setKey("12");

        CommonButton btn13 = new CommonButton();
        btn13.setName("运动信息");
        btn13.setType("click");
        btn13.setKey("13");

        CommonButton btn14 = new CommonButton();
        btn14.setName("投诉建议");
        btn14.setType("click");
        btn14.setKey("14");

        CommonButton btn21 = new CommonButton();
        btn21.setName("开放时间");
        btn21.setType("click");
        btn21.setKey("21");

        CommonButton btn22 = new CommonButton();
        btn22.setName("近期活动");
        btn22.setType("click");
        btn22.setKey("22");

        CommonButton btn31 = new CommonButton();
        btn31.setName("近期赛事");
        btn31.setType("click");
        btn31.setKey("31");

        CommonButton btn32 = new CommonButton();
        btn32.setName("赛事报名");
        btn32.setType("click");
        btn32.setKey("32");

        CommonButton btn33 = new CommonButton();
        btn33.setName("往期回顾");
        btn33.setType("click");
        btn33.setKey("33");


        /**
         * 微信：  mainBtn1,mainBtn2,mainBtn3底部的三个一级菜单。
         */

        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("健康贴士");
        //一级下有4个子菜单
        mainBtn1.setSub_button(new CommonButton[] { btn11, btn12, btn13, btn14 });


        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("场馆查询");
        mainBtn2.setSub_button(new CommonButton[] { btn21, btn22 });


        ComplexButton mainBtn3 = new ComplexButton();
        mainBtn3.setName("相关赛事");
        mainBtn3.setSub_button(new CommonButton[] { btn31, btn32, btn33 });


        /**
         * 封装整个菜单
         */
        Menu menu = new Menu();
        menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });

        return menu;
    }
}