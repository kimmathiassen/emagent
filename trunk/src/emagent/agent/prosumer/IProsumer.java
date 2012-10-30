package emagent.agent.prosumer;

import emagent.agent.IAgent;

public interface IProsumer extends IAgent{

	/**
	 * 
	 * @return The amount of electricity consumed in one tick. Negative is production. 
	 */
	int getTotalConsumption();
	
	int payElectricalBill();
}