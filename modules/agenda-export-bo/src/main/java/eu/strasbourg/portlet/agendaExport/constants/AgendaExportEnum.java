package eu.strasbourg.portlet.agendaExport.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum AgendaExportEnum {
    TYPE(0, "TYPE"),
    VOCABULARY(1, "VOCABULARY"),
    CATEGORY(2, "CATEGORY"),
    CATEGORYFILTER(3, "CATEGORYFILTER");

    private long id;
    private String name;

    AgendaExportEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static AgendaExportEnum get(long id) {
        for (AgendaExportEnum agendaExportEnum : values()) {
            if (agendaExportEnum.getId() == id) {
                return agendaExportEnum;
            }
        }
        return null;
    }

    public static List<AgendaExportEnum> getAll() {
        List<AgendaExportEnum> agendaExportEnum = new ArrayList<AgendaExportEnum>();
        agendaExportEnum.addAll(Arrays.asList(values()));
        return agendaExportEnum;
    }

}
