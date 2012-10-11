package emagent.agent;

import java.util.Collection;



public interface IMarket extends IAgent {
	public void subscribeToAuctions(IBrp l);
	
	public  void unsubscribeToAuctions(IBrp l);


	public void notifyTick(int newTick) throws Exception;

	public abstract void startRound() throws Exception;

	Collection<IBrp> getAuctionListeners();

}
