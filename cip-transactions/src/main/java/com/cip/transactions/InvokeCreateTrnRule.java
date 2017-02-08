package com.cip.transactions;

import org.drools.core.command.impl.ExecutableCommand;
import org.drools.core.command.runtime.BatchExecutionCommandImpl;
import org.kie.api.runtime.ExecutionResults;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.KieContainerResource;
import org.kie.server.api.model.KieContainerStatus;
import org.kie.server.api.model.ReleaseId;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.RuleServicesClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by swang on 08/02/17.
 */
public class InvokeCreateTrnRule {

    private KieServicesClient kieServicesClient = null;

    private KieServicesClient getKieServicesClient() {
        if (kieServicesClient == null) {
            String serverUrl = "http://localhost:8230/kie-server/services/rest/server";
            String user = "kieserver";
            String password = "kieserver1!";
            KieServicesConfiguration configuration = KieServicesFactory.newRestConfiguration(serverUrl, user, password);
            configuration.setMarshallingFormat(MarshallingFormat.XSTREAM);
            kieServicesClient = KieServicesFactory.newKieServicesClient(configuration);
        }
        final String containerID = "ciptransactions";
        final ServiceResponse<KieContainerResource> containerInfo = kieServicesClient.getContainerInfo(containerID);
        if (containerInfo==null || containerInfo.getType() == ServiceResponse.ResponseType.FAILURE) {
            final KieContainerResource kieContainerResource = new KieContainerResource(containerID, new ReleaseId("com.sw.drools", "cip-transactions", "1.0.0"));
            kieServicesClient.createContainer(containerID, kieContainerResource);
        }
        return kieServicesClient;
    }

    public void invokeRuleCreateAdjustmentTrn() {
        System.out.println("\n This is the GDST working--R - Create Client Adjustments" );
        List<ExecutableCommand<?>> commands = new ArrayList<ExecutableCommand<?>>();
        BatchExecutionCommandImpl executionCommand = new BatchExecutionCommandImpl(commands);
        executionCommand.setLookup("defaultStatelessKieSession");
        BusinessProcess businessProcess = new BusinessProcess();
        businessProcess.setCode("CLTADJ");
        TransactionUI trnUI = new TransactionUI();
        trnUI.setAction("Editing");
        ClientData clientData = new ClientData();
        clientData.setAccountTypeCode("PV");
        GroupData groupData = new GroupData();
        groupData.setUCode("SYSADMIN");
        ErrorMessage errorMessage = new ErrorMessage();
        org.drools.core.command.runtime.rule.InsertObjectCommand bpCommand = new org.drools.core.command.runtime.rule.InsertObjectCommand(businessProcess);
        org.drools.core.command.runtime.rule.InsertObjectCommand trnCommand = new org.drools.core.command.runtime.rule.InsertObjectCommand(trnUI, "UI");
        org.drools.core.command.runtime.rule.InsertObjectCommand clientCommand = new org.drools.core.command.runtime.rule.InsertObjectCommand(clientData);
        org.drools.core.command.runtime.rule.InsertObjectCommand grpCommand = new org.drools.core.command.runtime.rule.InsertObjectCommand(groupData);
        org.drools.core.command.runtime.rule.InsertObjectCommand errorCommand = new org.drools.core.command.runtime.rule.InsertObjectCommand(errorMessage, "ERR");
        commands.add(bpCommand);
        commands.add(trnCommand);
        commands.add(clientCommand);
        commands.add(grpCommand);
        commands.add(errorCommand);
        org.drools.core.command.runtime.rule.FireAllRulesCommand fireAllRulesCommand = new org.drools.core.command.runtime.rule.FireAllRulesCommand();
        commands.add(fireAllRulesCommand);
        RuleServicesClient ruleClient = getKieServicesClient().getServicesClient(RuleServicesClient.class);
        final ServiceResponse<ExecutionResults> executionResults = ruleClient.executeCommandsWithResults("ciptransactions", executionCommand);
        final TransactionUI ui = (TransactionUI)executionResults.getResult().getValue("UI");
        final boolean isRightRuleInvoked = ui.getTransTypeField() != null && ui.getTransTypeField().equals("Mandatory");
        System.out.println("\tIs CLTADJ invoked correctly? "+ isRightRuleInvoked );

        System.out.println("\tCLTADJ Rules executed"+ ui);
    }

    public void invokeRuleCreateDepotTrn() {
        System.out.println("\n This is the GDST not working--R - Create Depot Transaction" );

        List<ExecutableCommand<?>> commands = new ArrayList<ExecutableCommand<?>>();
        BatchExecutionCommandImpl executionCommand = new BatchExecutionCommandImpl(commands);
        executionCommand.setLookup("defaultStatelessKieSession");
        BusinessProcess businessProcess = new BusinessProcess();
        businessProcess.setCode("BP_CREATEDEPOTTRN");
        TransactionUI trnUI = new TransactionUI();
        trnUI.setAction("Creating");
        GroupData groupData = new GroupData();
        groupData.setUCode("SYSADMIN");
        org.drools.core.command.runtime.rule.InsertObjectCommand bpCommand = new org.drools.core.command.runtime.rule.InsertObjectCommand(businessProcess);
        org.drools.core.command.runtime.rule.InsertObjectCommand trnCommand = new org.drools.core.command.runtime.rule.InsertObjectCommand(trnUI, "UI");
        org.drools.core.command.runtime.rule.InsertObjectCommand grpCommand = new org.drools.core.command.runtime.rule.InsertObjectCommand(groupData);
        commands.add(bpCommand);
        commands.add(trnCommand);
        commands.add(grpCommand);
        org.drools.core.command.runtime.rule.FireAllRulesCommand fireAllRulesCommand = new org.drools.core.command.runtime.rule.FireAllRulesCommand();
        commands.add(fireAllRulesCommand);
        RuleServicesClient ruleClient = getKieServicesClient().getServicesClient(RuleServicesClient.class);
        final ServiceResponse<ExecutionResults> executionResults = ruleClient.executeCommandsWithResults("ciptransactions", executionCommand);
        final TransactionUI ui = (TransactionUI)executionResults.getResult().getValue("UI");
        final boolean isRightRuleInvoked = ui.getTransTypeField() != null && ui.getTransTypeField().equals("Mandatory");
        System.out.println("\tBP_CREATEDEPOTTRN Rules executed"+ ui );
        System.out.println("\tIs BP_CREATEDEPOTTRN invoked correctly? "+ isRightRuleInvoked );
    }

    public static void main(String[] args) {
        InvokeCreateTrnRule instance = new InvokeCreateTrnRule();
        instance.invokeRuleCreateAdjustmentTrn();
        instance.invokeRuleCreateDepotTrn();
    }
}
