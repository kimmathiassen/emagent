package emagent.auction;

import java.util.Stack;

import emagent.agent.brp.IBrp;


public abstract class Auction implements IAuction{
	protected long quantity;
	protected long startingPrice;
	protected AuctionStatus status;
	protected IBrp seller;
	protected Stack<IBid> bids;
	protected IAuctionResult result;
	private boolean bidAdded = false;
	
	public Auction(long electricalAmount, long startingPrice2, IBrp seller)
	{
		this.quantity = electricalAmount;
		this.startingPrice = startingPrice2;
		this.seller = seller;
		status = AuctionStatus.CREATED;
		bids = new Stack<IBid>();
	}

	public boolean addBid(IBid e) throws Exception {
		if(status != AuctionStatus.POSTED)
		{
			throw new Exception("Auction has not yet been posted");
		}
		if(!verifyBid(e))
		{
			return false;
		}
		bidAdded = true;
		return bids.add(e);
	}
	
	abstract boolean verifyBid(IBid bid);

	public AuctionStatus getStatus() {
		return status;
	}

	public void setStatus(AuctionStatus status) {
		this.status = status;
	}

	public long getQuantity() {
		return quantity;
	}

	public long getStartingPrice() {
		return startingPrice;
	}

	public IBrp getSeller() {
		return seller;
	}

	public Stack<IBid> getBids() {
		return bids;
	}
	
	@Override
	public void close() {
		status = AuctionStatus.DONE;
	}

	
	@Override
	public void newBiddingRound() {
		this.bidAdded = false;
	}

	@Override
	public boolean bidAdded() {
		return bidAdded;
	}
}
