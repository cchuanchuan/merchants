package top.cllccc.passbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * <h1>商户对象模型</h1>
 * */

//getter 和setter方法
@Data
//无参构造函数
@NoArgsConstructor
//全参构造函数
@AllArgsConstructor
//表明是一个实体对象
@Entity
//表名
@Table(name = "merchants")
public class Merchants {

    /** 商户id，主键,自动生成*/
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;

    /** 商户名称，需要是全局唯一的 */
    //表示是一个基本列，可以不加
    @Basic
    @Column(name = "name",unique = true,nullable = false)
    private String name;

    //@Transient 表示不属于这一张表

    /** 商户logo*/
    @Basic
    @Column(name = "logo_url", nullable = false)
    private String logoUrl;

    /** 商户营业执照*/
    @Basic
    @Column(name = "business_license_url",nullable = false)
    private String bussinessLicenseUrl;

    /** 商户的联系电话*/
    @Basic
    @Column(name = "phone",nullable = false)
    private String phone;

    @Basic
    @Column(name = "address",nullable = false)
    private String address;

    /** 商户是否通过审核*/
    @Basic
    @Column(name = "isAudit", nullable = false)
    private Boolean isAudit = false;
}
