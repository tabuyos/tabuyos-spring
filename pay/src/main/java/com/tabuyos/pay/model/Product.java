package com.tabuyos.pay.model;

import com.alipay.easysdk.payment.huabei.models.HuabeiConfig;

import java.util.Map;

/**
 * @Author Tabuyos
 * @Time 2020/7/2 9:48
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class Product{

	private String subject;
	private String outTradeNo;
	private String buyerId;
	private String refundAmount;
	private String outRequestNo;
	private String billType;
	private String billDate;
	private Map<String, String> parameters;
	private String totalAmount;
	private HuabeiConfig extendParams;
	private String authCode;
	private String returnUrl;
	private String quitUrl;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getOutRequestNo() {
		return outRequestNo;
	}

	public void setOutRequestNo(String outRequestNo) {
		this.outRequestNo = outRequestNo;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public HuabeiConfig getExtendParams() {
		return extendParams;
	}

	public void setExtendParams(HuabeiConfig extendParams) {
		this.extendParams = extendParams;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getQuitUrl() {
		return quitUrl;
	}

	public void setQuitUrl(String quitUrl) {
		this.quitUrl = quitUrl;
	}

	@Override
	public String toString() {
		return "Product{" +
				"subject='" + subject + '\'' +
				", outTradeNo='" + outTradeNo + '\'' +
				", buyerId='" + buyerId + '\'' +
				", refundAmount='" + refundAmount + '\'' +
				", outRequestNo='" + outRequestNo + '\'' +
				", billType='" + billType + '\'' +
				", billDate='" + billDate + '\'' +
				", parameters=" + parameters +
				", totalAmount='" + totalAmount + '\'' +
				", extendParams=" + extendParams +
				", authCode='" + authCode + '\'' +
				", returnUrl='" + returnUrl + '\'' +
				", quitUrl='" + quitUrl + '\'' +
				'}';
	}

	public static Builder create() {
		return new Builder();
	}

	public static final class Builder {
		private String subject;
		private String outTradeNo;
		private String buyerId;
		private String refundAmount;
		private String outRequestNo;
		private String billType;
		private String billDate;
		private Map<String, String> parameters;
		private String totalAmount;
		private HuabeiConfig extendParams;
		private String authCode;
		private String returnUrl;
		private String quitUrl;

		private Builder() {
		}

		public Builder subject(String subject) {
			this.subject = subject;
			return this;
		}

		public Builder outTradeNo(String outTradeNo) {
			this.outTradeNo = outTradeNo;
			return this;
		}

		public Builder buyerId(String buyerId) {
			this.buyerId = buyerId;
			return this;
		}

		public Builder refundAmount(String refundAmount) {
			this.refundAmount = refundAmount;
			return this;
		}

		public Builder outRequestNo(String outRequestNo) {
			this.outRequestNo = outRequestNo;
			return this;
		}

		public Builder billType(String billType) {
			this.billType = billType;
			return this;
		}

		public Builder billDate(String billDate) {
			this.billDate = billDate;
			return this;
		}

		public Builder parameters(Map<String, String> parameters) {
			this.parameters = parameters;
			return this;
		}

		public Builder totalAmount(String totalAmount) {
			this.totalAmount = totalAmount;
			return this;
		}

		public Builder extendParams(HuabeiConfig extendParams) {
			this.extendParams = extendParams;
			return this;
		}

		public Builder authCode(String authCode) {
			this.authCode = authCode;
			return this;
		}

		public Builder returnUrl(String returnUrl) {
			this.returnUrl = returnUrl;
			return this;
		}

		public Builder quitUrl(String quitUrl) {
			this.quitUrl = quitUrl;
			return this;
		}

		public Product build() {
			Product product = new Product();
			product.setSubject(subject);
			product.setOutTradeNo(outTradeNo);
			product.setBuyerId(buyerId);
			product.setRefundAmount(refundAmount);
			product.setOutRequestNo(outRequestNo);
			product.setBillType(billType);
			product.setBillDate(billDate);
			product.setParameters(parameters);
			product.setTotalAmount(totalAmount);
			product.setExtendParams(extendParams);
			product.setAuthCode(authCode);
			product.setReturnUrl(returnUrl);
			product.setQuitUrl(quitUrl);
			return product;
		}
	}
}
