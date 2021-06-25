package com.example.payservice.adapter;


import com.example.payservice.adapter.converter.CallProofPayConverter;
import com.example.payservice.outlet.cliten.register.RegServiceClient;
import com.example.payservice.outlet.cliten.register.pojo.Register;
import com.example.payservice.outlet.dao.mysql.CallProofPayDao;
import com.example.payservice.outlet.dao.mysql.pojo.CallProofPayPo;
import com.example.payservice.service.command.addcallorder.AddCallOrderCommand;
import com.example.payservice.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * 挂号付款适配器
 */
@Repository
@Slf4j
@Component
public class CallProofPayAdapter {


    @Autowired
    private CallProofPayDao callProofPayDao;

    //转换
    @Autowired
    private CallProofPayConverter converter;


    //openfeign接口
    @Autowired
    private RegServiceClient regServiceClient;


    /**
     * 添加挂号支付订单
     */
    public int addCallProof(AddCallOrderCommand addCallOrderCommand){
        CallProofPayPo excmtopo = converter.excmtopo(addCallOrderCommand);

        int i = callProofPayDao.addCallProofOrder(excmtopo);
        return i;

    }


    /**
     * 向openfeign发送获取挂号信息请求
     * @return
     */

    public ResponseResult<AddCallOrderCommand> findbyno(String no) {
        try {
            ResponseResult<Register> findbyno = regServiceClient.findbyno(no);

            if (findbyno.getCode() != 200) {
                return new ResponseResult<AddCallOrderCommand>(400, "未查询到挂号信息，请稍后重试！", null);
            }else{
                AddCallOrderCommand addCallOrderCommand = new AddCallOrderCommand();
                addCallOrderCommand.setPatientId(findbyno.getData().getPatientId());
                addCallOrderCommand.setType(findbyno.getData().getType());//挂号类别专家普通
                return new ResponseResult<AddCallOrderCommand>(200, "ok", addCallOrderCommand);

            }
            //return "就诊室";
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult<AddCallOrderCommand>(400, "未查询到挂号信息，请稍后重试！", null);
        }

    }

}
