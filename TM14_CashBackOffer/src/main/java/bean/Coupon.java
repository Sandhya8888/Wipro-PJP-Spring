package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Coupon")
public class Coupon {
	@Id
	private String CouponCode;
	@Column
	private int OfferPercentage;
	public String getCouponCode() {
		return CouponCode;
	}
	public void setCouponCode(String couponCode) {
		CouponCode = couponCode;
	}
	public int getOfferPercentage() {
		return OfferPercentage;
	}
	public void setOfferPercentage(int offerPercentage) {
		OfferPercentage = offerPercentage;
	}
}
