package eu.strasbourg.portlet.council.bean;

public class ProcurationBean {

    private String votant;
    private String procurationModeValue;
    private String presential;
    private  String officialVoterValue;
    private  String startTime;
    private  String startDelibValue;
    private  String endTime;
    private  String endDelibValue;

    public ProcurationBean(String votant, String procurationModeValue, String presential, String officialVoterValue,
                           String startTime, String startDelibValue, String endTime, String endDelibValue) {
        this.votant = votant;
        this.procurationModeValue = procurationModeValue;
        this.presential = presential;
        this.officialVoterValue = officialVoterValue;
        this.startTime = startTime;
        this.startDelibValue = startDelibValue;
        this.endTime = endTime;
        this.endDelibValue = endDelibValue;
    }

    public String getVotant() {
        return votant;
    }

    public String getProcurationModeValue() {
        return procurationModeValue;
    }

    public String getPresential() {
        return presential;
    }

    public String getOfficialVoterValue() {
        return officialVoterValue;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getStartDelibValue() {
        return startDelibValue;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getEndDelibValue() {
        return endDelibValue;
    }
}
