package com.crayoncms.user

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='username')
@ToString(includes='username,fullName,email', includeNames=true, includePackage=false)
class User implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService

	String username
	String password
	String email
	String firstName
	String lastName
	String fullName
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	Set<RoleGroup> getAuthorities() {
		UserRoleGroup.findAllByUser(this)*.roleGroup
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

	static transients = ['springSecurityService', 'fullName']

	static constraints = {
		username blank: false, unique: true
		firstName nullable: true, maxSize: 50
		lastName nullable: true, maxSize: 50
		email nullable: true, unique: true, email: true
		password blank: false, password: true, display: false
		passwordExpired display: false
		accountLocked display: false
	}

	static mapping = {
		password column: '`password`'
	}
	
	String getFullName() {
		firstName + " " + lastName
	}
}
