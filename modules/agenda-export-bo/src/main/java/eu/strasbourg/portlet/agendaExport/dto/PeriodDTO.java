package eu.strasbourg.portlet.agendaExport.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import eu.strasbourg.portlet.agendaExport.JSONAdapter.LocalDateDeserializer;
import eu.strasbourg.portlet.agendaExport.JSONAdapter.LocalDateSerializer;
import eu.strasbourg.portlet.agendaExport.XMLAdapter.DateAdapter;
import eu.strasbourg.service.agenda.model.EventPeriod;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@XmlRootElement(name = "period")
@XmlAccessorType(XmlAccessType.FIELD)
public class PeriodDTO {

    @XmlElement(name = "startDate")
    @XmlJavaTypeAdapter(DateAdapter.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate startDate;

    @XmlElement(name = "endDate")
    @XmlJavaTypeAdapter(DateAdapter.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate endDate;

    @XmlTransient
    private String initialSchedule;

    @XmlElement(name = "schedule")
    private String schedule;

    @XmlElement(name = "beginHour")
    private String beginHour;

    @XmlElement(name = "endHour")
    private String endHour;

    public PeriodDTO() {}

    public PeriodDTO(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public PeriodDTO(EventPeriod period, Locale locale) {
        this.startDate = period.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.endDate = period.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.schedule = period.getTimeDetail(locale);
        this.initialSchedule = schedule;
        this.setHours();
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    @JsonIgnore
    public String getInitialSchedule() {
        return initialSchedule;
    }

    public void setInitialSchedule(String initialSchedule) {
        this.initialSchedule = initialSchedule;
    }

    @JsonIgnore
    public String getBeginHour() {
        return beginHour;
    }

    public void setBeginHour(String beginHour) {
        this.beginHour = beginHour;
    }

    @JsonIgnore
    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    /**
     * Récupération de l'horaire de l'évenement, formaté
     * @return String
     */
    public String getFormattedSchedule() {
        String formatted;

        if(schedule == null) {
            return "";
        }

        formatted = schedule.replace(" ", "").toLowerCase();
        return formatted;
    }

    private Matcher getRegexMatcherOnFormattedSchedule() {
        String stringPattern = "([1-9]|([01]\\d|2[0-3]))h([0-5]\\d)?";
        Pattern pattern = Pattern.compile(stringPattern);
        return pattern.matcher(this.getFormattedSchedule());
    }

    public boolean scheduleHasValidFormat() {
        Matcher matcher = getRegexMatcherOnFormattedSchedule();
        return matcher.find();
    }

    /**
     * Renvoit la sous chaine qui respecte la regex
     * @return String
     */
    public String getMatchedScheduleFromString() {

        Matcher match = getRegexMatcherOnFormattedSchedule();

        if(match.find()) {
            return match.group(0);
        }

        return "";
    }

    /**
     *
     * @param period another PeriodDTO instance
     * @return boolean
     */
    public boolean isScheduleAfter(PeriodDTO period) {
        LocalTime currentTime = this.scheduleToLocalTime();
        LocalTime otherTime = period.scheduleToLocalTime();

        if(currentTime == null || otherTime == null) {
            return false;
        }

        if(currentTime.isAfter(otherTime)) {
            return true;
        }

        return false;
    }

    /**
     * Convertis le schedule vers une instance localTime
     * @return
     */
    public LocalTime scheduleToLocalTime() {

        if(this.scheduleHasValidFormat()) {
            String schedule = getMatchedScheduleFromString().toLowerCase();

            if(schedule != "") {

                String[] splitted = schedule.split("h");

                //Rajout d'un zéro au début si nécessaire
                if(splitted[0].length() == 1) { schedule = "0" + schedule; }

                //Rajout de deux zéro à la fin si nécessaire
                if(splitted.length < 2) { schedule += "00"; }

                schedule = schedule.replace("h", ":");
                return LocalTime.parse(schedule);
            }
        }

        return null;
    }

    /**
     * Rajoute les heures de début et de fin en fonction du champ schedule
     */
    public void setHours() {

        if(this.scheduleHasValidFormat()) {

            String[] hours = this.getFormattedSchedule().split("-");
            this.beginHour = hours[0];

            if(hours.length == 2 && hours[1] != null) {
                this.endHour = hours[1];
            }
        }
    }
}
