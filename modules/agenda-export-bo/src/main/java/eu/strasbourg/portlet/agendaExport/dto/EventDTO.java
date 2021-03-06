package eu.strasbourg.portlet.agendaExport.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.portal.kernel.util.HtmlUtil;
import eu.strasbourg.portlet.agendaExport.JSONAdapter.LocalDateDeserializer;
import eu.strasbourg.portlet.agendaExport.JSONAdapter.LocalDateSerializer;
import eu.strasbourg.portlet.agendaExport.XMLAdapter.DateAdapter;
import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.service.agenda.model.EventPeriod;
import eu.strasbourg.service.agenda.model.Manifestation;
import eu.strasbourg.service.place.model.Place;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@XmlRootElement(name = "event")
@XmlAccessorType(XmlAccessType.FIELD)
public class EventDTO {

    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "subtitle")
    private String subtitle;

    @XmlElement(name = "description")
    private String description;

    @XmlElement(name = "firstStartDate")
    @XmlJavaTypeAdapter(DateAdapter.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate firstStartDate;

    @XmlElement(name = "lastEndDate")
    @XmlJavaTypeAdapter(DateAdapter.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate lastEndDate;

    @XmlElement(name = "image")
    private String image;

    @XmlElement(name = "imageCopyright")
    private String imageCopyright;

    @XmlElement(name = "place")
    private EventPlaceDTO place;

    @XmlElement(name = "contact")
    private EventContactDTO contact;

    @XmlElement(name = "concert")
    private EventConcertDTO concert;

    @XmlElement(name = "price")
    private EventPriceDTO price;

    @XmlElement(name = "booking")
    private EventBookingDTO booking;

    @XmlElementWrapper(name = "periods")
    @XmlElement(name = "period")
    private List<PeriodDTO> periods;

    @XmlElement(name = "period")
    private PeriodDTO period;

    @XmlElementWrapper(name = "manifestations")
    @XmlElement(name = "manifestation")
    private List<ManifestationDTO> manifestations;

    @XmlElementWrapper(name = "vocabularies")
    @XmlElement(name = "vocabulary")
    private List<EventVocabularyDTO> vocabularies;

    @XmlTransient
    private List<EventCategoryDTO> categories;

    @XmlElementWrapper(name = "tags")
    @XmlElement(name = "tag")
    private List<String> tags;

    @XmlTransient
    private Locale locale;

    public EventDTO() {}

    public EventDTO(Event event, EventFiltersDTO filters, Locale locale) {
        this.locale = locale;
        this.title = event.getTitle(locale);
        this.subtitle = event.getSubtitle(locale);
        this.description = event.getDescription(locale);

        if(this.description == null) {
            this.description = "";
        }

        this.description = HtmlUtil.stripHtml(description).replaceAll("<br/>", "");

        this.image = event.getImageURL();
        this.imageCopyright = event.getImageCopyright(locale);

        if(event.getFirstStartDate() != null) {
            this.firstStartDate = event.getFirstStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }

        if(event.getLastEndDate() != null) {
            this.lastEndDate = event.getLastEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }

        //Fill lists and specials fields
        addManifestations(event.getManifestations());
        addPeriods(event.getEventPeriods());
        setFirstAndLastDate();
        addContact(event);
        addConcert(event);
        addPrice(event);
        addBooking(event);
        addCategories(event, filters);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {

        if(description == null) {
            description = "";
        }

        return HtmlUtil.stripHtml(description).replaceAll("<br/>", "");
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ManifestationDTO> getManifestations() {
        return manifestations;
    }

    public void setManifestations(List<ManifestationDTO> manifestations) {
        this.manifestations = manifestations;
    }

    public List<PeriodDTO> getPeriods() {
        return periods;
    }

    public void setPeriods(List<PeriodDTO> periods) {
        this.periods = periods;
    }

    @JsonIgnore
    public PeriodDTO getPeriod() {
        return period;
    }

    public void setPeriod(PeriodDTO period) {
        this.period = period;
    }

    public LocalDate getFirstStartDate() {
        return firstStartDate;
    }

    public void setFirstStartDate(LocalDate firstStartDate) {
        this.firstStartDate = firstStartDate;
    }

    public LocalDate getLastEndDate() {
        return lastEndDate;
    }

    public void setLastEndDate(LocalDate lastEndDate) {
        this.lastEndDate = lastEndDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageCopyright() {
        return imageCopyright;
    }

    public void setImageCopyright(String imageCopyright) {
        this.imageCopyright = imageCopyright;
    }

    public EventPlaceDTO getPlace() {
        return place;
    }

    public void setPlace(EventPlaceDTO place) {
        this.place = place;
    }

    public EventContactDTO getContact() {
        return contact;
    }

    public void setContact(EventContactDTO contact) {
        this.contact = contact;
    }

    public EventConcertDTO getConcert() {
        return concert;
    }

    public void setConcert(EventConcertDTO concert) {
        this.concert = concert;
    }

    public EventPriceDTO getPrice() {
        return price;
    }

    public void setPrice(EventPriceDTO price) {
        this.price = price;
    }

    public EventBookingDTO getBooking() {
        return booking;
    }

    public void setBooking(EventBookingDTO booking) {
        this.booking = booking;
    }

    public List<EventVocabularyDTO> getVocabularies() {
        return vocabularies;
    }

    public void setVocabularies(List<EventVocabularyDTO> vocabularies) {
        this.vocabularies = vocabularies;
    }

    public List<EventCategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<EventCategoryDTO> categories) {
        this.categories = categories;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public void addManifestations(List<Manifestation> manifestations) {

        if(this.manifestations == null) {
            this.manifestations = new ArrayList<>();
        }

        for(Manifestation manifestation : manifestations) {
            this.manifestations.add(new ManifestationDTO(manifestation, locale));
        }
    }

    public void addPeriods(List<EventPeriod> periods) {

        if(this.periods == null) {
            this.periods = new ArrayList<>();
        }

        for(EventPeriod period : periods) {
            this.periods.add(new PeriodDTO(period, locale));
        }
    }

    public void addPlace(Event event, Place place) {

        if(place == null ) {
            this.place = new EventPlaceDTO(
                event.getPlaceName(this.locale),
                event.getPlaceStreetNumber(),
                event.getPlaceName(this.locale),
                event.getPlaceZipCode(),
                event.getCity(this.locale),
                event.getPlaceCountry(),
                event.getAccess(this.locale),
                event.getAccessForDisabled(this.locale),
                event.getAccessForBlind(),
                event.getAccessForWheelchair(),
                event.getAccessForDeaf(),
                event.getAccessForElder(),
                event.getAccessForDeficient()
            );
        } else {
            this.place = new EventPlaceDTO(
                place.getName(),
                place.getAddressStreet(),
                event.getPlaceName(this.locale),
                place.getAddressZipCode(),
                place.getCity(locale),
                place.getAddressCountry(),
                place.getAccess(locale),
                place.getAccessForDisabled(locale),
                place.getAccessForBlind(),
                place.getAccessForWheelchair(),
                place.getAccessForDeaf(),
                place.getAccessForElder(),
                place.getAccessForDeficient()
            );
        }
    }

    public void addContact(Event event) {
        this.contact = new EventContactDTO(
            event.getPromoter(),
            event.getPhone(),
            event.getEmail(),
            event.getWebsiteName(this.locale),
            event.getWebsiteURL(this.locale)
        );
    }

    public void addConcert(Event event) {
        this.concert = new EventConcertDTO(
            event.getConcertId(),
            event.getComposer(),
            event.getDistribution(this.locale),
            event.getProgram(this.locale)
        );
    }

    public void addPrice(Event event) {
        this.price = new EventPriceDTO(
            event.getFree(),
            event.getPrice(this.locale)
        );
    }

    public void addBooking(Event event) {
        this.booking = new EventBookingDTO(
            event.getBookingDescription(this.locale),
            event.getBookingURL(),
            event.getSubscriptionURL()
        );
    }

    public void addVocabularies(List<AssetVocabulary> vocabularies) {

        if(this.vocabularies == null) {
            this.vocabularies = new ArrayList<>();
        }

        for(AssetVocabulary vocabulary : vocabularies) {
            EventVocabularyDTO vocabularyDTO = new EventVocabularyDTO();
            vocabularyDTO.setName(vocabulary.getName());
            this.vocabularies.add(vocabularyDTO);
        }
    }

    public void addVocabulary(AssetVocabulary vocabulary) {

        if(this.vocabularies == null) {
            this.vocabularies = new ArrayList<>();
        }

        EventVocabularyDTO vocabularyDTO = new EventVocabularyDTO();
        vocabularyDTO.setName(vocabulary.getName());
        this.vocabularies.add(vocabularyDTO);
    }

    public void addVocabulariesDTO(List<EventVocabularyDTO> vocabularies) {

        if(this.vocabularies == null) {
            this.vocabularies = new ArrayList<>();
        }

        this.vocabularies.addAll(vocabularies);
    }

    public EventVocabularyDTO getVocabularyByName(String vocabularyName) {
        if(this.vocabularies == null) {
            return null;
        }

        for(EventVocabularyDTO vocabulary : this.vocabularies) {
            if(vocabulary.getName().equals(vocabularyName)) {
                return vocabulary;
            }
        }

        return null;
    }

    /**
     *
     * @param event
     * @param filters
     */
    public void addCategories(Event event, EventFiltersDTO filters) {

        if(this.categories == null) {
            this.categories = new ArrayList<>();
        }

        for(AssetCategory category : event.getCategories()) {
            EventCategoryDTO newCategoryDTO = new EventCategoryDTO();
            newCategoryDTO.setName(category.getName());
            newCategoryDTO.setCategoryId(category.getCategoryId());
            newCategoryDTO.setVocabularyId(category.getVocabularyId());
            this.categories.add(newCategoryDTO);
        }
    }

    public void setFirstAndLastDate() {

        LocalDate firstDate = null;
        LocalDate endDate = null;
        for(PeriodDTO period : periods) {

            //StartDate
            if(firstDate == null) {
                firstDate = period.getStartDate();
            } else if (period.getStartDate().isBefore(firstDate)) {
                firstDate = period.getStartDate();
            }

            //EndDate
            if(endDate == null) {
                endDate = period.getEndDate();
            } else if (period.getEndDate().isAfter(endDate)) {
                endDate = period.getEndDate();
            }
        }
    }

    /**
     * Met à jour la liste des périodes à partir de la valeur donnée en paramètre
     * @param formatter
     * @param value
     */
    public void updatePeriods(DateTimeFormatter formatter, String value) {
        for(PeriodDTO period : this.periods) {
            LocalDateTime ldtStart = period.getStartDate().atStartOfDay().minusDays(1);
            LocalDateTime ldtEnd = period.getEndDate().atStartOfDay().plusDays(1);
            LocalDateTime dateToCompare = LocalDateTime.parse(value, formatter);

            if(
                (ldtStart.equals(ldtEnd) && ldtStart.equals(dateToCompare)) ||
                dateTimeIsWithinRange(ldtStart, dateToCompare, ldtEnd)
            ) {
                this.period = period;
            }
        }
    }

    /**
     * Est ce que la date est entre les 2 bornes temporelles ?
     * @param startDate
     * @param testDate
     * @param endDate
     * @return
     */
    private static boolean dateTimeIsWithinRange(LocalDateTime startDate, LocalDateTime testDate, LocalDateTime endDate) {
        return !(testDate.isBefore(startDate) || testDate.isAfter(endDate));
    }
}
