package src.entity.com;

import java.util.Date;

public class Account
{
	private String holderName;
	private Date expirationDate;
	private int accountNumber;
	private Double balance;
	public Account(String holderName,Date expirationDate,int accountNumber,Double balance)
	{
		this.holderName = holderName;
		this.expirationDate = expirationDate;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	public Account()
	{
		this.holderName = "";
		this.expirationDate = new Date();
		this.accountNumber = 0;
		this.balance = -1D;
	}
	Account(Account accountDetail)
	{
		Account newAccount = new Account();
		newAccount.accountNumber = accountDetail.getAccountNumber();
		newAccount.balance = new Double(accountDetail.getBalance());
		newAccount.expirationDate = new Date(accountDetail.getExpirationDate().getTime()); 
		newAccount.holderName = new String(accountDetail.getHolderName());
	}
	public String getHolderName() {
		return holderName; 
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
}
