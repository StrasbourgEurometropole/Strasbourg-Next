package eu.strasbourg.portlet.search_asset_v2;

import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ResourceRequest;

public class SearchParameters {

    private String resourceID;
    private String keywords = null;
    private int startDay = -1;
    private String startMonth;
    private int startYear = -1;
    private int endDay = -1;
    private String endMonth;
    private int endYear = -1;
    private long[] states = new long[]{};
    private long[] statuts = new long[]{};
    private long[] bpStatus = new long[]{};
    private long[] initiativeStatus = new long[]{};
    private long[] helpProposalActivityStatus = new long[]{};
    private long[] helpProposalTypes = new long[]{};
    private long[] localisations = new long[]{};
    private long[] projects = new long[]{};
    private long[] districts = new long[]{};
    private long[] thematics = new long[]{};
    private long[] types = new long[]{};
    private String selectedAllCategories;
    private String sortFieldAndType;
    private int start = -1;
    private int end = -1;

    public SearchParameters(ResourceRequest request) {
        this.resourceID = request.getResourceID();

        switch (resourceID) {
            case "entrySelectionVideo":
                initCommonParams(request);
                projects = ParamUtil.getLongValues(request, "selectedProject");
                districts = ParamUtil.getLongValues(request, "selectedDistricts");
                thematics = ParamUtil.getLongValues(request, "selectedThematics");
                setPaginationParams(request);
                break;

            case "entrySelectionProject":
                initCommonParams(request);
                statuts = ParamUtil.getLongValues(request, "selectedStatut");
                districts = ParamUtil.getLongValues(request, "selectedDistricts");
                thematics = ParamUtil.getLongValues(request, "selectedThematics");
                setPaginationParams(request);

            case "entrySelectionParticipation":
                initCommonParams(request);
                states = ParamUtil.getLongValues(request, "selectedStates");
                districts = ParamUtil.getLongValues(request, "selectedDistricts");
                thematics = ParamUtil.getLongValues(request, "selectedThematics");
                types = ParamUtil.getLongValues(request, "selectedTypes");
                setPaginationParams(request);
                break;

            case "entrySelectionAgenda":
                initCommonParams(request);
                projects = ParamUtil.getLongValues(request, "selectedProject");
                districts = ParamUtil.getLongValues(request, "selectedDistricts");
                thematics = ParamUtil.getLongValues(request, "selectedThematics");
                setPaginationParams(request);
                break;

            case "entrySelectionPetition":
                initCommonParams(request);
                states = ParamUtil.getLongValues(request, "selectedStates");
                districts = ParamUtil.getLongValues(request, "selectedDistricts");
                thematics = ParamUtil.getLongValues(request, "selectedThematics");
                setPaginationParams(request);
                break;

            case "entrySelectionSaisineObservatoire":
                initCommonParams(request);
                states = ParamUtil.getLongValues(request, "selectedStates");
                projects = ParamUtil.getLongValues(request, "selectedProject");
                districts = ParamUtil.getLongValues(request, "selectedDistricts");
                thematics = ParamUtil.getLongValues(request, "selectedThematics");
                break;

            case "entrySelectionBudgetParticipatif":
                initCommonParams(request);
                bpStatus = ParamUtil.getLongValues(request, "selectedBPStatus");
                districts = ParamUtil.getLongValues(request, "selectedDistricts");
                thematics = ParamUtil.getLongValues(request, "selectedThematics");
                setPaginationParams(request);
                break;

            case "entrySelectionInitiative":
                initCommonParams(request);
                initiativeStatus = ParamUtil.getLongValues(request, "selectedInitiativeStatus");
                districts = ParamUtil.getLongValues(request, "selectedDistricts");
                thematics = ParamUtil.getLongValues(request, "selectedThematics");
                setPaginationParams(request);
                break;

            case "entrySelectionNews":
                initCommonParams(request);
                states = ParamUtil.getLongValues(request, "selectedStates");
                districts = ParamUtil.getLongValues(request, "selectedDistricts");
                thematics = ParamUtil.getLongValues(request, "selectedThematics");
                setPaginationParams(request);
                break;

            case "entrySelectionProjectWorkshop":
                initCommonParams(request);
                states = ParamUtil.getLongValues(request, "selectedStates");
                districts = ParamUtil.getLongValues(request, "selectedDistricts");
                thematics = ParamUtil.getLongValues(request, "selectedThematics");
                setPaginationParams(request);
                break;

            case "entrySelectionMuseum":
                initCommonParams(request);
                selectedAllCategories = ParamUtil.getString(request, "selectedAllCategories");
                start = ParamUtil.getInteger(request, "start");
                end = ParamUtil.getInteger(request, "end");
                break;

            default:
                // Handle unknown resource ID if necessary
                break;
        }
    }

    private void initCommonParams(ResourceRequest request) {
        keywords = ParamUtil.getString(request, "selectedKeyWords", null);
        startDay = ParamUtil.getInteger(request, "selectedStartDay", -1);
        startMonth = ParamUtil.getString(request, "selectedStartMonth", null);
        startYear = ParamUtil.getInteger(request, "selectedStartYear", -1);
        endDay = ParamUtil.getInteger(request, "selectedEndDay", -1);
        endMonth = ParamUtil.getString(request, "selectedEndMonth", null);
        endYear = ParamUtil.getInteger(request, "selectedEndYear", -1);
    }

    private void setPaginationParams(ResourceRequest request) {
        int delta = ParamUtil.getInteger(request, "delta", -1);
        start = ParamUtil.getInteger(request, "start", -1);
        if(delta != -1) {
            end = start + delta;
        }
    }

    // Getters and Setters
    public String getResourceID() { return resourceID; }
    public void setResourceID(String resourceID) { this.resourceID = resourceID; }

    public String getKeywords() { return keywords; }
    public void setKeywords(String keywords) { this.keywords = keywords; }

    public int getStartDay() { return startDay; }
    public void setStartDay(int startDay) { this.startDay = startDay; }

    public String getStartMonth() { return startMonth; }
    public void setStartMonth(String startMonth) { this.startMonth = startMonth; }

    public int getStartYear() { return startYear; }
    public void setStartYear(int startYear) { this.startYear = startYear; }

    public int getEndDay() { return endDay; }
    public void setEndDay(int endDay) { this.endDay = endDay; }

    public String getEndMonth() { return endMonth; }
    public void setEndMonth(String endMonth) { this.endMonth = endMonth; }

    public int getEndYear() { return endYear; }
    public void setEndYear(int endYear) { this.endYear = endYear; }

    public long[] getStates() { return states; }
    public void setStates(long[] states) { this.states = states; }

    public long[] getStatuts() { return statuts; }
    public void setStatuts(long[] statuts) { this.statuts = statuts; }

    public long[] getBpStatus() { return bpStatus; }
    public void setBpStatus(long[] bpStatus) { this.bpStatus = bpStatus; }

    public long[] getInitiativeStatus() { return initiativeStatus; }
    public void setInitiativeStatus(long[] initiativeStatus) { this.initiativeStatus = initiativeStatus; }

    public long[] getHelpProposalActivityStatus() { return helpProposalActivityStatus; }
    public void setHelpProposalActivityStatus(long[] helpProposalActivityStatus) { this.helpProposalActivityStatus = helpProposalActivityStatus; }

    public long[] getHelpProposalTypes() { return helpProposalTypes; }
    public void setHelpProposalTypes(long[] helpProposalTypes) { this.helpProposalTypes = helpProposalTypes; }

    public long[] getLocalisations() { return localisations; }
    public void setLocalisations(long[] localisations) { this.localisations = localisations; }

    public long[] getProjects() { return projects; }
    public void setProjects(long[] projects) { this.projects = projects; }

    public long[] getDistricts() { return districts; }
    public void setDistricts(long[] districts) { this.districts = districts; }

    public long[] getThematics() { return thematics; }
    public void setThematics(long[] thematics) { this.thematics = thematics; }

    public long[] getTypes() { return types; }
    public void setTypes(long[] types) { this.types = types; }

    public String getSelectedAllCategories() { return selectedAllCategories; }
    public void setSelectedAllCategories(String selectedAllCategories) { this.selectedAllCategories = selectedAllCategories; }

    public String getSortFieldAndType() { return sortFieldAndType; }
    public void setSortFieldAndType(String sortFieldAndType) { this.sortFieldAndType = sortFieldAndType; }

    public int getStart() { return start; }
    public void setStart(int start) { this.start = start; }

    public int getEnd() { return end; }
    public void setEnd(int end) { this.end = end; }
}