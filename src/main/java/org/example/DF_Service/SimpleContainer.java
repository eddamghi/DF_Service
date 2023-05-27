package org.example.DF_Service;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class SimpleContainer {
    public static void main(String[] args) throws ControllerException {
        Runtime runtime = Runtime.instance();
        ProfileImpl profile = new ProfileImpl();
        profile.setParameter(Profile.MAIN_HOST, "localhost");
        AgentContainer agentContainer = runtime.createAgentContainer(profile);
        AgentController firstSeller  = agentContainer.createNewAgent("first seller", Seller.class.getName(), new Object[]{"13000"});
        AgentController secondSeller  = agentContainer.createNewAgent("second seller", Seller.class.getName(), new Object[]{"14000"});
        AgentController thirdSeller  = agentContainer.createNewAgent("third seller", Seller.class.getName(), new Object[]{"10000"});
        AgentController buyer  = agentContainer.createNewAgent("buyer", Buyer.class.getName(), new Object[]{});
        firstSeller.start();
        secondSeller.start();
        thirdSeller.start();
        buyer.start();

    }
}
