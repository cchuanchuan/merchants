package top.cllccc.passbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.cllccc.passbook.entity.Merchants;

/**
 * <h1>MerchantsDao 接口</h1>
 */
public interface MerchantsDao extends JpaRepository<Merchants,Integer> {

    /**
     * <h2>根据 id获取商户对象</h2>
     * @param id 商户id
     * @return {@link Merchants}
     */
    Merchants findMerchantsById(Integer id);

    /**
     * <h2>根据名称获取商户对象</h2>
     * @param name 商户名称
     * @return {@link Merchants}
     */
    Merchants findByName(String name);
}
