package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.dao.IUserDao;
import com.entity.UserEntity;
@Service
public class IUserServiceImpl implements IUserService{

	@Autowired
	private IUserDao dao;
	
	@Override
	public void addUser(UserEntity u) {
		dao.addUser(u);
		
	}

	@Override
	public void deleteUser(String id) {
		dao.deleteUser(id);
		
	}

	@Override
	public void updateUser(UserEntity u) {
		dao.updateUser(u);
		
	}

	@Override
	public List<UserEntity> findAll() {
		
		return dao.findAll();
	}

	@Override
	public UserEntity findById(String id) {
		
		return dao.findById(id);
	}
	
	@Override
	public UserEntity login(UserEntity u){
			
		return dao.login(u);	
	}

//	public static void main(String[] args) {
//		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		IUserServiceImpl i = (IUserServiceImpl) ac.getBean("IUserServiceImpl");
//		i.addUser(new UserEntity("103", "xiaozhang", "123456", "小张"));
//		i.updateUser(new UserEntity("102", "xiaoli", "123456", "小李"));
//		i.deleteUser("103");
//		System.out.println(i.findById("102").getUserName());
//		System.out.println(i.findAll());
//		
//	}
}
