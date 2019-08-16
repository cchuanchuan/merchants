package top.cllccc.passbook.service.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.cllccc.passbook.constant.Constants;
import top.cllccc.passbook.constant.ErrorCode;
import top.cllccc.passbook.dao.MerchantsDao;
import top.cllccc.passbook.entity.Merchants;
import top.cllccc.passbook.service.IMerchantsService;
import top.cllccc.passbook.vo.CreateMerchantsRequest;
import top.cllccc.passbook.vo.CreateMerchantsResponse;
import top.cllccc.passbook.vo.PassTemplate;
import top.cllccc.passbook.vo.Response;

/**
 * <h1>商户接口实现</h1>
 *
 * @Author: CCC
 * @Date 2019/8/15 20:29
 */
@Slf4j
@Service
public class MerchantsServiceImpl implements IMerchantsService{

    /** Merchants 数据库接口*/
    private final MerchantsDao merchantsDao;

    /** kafka 客户端 */
    private final KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    public MerchantsServiceImpl(MerchantsDao merchantsDao,  KafkaTemplate<String,String> kafkaTemplate){
        this.merchantsDao = merchantsDao;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    @Transactional
    public Response createMerchants(CreateMerchantsRequest request) {

        Response response = new Response();
        CreateMerchantsResponse merchantsResponse = new CreateMerchantsResponse();

        //校验merchants 各个属性是否正确
        ErrorCode errorCode = request.validate(merchantsDao);

        if(errorCode != ErrorCode.SUCCESS){
            merchantsResponse.setId(-1);
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
        }else{
            merchantsResponse.setId(merchantsDao.save(request.toMerchants()).getId());
        }

        response.setData(merchantsResponse);

        return response;
    }

    @Override
    public Response buildMerchantsInfoById(Integer id) {

        Response response  = new Response();

        Merchants merchants = merchantsDao.findMerchantsById(id);
        if(null == merchants){
            response.setErrorCode(ErrorCode.MERCHANTS_NOT_EXIST.getCode());
            response.setErrorMsg(ErrorCode.MERCHANTS_NOT_EXIST.getDesc());
        }
        response.setData(merchants);

        return response;
    }

    @Override
    public Response dropPassTemplate(PassTemplate template) {

        Response response = new Response();
        ErrorCode errorCode = template.validate(merchantsDao);

        if(errorCode != ErrorCode.SUCCESS){
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
        }else{
            String passtemplate = JSON.toJSONString(template);
            kafkaTemplate.send(
                    Constants.TEMPLATE_TOPIC,//topic
                    Constants.TEMPLATE_TOPIC,//key
                    passtemplate
            );
            log.info("DropPassTemplates: {}",passtemplate);
        }

        return null;
    }
}
