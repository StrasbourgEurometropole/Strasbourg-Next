package eu.strasbourg.utils.bean;

public class Structure {

	private String key;
	private String name;
	private String definitionFilePath;
	private String layoutFilePath;

	public Structure(String key, String name, String definitionFilePath, String layoutFilePath) {
		this.key = key;
		this.name = name;
		this.definitionFilePath = definitionFilePath;
		this.layoutFilePath = layoutFilePath;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDefinitionFilePath() {
		return definitionFilePath;
	}

	public void setDefinitionFilePath(String definitionFilePath) {
		this.definitionFilePath = definitionFilePath;
	}

	public String getLayoutFilePath() {
		return layoutFilePath;
	}

	public void setLayoutFilePath(String layoutFilePath) {
		this.layoutFilePath = layoutFilePath;
	}
}
