package top.cllccc.passbook;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import top.cllccc.passbook.service.IMerchantsService;
import top.cllccc.passbook.vo.CreateMerchantsRequest;
import top.cllccc.passbook.vo.PassTemplate;

import java.util.Date;

/**
 * <h1></h1>
 *
 * @Author: CCC
 * @Date 2019/8/15 20:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MerchantsServiceTest {

    @Autowired
    private IMerchantsService merchantsService;

    @Test
    //检测是test，执行成功会自动回滚
    //@Transactional
    public void testCreateMerchantService() {

        CreateMerchantsRequest request = new CreateMerchantsRequest();
        request.setName("name");
        request.setLogoUrl("logourl");
        request.setBussinesslicenseUrl("businesslicenseur;");
        request.setPhone("15996535434");
        request.setAddress("北京市");

        System.out.println(JSON.toJSONString(merchantsService.createMerchants(request)));
    }

    /** {"data":{"address":"北京市","bussinessLicenseUrl":"businesslicenseur;",
     * "id":4,"isAudit":false,"logoUrl":"logourl","name":"name","phone":"15996535434"},
     * "errorCode":0,"errorMsg":""}*/
    @Test
    @Transactional
    public void testBuildMerchantsInfoByid(){
        System.out.println(JSON.toJSONString(merchantsService.buildMerchantsInfoById(4)));
    }

    @Test
    public void testDropPassTemplate(){
        PassTemplate passTemplate = new PassTemplate();
        passTemplate.setId(4);
        passTemplate.setTitle("title2");
        passTemplate.setSummary("简介：summary");
        passTemplate.setDesc("desc详情");
        passTemplate.setHasToken(false);
        passTemplate.setBackground(2);
        passTemplate.setStart(new Date());
        passTemplate.setEnd(DateUtils.addDays(new Date(),10));

        System.out.println(JSON.toJSONString(
                merchantsService.dropPassTemplate(passTemplate)
        ));

    }
}
