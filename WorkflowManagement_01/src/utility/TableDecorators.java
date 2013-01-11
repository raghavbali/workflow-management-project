package utility;

import model.WorkflowMaster;

import org.displaytag.decorator.TableDecorator;

public class TableDecorators extends TableDecorator {

	public String getStageModLink() {
		WorkflowMaster row = (WorkflowMaster) getCurrentRowObject();
		return "<a href=\"stage_mod.action?workflowID=" + row.getWorkflowID()
				+ "&amp;pageName=workflow_list\">Stage Modification</a>";
	}
	
	public String getWfModLink() {
		WorkflowMaster row = (WorkflowMaster) getCurrentRowObject();
		return "<a href=\"edit_wf.action?workflowID=" + row.getWorkflowID()
				+ "\">Workflow Modification</a>";
	}

}
