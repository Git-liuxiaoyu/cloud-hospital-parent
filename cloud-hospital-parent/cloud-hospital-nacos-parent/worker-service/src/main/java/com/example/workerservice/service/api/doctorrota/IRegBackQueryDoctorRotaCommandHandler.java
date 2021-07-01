package com.example.workerservice.service.api.doctorrota;

import com.example.workerservice.service.command.doctorrota.regquery.RegBackQueryDoctorRotaCommand;
import com.example.workerservice.service.command.doctorrota.regquery.RegQueryDoctorRotaCommand;

import java.text.ParseException;
import java.util.List;

/**
 * 接口 - IRegQueryDoctorRotaCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/19
 */
public interface IRegBackQueryDoctorRotaCommandHandler {

    List<RegBackQueryDoctorRotaCommand.DoctorRotaVo> action(RegBackQueryDoctorRotaCommand command);

    /**
     * 自定义业务异常 - 日期转换错误
     **/
    class NewDateParseException extends RuntimeException {
        public NewDateParseException() {
            super("日期转换错误");
        }
    }


}
