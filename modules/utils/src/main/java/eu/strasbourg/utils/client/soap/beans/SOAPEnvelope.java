package eu.strasbourg.utils.client.soap.beans;

import com.liferay.petra.string.StringBundler;

import java.util.Map;

public class SOAPEnvelope {

    private Map<String, String> attributes;
    private String body;
    private String namespacePrefix;

    /**
     * Constructeur d'enveloppe SOAP
     * Note : le body est au format String car chaque service SOAP construit ses paramètres comme il le souhaite,
     *      ne pouvant détecter un format régulier, cela laisse la possibilité d'y mettre ce que le service demande.
     * @param namespacePrefix Préfixe utilisé par les balises Envelope, Header et Body
     * @param attributes Liste des attribut de l'enveloppe en clef/valeur (ex: encodingStyle / URI)
     * @param body XML au format String du body de l'enveloppe sans prendre en compte les balises du body elles-mêmes
     */
    public SOAPEnvelope(String namespacePrefix, Map<String, String> attributes, String body) {
        this.namespacePrefix = namespacePrefix;
        this.attributes = attributes;
        this.body = body;
    }

    /**
     * Retourne les attributs au format demandé par une enveloppe SOAP
     * @return attributs au format : xmlns:name1="value1" xmlns:name2="value2" ...
     */
    private String getFormattedAttributes() {
        StringBundler result = new StringBundler();

        for (Map.Entry<String, String> attribute : this.attributes.entrySet()) {
            result.append(" xmlns:");
            result.append(attribute.getKey());
            result.append("=\"");
            result.append(attribute.getValue());
            result.append("\"");
        }

        return result.toString();
    }

    /**
     * Retourne une l'enveloppe SOAP XML au format String
     */
    public String toString() {
        return "<" + this.namespacePrefix + ":Envelope " + this.getFormattedAttributes() +">\n" +
                "   <" + this.namespacePrefix + ":Header/>\n" +
                "   <" + this.namespacePrefix + ":Body>\n" +
                    this.body +
                "   </" + this.namespacePrefix + ":Body>\n" +
                "</" + this.namespacePrefix + ":Envelope> \n";
    }

}