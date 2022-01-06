package edu.kosmo.ex.vo;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter
@Setter
//public class User implements UserDetails, CredentialsContainer
public class CustomUser extends User{

	private EmpVO emp;
	
	public CustomUser(String ename, String password, Collection<? extends GrantedAuthority> authorities) {
		super(ename, password, authorities);
	}
		   
	public CustomUser(EmpVO empVO) {
		super(empVO.getEname(), Integer.toString(empVO.getEmpno()),Collections
		             .singletonList(new SimpleGrantedAuthority("ROLE_USER")));
		this.emp = empVO;
	}   

}
