package com.study.buyPlan.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author chengyin
 * @since 2017-12-05
 */
@TableName("buy_plan_item_temp")
public class BuyPlanItemTemp extends Model<BuyPlanItemTemp> {

    private static final long serialVersionUID = 1L;

	@TableId(value="buyPlanItemId", type= IdType.AUTO)
	private Integer buyPlanItemId;
	private String buyPlanId;
	private Integer directoryId;
	private Integer goodsId;
	private String commonName;
	private String goodsSpec;
	private String goodsUtil;
	private String goodsFactory;
	private Integer userBuyerId;
	private Integer userSupperId;
	private String userSupperName;
	private BigDecimal goodsPrice;
	private BigDecimal planNum;
	private BigDecimal itemAmount;
	private Integer createUserId;
	private Date createDate;
	private BigDecimal monthUsed;
	private BigDecimal storageNum;
	private BigDecimal sellPrice;
	private String lastNo;
	private String remark;


	public Integer getBuyPlanItemId() {
		return buyPlanItemId;
	}

	public void setBuyPlanItemId(Integer buyPlanItemId) {
		this.buyPlanItemId = buyPlanItemId;
	}

	public String getBuyPlanId() {
		return buyPlanId;
	}

	public void setBuyPlanId(String buyPlanId) {
		this.buyPlanId = buyPlanId;
	}

	public Integer getDirectoryId() {
		return directoryId;
	}

	public void setDirectoryId(Integer directoryId) {
		this.directoryId = directoryId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getGoodsSpec() {
		return goodsSpec;
	}

	public void setGoodsSpec(String goodsSpec) {
		this.goodsSpec = goodsSpec;
	}

	public String getGoodsUtil() {
		return goodsUtil;
	}

	public void setGoodsUtil(String goodsUtil) {
		this.goodsUtil = goodsUtil;
	}

	public String getGoodsFactory() {
		return goodsFactory;
	}

	public void setGoodsFactory(String goodsFactory) {
		this.goodsFactory = goodsFactory;
	}

	public Integer getUserBuyerId() {
		return userBuyerId;
	}

	public void setUserBuyerId(Integer userBuyerId) {
		this.userBuyerId = userBuyerId;
	}

	public Integer getUserSupperId() {
		return userSupperId;
	}

	public void setUserSupperId(Integer userSupperId) {
		this.userSupperId = userSupperId;
	}

	public String getUserSupperName() {
		return userSupperName;
	}

	public void setUserSupperName(String userSupperName) {
		this.userSupperName = userSupperName;
	}

	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public BigDecimal getPlanNum() {
		return planNum;
	}

	public void setPlanNum(BigDecimal planNum) {
		this.planNum = planNum;
	}

	public BigDecimal getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(BigDecimal itemAmount) {
		this.itemAmount = itemAmount;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public BigDecimal getMonthUsed() {
		return monthUsed;
	}

	public void setMonthUsed(BigDecimal monthUsed) {
		this.monthUsed = monthUsed;
	}

	public BigDecimal getStorageNum() {
		return storageNum;
	}

	public void setStorageNum(BigDecimal storageNum) {
		this.storageNum = storageNum;
	}

	public BigDecimal getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getLastNo() {
		return lastNo;
	}

	public void setLastNo(String lastNo) {
		this.lastNo = lastNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	protected Serializable pkVal() {
		return this.buyPlanItemId;
	}

	@Override
	public String toString() {
		return "BuyPlanItemTemp{" +
			"buyPlanItemId=" + buyPlanItemId +
			", buyPlanId=" + buyPlanId +
			", directoryId=" + directoryId +
			", goodsId=" + goodsId +
			", commonName=" + commonName +
			", goodsSpec=" + goodsSpec +
			", goodsUtil=" + goodsUtil +
			", goodsFactory=" + goodsFactory +
			", userBuyerId=" + userBuyerId +
			", userSupperId=" + userSupperId +
			", userSupperName=" + userSupperName +
			", goodsPrice=" + goodsPrice +
			", planNum=" + planNum +
			", itemAmount=" + itemAmount +
			", createUserId=" + createUserId +
			", createDate=" + createDate +
			", monthUsed=" + monthUsed +
			", storageNum=" + storageNum +
			", sellPrice=" + sellPrice +
			", lastNo=" + lastNo +
			", remark=" + remark +
			"}";
	}
}
