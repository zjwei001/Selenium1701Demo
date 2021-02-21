package com.po.page;

import org.openqa.selenium.By;

public class sendEmailPage {
    public static By writerButton= By.xpath("//*[@id='dvNavTop']/ul/li[2]/span[2]");
    public static By senderInput1 = By.xpath("nui-editableAddr-ipt");
    public static  By titleInput=By.xpath("//*[@aria-label='邮件主题输入框，请输入邮件主题']/input");
    public static By pictuteAttachedButton=By.xpath("//*[@title='一次可发送2000张照片，600首MP3，一部高清电影']/input");
    public static By switchFrameToSendButton=By.className("APP-editor-iframe");
    public static By contentInput=By.xpath("/html/body");
    public static By sendButton=By.xpath("//*[@class='js-component-button nui-mainBtn nui-btn nui-btn-hasIcon nui-mainBtn-hasIcon  ']/span[2]");

}
