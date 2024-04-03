package eu.strasbourg.utils.bean;

public class Template {

	private String className;
	private String structureKey;
	private String key;
	private String name;
	private String cacheable;
	private String scriptFilePath;

	public Template(String structureKey, String key, String name, String isCacheable, String scriptFilePath) {
		this.structureKey = structureKey;
		this.key = key;
		this.name = name;
		this.cacheable = isCacheable;
		this.scriptFilePath = scriptFilePath;
	}

	public Template(String className, String key, String name, String scriptFilePath) {
		this.className = className;
		this.key = key;
		this.name = name;
		this.scriptFilePath = scriptFilePath;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getStructureKey() {
		return structureKey;
	}

	public void setStructureKey(String structureKey) {
		this.structureKey = structureKey;
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

	public String getCacheable() {
		return cacheable;
	}

	public void setCacheable(String cacheable) {
		this.cacheable = cacheable;
	}

	public String getScriptFilePath() {
		return scriptFilePath;
	}

	public void setScriptFilePath(String scriptFilePath) {
		this.scriptFilePath = scriptFilePath;
	}
}
