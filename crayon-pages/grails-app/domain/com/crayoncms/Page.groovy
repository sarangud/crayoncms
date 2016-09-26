package com.crayoncms

import com.crayoncms.enums.PageStatus

class Page {

	String name
	String slug
	String content
	PageStatus status
	String layout
	String keywords
	String description
	short parent
	int menuOrder
	String access
	Date dateCreated
	Date lastUpdated

    static constraints = {
		name maxSize:160
		slug maxSize: 170, unique: true
		content widget: 'textarea', nullable: true
        layout maxSize:25
		description maxSize: 250, widget: 'textarea'
		keywords maxSize: 200
    	parent maxSize: 1, display: true
    	menuOrder maxSize: 4, display: false
		access inList: ["Public", "Registered"]
    }
	
	static mapping = {
		content type: 'text'
	}
}
