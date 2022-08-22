package service;

import java.util.List;



import bean.Cbean;
import bean.LearnersBean;
import bean.LoginBean;
import bean.Stbean;
import bean.Subean;
import bean.Tbean;
import dao.DaoLearners;
import dao.DaoLogin;
import dao.Daoclass;
import dao.Daostudent;
import dao.Daosubject;
import dao.Daoteach;

public class AdminService {

	DaoLogin login = new DaoLogin();
	Daostudent student = new Daostudent();
	Daosubject subject = new Daosubject();
	Daoteach teach = new Daoteach();
	Daoclass classes = new Daoclass();
	DaoLearners learner= new DaoLearners();
	
	
	
	

	
	public boolean AddStProfile(Stbean bean) 
	{	 
		return student.insertStudent(bean);
	}

	
	public int deleteStProfile(int stId) 
	{	
		
		return student.deleteStudentByName(stId);
	}
	
	public List<Stbean> viewStProfile() 
	{	 
		return student.getAllStudents();
	}
	

	public boolean AddTProfile(Tbean bean) 
	{	 
		return teach.insertTeach(bean);
	}

	
	public int deleteTProfile(int TId) 
	{	
		
		return teach.deleteTeachersByName(TId);
	}
	
	public List<Tbean> viewTProfile() 
	{	 
		return teach.getAllTeachers();
	}
	
	
	public boolean AddSuProfile(Subean bean) 
	{	 
		return subject.insertSubject(bean);
	}

	
	public int deleteSuProfile(int SuId) 
	{	
		
		return subject.deleteSubjectByName(SuId);
	}
	
	public List<Subean> viewSuProfile() 
	{	 
		return subject.getAllSubjects();
	}
	
	
	public boolean AddClasses(Cbean bean) 
	{	 
		return classes.insertClass(bean);
	}

	
	public int deleteClasses(String classname) 
	{	
		
		return classes.deleteClassByName(classname);
	}
	
	public List<Cbean> viewClasses() 
	{	 
		return classes.getAllClasses();
	}
	
	

	public boolean insertinLearnersTable(LearnersBean bean)
	{
		return learner.insertAll(bean);
	} 
	
	
	public int deleteLearnerByName(String learnername, String learnerSurname)
	{
		return learner.deleteClassByName(learnername,learnerSurname);
	}
	
	
	public List<LearnersBean> viewLearnerTable() 
	{	 
		return learner.getAll();
	}
	
	public LearnersBean SearchLearner(String name, String surname)
	{
	
		return learner.searchLearnersByName(name, surname);
		
	}
	
	
DaoLogin userDao = new DaoLogin();
	
	public String login(LoginBean beanFromUser) 
	{
		String user = null;
		
		LoginBean beanFromDb = userDao.getUserByUserName(beanFromUser.getUsername()) ;
		
		if(beanFromDb != null)
		{
			
		
			if(beanFromUser.getUsername().equals(beanFromDb.getUsername()) && beanFromUser.getPassword() == beanFromDb.getPassword())
			{
				user = beanFromDb.getUsername();
				System.out.println("Password Is CORRECT");
				System.out.println("Admin Service - Bean from DB - username = '" +beanFromDb.getUsername()+"' & password =  '"+ beanFromDb.getPassword()+"'");
				System.out.println("Admin Service - Bean from USER - username = '" +beanFromUser.getUsername()+"' & password =  '"+ beanFromUser.getPassword()+"'");
			}
			else
			{
				System.out.println("ADMIN SERVICE - INCORRECT USER OR PASWORD");
				System.out.println("Admin Service - Bean from DB - username = '" +beanFromDb.getUsername()+"' & password =  '"+ beanFromDb.getPassword()+"'");
				System.out.println("Admin Service - Bean from USER - username = '" +beanFromUser.getUsername()+"' & password =  '"+ beanFromUser.getPassword()+"'");
			}
		}
		
		return user;
	}
}
