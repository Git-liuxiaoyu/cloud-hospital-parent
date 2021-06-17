package com.example.verificationcodeservice.service.command.phone;

import com.example.verificationcodeservice.service.api.ISaveVerifyCodeCommandHandler;
import com.example.verificationcodeservice.util.ApplicationContextHolder;
import lombok.Data;

/**
 * 实体类 - 命令 - 保存验证码
 */
@Data
public class SaveVerifyCodeCommand {

    private String type;

    private String phone;

    private String code;

    private ISaveVerifyCodeCommandHandler saveVerifyCodeCommandHandler;

    public SaveVerifyCodeCommand() {
        this.saveVerifyCodeCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(ISaveVerifyCodeCommandHandler.class);
    }

    public SaveVerifyCodeCommand(String type, String phone, String code) {
        this();
        this.type = type;
        this.phone = phone;
        this.code = code;
    }

    public void execute(){
        this.saveVerifyCodeCommandHandler.action(this);
    }

}
