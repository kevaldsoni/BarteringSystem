package beans;

public class BarterPostPojo {
	
	private int reqId;
	
	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	private String title;
	
	private int offeringCatId;
	
	private String itemOfferedDesc;
	
	private int expectedCatId;
	
	private String expectedItemDesc;
	
	private String itemImage;
	
	private String tradeContact;
	
	private int userId;


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getOfferingCatId() {
		return offeringCatId;
	}

	public void setOfferingCatId(int offeringCatId) {
		this.offeringCatId = offeringCatId;
	}

	public String getItemOfferedDesc() {
		return itemOfferedDesc;
	}

	public void setItemOfferedDesc(String itemOfferedDesc) {
		this.itemOfferedDesc = itemOfferedDesc;
	}

	public int getExpectedCatId() {
		return expectedCatId;
	}

	public void setExpectedCatId(int expectedCatId) {
		this.expectedCatId = expectedCatId;
	}

	public String getExpectedItemDesc() {
		return expectedItemDesc;
	}

	public void setExpectedItemDesc(String expectedItemDesc) {
		this.expectedItemDesc = expectedItemDesc;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public String getTradeContact() {
		return tradeContact;
	}

	public void setTradeContact(String tradeContact) {
		this.tradeContact = tradeContact;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	

}
