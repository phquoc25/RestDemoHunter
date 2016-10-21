package com.qph.restdemo.service.dto;


import java.util.HashMap;
import java.util.Map;

/**
 * This enum used for upload module from csv 
 *
 */
public enum QuestionConfigField {

	QUESTION_CODE("questionCode", "saqcode"),
	SECTION_NAME ("sectionName","section"),
	SUB_SECTION_NAME ("subsectionName","subsection"),
	SUB_SECTION_CODE ("subsectionCode","subsectioncode"),
	QUESTION_NAME ("questionName","question"),
	QUESTION_TYPE ("questionType","type"),
	ANSWER ("answer", "answers"),
	ARG_LARGE("agricultureLarge", "agriculture(large)"),
	INTERME("intermediate", "intermediaries/agents"),
	MANUFACT ("manufact", "manufacturing"),
	SERVICE ("serviceProvider", "serviceproviders"),
	ARG_SMALL("agricultureSmall", "agriculture(small)"),
	HEAVY_EN("heavyEngineering", "heavyengineering"),
	OFFICE_HQ("officeHQ", "office/hq");

	private String property;

	private String headerName;

	static private Map<String, QuestionConfigField> map = new HashMap<String, QuestionConfigField>();

	static private Map<String, QuestionType> questionTypeMap = new HashMap<String, QuestionType>();

	static {
		questionTypeMap.put("free text", QuestionType.FREE_TEXT);
		questionTypeMap.put("numeric", QuestionType.NUMERIC);
		questionTypeMap.put("date", QuestionType.DATE);
		questionTypeMap.put("single choice", QuestionType.SINGLE_CHOICE);
		questionTypeMap.put("multi choice", QuestionType.MULTIPLE_CHOICE);
		questionTypeMap.put("upload", QuestionType.ATTACHMENT);
		questionTypeMap.put("derived", QuestionType.DERIVED);
	}

    static {
        for( QuestionConfigField type : values() ){
            map.put(type.headerName, type);
        }
    }

    QuestionConfigField(String property, String headerName){
        this.property = property;
        this.headerName = headerName;
    }

    public static QuestionConfigField findByHeaderName(String headerName) {
    	return map.get(headerName);
    }
    
    public static QuestionType getQuestionType(String value) {
    	return questionTypeMap.get(value);
    }

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getHeaderName() {
		return headerName;
	}

	public void setHeaderName(String headerName) {
		this.headerName = headerName;
	}
    
}
