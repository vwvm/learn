package org.vwvm.store.services.adminService.impl;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.vwvm.store.services.adminService.SandMailServer;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class SandMailServerImpl implements SandMailServer {

    @Resource
    private JavaMailSenderImpl mailSender;


    @Override
    public void sendSimpleEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1647010108@qq.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        try {
            mailSender.send(message);
            System.out.println("纯文本邮件发送成功");
        } catch (MailException e) {
            System.out.println("纯文本邮件发送失败 " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void sendComplexEmail(String to, String subject, String text, String
            filePath, String rscId, String rscPath) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("1647010108@qq.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, true);
            // 静态内容：放在HTML正文中的图片
            FileSystemResource res = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, res);

            // 邮件附件
            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);
            mailSender.send(message);
            System.out.println("复杂邮件发送成功");
        } catch (MessagingException e) {
            System.out.println("复杂邮件发送失败 " + e.getMessage());
            e.printStackTrace();
        }

    }
}
