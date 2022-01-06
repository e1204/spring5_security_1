package edu.kosmo.ex.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.kosmo.ex.mapper.EmpMapper;
import edu.kosmo.ex.vo.CustomUser;
import edu.kosmo.ex.vo.EmpVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

	//UserDetailsService 여기에서 UserDetails에 맞춰서 return 해라
	@Setter(onMethod_ = @Autowired)
	private EmpMapper empMapper;


	@Override
	public UserDetails loadUserByUsername(String ename) throws UsernameNotFoundException {
		log.warn("Load User By Employee number: " + ename);
		EmpVO vo = empMapper.readUser(ename);
		log.warn("queried by EmpVO mapper : " + vo);
		return vo == null ? null : new CustomUser(vo);		
	}
}