package eu.strasbourg.portlet.validation;

import com.liferay.portal.kernel.json.JSONObject;


public class ValidationResponse {

	public String err_class;
	public String err_desc;
	public String data;
	public String count;
	public String code_erreur;
	public String result;
    public String err;
    public String erreur;
    
    public ValidationResponse(JSONObject json) {
    	err_class = json.getString("err_class");
    	err_desc = json.getString("err_desc");
    	data = json.getString("data");
    	count = json.getString("count");
    	code_erreur = json.getString("code_erreur");
    	result = json.getString("result");
    	err = json.getString("err");
    	erreur = json.getString("erreur");
    }

    public ValidationResponse() {
    }

	public String getErr_class() {
		return err_class;
	}

	public void setErr_class(String err_class) {
		this.err_class = err_class;
	}

	public String getErr_desc() {
		return err_desc;
	}

	public void setErr_desc(String err_desc) {
		this.err_desc = err_desc;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getCode_erreur() {
		return code_erreur;
	}

	public void setCode_erreur(String code_erreur) {
		this.code_erreur = code_erreur;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getErr() {
		return err;
	}

	public void setErr(String err) {
		this.err = err;
	}

	public String getErreur() {
		return erreur;
	}

	public void setErreur(String erreur) {
		this.erreur = erreur;
	}
}
