package hello.world;

import com.thetradedesk.workflows.TtdWorkflows;
import com.thetradedesk.workflows.models.errors.ProblemDetailsException;
import com.thetradedesk.workflows.models.operations.GetCampaignIdVersionResponse;

import java.lang.Exception;

public class Main {

    public static void main(String[] args) throws ProblemDetailsException, Exception {

        TtdWorkflows sdk = TtdWorkflows.builder()
                .ttdAuth(System.getenv("WORKFLOWS_TTD_AUTH"))
                .build();

        GetCampaignIdVersionResponse res = sdk.campaign().getVersion()
                .id("001qobs")
                .call();

        if (res.campaignVersionWorkflow().isPresent()) {
            System.out.println(res.campaignVersionWorkflow().get());
        }
    }
}