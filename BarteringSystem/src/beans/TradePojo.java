package beans;

import java.util.Date;

public class TradePojo {
	
	private int tradeId;
	
	private int primaryReqId;
	
	private int secReqId;
	
	private String requestStatus;
	
	private int primaryUserRating;
	
	private int secUserRating;
	
	private int primaryTraderUserId;
	
	private int secTraderUserId;
	
	private int tradePrimRate;
	
	private int tradeSecRate;
	
	public int getTradePrimRate() {
		return tradePrimRate;
	}

	public void setTradePrimRate(int tradePrimRate) {
		this.tradePrimRate = tradePrimRate;
	}

	public int getTradeSecRate() {
		return tradeSecRate;
	}

	public void setTradeSecRate(int tradeSecRate) {
		this.tradeSecRate = tradeSecRate;
	}

	public int getSecTraderUserId() {
		return secTraderUserId;
	}

	public void setSecTraderUserId(int secTraderUserId) {
		this.secTraderUserId = secTraderUserId;
	}

	private Date tradeStatusTime;

	public Date getTradeStatusTime() {
		return tradeStatusTime;
	}

	public void setTradeStatusTime(Date tradeStatusTime) {
		this.tradeStatusTime = tradeStatusTime;
	}

	public int getPrimaryTraderUserId() {
		return primaryTraderUserId;
	}

	public void setPrimaryTraderUserId(int primaryTraderUserId) {
		this.primaryTraderUserId = primaryTraderUserId;
	}

	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	public int getPrimaryReqId() {
		return primaryReqId;
	}

	public void setPrimaryReqId(int primaryReqId) {
		this.primaryReqId = primaryReqId;
	}

	public int getSecReqId() {
		return secReqId;
	}

	public void setSecReqId(int secReqId) {
		this.secReqId = secReqId;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public int getPrimaryUserRating() {
		return primaryUserRating;
	}

	public void setPrimaryUserRating(int primaryUserRating) {
		this.primaryUserRating = primaryUserRating;
	}

	public int getSecUserRating() {
		return secUserRating;
	}

	public void setSecUserRating(int secUserRating) {
		this.secUserRating = secUserRating;
	}

}
