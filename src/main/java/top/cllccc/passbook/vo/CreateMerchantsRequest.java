package top.cllccc.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.cllccc.passbook.constant.ErrorCode;
import top.cllccc.passbook.dao.MerchantsDao;
import top.cllccc.passbook.entity.Merchants;

/**
 * <h2>创建商户对象</h2>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMerchantsRequest {

    /** 商户名称*/
    private String name;

    /** 商户logo*/
    private String logoUrl;

    /** 商户营业执照*/
    private String bussinesslicenseUrl;

    /** 商户联系电话*/
    private String phone;

    /** 商户地址*/
    private String address;

    /**
     * <h2>验证请求有效性 </h2>
     * @param merchantsDao {@link MerchantsDao}
     * @return {@link ErrorCode}
     */
    public ErrorCode validate(MerchantsDao merchantsDao){
        if(null != merchantsDao.findByName(this.name)){
            return ErrorCode.DUPLICATE_NAME;
        }
        if(null == this.logoUrl){
            return ErrorCode.EMPITY_LOGO;
        }

        if(null == this.bussinesslicenseUrl){
            return ErrorCode.EMPTY_BUSINESS_LICENSE;
        }

        if(null == this.address){
            return ErrorCode.EMPTY_ADDRESS;
        }

        if(null == this.phone){
            return ErrorCode.ERROR_PHONE;
        }

        return ErrorCode.SUCCESS;
    }

    /**
     * <h2>将请求对象转换为商户对象</h2>
     * @return {@link Merchants}
     */
    public Merchants toMerchants(){

        Merchants merchants = new Merchants();

        merchants.setName(name);
        merchants.setLogoUrl(logoUrl);
        merchants.setBussinessLicenseUrl(bussinesslicenseUrl);
        merchants.setPhone(phone);
        merchants.setAddress(address);

        return merchants;
    }
}
