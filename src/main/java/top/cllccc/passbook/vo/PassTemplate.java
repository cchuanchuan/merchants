package top.cllccc.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.cllccc.passbook.constant.ErrorCode;
import top.cllccc.passbook.dao.MerchantsDao;

import java.util.Date;

/**
 * <h1>投放的优惠券对象定义</h1>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassTemplate {

    /** 所属商户 id*/
    private Integer id;

    /** 优惠券标题*/
    private String title;

    /** 优惠券摘要*/
    private String summary;

    /** 优惠券详细信息*/
    private String desc;

    /** 最大限制个数*/
    private long limit;

    /** 优惠券是否有 token*/
    private Boolean hasToken; // token 存储于redis set中，每次领取从redis 中获取

    /** 优惠券背景色*/
    private Integer background;

    /** 优惠券开始时间*/
    private Date start;

    /** 优惠券结束时间*/
    private Date end;

    /**
     * <h2>校验优惠券信息的有效性</h2>
     * @param merchantsDao {@link MerchantsDao}
     * @return {@link ErrorCode}
     */
    public ErrorCode validate(MerchantsDao merchantsDao){
        if(null == merchantsDao.findMerchantsById(id)){
            return ErrorCode.MERCHANTS_NOT_EXIST;
        }else {
            return ErrorCode.SUCCESS;
        }

    }
}
