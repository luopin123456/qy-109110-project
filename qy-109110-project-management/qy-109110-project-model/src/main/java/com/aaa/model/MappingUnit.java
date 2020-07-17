package com.aaa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_mapping_unit")
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class MappingUnit {
    @Id
    private Long id;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 备注
     */
    private String memo;

    /**
     * 单位名称
     */
    @Column(name = "unit_name")
    private String unitName;

    /**
     * 注册地址
     */
    @Column(name = "register_address")
    private String registerAddress;

    /**
     * 注册时间
     */
    @Column(name = "register_time")
    private Date registerTime;

    /**
     * 办公地址
     */
    private String oa;

    /**
     * 法人
     */
    private String corporation;

    /**
     * 联系人
     */
    private String linkman;

    /**
     * 所属行政区
     */
    @Column(name = "owned_district")
    private String ownedDistrict;

    /**
     * 注册资金(万元)
     */
    @Column(name = "register_fund")
    private Double registerFund;

    /**
     * 统一社会信用代码
     */
    @Column(name = "social_credit_code")
    private String socialCreditCode;

    /**
     * 资质等级
     */
    @Column(name = "qualification_level")
    private String qualificationLevel;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 联系方式
     */
    @Column(name = "contact_way")
    private String contactWay;

    /**
     * 单位曾用名
     */
    @Column(name = "used_name")
    private String usedName;

    /**
     * 注册地址经度
     */
    @Column(name = "register_address_lon")
    private String registerAddressLon;

    /**
     * 注册单位纬度
     */
    @Column(name = "register_address_lat")
    private String registerAddressLat;

    /**
     * 注册地址邮编
     */
    @Column(name = "register_address_postcode")
    private String registerAddressPostcode;

    /**
     * 办公地址邮编
     */
    @Column(name = "oa_postcode")
    private String oaPostcode;

    /**
     * 办公场所面积（平方米）
     */
    @Column(name = "oa_area")
    private Double oaArea;

    /**
     * 单位成立时间
     */
    @Column(name = "establish_time")
    private Date establishTime;

    /**
     * 手机号码
     */
    @Column(name = "mobile_phone")
    private String mobilePhone;

    /**
     * 传真号码
     */
    @Column(name = "fax_num")
    private String faxNum;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 测绘人员总数
     */
    @Column(name = "surveying_num")
    private Integer surveyingNum;

    /**
     * 职工总数
     */
    @Column(name = "staff_num")
    private Integer staffNum;

    /**
     * 单位性质
     */
    @Column(name = "unit_nature")
    private String unitNature;

    /**
     * 所属行业
     */
    @Column(name = "belong_industry")
    private String belongIndustry;

    /**
     * 证书编号
     */
    @Column(name = "certificate_code")
    private String certificateCode;

    /**
     * 发证日期
     */
    @Column(name = "certificate_send_date")
    private Date certificateSendDate;

    /**
     * 公司类型
     */
    @Column(name = "company_type")
    private String companyType;

    /**
     * 股东及控股情况
     */
    @Column(name = "stock_details")
    private String stockDetails;

    /**
     * 合资形式
     */
    @Column(name = "joint_venture")
    private String jointVenture;

    /**
     * 合资企业中方控股（%）
     */
    @Column(name = "joint_ch_p")
    private Integer jointChP;

    /**
     * 合资企业批注文号
     */
    @Column(name = "joint_ratify_code")
    private String jointRatifyCode;

    /**
     * 主管部门
     */
    @Column(name = "competent_depart")
    private String competentDepart;

    /**
     * 首次取得资质等级
     */
    @Column(name = "first_qualification_level")
    private String firstQualificationLevel;

    /**
     * 首次取得资质发证日期
     */
    @Column(name = "first_qualification_date")
    private Date firstQualificationDate;

    /**
     * 申请资质前单位进行过程
     */
    @Column(name = "qualification_process")
    private String qualificationProcess;

    /**
     * 组织机构代码
     */
    @Column(name = "organization_code")
    private String organizationCode;

    /**
     * 单位直属类型
     */
    @Column(name = "unit_type")
    private String unitType;

    /**
     * 单位用户编号
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 单位审核状态 0:通过 1:未通过 2:已提交 3:未提交
     */
    @Column(name = "audit_status")
    private Integer auditStatus;

    /**
     * 
单位代码
     */
    @Column(name = "unit_code")
    private String unitCode;

    /**
     * 1白名单2
黑名单3待定
     */
    @Column(name = "unit_status")
    private Integer unitStatus;

    /**
     * 同步状态 0：已同步 1：未同步
     */
    @Column(name = "synchronization_status")
    private Integer synchronizationStatus;

    /**
     * 单位分值 默认为100分 小于60分
进黑名单,大于等于100分进白名单
     */
    private Integer score;

    /**
     * 备案业务分类: 不动产测绘和联合测绘
     */
    @Column(name = "filing_business")
    private String filingBusiness;

    /**
     * 业务范围
     */
    @Column(name = "business_scope")
    private String businessScope;

    /**
     * 单位简介
     */
    @Column(name = "unit_intro")
    private String unitIntro;

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public void setOa(String oa) {
        this.oa = oa;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public void setOwnedDistrict(String ownedDistrict) {
        this.ownedDistrict = ownedDistrict;
    }

    public void setRegisterFund(Double registerFund) {
        this.registerFund = registerFund;
    }

    public void setSocialCreditCode(String socialCreditCode) {
        this.socialCreditCode = socialCreditCode;
    }

    public void setQualificationLevel(String qualificationLevel) {
        this.qualificationLevel = qualificationLevel;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    public void setUsedName(String usedName) {
        this.usedName = usedName;
    }

    public void setRegisterAddressLon(String registerAddressLon) {
        this.registerAddressLon = registerAddressLon;
    }

    public void setRegisterAddressLat(String registerAddressLat) {
        this.registerAddressLat = registerAddressLat;
    }

    public void setRegisterAddressPostcode(String registerAddressPostcode) {
        this.registerAddressPostcode = registerAddressPostcode;
    }

    public void setOaPostcode(String oaPostcode) {
        this.oaPostcode = oaPostcode;
    }

    public void setOaArea(Double oaArea) {
        this.oaArea = oaArea;
    }

    public void setEstablishTime(Date establishTime) {
        this.establishTime = establishTime;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setFaxNum(String faxNum) {
        this.faxNum = faxNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSurveyingNum(Integer surveyingNum) {
        this.surveyingNum = surveyingNum;
    }

    public void setStaffNum(Integer staffNum) {
        this.staffNum = staffNum;
    }

    public void setUnitNature(String unitNature) {
        this.unitNature = unitNature;
    }

    public void setBelongIndustry(String belongIndustry) {
        this.belongIndustry = belongIndustry;
    }

    public void setCertificateCode(String certificateCode) {
        this.certificateCode = certificateCode;
    }

    public void setCertificateSendDate(Date certificateSendDate) {
        this.certificateSendDate = certificateSendDate;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public void setStockDetails(String stockDetails) {
        this.stockDetails = stockDetails;
    }

    public void setJointVenture(String jointVenture) {
        this.jointVenture = jointVenture;
    }

    public void setJointChP(Integer jointChP) {
        this.jointChP = jointChP;
    }

    public void setJointRatifyCode(String jointRatifyCode) {
        this.jointRatifyCode = jointRatifyCode;
    }

    public void setCompetentDepart(String competentDepart) {
        this.competentDepart = competentDepart;
    }

    public void setFirstQualificationLevel(String firstQualificationLevel) {
        this.firstQualificationLevel = firstQualificationLevel;
    }

    public void setFirstQualificationDate(Date firstQualificationDate) {
        this.firstQualificationDate = firstQualificationDate;
    }

    public void setQualificationProcess(String qualificationProcess) {
        this.qualificationProcess = qualificationProcess;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public void setUnitStatus(Integer unitStatus) {
        this.unitStatus = unitStatus;
    }

    public void setSynchronizationStatus(Integer synchronizationStatus) {
        this.synchronizationStatus = synchronizationStatus;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setFilingBusiness(String filingBusiness) {
        this.filingBusiness = filingBusiness;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    public void setUnitIntro(String unitIntro) {
        this.unitIntro = unitIntro;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    /**
     * 坐标
     */

    private String coordinate;

    public Long getId() {
        return id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public String getMemo() {
        return memo;
    }

    public String getUnitName() {
        return unitName;
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public String getOa() {
        return oa;
    }

    public String getCorporation() {
        return corporation;
    }

    public String getLinkman() {
        return linkman;
    }

    public String getOwnedDistrict() {
        return ownedDistrict;
    }

    public Double getRegisterFund() {
        return registerFund;
    }

    public String getSocialCreditCode() {
        return socialCreditCode;
    }

    public String getQualificationLevel() {
        return qualificationLevel;
    }

    public String getPhone() {
        return phone;
    }

    public String getContactWay() {
        return contactWay;
    }

    public String getUsedName() {
        return usedName;
    }

    public String getRegisterAddressLon() {
        return registerAddressLon;
    }

    public String getRegisterAddressLat() {
        return registerAddressLat;
    }

    public String getRegisterAddressPostcode() {
        return registerAddressPostcode;
    }

    public String getOaPostcode() {
        return oaPostcode;
    }

    public Double getOaArea() {
        return oaArea;
    }

    public Date getEstablishTime() {
        return establishTime;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getFaxNum() {
        return faxNum;
    }

    public String getEmail() {
        return email;
    }

    public Integer getSurveyingNum() {
        return surveyingNum;
    }

    public Integer getStaffNum() {
        return staffNum;
    }

    public String getUnitNature() {
        return unitNature;
    }

    public String getBelongIndustry() {
        return belongIndustry;
    }

    public String getCertificateCode() {
        return certificateCode;
    }

    public Date getCertificateSendDate() {
        return certificateSendDate;
    }

    public String getCompanyType() {
        return companyType;
    }

    public String getStockDetails() {
        return stockDetails;
    }

    public String getJointVenture() {
        return jointVenture;
    }

    public Integer getJointChP() {
        return jointChP;
    }

    public String getJointRatifyCode() {
        return jointRatifyCode;
    }

    public String getCompetentDepart() {
        return competentDepart;
    }

    public String getFirstQualificationLevel() {
        return firstQualificationLevel;
    }

    public Date getFirstQualificationDate() {
        return firstQualificationDate;
    }

    public String getQualificationProcess() {
        return qualificationProcess;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public String getUnitType() {
        return unitType;
    }

    public Long getUserId() {
        return userId;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public Integer getUnitStatus() {
        return unitStatus;
    }

    public Integer getSynchronizationStatus() {
        return synchronizationStatus;
    }

    public Integer getScore() {
        return score;
    }

    public String getFilingBusiness() {
        return filingBusiness;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public String getUnitIntro() {
        return unitIntro;
    }

    public String getCoordinate() {
        return coordinate;
    }
}