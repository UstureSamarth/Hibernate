package in.app.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "bank_account")
public class BankAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accNo;

	@Column(length = 20)
	private String holderName;

	private Double balance;

	@Column(length = 20)
	private String type;

	@CreationTimestamp
	private LocalDateTime openingDate;

	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;

	public BankAccount() {

	}

	public BankAccount(Long accNo, String holderName, Double balance, String type) {
		super();
		this.accNo = accNo;
		this.holderName = holderName;
		this.balance = balance;
		this.type = type;
	}

	public Long getAccNo() {
		return accNo;
	}

	public void setAccNo(Long accNo) {
		this.accNo = accNo;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDateTime getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(LocalDateTime openingDate) {
		this.openingDate = openingDate;
	}

	public LocalDateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	@Override
	public String toString() {
		return "BankAccount [accNo=" + accNo + ", holderName=" + holderName + ", balance=" + balance + ", type=" + type
				+ ", openingDate=" + openingDate + ", lastUpdatedDate=" + lastUpdatedDate + "]";
	}

}
